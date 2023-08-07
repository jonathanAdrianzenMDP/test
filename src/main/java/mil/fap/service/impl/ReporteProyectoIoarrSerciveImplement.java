/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ReportePoyectoIoarrData;
import mil.fap.models.ReportePoyectoIoarr;
import mil.fap.service.ReporteProyectoIoarrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristina
 */
@Service("reporteProyectoIoarrService")
public class ReporteProyectoIoarrSerciveImplement implements ReporteProyectoIoarrService {
@Autowired
    ReportePoyectoIoarrData data;
    @Override
    public List<ReportePoyectoIoarr> ReportePoyectoIoarr(Integer Idproioarr) {
         return data.ReportePoyectoIoarr(Idproioarr); 
    }
    
    
}
