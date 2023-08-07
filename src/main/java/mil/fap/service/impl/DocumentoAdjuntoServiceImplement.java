/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;
import java.util.List;
import mil.fap.dao.DocumentoAdjuntoData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Util;
import mil.fap.models.DocumentoAdjunto;
import mil.fap.models.helpers.Message;
import mil.fap.service.DocumentoAdjuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan
 */
@Service("documentoAdjuntoService")
public class DocumentoAdjuntoServiceImplement implements DocumentoAdjuntoService {
    @Autowired
    DocumentoAdjuntoData data;
    
    @Override
    public Message set(DocumentoAdjunto item) {
        Message msj = new Message();
        try{
            item.setByteDOC(Util.readFileToByteArray(item.getURLDOC()));
            data.set(item);
            Util.deleteFile(item.getURLDOC());
            msj.setSuccess(true);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        }catch(Exception ex){
            msj.setException(ex.getMessage());
            msj.setSuccess(false);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public List<DocumentoAdjunto> getAll(DocumentoAdjunto item) {
        return data.getAll(item);
    }
      
      @Override
    public String updateEstado(DocumentoAdjunto item) {
        try{
            data.updateEstado(item);
        }catch(Exception ex){
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
        return Constantes.Mensajes.MensajeCambiarEstado;
    }
    
    @Override
    public DocumentoAdjunto getDocumento(DocumentoAdjunto item) {
        
        return data.get(item);
    }
}
