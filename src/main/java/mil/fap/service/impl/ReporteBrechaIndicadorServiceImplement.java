/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ReporteBrechaIndicadorData;
import mil.fap.models.ReporteBrechaIndicador;
import mil.fap.service.ReporteBrechaIndicadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristina
 */
@Service("reporteBrechaIndicadorService")
public class ReporteBrechaIndicadorServiceImplement implements ReporteBrechaIndicadorService {
@Autowired
    ReporteBrechaIndicadorData data;
    @Override
    public List<ReporteBrechaIndicador> getReporteBrechaIndicador(String anio, String servtipolo,
             String indicbrech) {
         return data.getReporteBrechaIndicador(anio,servtipolo,indicbrech); 
    }
    
    
}
