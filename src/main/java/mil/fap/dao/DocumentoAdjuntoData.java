/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.DocumentoAdjunto;

/**
 *
 * @author Jonathan
 */
public interface DocumentoAdjuntoData {
    public Integer set(DocumentoAdjunto item);
    public List<DocumentoAdjunto> getAll(DocumentoAdjunto item);
    public String updateEstado(DocumentoAdjunto item);
    DocumentoAdjunto get(DocumentoAdjunto item);
}
