/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.Inversion;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.ProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.TipoItem;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.helpers.Message;

/**
 *
 * @author jmezas
 */
public interface ProyectoPIPService {

    Message setProyectoPIP(NuevoPIPRequest item);

    Message updateProyectoPIP(NuevoPIPRequest item);

    NuevoPIPRequest getProyectoPIP(Integer id);

    List<TipoItem> getTipoItem(Integer id);

    List<Inversion> getInversion(Integer id);

    Message updatePmiPIP(ProyectoPIP item);

    Message updateProyectoPIPFechaPlan(ProyectoPIP item);
    
    Message updateProyectoPIPNombreCodigo(ProyectoPIP item);

    Message enviarProyectoPIP(NuevoPIPRequest item, SeguimientoProy _seguimientoProy);

    Message enviarReferenciaPIP(ProyectoPIP item, SeguimientoProy _seguimientoProy);

    Message enviarProyectoComite(ProyectoPIP item);

    Message enviarProyectoPerfil(ProyectoPIP item, SeguimientoProy _seguimientoProy);

    List<UnidadEjecutoraInver> getUnidadEjecutoraInversiones(int id);

    Message updateProyectoPIPCierreInv(ProyectoPIP item);

}
