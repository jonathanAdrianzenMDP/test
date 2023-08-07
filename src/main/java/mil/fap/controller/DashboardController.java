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
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.Dashboard;
import mil.fap.models.FuenteFinancieroEN;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.DashboardService;
import mil.fap.service.IdeasInversionService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author jadrianzen
 */

@Controller
@RequestMapping("/admin")
public class DashboardController {
    @Autowired
    UsuarioService usuarioService;
    
    @Autowired
    DashboardService dashboardService;
    
    @Autowired
    IdeasInversionService ideasInversionService;
    
    @RequestMapping(value = {"/dashboard"}, method = RequestMethod.GET)
    public String dashboard(Model model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("infoPerfil", item.getIdperfil());
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        dateFormat.format(date);
        Integer anioActual = Integer.parseInt(dateFormat.format(date));
        for (int i = -1; i <= Constantes.Parametros.AnioActualHaciaAtras; i++) {
            map.put(anioActual + i, anioActual + i);
        }
        model.addAttribute("anios", map);
        model.addAttribute("anioActual", anioActual);
        
        return "dashboard";
    }
    
    @RequestMapping(value = "/getTotalIdeas", method = RequestMethod.POST)
    public @ResponseBody
    Message getCantidadTotalIdeas(@RequestParam("anio") int anio) {
        Message msj = new Message();
         Dashboard _dashboard = new Dashboard();
        _dashboard.setAnio(anio);
        _dashboard.setEstadoactu(Constantes.Todos.value);
        _dashboard.setProcactual(Constantes.Todos.value);
        List<Dashboard> result =  dashboardService.getCantidadIdeasInversion(_dashboard);
         msj.setData(result);
        return msj;
    }
    
    @RequestMapping(value = "/getCostoTotalIdeas", method = RequestMethod.POST)
    public @ResponseBody
    Message getCostoTotalIdeas(@RequestParam("anio") int anio) {
        Message msj = new Message();
         Dashboard _dashboard = new Dashboard();
        _dashboard.setAnio(anio);
        List<Dashboard> result =  dashboardService.getTotalCostoIdeasInversion(_dashboard);
        
         msj.setData(result);
        return msj;
    }
    
    @RequestMapping(value = "/getTotalFuenteFinanc", method = RequestMethod.POST)
    public @ResponseBody
    Message getTotalFuenteFinanc(@RequestParam("anio") int anio) {
        Message msj = new Message();
         FuenteFinancieroEN _item = new FuenteFinancieroEN();
        _item.setAnio(anio);
        List<FuenteFinancieroEN> result =  dashboardService.getFuenteFinanciamiento(_item);
        
         msj.setData(result);
        return msj;
    }
    
}