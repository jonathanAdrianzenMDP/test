/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;

/**
 *
 * @author Jonathan
 */
public interface UsuarioService {

    public List<Usuario> listPagination(Usuario item);

    public Usuario getLogin(Usuario item);

    public Usuario buscarPorNsa(String nsa);

    public String insertar(Usuario usuario);

    Message updateEstado(Usuario item);

    public Message updateUsuarioPassword(Usuario item);

    public Message updateUsuarioPerfil(Usuario item);

    public Usuario buscarPorId(Integer idusuario);

    public List<Usuario> list();

    public List<Usuario> PerfilAccion(Integer idperfil);

    public List<Usuario>  PerfilMenu(Integer idperfil);
    
    public List<Usuario> listMenu();

}
