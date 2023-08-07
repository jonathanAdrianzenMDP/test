/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.ParametroValor;


/**
 *
 * @author jmezas
 */
public interface ParametroValorData {
    Integer add(ParametroValor item);
    void update(ParametroValor item);
    List<ParametroValor> list(int idparametro);
    List<ParametroValor> listAll(int idparametro);
    List<ParametroValor> listParametro();
    void deleteParametro(ParametroValor item);

}
