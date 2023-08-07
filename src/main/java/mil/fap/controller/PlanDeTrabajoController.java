/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.util.List;
import mil.fap.helpers.Constantes;
import mil.fap.models.ComiteTrabajo;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.ComiteTrabajoService;
import mil.fap.service.ObservacionService;
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
 * @author cristina
 */
@Controller
@RequestMapping("/")
public class PlanDeTrabajoController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ComiteTrabajoService comiteService;

    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;

    @Autowired
    ObservacionService observacionService;

    @RequestMapping(value = {"/planDeTrabajo"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);

        return "planDeTrabajo";
    }

    @RequestMapping(value = "/ListaPlanTrabajo", method = RequestMethod.POST)
    @ResponseBody
    public Message planTrabajo(@RequestBody ComiteTrabajo item) {
        Message msj = new Message();
        List<ComiteTrabajo> oData = comiteService.listPagination(item);
        msj.setData(oData);
        return msj;
    }

    @RequestMapping(value = "/enviarReferenciaPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarReferenciaPIP(@RequestBody ProyectoPIP item) {
        Message msj = new Message();
        item.setEstadoactu(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setProcactual(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIdProyepip());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        msj = proyectoPIPService.enviarReferenciaPIP(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/aprobarReferenciaPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarP01PIP(@RequestBody SeguimientoProy item) {
        Message msj;

        item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        msj = _SeguimientoProyService.setPIP(item);
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.Perfil);
        msj = _SeguimientoProyService.setPIP(item);

        return msj;
    }

    @RequestMapping(value = "/insertObservacionPlan", method = RequestMethod.POST)
    @ResponseBody
    public Message insertObservacionPlan(@RequestBody Observacion item) {
        item.setIDPROIOARR(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
        Message msj = observacionService.insertObservacionPIP(item, seguimientoProy);
        return msj;
    }

}
