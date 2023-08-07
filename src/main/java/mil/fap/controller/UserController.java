/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.Usuario;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import mil.fap.models.helpers.Message;
import mil.fap.models.helpers.SelectItem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Jonathan
 */
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = "/controlAcceso", method = RequestMethod.GET)
    public String controlAcceso(ModelMap model) {
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

        return "controlAccesos";
    }

    @RequestMapping(value = "/actualizarContraseña", method = RequestMethod.GET)
    public String actualizarContraseña(ModelMap model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
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

        return "actualizarContraseña";
    }

    @RequestMapping(value = "/ListControlAcceso", method = RequestMethod.POST)
    @ResponseBody
    public Message Usuario(@RequestBody Usuario item) {
        Message msj = new Message();
        List<Usuario> oData = usuarioService.listPagination(item);
        msj.setData(oData);
        return msj;
    }

    @RequestMapping(value = "/BuscarUsuario", method = RequestMethod.GET)
    public @ResponseBody
    Message usuario(ModelMap model, @RequestParam("nsa") String nsa) {
        Message msj = new Message();
        Usuario oUsuario = usuarioService.buscarPorNsa(nsa);
        if (oUsuario != null) {
            msj.setData(oUsuario);
        } else {
            msj.convert(Constantes.Mensajes.MensajeUsuarioNoEncontrado);
        }
        return msj;
    }

    @RequestMapping(value = "/registrarUsuario", method = RequestMethod.POST)
    @ResponseBody
    public Message insertar(@RequestBody Usuario usuario) {
        Message msj = new Message();
        String response = usuarioService.insertar(usuario);
        msj.convert(response);
        return msj;

    }

    @RequestMapping(value = {"/actualizarEstadoUsuario"}, method = RequestMethod.POST)
    @ResponseBody
    public Message actualizarEstadoUsuario(@RequestBody Usuario item) {
        Message msg;
        msg = usuarioService.updateEstado(item);
        return msg;
    }

    @RequestMapping(value = "/actualizarUsuarioPassword", method = RequestMethod.POST)
    @ResponseBody
    public Message actualizarUsuarioPassword(@RequestBody Usuario item) {
//        Message msj = new Message();
        Message msj = usuarioService.updateUsuarioPassword(item);
//        msj.setData(response);
        return msj;
    }

    @RequestMapping(value = "/actualizarUsuarioPerfil", method = RequestMethod.POST)
    @ResponseBody
    public Message actualizarUsuarioPerfil(@RequestBody Usuario item) {
//       Message msj = new Message();
//       Message response = usuarioService.updateUsuarioPerfil(item);
//       msj.setData(response);
        Message msj = usuarioService.updateUsuarioPerfil(item);
        return msj;
    }

    @RequestMapping(value = "/getUsuarioPassword", method = RequestMethod.GET)
    public @ResponseBody
    Message ComiteTrabajo(@RequestParam("id") int id) {
        Message msj = new Message();
        msj.setData(usuarioService.buscarPorId(id));
        return msj;
    }

    @RequestMapping(value = "/cargarPerfil", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarPerfil(@RequestBody SelectItem item) {

        Message msj = new Message();

        List<Usuario> lUsuario = usuarioService.list();
        List<SelectItem> lItemsUsuario = new ArrayList();
        for (Usuario oUsuario : lUsuario) {
            lItemsUsuario.add(
                    new SelectItem(
                            oUsuario.getIdperfil().toString(),
                            oUsuario.getPerfil()
                    )
            );
        }
        msj.setData(lItemsUsuario);

        return msj;
    }
    
       @RequestMapping(value = "/listMenu", method = RequestMethod.POST)
    public @ResponseBody
    Message listMenu(@RequestBody SelectItem item) {

        Message msj = new Message();

        List<Usuario> lUsuario = usuarioService.listMenu();
        List<SelectItem> lItemsUsuario = new ArrayList();
        for (Usuario oUsuario : lUsuario) {
            lItemsUsuario.add(
                    new SelectItem(
                            oUsuario.getIdmenu().toString(),
                            oUsuario.getMenu()
                    )
            );
        }
        msj.setData(lItemsUsuario);

        return msj;
    }
    
    

//    @RequestMapping(value = "/getPermisoAcciones", method = RequestMethod.POST)
//    @ResponseBody
//    public Message getPermisoAcciones(@RequestParam("id") Integer idperfil) {
//        Usuario item = usuarioService.PerfilAccion(new Usuario());
//        Message msj = new Message();
//        item.getIdperfil();
//        item.getIdaccion();
//        return msj;
//    }
//    @RequestMapping(value = "/getPermisoMenu", method = RequestMethod.POST)
//    @ResponseBody
//    public Message getPermisoMenu() {
//        Usuario item = usuarioService.PerfilMenu(new Usuario());
//        Message msj = new Message();
//        item.getIdperfil();
//        item.getIdmenu();
//        item.getMenu();
//        item.getUrl();
//        item.getClase();
// 
//        return msj;
//    }
    @RequestMapping(value = "/getPermisoMenu", method = RequestMethod.POST)
    @ResponseBody
    public Message getPermisoMenu(@RequestParam("id") Integer idperfil) {
        Message msj = new Message();
        msj.setData(usuarioService.PerfilMenu(idperfil));
        return msj;

    }
    
    
    
}
