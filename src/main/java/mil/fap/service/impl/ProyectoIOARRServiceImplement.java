/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ProyectoIOARRData;
import mil.fap.dao.ProyectoTipoIOARRData;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.dao.UnidadEjecutoraInverData;
import mil.fap.helpers.Constantes;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.ProyectoTipoIOARR;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.helpers.Message;
import mil.fap.service.ProyectoIOARRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan
 */
@Service("proyectoIOARRService")
public class ProyectoIOARRServiceImplement implements ProyectoIOARRService {

    @Autowired
    ProyectoIOARRData _ProyectoIOARRData;
    @Autowired
    ProyectoTipoIOARRData _ProyectoTipoIOARRData;
    @Autowired
    SeguimientoProyData _SeguimientoProyData;
    @Autowired
    UnidadEjecutoraInverData _UnidadEjecutoraInverData;

    @Override
    public Message setProyectoIOARR(NuevoIOARRRequest item) {
        Message msj = new Message();
        try {
            item.getProyectoIOARR().setAprobacionPMI(Constantes.EstadosPMI.SinRevision);
            item.getProyectoIOARR().setIdEstadoActual(Constantes.EstadosPIP_IOARR.EnElaboracion);
            item.getProyectoIOARR().setIdProcesoActual(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
            Integer id = _ProyectoIOARRData.set(item.getProyectoIOARR());
            item.getProyectoIOARR().setIdProyectoIOARR(id);

            for (ProyectoTipoIOARR i : item.getListProyectoTipoIOARR()) {
                i.setIdProyIOARR(id);
                _ProyectoTipoIOARRData.set(i);
            }

            SeguimientoProy seguimientoProy = new SeguimientoProy();
            seguimientoProy.setIdproioarr(id);
            seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.EnElaboracion);
            seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
            _SeguimientoProyData.setIOARR(seguimientoProy);

            msj.setData(item.getProyectoIOARR());
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message updateProyectoIOARR(NuevoIOARRRequest item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoIOARRData.update(item.getProyectoIOARR());
            item.getProyectoIOARR().setIdProyectoIOARR(id);

            ProyectoTipoIOARR _proyectoTipoIOARR = new ProyectoTipoIOARR();
            _proyectoTipoIOARR.setIdProyIOARR(id);
            _proyectoTipoIOARR.setUsucreacio(item.getProyectoIOARR().getUsucreacio());
            _ProyectoTipoIOARRData.update(_proyectoTipoIOARR);

            for (ProyectoTipoIOARR i : item.getListProyectoTipoIOARR()) {
                i.setIdProyIOARR(id);
                _ProyectoTipoIOARRData.set(i);
            }
            msj.setData(item.getProyectoIOARR());
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message updateProyectoIOARRUIT(ProyectoIOARR item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoIOARRData.updateUIT(item);
            item.setIdProyectoIOARR(id);
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
    public Message updateProyectoIOARRCierreInv(ProyectoIOARR item) {
        Message msj = new Message();
        try {
            _ProyectoIOARRData.updateCierreInv(item);
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
    public NuevoIOARRRequest getProyectoIOARR(Integer id) {
        NuevoIOARRRequest obj = new NuevoIOARRRequest();
        obj.setProyectoIOARR(_ProyectoIOARRData.getById(id));
        obj.setListProyectoTipoIOARR(_ProyectoTipoIOARRData.list(id));
        return obj;
    }

    @Override
    public List<ProyectoTipoIOARR> getProyectoTipoIOARR(Integer id) {
        return _ProyectoTipoIOARRData.list(id);
    }

    @Override
    public Message updatePmi(ProyectoIOARR item) {
        Message msj = new Message();
        try {
            _ProyectoIOARRData.updatePmi(item);
            if (item.getAprobacionPMI().equals(Constantes.EstadosPMI.Aprobado)) {
                SeguimientoProy _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
                _seguimientoProy.setIdproioarr(item.getIdProyectoIOARR());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setIOARR(_seguimientoProy);

                _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.AprobacionIOARR);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
                _seguimientoProy.setIdproioarr(item.getIdProyectoIOARR());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setIOARR(_seguimientoProy);
            } else {
                SeguimientoProy _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
                _seguimientoProy.setIdproioarr(item.getIdProyectoIOARR());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setIOARR(_seguimientoProy);
            }
            msj.setSuccess(true);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setSuccess(false);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message enviarProyectoIOARR(NuevoIOARRRequest item, SeguimientoProy _seguimientoProy) {

        Message msj = new Message();
        try {
            updateProyectoIOARR(item);
            _SeguimientoProyData.setIOARR(_seguimientoProy);
            msj.setData(item.getProyectoIOARR());
            msj.setSuccess(true);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setSuccess(false);
            msj.setException(ex.getMessage());
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;

    }

    @Override
    public Message enviarProyectoExpTecnico(ProyectoIOARR item) {

        Message msj = new Message();
        try {

            SeguimientoProy _seguimientoProy = new SeguimientoProy();
            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente);
            _seguimientoProy.setIdproioarr(item.getIdProIOARR());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setIOARR(_seguimientoProy);

            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.InformeConsistencia);
            _seguimientoProy.setIdproioarr(item.getIdProIOARR());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setIOARR(_seguimientoProy);

            msj.setData(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;

    }

    @Override
    public Message enviarProyectoComite(ProyectoIOARR item) {

        Message msj = new Message();
        try {
            SeguimientoProy _seguimientoProy = new SeguimientoProy();
            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
            _seguimientoProy.setIdproioarr(item.getIdProIOARR());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setIOARR(_seguimientoProy);

            //actualizar seguimiento PIP plan de trabajo sin registro
            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente);
            _seguimientoProy.setIdproioarr(item.getIdProIOARR());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setIOARR(_seguimientoProy);

            msj.setData(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;

    }

    @Override
    public Message enviarProyectoIOARRUIT(ProyectoIOARR item, SeguimientoProy _seguimientoProy) {

        Message msj = new Message();
        try {
            updateProyectoIOARRUIT(item);
            updateProyectoIOARRNombreCodigo(item);
            _SeguimientoProyData.setIOARR(_seguimientoProy);
            msj.setData(item);
            msj.setSuccess(true);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setSuccess(false);
            msj.setException(ex.getMessage());
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;

    }

    @Override
    public Message updateProyectoIOARRNombreCodigo(ProyectoIOARR item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoIOARRData.updateNombreCodigo(item);
            item.setIdProIOARR(id);
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
    public List<UnidadEjecutoraInver> getUnidadEjecutoraInversiones(int id) {

        return _UnidadEjecutoraInverData.getAll(id);

    }

}
