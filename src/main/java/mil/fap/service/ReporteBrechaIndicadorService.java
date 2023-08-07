/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.ReporteBrechaIndicador;

/**
 *
 * @author mnieva
 */
public interface ReporteBrechaIndicadorService {
      public List<ReporteBrechaIndicador> getReporteBrechaIndicador(String anio, String servtipolo, String indicbrech); 
}

