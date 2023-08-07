/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.UnidadEjecutoraInverService;
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
@RequestMapping("/admin")
public class UnidadEjecutoraInverController {
    
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UnidadEjecutoraInverService InverService;
    

    @RequestMapping(value = "/unidadEjecutoraInver", method = RequestMethod.GET)
    public String UnidadEjecutoraInver(ModelMap model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        model.addAttribute("idusuario", item.getIdusuario());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.format(date);
        Integer anioActual = Integer.parseInt(dateFormat.format(date));
        for (int i = -1; i <= Constantes.Parametros.AnioActualHaciaAtras; i++) {
            map.put(anioActual + i, anioActual + i);

            model.addAttribute("anios", map);

            List<Usuario> lperfil = usuarioService.list();
            Map<String, String> usuario = new LinkedHashMap<String, String>();
            for (Usuario oUsuario : lperfil) {
                usuario.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
                usuario.put(oUsuario.getIdperfil().toString(), oUsuario.getPerfil());
            }
            model.addAttribute("lperfil", usuario);
        }

        return "unidadEjecutoraInver";
    }
 @RequestMapping(value = "/ListUnidadEjecutoraInver", method = RequestMethod.POST)
    @ResponseBody
    public Message UnidadEjecutoraInver(@RequestBody UnidadEjecutoraInver item) {
        Message msj = new Message();
        List<UnidadEjecutoraInver> oData = InverService.listPagination(item);
        msj.setData(oData);
        return msj;
    }

    @RequestMapping(value = "/registrarUnidadEjecutoraInver", method = RequestMethod.POST)
    @ResponseBody
    public Message registrar(@RequestBody UnidadEjecutoraInver item) {
        Message msj = new Message();
        String response = InverService.register(item);
        msj.convert(response);
        return msj;
    }
    
    @RequestMapping(value = "/actualizarEstadoUnidadEjecutoraInver", method = RequestMethod.GET)
    @ResponseBody
    public Message actualizarEstado(@RequestParam("id") int id) {
        Message oMensaje = new Message();
        UnidadEjecutoraInver oitem = new UnidadEjecutoraInver();
        oitem.setIdentificador(id);
        String response = InverService.updateEstado(oitem);
        oMensaje.convert(response);

        return oMensaje;
    }
}
