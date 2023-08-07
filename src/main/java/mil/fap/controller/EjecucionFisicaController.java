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
import mil.fap.models.EjecucionFisica;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.EjecucionFisicaService;
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
public class EjecucionFisicaController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    EjecucionFisicaService _EjecucionFisicaService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;

    @Autowired
    ObservacionService observacionService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @RequestMapping(value = {"/ejecucionFisicaPIP"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        EjecucionFisica fuente = new EjecucionFisica();
        fuente.setIdproioarr(0);
        fuente.setIdproyepip(id);
        fuente = _EjecucionFisicaService.getPIP(fuente);
        model.addAttribute("fuente", fuente);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);
        return "ejecucionFisicaPIP";
    }

    @RequestMapping(value = {"/ejecucionFisicaIOARR"}, method = RequestMethod.GET)
    public String indexIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera);
        seguimiento.setIdproioarr(id);
        seguimiento.setIdproyepip(0);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        EjecucionFisica fuente = new EjecucionFisica();
        fuente.setIdproioarr(id);
        fuente.setIdproyepip(0);
        fuente = _EjecucionFisicaService.getPIP(fuente);
        model.addAttribute("fuente", fuente);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);
        return "ejecucionFisicaIOARR";
    }

    @RequestMapping(value = "/enviarEjecucionFisica", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarEjecucionFisica(@RequestBody SeguimientoProy item) {
        Message msj = _EjecucionFisicaService.enviar(item);
        return msj;
    }

    @RequestMapping(value = "/aprobarEjecucionFisica", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarEjecucionFisica(@RequestBody SeguimientoProy item) {
        Message msj = _EjecucionFisicaService.aprobar(item);
        return msj;
    }

    @RequestMapping(value = "/observarEjecucionFisica", method = RequestMethod.POST)
    @ResponseBody
    public Message observarEjecucionFisica(@RequestBody Observacion item) {
        Message msj = _EjecucionFisicaService.observar(item);
        return msj;
    }

    @RequestMapping(value = "/registrarFuenteFinanciamientoPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message registrarFuenteFinanciamientoPIP(@RequestBody EjecucionFisica item) {
        Message msj = _EjecucionFisicaService.register(item);
        return msj;
    }

//    @RequestMapping(value = "/actualizarFuenteFinanciamiento", method = RequestMethod.GET)
//    @ResponseBody
//    public Message actualizarFuenteFinanciamiento(@RequestParam("id") int id) {
//        Message oMensaje = new Message();
//        EjecucionFisica oitem = new EjecucionFisica();
//        oitem.setIdfinanci(21);
//        String response = _EjecucionFisicaService.updateEstado(oitem);
//        oMensaje.convert(response);
//
//        return oMensaje;
//    }
    @RequestMapping(value = "/actualizarFuenteFinanciamiento", method = RequestMethod.POST)
    @ResponseBody
    public Message actualizarFuenteFinanciamiento(@RequestBody EjecucionFisica item) {
        Message msj = new Message();
        Message response = _EjecucionFisicaService.update(item);
        msj.setData(response);
        return msj;
    }

}
