<%-- 
    Document   : comitetrabajoIOARR
    Created on : 18-oct-2018, 11:53:18
    Author     : Jonathan
--%>
<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.text.DecimalFormat" %>

<jsp:include page="template/header.jsp" />
<script src="<c:url value='/resources/js/highcharts/highcharts.js' />" type="text/javascript"></script>
<script src="<c:url value='/resources/js/highcharts/exporting.js' />" type="text/javascript"></script>
<script src="<c:url value='/resources/js/highcharts/export-data.js' />" type="text/javascript"></script>
<input type="hidden" id="hdnIdProyectoPIP" value="0" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<input type="hidden" id="hdnIdProyectoIOARR" value="${item.proyectoIOARR.idProIOARR}" />

<div class="container-fluid">

    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">IOARR</label><br>
            <label>FORMULACIÓN Y EVALUACIÓN</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">COMITE DE TRABAJO</label>

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
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR)) {%>
                <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 72 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / SIN REGISTROS-->
                    <button type="button" class="btn btn-primary ml-2" name="btnGuardarFecha"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary ml-2" name="btnEnviarIOARR" title="Enviar a la Unidad Ejecutora"><span class="fas fa-paper-plane"></span> Enviar</button>
                </c:if> 
                <% }%>

            </div>
        </div>    
    </div>

    <hr>
    <div class="form-group row ">

        <label class="col-sm-2">Integrante del Comité de Trabajo:</label>
        <div class="col-sm-3">
            <input type="text" class="form-control" id="txtIntegrante" />
        </div>
        <label class="col-sm-2">Número de Documento:</label>
        <div class="col-sm-2">
            <input type="text" class="form-control" id="txtNrooficio" />
        </div>
        <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR)) {%>
        <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 72 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / SIN REGISTROS-->
            <div class="float-right">
                <button id="btnGuardar" class="btn btn-primary"><span class="fas fa-plus"></span> Agregar </button>
            </div>
        </c:if>
        <% }%>
    </div>

    <hr>


    <!-- Bandeja Principal -->
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table id="tblComiteTrabajo"  class="table table-bordered table-md">
                    <thead>
                        <tr>
                            <th>Nº</th>
                            <th>Integrante</th>
                            <th>Número de Documento</th>
                            <th>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <hr>

    <div class="card">            
        <div class="card-header"  data-toggle="collapse"  href="#item3" aria-expanded="true" >
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
                            <input type="text" class="form-control text-uppercase" id="txtNamefile" placeholder="Descripción del Archivo">
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
                    <table id="tblDocsAdjuntos"  width="100%" cellspacing="0" class="table table-bordered table-md">
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


<!-- Modal NUEVO-->
<div class="modal fade bs-example-modal-lg" id="mdlEditar" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Comite de Trabajo</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label class="col-sm-6">Integrante:</label>
                        <div class="col-sm-12">
                            <input type="text" id="txtIntegranteeditar" class="form-control" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-6">Número de Oficio:</label>
                        <div class="col-sm-12">
                            <input type="text" id="txtNrooficioeditar" class="form-control" />
                        </div>
                    </div>
                </form>
            </div><!-- FIN modal-body-->
            <div class="modal-footer">
                <button type="button" id="btnGuardarEditar" class="btn btn-primary"><span class="fas fa-save"></span> Guardar </button>
            </div>
        </div><!-- FIN modal-content-->
    </div><!-- FIN modal-dialog-->
</div><!-- FIN Modal NUEVO-->
<!-- Modal OBSERVACION-->
<div class="modal fade" id="mdlObservar" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title">Registrar Observación</h4>
            </div>

            <div class="modal-body">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">

                            <div class="col-sm-10">   
                                <textarea class="form-control" id="txtObservacion" placeholder="Ingresar la Observación"></textarea>
                            </div>
                            <div class="col-sm-2">
                                <div class="float-right">
                                    <button id="btnGuardarObservacion" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div><!-- FIN MODAL-BODY -->
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>



<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/comiteTrabajos/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/comiteTrabajos/controller.js' />"></script>

</body>
</html>
