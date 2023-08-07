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
import mil.fap.models.ParametroValor;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.LiquidacionInversionService;
import mil.fap.service.ObservacionService;
import mil.fap.service.ParametroValorService;
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
public class LiquidacionInversionController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    LiquidacionInversionService _LiquidacionInversionService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    @Autowired
    ParametroValorService parametroValorService;
    @Autowired
    ObservacionService observacionService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @RequestMapping(value = {"/liquidacionInversionPIP"}, method = RequestMethod.GET)
    public String index(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.LiquidacionInversion);
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

        List<ParametroValor> CierreInversiones = parametroValorService.list(Constantes.Parametros.CierreInversiones);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : CierreInversiones) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("CierreInversiones", hashMap);
       
        return "liquidacionInversionPIP";
    }

    @RequestMapping(value = {"/liquidacionInversionIOARR"}, method = RequestMethod.GET)
    public String indexIOARR(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.LiquidacionInversion);
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

        List<ParametroValor> CierreInversiones = parametroValorService.list(Constantes.Parametros.CierreInversiones);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : CierreInversiones) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("CierreInversiones", hashMap);

        return "liquidacionInversionIOARR";
    }

    @RequestMapping(value = "/aprobarLiquidacionInversion", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarLiquidacionInversion(@RequestBody SeguimientoProy item) {
        Message msj = _LiquidacionInversionService.aprobar(item);
        return msj;
    }

    @RequestMapping(value = "/registrarCierreInversion", method = RequestMethod.POST)
    @ResponseBody
    public Message registrarCierreInversion(@RequestBody ProyectoIOARR item) {
        Message msj = new Message();
        Message response = proyectoIOARRService.updateProyectoIOARRCierreInv(item);
        msj.setData(response);
        return msj;
    }

    @RequestMapping(value = "/registrarCierreInversionPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message registrarCierreInversionPIP(@RequestBody ProyectoPIP item) {
        Message msj = new Message();
        Message response = proyectoPIPService.updateProyectoPIPCierreInv(item);
        msj.setData(response);
        return msj;
    }
    
        @RequestMapping(value = "/regresar", method = RequestMethod.POST)
    @ResponseBody
    public Message regresar(@RequestBody SeguimientoProy item) {
        Message msj = _LiquidacionInversionService.regresar(item);
        return msj;
    }

}
