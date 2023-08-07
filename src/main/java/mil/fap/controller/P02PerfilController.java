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
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
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
 * @author jmezas
 */
@Controller
@RequestMapping("/")
public class P02PerfilController {

    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    @Autowired
    ObservacionService observacionService;

    @RequestMapping(value = {"/p02Perfil"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.Perfil);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoPIPService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);

        return "p02Perfil";
    }

    @RequestMapping(value = "/enviarP02Perfil", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarP02Perfil(@RequestBody ProyectoPIP item) {

        Message msj = new Message();
        item.setEstadoactu(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setProcactual(Constantes.ProcesosPIP_IOARR.Perfil);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIdProyepip());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.Perfil);
        msj = proyectoPIPService.enviarProyectoPerfil(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/aprobarP02Perfil", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarP02Perfil(@RequestBody SeguimientoProy item) {
        Message msj;
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.Perfil);
        msj = _SeguimientoProyService.setPIP(item);
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente);
        msj = _SeguimientoProyService.setPIP(item);
        return msj;
    }

    @RequestMapping(value = "/ObservacionP02Perfil", method = RequestMethod.POST)
    @ResponseBody
    public Message insertObservacionP02Perfil(@RequestBody Observacion item) {
        item.setIDPROIOARR(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.Perfil);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.Perfil);
        Message msj = observacionService.insertObservacionPIP(item, seguimientoProy);
        return msj;
    }
}
