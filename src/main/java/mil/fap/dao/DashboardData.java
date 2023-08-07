/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.Dashboard;
import mil.fap.models.FuenteFinancieroEN;

/**
 *
 * @author jmezas
 */
public interface DashboardData {
    
        List<Dashboard> getCantidadIdeasInversion(Dashboard item);
        List<Dashboard> getTotalCostoIdeasInversion(Dashboard item);
        List<FuenteFinancieroEN> getFuenteFinanciamiento(FuenteFinancieroEN item);
}
    

