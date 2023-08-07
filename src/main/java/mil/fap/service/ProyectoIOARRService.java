/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.ProyectoIOARR;
import mil.fap.models.ProyectoTipoIOARR;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.SolEjecucion;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.helpers.Message;

/**
 *
 * @author Jonathan
 */
public interface ProyectoIOARRService {

    Message setProyectoIOARR(NuevoIOARRRequest item);
    Message updateProyectoIOARR(NuevoIOARRRequest item);
    Message updateProyectoIOARRUIT(ProyectoIOARR item);
    Message updateProyectoIOARRCierreInv(ProyectoIOARR item);
    NuevoIOARRRequest getProyectoIOARR(Integer id);
    
    List<ProyectoTipoIOARR> getProyectoTipoIOARR(Integer id);
    Message updatePmi(ProyectoIOARR item);
    Message enviarProyectoIOARR(NuevoIOARRRequest item, SeguimientoProy _seguimientoProy);
    Message enviarProyectoIOARRUIT(ProyectoIOARR item, SeguimientoProy _seguimientoProy);
    Message enviarProyectoExpTecnico(ProyectoIOARR item);
    Message enviarProyectoComite(ProyectoIOARR item);
    Message updateProyectoIOARRNombreCodigo(ProyectoIOARR item);
    List<UnidadEjecutoraInver> getUnidadEjecutoraInversiones(int id);
}
