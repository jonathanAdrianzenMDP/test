/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import mil.fap.models.ParametroValor;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.ParametroValorService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author jadrianzen
 */
@Controller
@RequestMapping("/admin")
public class ParametroValorController {

    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ParametroValorService parametroValorService;

    @RequestMapping(value = {"/mantParametroValor"}, method = RequestMethod.GET)
    public ModelAndView index(ModelMap model) {
        ModelAndView mv = new ModelAndView("mantParametroValor");
        Usuario item = usuarioService.getLogin(new Usuario());
        mv.addObject("userInfo", item);
        mv.addObject("infoPerfil", item.getIdperfil());
        mv.addObject("parametroValor", parametroValorService.listParametro());
        return mv;
    }

    @RequestMapping(value = {"/listParametroValor"}, method = RequestMethod.POST)
    @ResponseBody
    public Message listParametroValor(@RequestBody ParametroValor item) {
        Message msg = new Message();
        msg.setData(parametroValorService.listAll(item.getIdparame()));
        return msg;
    }

    @RequestMapping(value = {"/deleteParametroValor"}, method = RequestMethod.POST)
    @ResponseBody
    public Message deleteParametroValor(@RequestBody ParametroValor item) {
        Message msg;
        msg = parametroValorService.deleteParametro(item);
        return msg;
    }

    @RequestMapping(value = {"/addParametroValor"}, method = RequestMethod.POST)
    @ResponseBody
    public Message addParametroValor(@RequestBody ParametroValor item) {
        Message msg;
        msg = parametroValorService.add(item);
        return msg;
    }
}
