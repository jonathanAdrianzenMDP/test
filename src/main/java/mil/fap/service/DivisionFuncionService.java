/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;

/**
 *
 * @author mnieva
 */
public interface DivisionFuncionService {

    public List<DivisionFuncion> list(Integer idfuncion);

    public DataTable<DivisionFuncion> Paginacion(DivisionFuncion item);

    public Message updataEstado(Integer iddivfuncion);

    public String insertar(DivisionFuncion DivisionFuncion);

    public String update(DivisionFuncion DivisionFuncion);

    public DivisionFuncion buscarPorId(Integer iddivfuncion);

}