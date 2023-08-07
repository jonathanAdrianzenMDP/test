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
import mil.fap.dao.UsuarioData;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.helpers.Func;
import mil.fap.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jonathan
 */
@Repository("usuarioData")
public class UsuarioDataImplement implements UsuarioData {

    private SimpleJdbcCall validarDatosUsuario;
    private SimpleJdbcCall insertarUsuario;
    private SimpleJdbcCall listaPaginationUsuario;
    private SimpleJdbcCall buscarDatosUsuario;
    private SimpleJdbcCall actualizarEstadoUsuario;
    private SimpleJdbcCall actualizarUsuarioPassword;
    private SimpleJdbcCall buscarDatosUsuarioPassword;
    private SimpleJdbcCall actualizarUsuarioPerfil;
    private SimpleJdbcCall seleccionarPerfil;
    private SimpleJdbcCall perfilAccion;
    private SimpleJdbcCall perfilMenu;
    private SimpleJdbcCall listaMenu;

    @Autowired
    public void setDataSource(DataSource dataSource) {

        this.validarDatosUsuario = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_VALIDACION_USUARIO");
        this.insertarUsuario = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_INS_DATOS_USUARIO");
        this.listaPaginationUsuario = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_USUARIO_ALL");
        this.buscarDatosUsuario = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_DATOS_USUARIO");
        this.actualizarEstadoUsuario = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_DEL_UPDATE_USUARIO");
        this.actualizarUsuarioPassword = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_UPD_USUARIOPASSWORD");
        this.buscarDatosUsuarioPassword = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_USUARIOPASSWORD");
        this.actualizarUsuarioPerfil = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_UPD_USUARIOPERFIL");
        this.seleccionarPerfil = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_LISTPERFIL");
        this.perfilAccion = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_PERFIL_ACCION");
        this.perfilMenu = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_ACCESO_MENU");
        this.listaMenu = new SimpleJdbcCall(dataSource)
                .withSchemaName(Constantes.BDContext.Schema)
                .withCatalogName(Constantes.BDContext.PKG_ADMINISTRACION)
                .withProcedureName("USP_GET_LISTMENU");

    }

    @Override
    public Usuario getLogin(Usuario item) {
        Usuario usuario = new Usuario();
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_USUARIO", item.getUsuario());

        Map map
                = validarDatosUsuario.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            usuario = new Usuario();
            usuario.setNsa(Format.toString(obj.get("NSA")));
            usuario.setGrado(Format.toString(obj.get("GRADO")));
            usuario.setNombres(Format.toString(obj.get("APELLIDOS")));
            usuario.setUnidad(Format.toString(obj.get("SIGLA_UNIDAD")));
            usuario.setUsuario(Format.toString(obj.get("USUARIO")));
            usuario.setPassword(Format.toString(obj.get("ENCRYTED_PASSWORD")));
            usuario.setDescri(Format.toString(obj.get("DESC_UNIDAD")));
            usuario.setIdperfil(Format.toInt(obj.get("IDPERFIL")));
            usuario.setPerfil(Format.toString(obj.get("PERFIL")));
            usuario.setCodigo(Format.toString(obj.get("CODIGO")));
            usuario.setIdorganigrama(Format.toString(obj.get("IDORGANIGRAMA")));
            usuario.setIdusuario(Format.toInt(obj.get("IDUSUARIO")));

        }
        return usuario;
    }

    @Override
    public List<Usuario> listPagination(Usuario item) {
        List<Usuario> oDatos = new ArrayList<>();
        SqlParameterSource in = new MapSqlParameterSource();

        Map map = listaPaginationUsuario.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            Usuario usuario = new Usuario();
            usuario.setNsa(Format.toString(obj.get("NSA")));
            usuario.setNombres(Format.toString(obj.get("NOMBRES")));
            usuario.setSigla(Format.toString(obj.get("SIGLA")));
            usuario.setPassword(Format.toString(obj.get("PASSWORD")));
            usuario.setIdusuario(Format.toInt(obj.get("IDUSUARIO")));
            usuario.setEstado(Format.toBoolean(obj.get("ESTADO")));
            usuario.setIdusuario(Format.toInt(obj.get("IDUSUARIO")));
            usuario.setFeccreacio(Format.toString(obj.get("FECCREACIO")));
            usuario.setPerfil(String.valueOf(obj.get("PERFIL")));
            usuario.setEstado(Format.toBoolean(obj.get("ESTADO")));

            oDatos.add(usuario);
        }
        return oDatos;
    }

    @Override
    public Usuario buscarPorNsa(String nsa) {
        Usuario oUsuario = null;
        SqlParameterSource in = new MapSqlParameterSource().addValue("V_NSA", nsa);
        Map map = buscarDatosUsuario.execute(in);
        List<Map> result = (List<Map>) map.get("CV");

        if (result.isEmpty()) {
            oUsuario = null;

        } else {

            for (Map obj : result) {
                oUsuario = new Usuario();
                oUsuario.setNsa(Format.toString(obj.get("NSA")));
                oUsuario.setGrado(Format.toString(obj.get("GRALFA")));
                oUsuario.setNombres(Format.toString(obj.get("APELLIDOS")));
                oUsuario.setUnidad(Format.toString(obj.get("SIGLA")));
                oUsuario.setDescri(Format.toString(obj.get("DESCRI")));
                oUsuario.setCodigo(Format.toString(obj.get("CODIGO")));
                oUsuario.setGradonombre(Format.toString(obj.get("GRADONOMBRE")));
            }
        }

        return oUsuario;
    }

    @Override
    public String insertar(Usuario usuario) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("V_NSA", usuario.getNsa())
                .addValue("V_IDPERFIL", usuario.getIdperfil())
                .addValue("V_USUCREACIO", usuario.getUsucreacio());

        Map map = insertarUsuario.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }

        return oCodigo;
    }

    @Override
    public void updateEstado(Usuario item) {

        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDUSUARIO", item.getIdusuario())
                .addValue("V_ESTADO", (item.isEstado() == true ? "1" : "0"));
        actualizarEstadoUsuario.execute(in);
    }

    @Override
    public String updateUsuarioPassword(Usuario item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDUSUARIO", item.getIdusuario())
                .addValue("V_ENCRYTED_PASSWORD", Func.encrytePassword(item.getPassword()));

        Map map = actualizarUsuarioPassword.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public String updateUsuarioPerfil(Usuario item) {
        String oCodigo = "";
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDUSUARIO", item.getIdusuario())
                .addValue("I_IDPERFIL", item.getIdperfil());

        Map map = actualizarUsuarioPerfil.execute(in);
        List<Map> result = (List<Map>) map.get("MENSAJE");
        for (Map obj : result) {
            oCodigo = Format.toString(obj.get("MSG"));
        }
        return oCodigo;
    }

    @Override
    public Usuario buscarPorId(Integer idusuario) {
        Usuario usuario = null;
        SqlParameterSource in = new MapSqlParameterSource()
                .addValue("I_IDUSUARIO", idusuario);

        Map map
                = buscarDatosUsuarioPassword.execute(in);
        List<Map> result = (List<Map>) map.get("CV");
        for (Map obj : result) {

            usuario = new Usuario();
            usuario.setIdusuario(Format.toInteger(obj.get("IDUSUARIO")));
            usuario.setDatos(Format.toString(obj.get("DATOS")));
            usuario.setPassword(Format.toString(obj.get("ENCRYTED_PASSWORD")));
            usuario.setIdperfil(Format.toInteger(obj.get("IDPERFIL")));

        }
        return usuario;
    }

    @Override
    public List<Usuario> list() {
        List<Usuario> lUsuario = new ArrayList<>();
        try {
            Map map = seleccionarPerfil.execute();
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {

                Usuario usuario = new Usuario();
                usuario.setIdperfil(Format.toInteger(obj.get("IDPERFIL")));
                usuario.setPerfil(Format.toString(obj.get("PERFIL")));

                lUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lUsuario;
    }

    @Override
    public List<Usuario> PerfilAccion(Integer idperfil) {
        List<Usuario> lusuarios = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPERFIL", idperfil);
            Map map
                    = perfilAccion.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {
                Usuario oUsuario = new Usuario();
                oUsuario.setIdaccion(Format.toInteger(obj.get("IDACCION")));
                oUsuario.setIdperfil(Format.toInteger(obj.get("IDPERFIL")));

                lusuarios.add(oUsuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lusuarios;
    }
    
    @Override
    public List<Usuario> PerfilMenu(Integer idperfil) {
        List<Usuario> lusuarios = new ArrayList<>();
        try {
            SqlParameterSource in = new MapSqlParameterSource()
                    .addValue("I_IDPERFIL", idperfil);
            Map map
                    = perfilMenu.execute(in);
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {
                Usuario oUsuario = new Usuario();
                oUsuario.setIdperfil(Format.toInteger(obj.get("IDPERFIL")));
                oUsuario.setIdmenu(Format.toInteger(obj.get("IDMENU")));
                oUsuario.setMenu(Format.toString(obj.get("MENU")));
                oUsuario.setUrl(Format.toString(obj.get("URL")));
                oUsuario.setClase(Format.toString(obj.get("CLASE")));
                lusuarios.add(oUsuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lusuarios;

    }

    @Override
    public List<Usuario> listMenu() {
        List<Usuario> lUsuario = new ArrayList<>();
        try {
            Map map = listaMenu.execute();
            List<Map> result = (List<Map>) map.get("CV");
            for (Map obj : result) {
                Usuario usuario = new Usuario();
                usuario.setIdmenu(Format.toInteger(obj.get("IDMENU")));
                usuario.setMenu(Format.toString(obj.get("MENU")));
                usuario.setUrl(Format.toString(obj.get("URL")));
                usuario.setClase(Format.toString(obj.get("CLASE")));
                lUsuario.add(usuario);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lUsuario;
    }
}
