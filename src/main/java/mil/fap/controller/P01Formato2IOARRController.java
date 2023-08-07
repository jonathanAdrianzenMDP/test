/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import mil.fap.models.Usuario;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author cristina
 */
@Controller
@RequestMapping("/")
public class P01Formato2IOARRController {

    @Autowired
    UsuarioService usuarioService;

    @RequestMapping(value = {"/p01Formato2IOARR"}, method = RequestMethod.GET)
    public String index(Model model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        return "p01Formato2IOARR";
    }

}
