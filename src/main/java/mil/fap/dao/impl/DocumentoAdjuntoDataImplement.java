/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao.impl;

import java.io.ByteArrayInputStream;
import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import mil.fap.dao.DocumentoAdjuntoData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.DocumentoAdjunto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */
@Repository("documentoAdjuntoData")
public class DocumentoAdjuntoDataImplement implements DocumentoAdjuntoData {
    
    private SimpleJdbcCall insertarDocumentoAdjuntoBrechaIndicador;
    private SimpleJdbcCall listarDocumentoAdjunto;
    private SimpleJdbcCall actualizarEstadoDocumentoAdjunto;
    private SimpleJdbcCall getDocumentoAdjunto;
    
    
        @Autowired
    public void setDataSource(DataSource dataSource) {

        this.insertarDocumentoAdjuntoBrechaIndicador = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_INS_DOCUMENTADJUNTO");
        this.listarDocumentoAdjunto = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_DOCUMENADJUNTO_ALL");
        this.getDocumentoAdjunto = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_DOCUMENADJUNTO")
                .returningResultSet("CV", new DocumentoAdjuntoRowMapper());
        this.actualizarEstadoDocumentoAdjunto = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_DEL_DOCUMENADJUNTO");
    }

    @Override
    public Integer set(DocumentoAdjunto item) {
          String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
        .addValue("I_IDBRECINDI", item.getIDBRECINDI())
        .addValue("I_IDPROIOARR", item.getIDPROIOARR())
        .addValue("I_IDPROYEPIP", item.getIDPROYEPIP())
        .addValue("I_IDPROVEEDOR", 0)        
        .addValue("I_PROCACTUAL", item.getPROCACTUAL())
        .addValue("V_DESCDOC", item.getDESCDOC())
        .addValue("V_URLDOC", item.getURLDOC())
        .addValue("V_NOMDOC", item.getNOMDOC())
        .addValue("B_BYTEDOC",  new SqlLobValue(new ByteArrayInputStream(item.getByteDOC()), 
        item.getByteDOC().length, new DefaultLobHandler()), Types.BLOB)
        .addValue("V_USUCREACIO", item.getUsucreacio());

        Map map = insertarDocumentoAdjuntoBrechaIndicador.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return Integer.parseInt(oCodigo);
    }

    @Override
    public List<DocumentoAdjunto> getAll(DocumentoAdjunto item) {
              List<DocumentoAdjunto> lresult = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDBRECINDI", item.getIDBRECINDI())
                    .addValue("I_IDPROYEPIP", item.getIDPROYEPIP())
                    .addValue("I_PROCACTUAL", item.getPROCACTUAL())
                    .addValue("I_IDPROIOARR", item.getIDPROIOARR());
            Map map = listarDocumentoAdjunto.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for(Map obj : result)
             {
                 DocumentoAdjunto doc = new DocumentoAdjunto();
                doc.setIDDOCUMENT(Format.toInteger(obj.get("IDDOCUMENT")));
                doc.setNOMDOC(Format.toString(obj.get("NOMDOC")));
                doc.setDESCDOC(Format.toString(obj.get("DESCDOC")));
                doc.setURLDOC(Format.toString(obj.get("URLDOC")));
                doc.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
                doc.setUsucreacio(Format.toString(obj.get("USUCREACIO")));
                doc.setDESCPROCACTUAL(Format.toString(obj.get("VALOR")));
                doc.setPROCACTUAL(Format.toInteger(obj.get("PROCACTUAL")));

                lresult.add(doc);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lresult;
    }
    @Override
    public DocumentoAdjunto get(DocumentoAdjunto item) {
        DocumentoAdjunto doc = new DocumentoAdjunto();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("V_NOMDOC", item.getNOMDOC());
           Map<String, Object> out = getDocumentoAdjunto.execute(in);
           List<DocumentoAdjunto> result = (List<DocumentoAdjunto>) out.get("CV");
           return result.get(0);

        } catch (Exception e) {
            System.out.println(e);
        }
        return doc;
    }
    @Override
    public String updateEstado(DocumentoAdjunto item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDDOCUMENT", item.getIDDOCUMENT())
                .addValue("V_USUMODIFIC", item.getUsumodific());
        Map map = actualizarEstadoDocumentoAdjunto.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }
    
    private static class DocumentoAdjuntoRowMapper implements RowMapper<DocumentoAdjunto> {
        @Override
        public DocumentoAdjunto mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            DocumentoAdjunto doc = new DocumentoAdjunto();
            doc.setIDDOCUMENT(resultSet.getInt(("IDDOCUMENT")));
            doc.setNOMDOC(resultSet.getString("NOMDOC"));
            doc.setDESCDOC(resultSet.getString("DESCDOC"));
            doc.setURLDOC(resultSet.getString("URLDOC"));
            doc.setFeccreacio(resultSet.getString("FECCREACIO"));
            doc.setUsucreacio(resultSet.getString("USUCREACIO"));
            doc.setDESCPROCACTUAL(resultSet.getString("VALOR"));
            doc.setPROCACTUAL(resultSet.getInt("PROCACTUAL"));

            Blob blob = resultSet.getBlob("ARCHIVO");
            byte[] bytes = blob.getBytes(1, (int) blob.length());
            doc.setByteDOC(bytes);
            return doc;
        }
    }
    
}
