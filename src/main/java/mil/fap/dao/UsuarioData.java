/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.Usuario;

/**
 *
 * @author Jonathan
 */
public interface UsuarioData {

    public Usuario getLogin(Usuario item);

    public List<Usuario> listPagination(Usuario item);

    void updateEstado(Usuario item);

    public Usuario buscarPorNsa(String nsa);

    public String insertar(Usuario usuario);

    public String updateUsuarioPassword(Usuario item);

    public String updateUsuarioPerfil(Usuario item);

    public Usuario buscarPorId(Integer idusuario);

    public List<Usuario> list();
    
    public List<Usuario> PerfilAccion(Integer idperfil);
    
    public List<Usuario> PerfilMenu(Integer idperfil);
      
    public List<Usuario> listMenu();

}
