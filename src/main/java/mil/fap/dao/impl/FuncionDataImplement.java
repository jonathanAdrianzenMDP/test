/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.FuncionData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Funcion;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlInOutParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author cristina
 */
@Repository("funcionData")
public class FuncionDataImplement implements FuncionData {
    
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall listaFuncion;
    private SimpleJdbcCall PaginacionFuncion;
    private SimpleJdbcCall cambiarEstadoFuncion;
    private SimpleJdbcCall insertarFuncion;
    private SimpleJdbcCall actualizarFuncion;
    private SimpleJdbcCall buscarIdfuncion;
    
    @Autowired
    public void setDataSource(DataSource dataSource) {
        
         this.listaFuncion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_FUNCION");
         this.PaginacionFuncion = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_GET_FUNCION_ALL");
         this.cambiarEstadoFuncion = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_UPD_ESTADO_FUN");
         this.insertarFuncion = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_INS_FUNCION");
         this.actualizarFuncion = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_UPD_FUNCION");
         this.buscarIdfuncion = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_GET_PORIDFUN_ALL");
    }
    
    @Override
    public List<Funcion> list() {List<Funcion> lFuncion = new ArrayList<>();
        try {
            Map map = listaFuncion.execute();
            List<Map> result = (List<Map>) map.get("CV");
             for(Map obj : result){

                Funcion fun = new Funcion();
                fun.setIdfuncion(Format.toInteger(obj.get("IDFUNCION")));
                fun.setDescfuncion(Format.toString(obj.get("DESCFUNCION")));
                fun.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lFuncion.add(fun);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lFuncion;
    }
        

//    @Override
//    public DataTable<Funcion> Paginacion(Funcion item) {
//        DataTable<Funcion> oDatos = new DataTable<>();
//        
//        oDatos.setAaData(new ArrayList<Funcion>());
//        
//        SqlInOutParameter in = new MapSqlParameterSource()
//                
//        
//    }

//    @Override
//    public Message updataEstado(Integer idfuncion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

//    @Override
//    public String insertar(Funcion funcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public String update(Funcion funcion) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Funcion buscarPorId(Integer idfuncion) {
        Funcion oFuncion = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue(" I_IDFUNCION", idfuncion);
        
        Map map
                = buscarIdfuncion.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result){
            
            oFuncion = new Funcion();
            oFuncion.setIdfuncion(Format.toInteger(obj.get("IDFUNCION")));
            oFuncion.setDescfuncion(Format.toString(obj.get("DESCFUNCION")));
        }
        return oFuncion;
    }

    @Override
    public DataTable<Funcion> Paginacion(Funcion item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Message updataEstado(Integer idfuncion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Funcion funcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String update(Funcion funcion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
