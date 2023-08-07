/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service.impl;

import java.util.ArrayList;
import java.util.List;
import mil.fap.dao.UsuarioData;
import mil.fap.helpers.Constantes;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan
 */
@Service("usuarioService")
//Implementamos los metodos de la inteface UserDetailsService (SpringSecurity)
public class UsuarioServiceImplement implements UserDetailsService, UsuarioService {

    @Autowired
    UsuarioData usuarioData;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario obj = new Usuario();
        obj.setUsuario(username);
        Usuario item;

        try {
            item = usuarioData.getLogin(obj);
            if (item == null) {
                throw new UsernameNotFoundException(username);
            }
            //List<String> roleNames = usuarioData.getRoleNames(item.getIdusuario());
            List<GrantedAuthority> grantList = new ArrayList<>();
            //if (item.getPerfil() != null) {
            //for (String role : roleNames) {
            GrantedAuthority authority = new SimpleGrantedAuthority("ADMINISTRADOR");
            grantList.add(authority);
            //}
            UserDetails userDetails = (UserDetails) new User(username, item.getPassword(), grantList);
            return userDetails;
            //}
        } catch (Exception ex) {
            //throw new UnknownError(ex.getMessage().toString());
            UserDetails userDetails = (UserDetails) new User(username, username, false, false, false, false, null);
            return userDetails;
        }

    }

    @Override
    public Usuario getLogin(Usuario item) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String username = loggedInUser.getName();
        Usuario usuario = new Usuario();
        usuario.setUsuario(username);
        return usuarioData.getLogin(usuario);
    }

    @Override
    public Usuario buscarPorNsa(String nsa) {
        return usuarioData.buscarPorNsa(nsa);
    }

    @Override
    public List<Usuario> listPagination(Usuario item) {
        return usuarioData.listPagination(item);
    }

    @Override
    public String insertar(Usuario usuario) {
        try {
            String oCodigo = usuarioData.insertar(usuario);
            if (oCodigo.equals("0")) {
                return Constantes.Mensajes.MensajeUsuarioDuplicado;
            }
            return Constantes.Mensajes.MensajeGuardarExito;
        } catch (Exception ex) {
            return Constantes.Mensajes.MensajeErrorExcepcion;
        }
    }

    @Override
    public Message updateEstado(Usuario item) {
        Message msg = new Message();
        try {
            usuarioData.updateEstado(item);
            msg.setSuccess(true);
            msg.convert(item.isEstado() == true ? Constantes.Mensajes.MensajeCambiarEstadoActivo : Constantes.Mensajes.MensajeCambiarEstado);
        } catch (Exception ex) {
            msg.setSuccess(false);
            msg.convert(Constantes.Mensajes.MensajeErrorExcepcion);
            msg.setException(ex.getMessage());
        }
        return msg;
    }

    @Override
    public Message updateUsuarioPassword(Usuario item) {
        Message msj = new Message();
        try {
            usuarioData.updateUsuarioPassword(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public Usuario buscarPorId(Integer idusuario) {
        return usuarioData.buscarPorId(idusuario);
    }

    @Override
    public Message updateUsuarioPerfil(Usuario item) {
        Message msj = new Message();
        try {
            usuarioData.updateUsuarioPerfil(item);
            msj.setType(Constantes.Mensajes.typeSuccess);
            msj.setData(item);
            msj.convert(Constantes.Mensajes.MensajeGuardarExito);
        } catch (Exception ex) {
            msj.setException(ex.getMessage());
            msj.setType(Constantes.Mensajes.typeError);
            msj.convert(Constantes.Mensajes.MensajeErrorExcepcion);
        }
        return msj;
    }

    @Override
    public List<Usuario> list() {
        return usuarioData.list();
    }

    @Override
    public List<Usuario> PerfilAccion(Integer idperfil) {
        return usuarioData.PerfilAccion(idperfil);
    }

    @Override
    public List<Usuario> PerfilMenu(Integer idperfil) {
        return usuarioData.PerfilMenu(idperfil);
    }
    
    @Override
    public List<Usuario> listMenu() {
        return usuarioData.listMenu();
    }
}
