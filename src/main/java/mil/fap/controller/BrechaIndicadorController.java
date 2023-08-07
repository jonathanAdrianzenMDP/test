/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.BrechaIndicadorRequest;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.Funcion;
import mil.fap.models.Grupofunc;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.models.helpers.SelectItem;
import mil.fap.service.BrechaIndicadorService;
import mil.fap.service.DivisionFuncionService;
import mil.fap.service.DocumentoAdjuntoService;
import mil.fap.service.FuncionService;
import mil.fap.service.ParametroValorService;
import mil.fap.service.GrupofuncService;
import mil.fap.service.ReporteBrechaIndicadorService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BrechaIndicadorController {

    @Autowired
    BrechaIndicadorService brechaService;
    @Autowired
    UsuarioService usuarioService;

    @Autowired
    FuncionService funcionService;
    @Autowired
    GrupofuncService grupofuncService;
    @Autowired
    DivisionFuncionService divisionFuncionService;
    @Autowired
    ParametroValorService parametroValorService;
    @Autowired
    DocumentoAdjuntoService documentoAdjuntoService;
    @Autowired
    ReporteBrechaIndicadorService reporteBrechaIndicadorService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String index(ModelMap model) {

        return "redirect:/brechaIndicador";
    }

    @RequestMapping(value = {"/brechaIndicador"}, method = RequestMethod.GET)
    public String brechaIndicador(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);      
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.format(date);
        Integer anioActual = Integer.parseInt(dateFormat.format(date));
        for (int i = -1; i <= Constantes.Parametros.AnioActualHaciaAtras; i++) {
            map.put(anioActual + i, anioActual + i);
        }
         Usuario perfilMenu = new Usuario();
         perfilMenu.setIdperfil(anioActual);
         
         
         model.addAttribute("idperfil", perfilMenu);
        model.addAttribute("anios", map);
        model.addAttribute("anioActual", anioActual);
        return "brechasIndicadores";
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    @RequestMapping(value = "/getDatosUsuario", method = RequestMethod.POST)
    public Message getDatosUsuario() {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        Usuario item = usuarioService.getLogin(usuario);
        String datosLogin = item.getGrado() + " " + item.getNombres() + " - " + item.getUnidad();
        Message msj = new Message();
        msj.setMessage(datosLogin);
        return msj;
    }

    @RequestMapping(value = "/cargarParametroValor", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarParametroValor(@RequestParam("idparametro") int idparametro) {
        Message msj = new Message();
        msj.setData(parametroValorService.list(idparametro));
        return msj;
    }

    @RequestMapping(value = "/cargarFuncion", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarFuncion(@RequestBody SelectItem item) {

        Message msj = new Message();

        List<Funcion> lFuncion = funcionService.list();
        List<SelectItem> lItemsFuncion = new ArrayList();
        for (Funcion oFuncion : lFuncion) {
            lItemsFuncion.add(
                    new SelectItem(
                            oFuncion.getIdfuncion().toString(),
                            oFuncion.getDescfuncion()
                    )
            );
        }
        msj.setData(lItemsFuncion);

        return msj;
    }

    @RequestMapping(value = "/cargarDivisionFuncion", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarDivFuncional(@RequestBody SelectItem item) {

        Message msj = new Message();

        List<DivisionFuncion> lDivisionFuncion = divisionFuncionService.list(Integer.parseInt(item.getValue()));

        List<SelectItem> lItemsDivisionFuncion = new ArrayList();
        for (DivisionFuncion oDivisionFuncion : lDivisionFuncion) {
            lItemsDivisionFuncion.add(
                    new SelectItem(
                            oDivisionFuncion.getIddivfuncion().toString(),
                            oDivisionFuncion.getDescdivfuncion()
                    )
            );
        }
        msj.setData(lItemsDivisionFuncion);

        return msj;

    }

    @RequestMapping(value = "/cargarGrupoFuncional", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarGrupoFuncional(@RequestBody SelectItem item) {

        Message msj = new Message();
        List<Grupofunc> lGrupofunc = grupofuncService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsGrupofunc = new ArrayList();
        for (Grupofunc oGrupofunc : lGrupofunc) {
            lItemsGrupofunc.add(
                    new SelectItem(
                            oGrupofunc.getIdgrupofun().toString(),
                            oGrupofunc.getDescgrupofunc()
                    )
            );
        }
        msj.setData(lItemsGrupofunc);

        return msj;

    }

    @RequestMapping(value = "/getBrechaIndicador", method = RequestMethod.GET)
    public @ResponseBody
    Message brechaIndicador(@RequestParam("id") int id) {
        Message msj = new Message();
        msj.setData(brechaService.buscarPorId(id));
        return msj;
    }

    
//       @RequestMapping(value = "/getBrechaIndicador", method = RequestMethod.GET)
//    public @ResponseBody
//    Message brechaIndicador(@RequestParam("id") int id, ModelMap model) {
//  
//                BrechaIndicador result;
//        result = brechaService.buscarPorId(id);
//        model.addAttribute("item", result);
//        return msj;
//    }
    
    @RequestMapping(value = "/buscarBrechaIndicador", method = RequestMethod.POST)
    @ResponseBody
    public Message brechaIndicador(@RequestBody BrechaIndicador item) {
        Message msj = new Message();
        List<BrechaIndicador> oData = brechaService.listPagination(item);

        msj.setData(oData);
        return msj;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    @ResponseBody
    public Message registrar(@RequestBody BrechaIndicadorRequest item) {
        Message msj = new Message();
        String response = brechaService.register(item);
        msj.convert(response);
        return msj;

    }

    @RequestMapping(value = "/actualizar", method = RequestMethod.POST)
    @ResponseBody
    public Message actualizar(@RequestBody  BrechaIndicador item) {
        Message msj = new Message();
        Message response = brechaService.update(item);
        msj.setData(response);
        return msj;

    }

    @RequestMapping(value = "/actualizarEstado", method = RequestMethod.GET)
    @ResponseBody
    public Message actualizarEstado(@RequestParam("id") int id) {
        Message oMensaje = new Message();
        BrechaIndicador oitem = new BrechaIndicador();
        oitem.setIdbrecindi(id);
        String response = brechaService.updateEstado(oitem);
        oMensaje.convert(response);

        return oMensaje;
    }

    @RequestMapping("/reportebrecha")
    public String verReporte(Model model, @RequestParam(
            name = "format",
            defaultValue = "pdf",
            required = false) String format,
            @RequestParam("anio") String anio,
            @RequestParam("service") String service,
            @RequestParam("indicador") String indicador) {
        model.addAttribute("format", format);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("USUARIO", item.getUsuario());
        model.addAttribute("datasource",
                reporteBrechaIndicadorService.getReporteBrechaIndicador(anio, service, indicador));

        return "reporteBrechaIndicador_report";
    }

    @RequestMapping(value = {"/readBRECHA"}, method = RequestMethod.GET)
    public String readOnlyIOARR(ModelMap model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        return "readBRECHA";
    }

}
