<%-- 
    Document   : planDeTrabajo
    Created on : 23/01/2019, 08:59:15 AM
    Author     : cristina
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
<input type="hidden" id="hdnIdProyectoIOARR" value="${item.proyectoIOARR.idProIOARR}" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<input type="hidden" id="txtidproioarr" value="${item.proyectoIOARR.idProIOARR}" />
<div class="wrapper"></div>

<div class="container-fluid">   

    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">IOARR</label><br>
            <label>PROGRAMACION MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">APROBACIÓN DE LA IOARR</label>
        </div>
        <div class="col-sm-12 text-center h5">
            <label class="badge badge-${seguimiento.styleProc}">${seguimiento.nombreEstado}</label>
        </div>
    </div>

    <hr>

    <div class="form-group row">
        <div class="col-sm-12">
            <div class="float-left">
                <a href="./seguimientoIOARR?id=${item.proyectoIOARR.idProIOARR}"><button type="button" class="btn btn-primary"><span class="fas fa-book"></span> Ver Seguimiento</button></a>
            </div>
            <div class="float-right">
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 72}"><!-- SIN REGISTROS -->        
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                </c:if>
                <% } %>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.PMI) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button  name="btnObservar" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                </c:if>
                <% }%>  
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 44}"><!-- OBSERVADO -->           
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>                  
                </c:if>
                <% }%>
            </div>
        </div>    
    </div>

    <!-- Bandeja Principal -->
    <div class="card mb-1">
        <div class="card-header"  id="headingOne" data-toggle="collapse"  href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
            <h4 class="mb-0">
                <button class="btn btn-link">DATOS GENERALES</button>
            </h4>
        </div>
        <div>
            <div class="card-body">

                <div  class="row">
                    <label class="col-sm-4 col-md-2">CODIGO DE IDEA:</label>
                    <div class="col-sm-4 col-md-2">
                        <label>${item.proyectoIOARR.codunimef}</label>
                    </div>
                </div>
                <div  class="row">
                    <label class="col-sm-4 col-md-2">INVERSION:</label>
                    <div class="col-sm-10">
                        <label class="text-uppercase">${item.proyectoIOARR.nombreInversion}</label>
                    </div>
                    <label class="col-sm-4 col-md-2">UNIDAD EJECUTORA:</label>
                    <div class="col-sm-10">
                        <c:forEach items="${lstNombreUnidadEjecutora}" var="obj">
                            <c:if test="${obj.key eq item.proyectoIOARR.idNombreUEI}"><label>${obj.value}</label></c:if>
                        </c:forEach>
                    </div>
                    <label class="col-sm-4 col-md-2">¿LA INVERSION ES MAYOR A 75 UIT?</label>
                    <div class="col-sm-10">
                        <select class="form-control" name="cboUIT">
                            <option value="0">--SELECCIONE--</option>
                            <option value="2" <c:if test="${item.proyectoIOARR.uitmayor75 eq 2}">selected="selected"</c:if>>SI</option>
                            <option value="1" <c:if test="${item.proyectoIOARR.uitmayor75 eq 1}">selected="selected"</c:if>>NO</option>
                            </select>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
    <c:if test="${seguimiento.estadoproc eq 42 or seguimiento.estadoproc eq 43}"><!-- EN REVISION, APROBADO -->
        <div class="card">  
            <div id="item2">
                <div class="card-body">
                    <div  class="row">
                        <label class="col-md-2">NOMBRE IOARR: </label>
                        <div class="col-md-6">
                            <input type="text" class="form-control" id="txtnomforeva" value="${item.proyectoIOARR.nomforeva}"
                                   <c:if test="${seguimiento.estadoproc eq 43}"> disabled="disabled" </c:if>/>
                            <small>*Fuente del MEF</small>
                    </div>
                    
                    <label class="col-md-2">CÓDIGO ÚNICO:</label>
                    <div class="col-md-2">
                        <input type="text" class="form-control" id="txtcodforeva" value="${item.proyectoIOARR.codforeva}"
                           <c:if test="${seguimiento.estadoproc eq 43}"> disabled="disabled" </c:if>/>
                        <small>*Fuente del MEF</small>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </c:if>
    <% }%>

    <!-- SECCION ADJUNTAR -->
    <div class="card">            
        <div class="card-header"  data-toggle="collapse" href="#item3" aria-expanded="true" >
            <h4 class="mb-0">
                <button class="btn btn-link">DOCUMENTOS ADJUNTOS</button>
            </h4>
        </div>
        <div id="item3" >
            <div class="card-body">

                <div class="form-group row">
                    <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 72 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / SIN REGISTROS-->
                        <div class="col-sm-4">   
                            <input type="file" id="txtfile" multiple="false">
                            <p class="help-block">Formatos jpg, pdf.</p>
                        </div>
                        <div class="col-sm-6">   
                            <input type="text" class="form-control text-uppercase" id="txtNamefile" placeholder="Descripción del Archivo" value="Doc Solicitud de Ejecucion IOARR" /> 
                        </div>
                        <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
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
            </div><!-- FIN MODAL-BODY -->
            <div class="modal-footer">
                <button id="btnGuardarObservacion" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/solicitudEjecucion/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/solicitudEjecucion/controller.js' />"></script>

</body>
</html>
