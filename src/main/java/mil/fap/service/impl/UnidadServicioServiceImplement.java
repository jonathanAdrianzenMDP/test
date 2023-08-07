/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.UnidadServicioData;
import mil.fap.models.UnidadServicio;
import mil.fap.service.UnidadServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristina
 */
@Service("unidadServicioService")
public class UnidadServicioServiceImplement  implements UnidadServicioService {
 
@Autowired
    UnidadServicioData data;

    @Override
    public List<UnidadServicio> listaUnidadServicio() {
        return data.listaUnidadServicio();
    }
    }
    

