/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.ReporteProyectoPIPData;
import mil.fap.models.ReporteProyectoPIP;
import mil.fap.service.ReporteProyectoPIPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jose
 */
@Service("reporteProyectoPIPService")
public class ReporteProyectoPIPServiceImplement implements ReporteProyectoPIPService {
   
    @Autowired
    ReporteProyectoPIPData data;
    @Override
    public List<ReporteProyectoPIP> ReporteProyectoPIP(Integer Idproyepip) {
        return data.ReporteProyectoPIP(Idproyepip);
    }
}
