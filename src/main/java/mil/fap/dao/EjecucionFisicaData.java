/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import mil.fap.models.EjecucionFisica;

/**
 *
 * @author jmezas
 */
public interface EjecucionFisicaData {

    public String register(EjecucionFisica item);

    public EjecucionFisica get(EjecucionFisica item);

//    public String updateEstado(EjecucionFisica item);
    
    public String update(EjecucionFisica item);

}
