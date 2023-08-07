package mil.fap.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.GrupofuncData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.Grupofunc;
import mil.fap.models.Pagination;
import mil.fap.models.helpers.DataTable;
import mil.fap.models.helpers.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

@Repository("grupofuncData")
public class GrupofuncDataImplement implements GrupofuncData {

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcCall listaGrupofunc;
    private SimpleJdbcCall paginarGrupofunc;
    private SimpleJdbcCall cambiarEstadoGrupofunc;
    private SimpleJdbcCall insertarGrupofunc;
    private SimpleJdbcCall actualizarGrupofunc;
    private SimpleJdbcCall buscarGrupofunc;
            
            
            
    @Autowired
    public void setDataSource(DataSource dataSource) {
        
         this.listaGrupofunc = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_GRUPOFUNC");
         this.paginarGrupofunc = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_GET_GRUPOFUNC_ALL");
         this.cambiarEstadoGrupofunc = new  SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_UPD_ESTADO_GRUPOFUNC");
         this.insertarGrupofunc = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_INS_GRUPOFUNC");
         this.actualizarGrupofunc = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_UPD_GRUPOFUNC");
         this.buscarGrupofunc = new SimpleJdbcCall(dataSource)
                 .withSchemaName(Constantes.BDContext.Schema)
                 .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                 .withProcedureName("USP_GET_BUSCARPORID_GRUPOFUNC");
       
                 
         
    }
    
    
    @Override
    public List<Grupofunc> list(Integer iddivfuncion) {
        List<Grupofunc> lGrupofunc = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("N_IDDIVFUNCION", iddivfuncion);
            Map map = listaGrupofunc.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                Grupofunc grupofunc = new Grupofunc();
                grupofunc.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
                grupofunc.setIddivfuncion(Format.toInteger(obj.get("IDDIVFUNCION")));
                grupofunc.setDescgrupofunc(Format.toString(obj.get("DESCGRUPOFUNC")));
                grupofunc.setEstado(Format.toBoolean(obj.get("ESTADO")));

                lGrupofunc.add(grupofunc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lGrupofunc;
    }

    @Override
    public DataTable<Grupofunc> paginar(Grupofunc item) {
        DataTable<Grupofunc> oDatos = new DataTable<>();
        
        oDatos.setAaData(new ArrayList<Grupofunc>());
        
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("N_PAGENUM", item.getPageInfo().getiPage())
                .addValue("N_PAGESIZE", item.getPageInfo().getiLength());
        
        Map map 
                = paginarGrupofunc.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result){
            
           Grupofunc grupofunc = new Grupofunc();
           grupofunc.setPageInfo(new Pagination());
           grupofunc.getPageInfo().setiTotal(Format.toInteger(obj.get("TOTAL")));
           grupofunc.getPageInfo().setiEnd(Format.toInteger(obj.get("iEND")));
           grupofunc.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
           grupofunc.setIddivfuncion(Format.toInteger(obj.get("IDDIVFUNCION")));
           grupofunc.setDescgrupofunc(Format.toString(obj.get("DESCGRUPOFUNC")));
           grupofunc.setEstado(Format.toBoolean(obj.get("ESTADO")));
           oDatos.getAaData().add(grupofunc);
        }
        oDatos.setiDisplayRecords(oDatos.getAaData().size());
        return oDatos;
    }

    @Override
    public Message cambiarEstado(Integer idgrupofun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Grupofunc Grupofunc) {
        String oCodigo = "";
         SqlParameterSource in = new MapSqlParameterSource()
                 .addValue("I_IDGRUPOFUN", Grupofunc.getIdgrupofun())
                 .addValue("N_DESCGRUPOFUNC", Grupofunc.getDescgrupofunc());
      
         Map map = insertarGrupofunc.execute(in);
         List<Map> result = (List<Map>) map.get("MENSAJE");
         for (Map obj : result){
             oCodigo = Format.toString(obj.get("MSG"));
         }
         return oCodigo;
    }   

    @Override
    public String actualizar(Grupofunc grupofunc) {
       String oCodigo = "";
       SqlParameterSource in = new MapSqlParameterSource()
               .addValue("I_IDGRUPOFUN", grupofunc.getIdgrupofun())
               .addValue("N_DESCGRUPOFUNC", grupofunc.getDescgrupofunc());
       
         Map map = actualizarGrupofunc.execute(in);
         List<Map> result = (List<Map>) map.get("MENSAJE");
         for (Map obj : result){
             oCodigo = Format.toString(obj.get("MSG"));
         }
         return oCodigo;
    }

    @Override
    public Grupofunc buscarPorId(Integer idgrupofun) {
        Grupofunc grupofunc = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDGRUPOFUN", idgrupofun);
        
        Map map 
                = buscarGrupofunc.execute(in);
        List<Map> result =(List<Map>)map.get("CV");
        for (Map obj : result){
            
            grupofunc = new Grupofunc();
            grupofunc.setIdgrupofun(Format.toInteger(obj.get("IDGRUPOFUN")));
            grupofunc.setDescgrupofunc(Format.toString(obj.get("DESCGRUPOFUNC")));
        }
        return grupofunc;
    }

   
}
