<%-- 
    Document   : brechasIndicadores
    Created on : 04-oct-2018, 8:05:29
    Author     : Jonathan
--%>

<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>

<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<spring:url value="/reportebrecha" var="reportLink" />
<div class="container-fluid">

    <div class="row">
        <div class="col-md-12 text-center text-uppercase h4"><label>BANDEJA DE BRECHAS E INDICADORES</label></div>
    </div>
    <hr>
    <div class="card">
        <div class="card-header" data-toggle="collapse" data-target="#item1" aria-expanded="false" aria-controls="item1">
            <h5 class="mb-0">
                <button class="btn btn-link">
                    FILTRAR POR:
                </button>
            </h5>
        </div>
        <div id="item1" class="collapse">
            <div class="card-body">
                <div class="form-group row ">
                    <label class="col-sm-2">Servicio asociado a la Tipología:</label>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="txtServicioAsociadoTopologia" />
                    </div>
                    <label class="col-sm-2">Año de Registro:</label>
                    <div class="col-sm-2">
                        <form:select id="cboAnio" class="form-control" path="anios">
                            <c:forEach items="${anios}" var="obj">
                                <option <c:if test="${obj.key eq anioActual}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-2">
                        <label>Indicador Brecha del Servicio:</label>
                    </div>
                    <div class="col-sm-4">
                        <input type="text" class="form-control" id="txtIndicador" />
                    </div>
                    <div class="col-sm-4">
                        <div class="float-right">
                            <button id="btnBuscar" class="btn btn-primary"><span class="fas fa-search"></span> Buscar</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div> 

    <hr>
    <div class="row">
        <div class="col-sm-12">
            <div class="float-right">
                
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.PMI)) {%>
                <button id="btnNuevo" class="btn btn-primary"><span class="fas fa-plus"></span> Nuevo</button>
                <% }%>
                <button id="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Ver Adjuntos</button>
                <button id="btnImprimir" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Imprimir"><span class="fas fa-print"></span> Imprimir</button>

            </div>
        </div>
    </div>
    <!-- Bandeja Principal -->
    <div class="card shadow mt-1 mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table id="tblBrechasIndicadores" class="table table-bordered" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Codigo Interno</th>
                            <th>Sector</th>
                            <th>Funcion</th>
                            <th>Division funcional</th>
                            <th>Grupo funcional</th>
                            <th>Tipologia de Inversión</th>
                            <th>Servicio Asociado a la Tipologia</th>
                            <th>Indicador Brecha del servicio</th>
                            <th>Unidad Medida</th>
                            <th>Unidad Capacidad Productora</th>
                            <th class="tres-botones">Acción</th>
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
    <div class="modal fade" id="mdlAdjuntos" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title">DOCUMENTOS ADJUNTOS DEL AÑO: <span id="spanAnioTitle"></span></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
                        <div class="col-sm-4">   
                            <input type="file" id="txtfile" multiple="false">
                            <p class="help-block">Formatos jpg, pdf.</p>
                        </div>
                        <div class="col-sm-6">   
                            <input type="text" class="form-control" id="txtNamefile" placeholder="Descripción del Archivo">
                        </div>
                        <div class="col-sm-2">
                            <div class="float-right">
                                <button id="btnAdjuntar" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="tblDocsAdjuntos" width="100%" cellspacing="0">
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
                </div><!-- FIN MODAL-BODY -->

            </div><!-- FIN modal-content-->
        </div><!-- FIN modal-dialog-->
    </div><!-- FIN Modal-->

</div><!-- FIN DEL CONTAINER  -->


<!-- Modal NUEVO-->
<div class="modal fade bs-example-modal-lg" id="mdlNuevo" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Nuevo Registro de Brecha e Indicadores</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label class="col-sm-2">Código Interno:</label>
                        <div class="col-sm-2">
                            <input type="text" id="txtCodigoInterno" class="form-control" disabled />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Año:</label>
                        <div class="col-sm-2">
                            <form:select id="cboAnioNuevo" class="form-control" path="anios">
                                <c:forEach items="${anios}" var="obj">
                                    <option <c:if test="${obj.key eq anioActual}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="txtSector"></select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Función:</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="cboFuncion"></select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">División Función:</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="cboDivFuncion"></select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Grupo Funcional:</label>
                        <div class="col-sm-10">
                            <select class="form-control" id="cboGrupoFunc"></select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Tipología de Inversión:</label>
                        <div class="col-sm-10">
                            <input type="text" id="txtTipologia" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Servicio asociado a la Tipologia:</label>
                        <div class="col-sm-10">
                            <input type="text" id="txtServicioAsociadoTopologiaNuevo" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Indicador Brecha del Servicio (Cantidad y Calidad):</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="txtIndicadorNuevo" rows="3"></textarea>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Unidad de Medida:</label>
                        <div class="col-sm-10">
                            <input type="text" id="txtUnidadMed" class="form-control" />
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Unidad Capacidad Productora:</label>
                        <div class="col-sm-10">
                            <input type="text" id="txtCapPro" class="form-control" />
                        </div>
                    </div>
                </form>
            </div><!-- FIN modal-body-->
            <div class="modal-footer">
                <button type="button" id="btnGuardar" class="btn btn-primary"><span class="fas fa-save"></span> Guardar copia</button>
            </div>

            <div class="modal-footer">
                <button type="button" id="btnGuardarEditar" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div><!-- FIN modal-content-->
    </div><!-- FIN modal-dialog-->
</div><!-- FIN Modal NUEVO-->


<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/brechasIndicadores/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/brechasIndicadores/controller.js' />"></script>

</body>
</html>