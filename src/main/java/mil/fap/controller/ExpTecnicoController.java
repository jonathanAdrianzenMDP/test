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
import mil.fap.service.ExpTecnicoService;
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
 * @author jmezas
 */
@Controller
@RequestMapping("/")
public class ExpTecnicoController {
@Autowired
    UsuarioService usuarioService;
    @Autowired
    ExpTecnicoService _ExpTecnicoService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;

    @Autowired
    ObservacionService observacionService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @RequestMapping(value = {"/expTecnicoPIP"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente);
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
        
        return "expTecnicoPIP";
    }
    
    @RequestMapping(value = {"/expTecnicoIOARR"}, method = RequestMethod.GET)
    public String indexIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente);
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
        return "expTecnicoIOARR";
    }
    
    @RequestMapping(value = "/enviarExpedienteTecnico", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarExpTecnico(@RequestBody SeguimientoProy item) {
         Message msj = _ExpTecnicoService.enviar(item);
        return msj;
    }
    
    @RequestMapping(value = "/aprobarExpedienteTecnico", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarExpTecnico(@RequestBody SeguimientoProy item) {
        Message msj = _ExpTecnicoService.aprobar(item);
        return msj;
    }
  
    @RequestMapping(value = "/observarExpedienteTecnico", method = RequestMethod.POST)
    @ResponseBody
    public Message observarExpTecnico(@RequestBody Observacion item) {
        Message msj = _ExpTecnicoService.observar(item);
        return msj;
    }
    

}
