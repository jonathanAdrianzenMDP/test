/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import mil.fap.helpers.Constantes;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.ObservacionService;
import mil.fap.service.ProyectoIOARRService;
import mil.fap.service.ProyectoPIPService;
import mil.fap.service.SeguimientoProyService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
public class SeguimientoController {
    
    @Autowired
    ProyectoIOARRService proyectoIOARRService;
    
    @Autowired
    ProyectoPIPService proyectoPIPService;
    
    @Autowired
    SeguimientoProyService seguimientoProyService;
    
    @Autowired
    ObservacionService observacionService;
    
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    
    @RequestMapping(value = {"/seguimientoPIP"}, method = RequestMethod.GET)
    public String seguimientoPIP(Model model, @RequestParam("id") int id) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        model.addAttribute("procesos", seguimientoProyService.getSeguimientoEstadosPIP_IOARR(0, id));
        
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(result.getProyectoPIP().getProcactual());
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        
        return "index";
    }
    @RequestMapping(value = {"/seguimientoIOARR"}, method = RequestMethod.GET)
    public String seguimientoIOARR(Model model, @RequestParam("id") int id) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        
        NuevoIOARRRequest result;
        result = proyectoIOARRService.getProyectoIOARR(id);
        String total = result.getProyectoIOARR().getV_totalInversionTipoIoarr();
        
        model.addAttribute("totalInversion", total);
        model.addAttribute("item", result);
        model.addAttribute("procesos", seguimientoProyService.getSeguimientoEstadosPIP_IOARR(id, 0));
        
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(result.getProyectoIOARR().getIdProcesoActual());
        seguimiento.setIdproioarr(id);
        seguimiento.setIdproyepip(0);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
     
        return "indexIOARR";
    }
    @RequestMapping(value = "/insertObservacionSeg", method = RequestMethod.POST)
    @ResponseBody
    public Message insertObservacionSeg(@RequestBody Observacion item){
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        Message msj = observacionService.insertObservacionIOARR(item, seguimientoProy);
        return msj;
    }
    
    @RequestMapping(value = "/getAllObservacionSeg", method = RequestMethod.POST)
    @ResponseBody
    public Message getAllObservacionSeg(@RequestBody Observacion item){
       
        Message msj = observacionService.getAllObservacion(item);
        
        return msj;
    }
}
