
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.IdeasInversion;
import mil.fap.models.ParametroValor;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.UnidadServicio;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import mil.fap.service.IdeasInversionService;
import mil.fap.service.ParametroValorService;
import mil.fap.service.ProyectoIOARRService;
import mil.fap.service.ProyectoPIPService;
import mil.fap.service.UnidadServicioService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jonathan
 */
@Controller
@RequestMapping("/")
public class IdeasInversionController {

    @Autowired
    ParametroValorService parametroValorService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    IdeasInversionService ideasInversionService;

    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @Autowired
    ProyectoPIPService proyectoPIPService;

    @Autowired
    UnidadServicioService UnidadServicioService;

    @RequestMapping(value = {"/ideasInversion"}, method = RequestMethod.GET)
    public String index(ModelMap model, @RequestParam(
            name = "idinver",
            required = false) String idinver) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        model.addAttribute("userInforData", item.getResumendatos());
        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.EstadosRegistrosSeguimientoPIP_IOARR);
        Map<String, String> estadosRegistro = new LinkedHashMap<String, String>();
        estadosRegistro.put(Format.toString(Constantes.Todos.value), Constantes.Todos.text);
        for (ParametroValor oItem : lstResult) {
            estadosRegistro.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("estadosRegistro", estadosRegistro);
        model.addAttribute("V_IOARR_PIP", idinver);

        List<UnidadServicio> lUnidadServicio = UnidadServicioService.listaUnidadServicio();
        Map<String, String> lstUPS = new HashMap<String, String>();
        lstUPS.put(Format.toString(Constantes.Todos.value), Constantes.Todos.text);
        for (UnidadServicio oUnidadServicio : lUnidadServicio) {
            lstUPS.put(oUnidadServicio.getCodigo().toString(), oUnidadServicio.getSigla());
        }
        model.addAttribute("lstUPS", lstUPS);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.format(date);
        Integer anioActual = Integer.parseInt(dateFormat.format(date));
        for (int i = -1; i <= Constantes.Parametros.AnioActualHaciaAtras; i++) {
            map.put(anioActual + i, anioActual + i);
        }
        model.addAttribute("anios", map);
        model.addAttribute("anioActual", anioActual);

        Map<String, String> tipoInversion = new LinkedHashMap<String, String>();
        tipoInversion.put(Format.toString(Constantes.Todos.value), Constantes.Todos.text);
        tipoInversion.put(Constantes.TipoInversion.IOARR, Constantes.TipoInversion.IOARR);
        tipoInversion.put(Constantes.TipoInversion.PIP, Constantes.TipoInversion.PIP);
        model.addAttribute("tipoInversion", tipoInversion);

        return "ideasInversion";
    }

    @RequestMapping(value = "/buscarIdeasInversion", method = RequestMethod.POST)
    @ResponseBody
    public DataTable<IdeasInversion> brechaIndicador(@RequestBody IdeasInversion item) {

        DataTable<IdeasInversion> oData = ideasInversionService.listPagination(item);
        return oData;

    }

    @RequestMapping(value = "/updatePmiIOARR", method = RequestMethod.POST)
    @ResponseBody
    public Message updatePmi(@RequestParam("id") int id, @RequestParam("estado") int estado, @RequestParam("codigo") int codigo) {
        Message oMensaje;
        ProyectoIOARR obj = new ProyectoIOARR();
        obj.setIdProyectoIOARR(id);
        obj.setAprobacionPMI(estado);
        obj.setCodunimef(codigo);
        oMensaje = proyectoIOARRService.updatePmi(obj);
        return oMensaje;
    }

    @RequestMapping(value = "/updatePmiPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message updatePmiPIP(@RequestParam("id") int id, @RequestParam("estado") int estado, @RequestParam("codigo") int codigo) {
        Message oMensaje;
        ProyectoPIP obj = new ProyectoPIP();
        obj.setIdProyepip(id);
        obj.setAprobacpmi(estado);
        obj.setCodunimef(codigo);
        oMensaje = proyectoPIPService.updatePmiPIP(obj);
        return oMensaje;
    }

}
