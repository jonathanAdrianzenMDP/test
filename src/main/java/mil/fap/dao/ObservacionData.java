/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.Observacion;

/**
 *
 * @author cristina
 */
public interface ObservacionData {
    String insert(Observacion item);
    List<Observacion> getAll(Observacion item);
}
