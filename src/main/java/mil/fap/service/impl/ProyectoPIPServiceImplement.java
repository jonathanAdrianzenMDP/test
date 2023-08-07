/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.InversionData;
import mil.fap.dao.ProyectoPIPData;
import mil.fap.dao.SeguimientoProyData;
import mil.fap.dao.TipoItemData;
import mil.fap.dao.UnidadEjecutoraInverData;
import mil.fap.helpers.Constantes;
import mil.fap.models.Inversion;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.TipoItem;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.helpers.Message;
import mil.fap.service.ProyectoPIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("proyectoPIPService")
public class ProyectoPIPServiceImplement implements ProyectoPIPService {

    @Autowired
    ProyectoPIPData _ProyectoPIPData;

    @Autowired
    SeguimientoProyData _SeguimientoProyData;

    @Autowired
    TipoItemData _TipoItemData;

    @Autowired
    InversionData _InversionData;

    @Autowired
    UnidadEjecutoraInverData _UnidadEjecutoraInverData;

    @Override
    public Message setProyectoPIP(NuevoPIPRequest item) {
        Message msj = new Message();
        try {
            item.getProyectoPIP().setAprobacpmi(Constantes.EstadosPMI.SinRevision);
            item.getProyectoPIP().setEstado(Constantes.EstadoRegistro.EstadoActivo);
            item.getProyectoPIP().setEstadoactu(Constantes.EstadosPIP_IOARR.EnElaboracion);
            item.getProyectoPIP().setProcactual(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
            Integer id = _ProyectoPIPData.set(item.getProyectoPIP());
            item.getProyectoPIP().setIdProyepip(id);

            for (TipoItem i : item.getListTipoItem()) {
                i.setIdproyepip(id);
                _TipoItemData.set(i);
            }
            for (Inversion i : item.getListInversion()) {
                i.setIdproyepip(id);
                _InversionData.set(i);
            }
            SeguimientoProy seguimientoProy = new SeguimientoProy();
            seguimientoProy.setIdproyepip(id);
            seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.EnElaboracion);
            seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
            _SeguimientoProyData.setPIP(seguimientoProy);

            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item.getProyectoPIP());
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Message updateProyectoPIP(NuevoPIPRequest item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoPIPData.update(item.getProyectoPIP());
            item.getProyectoPIP().setIdProyepip(id);

            TipoItem _TipoItem = new TipoItem();
            _TipoItem.setIdproyepip(id);
            _TipoItem.setUsucreacio(item.getProyectoPIP().getUsucreacio());
            _TipoItemData.update(_TipoItem);

            for (TipoItem i : item.getListTipoItem()) {
                i.setIdproyepip(id);
                _TipoItemData.set(i);
            }

            Inversion _Inversion = new Inversion();
            _Inversion.setIdproyepip(id);
            _Inversion.setUsucreacio(item.getProyectoPIP().getUsucreacio());
            _InversionData.update(_Inversion);

            for (Inversion i : item.getListInversion()) {
                i.setIdproyepip(id);
                _InversionData.set(i);
            }

            msj.setData(item.getProyectoPIP());
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public NuevoPIPRequest getProyectoPIP(Integer id) {
        NuevoPIPRequest result = new NuevoPIPRequest();
        result.setProyectoPIP(_ProyectoPIPData.get(id));

        result.setListTipoItem(_TipoItemData.list(id));
        result.setListInversion(_InversionData.list(id));

        return result;
    }

    @Override
    public Message updatePmiPIP(ProyectoPIP item) {
        Message msj = new Message();
        try {
            _ProyectoPIPData.updatePmiPIP(item);
            if (item.getAprobacpmi().equals(Constantes.EstadosPMI.Aprobado)) {
                SeguimientoProy _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
                _seguimientoProy.setIdproyepip(item.getIdProyepip());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setPIP(_seguimientoProy);

                _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
                _seguimientoProy.setIdproyepip(item.getIdProyepip());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setPIP(_seguimientoProy);

            } else {
                SeguimientoProy _seguimientoProy = new SeguimientoProy();
                _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
                _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
                _seguimientoProy.setIdproyepip(item.getIdProyepip());
                _seguimientoProy.setUsucreacio(item.getUsucreacio());
                _seguimientoProy.setIpTerminal(item.getIpTerminal());
                _SeguimientoProyData.setPIP(_seguimientoProy);
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
    public Message updateProyectoPIPCierreInv(ProyectoPIP item) {
        Message msj = new Message();
        try {
            _ProyectoPIPData.updateCierreInvPIP(item);
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
    public List<TipoItem> getTipoItem(Integer id) {
        return _TipoItemData.list(id);
    }

    @Override
    public Message enviarProyectoPIP(NuevoPIPRequest item, SeguimientoProy _seguimientoProy) {

        Message msj = new Message();
        try {
            updateProyectoPIP(item);
            _SeguimientoProyData.setPIP(_seguimientoProy);
            msj.setData(item.getProyectoPIP());
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
    public Message updateProyectoPIPFechaPlan(ProyectoPIP item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoPIPData.updateFechaPlan(item);
            item.setIdProyepip(id);
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
    public Message updateProyectoPIPNombreCodigo(ProyectoPIP item) {
        Message msj = new Message();
        try {
            Integer id = _ProyectoPIPData.updateNombreCodigo(item);
            item.setIdProyepip(id);
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
    public Message enviarProyectoComite(ProyectoPIP item) {

        Message msj = new Message();
        try {
            updateProyectoPIPFechaPlan(item);
            //actualizar seguimiento PIP de comite aprobado
            SeguimientoProy _seguimientoProy = new SeguimientoProy();
            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.ComiteTrabajo);
            _seguimientoProy.setIdproyepip(item.getIdProyepip());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setPIP(_seguimientoProy);

            //actualizar seguimiento PIP plan de trabajo sin registro
            _seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
            _seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef);
            _seguimientoProy.setIdproyepip(item.getIdProyepip());
            _seguimientoProy.setUsucreacio(item.getUsucreacio());
            _seguimientoProy.setIpTerminal(item.getIpTerminal());
            _SeguimientoProyData.setPIP(_seguimientoProy);

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
    public List<UnidadEjecutoraInver> getUnidadEjecutoraInversiones(int id) {
        return _UnidadEjecutoraInverData.getAll(id);
    }

    @Override
    public List<Inversion> getInversion(Integer id) {
        return _InversionData.list(id);

    }

    @Override
    public Message enviarReferenciaPIP(ProyectoPIP item, SeguimientoProy _seguimientoProy) {
        Message msj = new Message();
        try {
            _SeguimientoProyData.setPIP(_seguimientoProy);
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
    public Message enviarProyectoPerfil(ProyectoPIP item, SeguimientoProy _seguimientoProy) {

        Message msj = new Message();
        try {
            updateProyectoPIPNombreCodigo(item);
            _SeguimientoProyData.setPIP(_seguimientoProy);
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
}
