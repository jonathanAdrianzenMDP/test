/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.DocumentoAdjunto;
import mil.fap.models.helpers.Message;

/**
 *
 * @author Jonathan
 */
public interface DocumentoAdjuntoService {
    public Message set(DocumentoAdjunto item);
    public List<DocumentoAdjunto> getAll(DocumentoAdjunto item);
    public String updateEstado(DocumentoAdjunto item);   
    DocumentoAdjunto getDocumento(DocumentoAdjunto item);
}
