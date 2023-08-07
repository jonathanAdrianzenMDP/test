/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.UnidadEjecutoraInverData;
import mil.fap.helpers.Constantes;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.service.UnidadEjecutoraInverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("unidadEjecutoraInverService")
public class UnidadEjecutoraInverServiceImplement implements UnidadEjecutoraInverService{
    
    @Autowired
    UnidadEjecutoraInverData data;

    @Override
    public List<UnidadEjecutoraInver> listPagination(UnidadEjecutoraInver item) {
         return data.listPagination(item);
    }

    @Override
    public String register(UnidadEjecutoraInver item) {

            try {
            String oCodigo = data.register(item);
            if (oCodigo.equals("0")) {
                return Constantes.Mensajes.MensajeUsuarioDuplicado;
            }
            return Constantes.Mensajes.MensajeGuardarExito;
        } catch (Exception ex) {
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
    }

    @Override
    public String updateEstado(UnidadEjecutoraInver item) {
       try {
            data.updateEstado(item);
        } catch (Exception ex) {
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
        return Constantes.Mensajes.MensajeCambiarEstado;
    }
}
