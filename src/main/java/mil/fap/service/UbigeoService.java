/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.Ubigeo;

/**
 *
 * @author jmezas
 */
public interface UbigeoService {
 
       public List<Ubigeo> list();
       
       public List<Ubigeo> listProv(String codigo);
       
       public List<Ubigeo> listDist(String codigo);
    
}
