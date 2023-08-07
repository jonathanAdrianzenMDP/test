/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;
import mil.fap.models.helpers.Message;
import mil.fap.dao.FuncionData;
import mil.fap.models.Funcion;
import mil.fap.models.helpers.DataTable;
import mil.fap.service.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author cristina
 */
@Service("funcionService")
public class FuncionServiceImplement implements FuncionService {

    @Autowired
    FuncionData data;

    @Override
    public List<Funcion> list() {
        return data.list();
    }

    @Override
    public DataTable<Funcion> Paginacion(Funcion item) {
        return data.Paginacion(item);
    }

    @Override
    public Message updataEstado(Integer idfuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Funcion funcion) {
        return data.insertar(funcion);
    }

    @Override
    public String update(Funcion funcion) {
        return data.update(funcion);
    }

    @Override
    public Funcion buscarPorId(Integer idfuncion) {
        return data.buscarPorId(idfuncion);
    }

}
