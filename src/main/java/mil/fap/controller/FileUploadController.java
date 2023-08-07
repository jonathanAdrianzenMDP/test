/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Util;
import mil.fap.models.DocumentoAdjunto;
import mil.fap.models.ParametroValor;
import mil.fap.models.helpers.Message;
import mil.fap.service.DocumentoAdjuntoService;
import mil.fap.service.ParametroValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 *
 * @author Jonathan
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {
   @Autowired
   DocumentoAdjuntoService documentoAdjuntoService;
   @Autowired
    ParametroValorService parametroValorService;
   
   @PostMapping("/changefile")
   public @ResponseBody Message fileUpload(MultipartHttpServletRequest request)
         throws IOException {
       String url = System.getProperty("user.home");
              
       Util _util = new Util();
        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.URL);
        for (ParametroValor oItem : lstResult) {
       
            url += File.separator + oItem.getValor() +File.separator;
        }
        
       Message msj = _util.sendFileServer(request,url);
       
       return msj;
   }
   
   @RequestMapping(value = "/savefile", method = RequestMethod.POST)
   public @ResponseBody Message sendFileUpload(@RequestBody DocumentoAdjunto item)
   {
       Message msj;
      // item.setUsucreacio("UsuarioDemo");
       if(item.getIDBRECINDI() == null)
       item.setIDBRECINDI(0);
       if(item.getIDPROIOARR()== null)
       item.setIDPROIOARR(0);
       if(item.getIDPROYEPIP()== null)
       item.setIDPROYEPIP(0);
       msj = documentoAdjuntoService.set(item);
       
       return msj;
   }
   
   @RequestMapping(value = "/listfile", method = RequestMethod.POST)
   public @ResponseBody Message listFileUpload(@RequestBody DocumentoAdjunto item)
   {
       Message msj = new Message();
        msj.setData(documentoAdjuntoService.getAll(item));
        return msj;
       
   }
   

    @RequestMapping(value = "/updateEstado", method = RequestMethod.GET)
    @ResponseBody
    public Message actualizarEstado(@RequestParam("id") int id) {
        
        Message oMensaje = new Message();
        DocumentoAdjunto oitem = new DocumentoAdjunto();
        oitem.setIDDOCUMENT(id);
        String response = documentoAdjuntoService.updateEstado(oitem);
        oMensaje.convert(response);

        return oMensaje;
    }
       
   
}
