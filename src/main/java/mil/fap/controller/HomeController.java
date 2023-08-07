/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mil.fap.models.Usuario;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author jmezas
 */
@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    UsuarioService usuarioService;
    
    @RequestMapping(value = {"/login.html"}, method = RequestMethod.GET)
    public String loginPage(Model model) {
 
        return "login";
    }
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:login.html";
    }
    @RequestMapping(value = {"/DeniedPage"}, method = RequestMethod.GET)
    public String DeniedPage(Model model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        return "template/error";
    }
}
