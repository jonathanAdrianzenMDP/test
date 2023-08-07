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
import mil.fap.models.Observacion;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.ObservacionService;
import mil.fap.service.ProyectoIOARRService;
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
 * @author mnieva
 */
@Controller
@RequestMapping("/")
public class SolicitudEjecucionController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @Autowired
    SeguimientoProyService _SeguimientoProyService;

    @Autowired
    ObservacionService observacionService;

    @RequestMapping(value = "/solicitudEjecucion", method = RequestMethod.GET)
    public String indexIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result;
        result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
//        if (!result.getProyectoIOARR().getAprobacionPMI().equals(Constantes.EstadosPMI.Aprobado)) {
//            return "redirect:/seguimientoIOARR?id=" + id;
//        }
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
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
        return "solicitudEjecucion";
    }
    @RequestMapping(value = "/enviarSolicitudIOARRUIT", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarSolicitudIOARRUIT(@RequestBody ProyectoIOARR item) {
        Message msj;
        item.setIdEstadoActual(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setIdProcesoActual(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproioarr(item.getIdProIOARR());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
        //  msj = solEjecucionService.enviarProyectoIOARR(item, seguimientoProy);
        msj = proyectoIOARRService.enviarProyectoIOARRUIT(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/aprobarIOARRUIT", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarIOARRUIT(@RequestBody SeguimientoProy item) {
        Message msj;
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
        msj = _SeguimientoProyService.setIOARR(item);
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
        msj = _SeguimientoProyService.setIOARR(item);
        return msj;
    }

    @RequestMapping(value = "/insertObservacionUIT", method = RequestMethod.POST)
    @ResponseBody
    public Message insert(@RequestBody Observacion item) {
        item.setIDPROYEPIP(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproioarr(item.getIDPROIOARR());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
        Message msj = observacionService.insertObservacionIOARR(item, seguimientoProy);
        return msj;
    }

}
