/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ParametroValorData;
import mil.fap.helpers.Constantes;
import mil.fap.models.ParametroValor;
import mil.fap.models.helpers.Message;
import mil.fap.service.ParametroValorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("parametroValorService")
public class ParametroValorServiceImplement implements ParametroValorService{
    
    @Autowired
    ParametroValorData data;
    
    @Override
    public Message add(ParametroValor item) {
        Message msg = new Message();
        try{
            if(item.getIdparamval().equals(0)){
            data.add(item);    
            }else{
                data.update(item);
            }
            msg.setSuccess(true);
            msg.convert(Constantes.Mensajes.MensajeGuardarExito);
        }catch(Exception ex){
            msg.setSuccess(false);
            msg.convert(Constantes.Mensajes.MensajeErrorExcepcion);
            msg.setException(ex.getMessage());
        }
        return msg;
    }
    
    
    @Override
    public List<ParametroValor> list(int idparametro) {
        return data.list(idparametro);
    }
    
    @Override
    public List<ParametroValor> listAll(int idparametro) {
        return data.listAll(idparametro);
    }

    @Override
    public List<ParametroValor> listParametro() {
        return data.listParametro(); 
    }
    
    @Override
    public Message deleteParametro(ParametroValor item) {
        Message msg = new Message();
        try{
            data.deleteParametro(item);
            msg.setSuccess(true);
            msg.convert(item.isEstado()==true?Constantes.Mensajes.MensajeCambiarEstadoActivo: Constantes.Mensajes.MensajeCambiarEstado);
        }catch(Exception ex){
            msg.setSuccess(false);
            msg.convert(Constantes.Mensajes.MensajeErrorExcepcion);
            msg.setException(ex.getMessage());
        }
        return msg;
    }
}
