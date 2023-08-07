/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.List;

import mil.fap.dao.DivisionFuncionData;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import mil.fap.service.DivisionFuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("divisionFuncionService")
public class DivisionFuncionServiceImplement implements DivisionFuncionService {

    @Autowired
    DivisionFuncionData data;

    @Override
    public List<DivisionFuncion> list(Integer idfuncion) {
        return data.list(idfuncion);
    }


    @Override
    public DataTable<DivisionFuncion> Paginacion(DivisionFuncion item) {
        return data.Paginacion(item);
    }

    @Override
    public Message updataEstado(Integer iddivfuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(DivisionFuncion DivisionFuncion) {
        return data.insertar(DivisionFuncion);
    }

    @Override
    public String update(DivisionFuncion DivisionFuncion) {
        return data.update(DivisionFuncion);
    }

    @Override
    public DivisionFuncion buscarPorId(Integer iddivfuncion) {
        return data.buscarPorId(iddivfuncion);
    }

    

}
