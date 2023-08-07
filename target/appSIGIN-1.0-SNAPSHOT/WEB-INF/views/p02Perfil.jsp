<%-- 
    Document   : p02Perfil
    Created on : 23/01/2019, 08:59:15 AM
    Author     : jhosep meza
--%>
<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.text.DecimalFormat" %>

<!DOCTYPE html>
<jsp:include page="template/header.jsp" />
<input type="hidden" id="hdnIdProyectoPIP" value="${item.proyectoPIP.idProyepip}" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<input type="hidden" id="txtidproyepip" value="${item.proyectoPIP.idProyepip}" />
<div class="wrapper"></div>

<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">PROYECTO DE INVERSION</label><br>
            <label>FORMULACIÓN Y EVALUACIÓN</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">PERFIL</label>
        </div>

        <div class="col-sm-12 text-center h5">
            <label class="badge badge-${seguimiento.styleProc}">${seguimiento.nombreEstado}</label>
        </div>

    </div>
    <hr>
    <div class="form-group row">
        <div class="col-sm-12">
            <div class="float-left">
                <a href="./seguimientoPIP?id=${item.proyectoPIP.idProyepip}"><button type="button" class="btn btn-primary"><span class="fas fa-book"></span> Ver Seguimiento</button></a>
            </div>
            <div class="float-right">
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.COMITE_TRABAJO)) {%>
                <c:if test="${seguimiento.estadoproc eq 72}"><!-- EN ELABORACION -->
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>   
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.COMITE_TRABAJO)) {%>
                <c:if test="${seguimiento.estadoproc eq 44}"><!-- OBSERVADO -->                 
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                </c:if>
                <% }%>
            </div>
        </div>    
    </div>
    <div class="card">
        <div class="card-header"  data-toggle="collapse" href="#item1">
            <h4 class="mb-0">
                <button class="btn btn-link">DATOS GENERALES</button>
            </h4>
        </div>
        <div id="item1">
            <div class="card-body">
                <div  class="row">
                    <label class="col-md-2">CODIGO DE IDEA:</label>
                    <div class="col-md-4">
                        <label>${item.proyectoPIP.codunimef}</label>
                    </div>
                </div>
                <div  class="row">
                    <label class="col-md-2">INVERSION:</label>
                    <div class="col-md-10">
                        <label class="text-uppercase">${item.proyectoPIP.nomproyect}</label>
                    </div>
                </div>
                <div  class="row">
                    <label class="col-md-2">UNIDAD EJECUTORA</label>
                    <div class="col-sm-10">
                        <c:forEach items="${lstNombreUnidadEjecutora}" var="obj">
                            <c:if test="${obj.key eq item.proyectoPIP.idnombruei}"><label>${obj.value}</label></c:if>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
    <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
    <div class="card">  
        <div id="item2">
            <div class="card-body">
                <div  class="row">
                    <label class="col-md-2">Nombre PIP:</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="txtnomforeva" value="${item.proyectoPIP.nomforeva}"
                               <c:if test="${seguimiento.estadoproc eq 43}"> disabled="disabled" </c:if> />
                        <small>*Fuente del MEF</small>
                    </div>
                    <div class="col-md-2"></div>
                    <label class="col-md-2">Código Unico:</label>
                    <div class="col-md-3">
                        <input type="text" class="form-control" id="txtcodforeva" value="${item.proyectoPIP.codforeva}"
                           <c:if test="${seguimiento.estadoproc eq 43}"> disabled="disabled" </c:if>/>
                        <small>*Fuente del MEF</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </c:if>
    <% }%>

    <div class="card">            
        <div class="card-header"  data-toggle="collapse"  data-target="#item3" aria-expanded="true" >
            <h4 class="mb-0">
                <button class="btn btn-link">DOCUMENTOS ADJUNTOS</button>
            </h4>
        </div>
        <div id="item3" class="collpase show" >
            <div class="card-body">

                <div class="form-group row">
                    <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 72 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / SIN REGISTROS-->
                        <div class="col-sm-4">   
                            <input type="file" id="txtfile" multiple="false">
                            <p class="help-block">Formatos jpg, pdf.</p>
                        </div>
                        <div class="col-sm-6">   
                            <input type="text" class="form-control" id="txtNamefile" value='PERFIL' placeholder="Descripción del Archivo">
                        </div>
                        <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.COMITE_TRABAJO)) {%>
                        <div class="col-sm-2">
                            <div class="float-right">
                                <button id="btnAdjuntar" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                            </div>
                        </div>
                        <% }%>
                    </c:if>
                </div>
                <div class="table-responsive">
                    <table id="tblDocsAdjuntos" class="table table-bordered table-md">
                        <thead>
                            <tr>
                                <th>Número</th>
                                <th>Descripción del Documento</th>
                                <th>Fecha Creación</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>

        </div>
    </div>


</div><!-- FIN DEL CONTAINER  -->

<!-- Modal OBSERVACION-->
<div class="modal fade" id="mdlObservar" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Registrar Observación</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-12">
                        <textarea class="form-control" id="txtObservacion" placeholder="Ingresar la Observación"></textarea>

                    </div>
                </div>
            </div>      

            <div class="modal-footer">
                <button id="btnGuardarObservacion" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div>
    </div>
</div>

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/p02perfil/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/p02perfil/controller.js' />"></script>


</body>
</html>
