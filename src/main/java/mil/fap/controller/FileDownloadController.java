/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Util;
import mil.fap.models.DocumentoAdjunto;
import mil.fap.models.ParametroValor;
import mil.fap.service.DocumentoAdjuntoService;
import mil.fap.service.ParametroValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Jonathan
 */
@Controller
@RequestMapping("/download")
public class FileDownloadController {

    @Autowired
    ParametroValorService parametroValorService;
    @Autowired
    DocumentoAdjuntoService  _DocumentoAdjuntoService;
    
    @RequestMapping("/file/{fileName:.+}")
    public void downloadPDFResource(HttpServletRequest request,
            HttpServletResponse response,
            @PathVariable("fileName") String fileName) {
       
        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.URL);
        for (ParametroValor oItem : lstResult) {
            
            //OBTENEMOS DATOS DEL DOCUMENTO A DESCARGAR
            DocumentoAdjunto item = new DocumentoAdjunto();
            item.setNOMDOC(fileName);
            item = _DocumentoAdjuntoService.getDocumento(item);
            
            //GENERAMOS EL DOCUMENTO FROM ARRAY BYTE
            String urlWriteFile = System.getProperty("user.home");
            urlWriteFile += File.separator + oItem.getValor() +File.separator;
            File f = new File(urlWriteFile);
            if(!f.exists()){
               f.mkdirs();
            }
            urlWriteFile += fileName;
            Util.writeBytesToFile(item.getByteDOC(), urlWriteFile);
            Path pathfileOrigen = Paths.get(urlWriteFile);
            
            //DESCARGAMOS EL ARCHIVO SEGUN LA EXTENSION    
            File newfile = new File(urlWriteFile);
            String extension = Util.getFileExtension(newfile);
            switch (extension) {
                case "doc":
                    response.setContentType("application/msword");
                    break;
                case "docx":
                    response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
                    break;
                default:
                    response.setContentType("application/"+extension+"");
                    break;
            }
            response.setHeader("Content-Disposition","attachment;filename="+newfile.getName());
           
            try {
                Files.copy(pathfileOrigen, response.getOutputStream());
                response.getOutputStream().flush();
                Util.deleteFile(urlWriteFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
        }
    }
}
