/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.util.List;
import mil.fap.helpers.Constantes;
import mil.fap.models.ComiteTrabajo;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.ComiteTrabajoService;
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
 * @author mnieva
 */
@Controller
@RequestMapping("/")
public class ComiteTrabajoController {

    @Autowired
    ComiteTrabajoService comiteService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    @Autowired
    ObservacionService observacionService;

    @RequestMapping(value = "/comiteTrabajo", method = RequestMethod.GET)
    public String comitTrabajo(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);

        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());

        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);

        return "comiteTrabajos";
    }

    @RequestMapping(value = "/comiteTrabajoIOARR", method = RequestMethod.GET)
    public String comitTrabajoIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);

        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());

        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
        seguimiento.setIdproioarr(id);
        seguimiento.setIdproyepip(0);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);

        return "comiteTrabajosIOARR";
    }

    @RequestMapping(value = "/ListComiteTrabajo", method = RequestMethod.POST)
    @ResponseBody
    public Message comiteTrabajo(@RequestBody ComiteTrabajo item) {
        Message msj = new Message();
        List<ComiteTrabajo> oData = comiteService.listPagination(item);
        msj.setData(oData);
        return msj;
    }

    @RequestMapping(value = "/registrarComiteTrabajo", method = RequestMethod.POST)
    @ResponseBody
    public Message registrar(@RequestBody ComiteTrabajo item) {
        Message msj = new Message();
        Message response = comiteService.register(item);
        msj.setData(response);
        return msj;
    }

    @RequestMapping(value = "/actualizarComiteTrabajo", method = RequestMethod.POST)
    @ResponseBody
    public Message actualizar(@RequestBody ComiteTrabajo item) {
        Message msj = new Message();
        Message response = comiteService.update(item);
        msj.setData(response);
        return msj;
    }

    @RequestMapping(value = "/getComiteTrabajo", method = RequestMethod.GET)
    public @ResponseBody
    Message ComiteTrabajo(@RequestParam("id") int id) {
        Message msj = new Message();
        msj.setData(comiteService.buscarPorId(id));
        return msj;
    }

    @RequestMapping(value = "/actualizarEstadoComite", method = RequestMethod.GET)
    @ResponseBody
    public Message actualizarEstado(@RequestParam("id") int id) {
        Message oMensaje = new Message();
        ComiteTrabajo oitem = new ComiteTrabajo();
        oitem.setIdintegrante(id);
        String response = comiteService.updateEstado(oitem);
        oMensaje.convert(response);

        return oMensaje;
    }

    @RequestMapping(value = "/enviarComite", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarComite(@RequestBody ProyectoPIP item) {
        Message msj = new Message();
        msj = proyectoPIPService.enviarProyectoComite(item);
        return msj;
    }

    @RequestMapping(value = "/enviarComiteIOARR", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarComiteIOARR(@RequestBody ProyectoIOARR item) {
        Message msj = new Message();
        msj = proyectoIOARRService.enviarProyectoComite(item);
        return msj;
    }

    @RequestMapping(value = "/insertObservacionComite", method = RequestMethod.POST)
    @ResponseBody
    public Message insertObservacionComite(@RequestBody Observacion item) {
        item.setIDPROIOARR(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
        Message msj = observacionService.insertObservacionPIP(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/setComite", method = RequestMethod.POST)
    public @ResponseBody
    Message setComite(@RequestBody ProyectoPIP item) {
        Message msj = new Message();
        if (item.getIdProyepip() == 0) {
            msj = proyectoPIPService.updateProyectoPIPFechaPlan(item);
        } else {
            item.setEstadoactu(Constantes.EstadosPIP_IOARR.EnElaboracion);
            item.setProcactual(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
            msj = proyectoPIPService.updateProyectoPIPFechaPlan(item);
        }

        return msj;
    }

}
