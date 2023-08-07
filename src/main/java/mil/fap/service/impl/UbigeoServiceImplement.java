/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.UbigeoData;
import mil.fap.models.Ubigeo;
import mil.fap.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jmezas
 */
@Service("ubigeoService")
public class UbigeoServiceImplement implements UbigeoService {

    @Autowired
    UbigeoData data;

    @Override
    public List<Ubigeo> list() {
        return data.list();
    }

    @Override
    public List<Ubigeo> listProv (String codigo) {
         return data.listProv(codigo);
    }
    
     @Override
    public List<Ubigeo> listDist (String codigo) {
         return data.listDist(codigo);
    }

}
