/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.Funcion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;

/**
 *
 * @author cristina
 */
public interface FuncionData {
    
    public List<Funcion> list();

    public DataTable<Funcion> Paginacion(Funcion item);
    
    public Message updataEstado(Integer idfuncion);

    public String insertar(Funcion funcion);

    public String update(Funcion funcion);

    public Funcion buscarPorId(Integer idfuncion);

}
