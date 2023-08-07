/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import mil.fap.dao.IdeasInversionData;
import mil.fap.helpers.Constantes;
import mil.fap.models.IdeasInversion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import mil.fap.service.IdeasInversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author mnieva
 */
@Service("ideasInversionService")
public class IdeasInversionServiceImplement implements IdeasInversionService {

    @Autowired
    IdeasInversionData data;
    
    @Override
    public DataTable<IdeasInversion> listPagination(IdeasInversion item) {
         Message msj = new Message();
        try{
          return data.listPagination(item);
          // msj.setSuccess(true);
          // msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        }catch(Exception ex){
            msj.setException(ex.getMessage());
            msj.setSuccess(false);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
            return null;
        }
    
    }
}
