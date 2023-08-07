/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ComiteTrabajoData;
import mil.fap.helpers.Constantes;
import mil.fap.models.ComiteTrabajo;
import mil.fap.models.helpers.Message;
import mil.fap.service.ComiteTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmeza
 */
@Service("comiteTrabajoService")
public class ComiteTrabajoServiceImplement implements ComiteTrabajoService {

    @Autowired
    ComiteTrabajoData data;

    @Override
    public List<ComiteTrabajo> listPagination(ComiteTrabajo item) {
        return data.listPagination(item);
    }

    @Override
    public Message register(ComiteTrabajo item) {
        Message msj = new Message();
        try {
            data.register(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message update(ComiteTrabajo item) {
        Message msj = new Message();
        try {
            data.update(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public ComiteTrabajo buscarPorId(Integer idintegrante) {
        return data.buscarPorId(idintegrante);
    }

    @Override
    public String updateEstado(ComiteTrabajo item) {
        try {
            data.updateEstado(item);
        } catch (Exception ex) {
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
        return Constantes.Mensajes.MensajeCambiarEstado;
    }

}
