<%-- 
    Document   : ideasInversion
    Created on : 29-oct-2018, 10:40:16
    Author     : Jonathan
--%>
<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>

<!-- Static navbar -->
<jsp:include page="template/header.jsp" />


<div class="container-fluid">

    <div class="row">
        <div class="col-md-12 text-center text-uppercase h4"><label>IDEAS DE PROYECTO DE INVERSION E INVERSIONES</label></div>
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

                <div class="form-group row">
                    <label class="col-sm-2">Año de Registro:</label>
                    <div class="col-sm-2">
                        <form:select id="txtanio" class="form-control" path="anios">
                            <c:forEach items="${anios}" var="obj">
                                <option <c:if test="${obj.key eq anioActual}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                            </c:forEach>
                        </form:select>
                    </div>
                    <label class="col-sm-3">Código de Idea:</label>
                    <div class="col-sm-2">
                        <input type="text" class="form-control" id="txtCodigo" data-findenter="1" value="${V_IOARR_PIP}"/>   
                    </div>
                </div>
                <div class="form-group row">
                    <label class="col-sm-2">Tipo de Inversión:</label>
                    <div class="col-sm-2">
                        <form:select id="txtTipo" class="form-control" path="tipoInversion" >
                            <form:options  items="${tipoInversion}" />
                        </form:select> 
                    </div>

                    <c:if test="${userInfo.codigo != 240}"><!-- EN ELABORACION / SIN REGISTROS-->
                        <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.EJECUCION_EMGRA)|| Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>                    
                            <label class="col-sm-3">Unidad Prestadora de Servicio FAP:</label>
                            <div class="col-sm-5">
                                <form:select id="txtSigla" class="form-control" path="lstUPS" >
                                    <form:options  items="${lstUPS}" />
                                </form:select>          
                            </div>                
                        <% }%>
                        <%if (Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP) || Util.hasRole(Constantes.PerfilUsuario.PMI)
                              || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR)|| Util.hasRole(Constantes.PerfilUsuario.COMITE_TRABAJO)
                              || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_EJECUTORA)) {%>                      
                            <div class="col-sm-5">
                                <input type="hidden" class="form-control"id="txtSigla" value="${userInfo.codigo}"/>
                            </div>         
                        <% }%>
                    </c:if>
                    <c:if test="${userInfo.codigo eq 240}"><!-- EN ELABORACION / SIN REGISTROS-->
                        <label class="col-sm-3">Unidad Prestadora de Servicio FAP:</label>
                        <div class="col-sm-5">
                            <form:select id="txtSigla" class="form-control" path="lstUPS" >
                                <form:options  items="${lstUPS}" />
                            </form:select>          
                        </div>  
                    </c:if>
                </div>
                <div class="form-group row">
                    <div class="col-sm-2">
                        <label>Estado de Idea de Inversion:</label>
                    </div>
                    <div class="col-sm-2">

                        <form:select id="txtEstado_registro" class="form-control" path="estadosRegistro">
                            <form:options  items="${estadosRegistro}" />
                        </form:select>        
                    </div>

                    <div class="col-sm-3">
                        <label>Nombre Idea de Inversión:</label>
                    </div>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" data-findenter="1" id="txtNombreproy"/>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="float-right">
                            <button id="btnBuscar" class="btn btn-primary"><span class="fas fa-search"></span> Buscar</button>

                            <button class="btn btn-primary d-none"><span class="glyphicon glyphicon-list-alt"></span> Generar Reporte PMI</button>
                        </div>
                    </div>
                </div>   

            </div>
        </div>
    </div>     

    <hr>
    <!-- Bandeja Principal -->

    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table id="tblIdeasInversiones" class="table table-bordered" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Idea de Inversión</th>
                            <th>Tipo de Inversión</th>
                            <th>Unidad Prestadora de Servicio FAP</th>
                            <th>Estado Idea de Inversión</th>
                            <th>Fecha de Aprobación Propuesta - EMGRA</th>
                            <th>PMI Institucional</th>
                            <th>Acción</th>        
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>   
    <!-- FIN Container -->
</div>



<!-- Modal-->
<div class="modal" id="mdlRegistrar" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Registrar Codigo de Idea</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>


            </div>
            <div class="modal-body">
                <div class="form-group row">
                    <div class="col-sm-9">   
                        <input type="number" class="form-control" id="txtCodUniMEF" placeholder="Codigo de Idea">
                    </div>
                    <div class="col-sm-2">

                    </div>
                </div>

            </div><!-- FIN MODAL-BODY -->
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button id="btnGuardarCodigo" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>


<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/ideasInversion/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/ideasInversion/controller.js' />"></script>


</body>
</html>