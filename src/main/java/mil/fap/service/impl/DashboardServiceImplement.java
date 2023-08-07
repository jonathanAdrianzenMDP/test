/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.DashboardData;
import mil.fap.models.Dashboard;
import mil.fap.models.FuenteFinancieroEN;
import mil.fap.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("dashboardService")
public class DashboardServiceImplement implements DashboardService{
    
    @Autowired
    DashboardData data;

    @Override
    public List<Dashboard> getCantidadIdeasInversion(Dashboard item) {
       return data.getCantidadIdeasInversion(item);
    }
    @Override
    public List<Dashboard> getTotalCostoIdeasInversion(Dashboard item) {
       return data.getTotalCostoIdeasInversion(item);
    }

    @Override
    public List<FuenteFinancieroEN> getFuenteFinanciamiento(FuenteFinancieroEN item) {
        return data.getFuenteFinanciamiento(item);
    }

}
