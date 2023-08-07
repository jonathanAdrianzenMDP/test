/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.models;

public class Usuario extends Base {

    private Integer idusuario;
    private String usuario;
    private String nsa;
    private String perfil;
    private Integer idperfil;
    private String grado;
    private String nombres;
    private String unidad;
    private String sigla;
    private String password;
    private String resumen;
    private String resumendatos;
    private Pagination pageInfo;
    private String datos;
    private boolean estado;
    private String descri;
    private String codigo;
    private String idorganigrama;
    private String gradonombre;
    private Integer idaccion;
    private Integer idmenu;
    private String menu;
    private String url;
    private String clase;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }
    
    public Integer getIdaccion() {
        return idaccion;
    }

    public void setIdaccion(Integer idaccion) {
        this.idaccion = idaccion;
    }

    public String getGradonombre() {
        return gradonombre;
    }

    public void setGradonombre(String gradonombre) {
        this.gradonombre = gradonombre;
    }
    
    public String getIdorganigrama() {
        return idorganigrama;
    }

    public void setIdorganigrama(String idorganigrama) {
        this.idorganigrama = idorganigrama;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public Integer getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(Integer idperfil) {
        this.idperfil = idperfil;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    /**
     * @param idusuario the idusuario to set
     */
    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the nsa
     */
    public String getNsa() {
        return nsa;
    }

    /**
     * @param nsa the nsa to set
     */
    public void setNsa(String nsa) {
        this.nsa = nsa;
    }

    /**
     * @return the perfil
     */
    public String getPerfil() {
        return perfil;
    }

    /**
     * @param perfil the perfil to set
     */
    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    /**
     * @return the grado
     */
    public String getGrado() {
        return grado;
    }

    /**
     * @param grado the grado to set
     */
    public void setGrado(String grado) {
        this.grado = grado;
    }

    /**
     * @return the nombres
     */
    public String getNombres() {
        return nombres;
    }

    /**
     * @param nombres the nombres to set
     */
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    /**
     * @return the unidad
     */
    public String getUnidad() {
        return unidad;
    }

    /**
     * @param unidad the unidad to set
     */
    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the resumen
     */
    public String getResumen() {
        return this.getGrado() + " " + this.getNombres() + " - " + this.getPerfil();
    }

    /**
     * @param resumen the resumen to set
     */
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    
    public String getResumendatos() {
         return this.getDescri() + " - " + this.getUnidad();
    }

  
    public void setResumendatos(String resumendatos) {    
        this.resumendatos = resumendatos;
    }

    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    /**
     * @return the pageInfo
     */
    public Pagination getPageInfo() {
        return pageInfo;
    }

    /**
     * @param pageInfo the pageInfo to set
     */
    public void setPageInfo(Pagination pageInfo) {
        this.pageInfo = pageInfo;
    }

    public String getDescri() {
        return descri;
    }

    public void setDescri(String descri) {
        this.descri = descri;
    }

}
