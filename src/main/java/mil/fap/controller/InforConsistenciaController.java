/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.InforConsistPIPService;
import mil.fap.service.ObservacionService;
import mil.fap.service.ProyectoIOARRService;
import mil.fap.service.ProyectoPIPService;
import mil.fap.service.SeguimientoProyService;
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
 * @author nlarico
 */
@Controller
@RequestMapping("/")
public class InforConsistenciaController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    InforConsistPIPService _InforConsistPIPService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;

    @Autowired
    ObservacionService observacionService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @RequestMapping(value = {"/inforConsistPIP"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.InformeConsistencia);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);
        return "inforConsistPIP";
    }
    
    @RequestMapping(value = {"/inforConsistIOARR"}, method = RequestMethod.GET)
    public String indexIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.InformeConsistencia);
        seguimiento.setIdproioarr(id);
        seguimiento.setIdproyepip(0);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);
        return "inforConsistIOARR";
    }
    
    @RequestMapping(value = "/enviarInformeConsistencia", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarInformeConsistencia(@RequestBody SeguimientoProy item) {
         Message msj = _InforConsistPIPService.enviar(item);
        return msj;
    }
    
    @RequestMapping(value = "/aprobarInformeConsistencia", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarInformeConsistencia(@RequestBody SeguimientoProy item) {
        Message msj = _InforConsistPIPService.aprobar(item);
        return msj;
    }
  
    @RequestMapping(value = "/observarInformeConsistencia", method = RequestMethod.POST)
    @ResponseBody
    public Message observarInformeConsistencia(@RequestBody Observacion item) {
        Message msj = _InforConsistPIPService.observar(item);
        return msj;
    }
    
    

    
}
