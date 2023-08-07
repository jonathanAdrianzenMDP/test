<%-- 
    Document   : IquidacionInversion
    Created on : 14/05/2019, 10:22:42 AM
    Author     : jmeza
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
<input type="hidden" id="hdnIdProyectoPIP" value="0" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<div class="wrapper"></div>

<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">IOARR</label><br>
            <label>EJECUCION DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">LIQUIDACION DE INVERSION</label>
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
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_EJECUTORA) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                <c:if test="${seguimiento.estadoproc eq 72}"><!-- EN ELABORACION -->
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>   
                    <button type="button" class="btn btn-primary" name="btnRegresar"><span class="fas fa-paper-plane"></span> Regresar </button> 
                </c:if>
                <% }%>
            </div>
        </div>    
    </div>

    <!-- Bandeja Principal -->
    <div class="card">
        <div class="card-header"  data-toggle="collapse" href="#item1">
            <h4 class="mb-0">
                <button class="btn btn-link">DATOS GENERALES</button>
            </h4>
        </div>
        <div id="item1">
            <div class="card-body">

                <div class="row">
                    <label class="col-sm-2">CODIGO DE IDEA:</label>
                    <div class="col-sm-4">
                        <label>${item.proyectoIOARR.codunimef}</label>
                    </div>
                </div>

                <div class="row">
                    <label class="col-sm-2">INVERSION:</label>
                    <div class="col-sm-10">
                        <label class="text-uppercase">${item.proyectoIOARR.nombreInversion}</label>
                    </div>
                </div>

                <div class="row">
                    <label class="col-sm-2">UNIDAD EJECUTORA:</label>
                    <div class="col-sm-10">
                        <c:forEach items="${lstNombreUnidadEjecutora}" var="obj">
                            <c:if test="${obj.key eq item.proyectoIOARR.idNombreUEI}"><label>${obj.value}</label></c:if>
                        </c:forEach>
                    </div>
                </div>
                <c:if test="${seguimiento.estadoproc eq 43}"><!-- EN ELABORACION / SIN REGISTROS-->
                    <div class="row">
                        <label class="col-sm-2">CIERRE DE INVERSION:</label>   
                        <div class="col-sm-10">
                            <form:select  id="cboCierre" class="form-control" path="CierreInversiones">
                                <c:forEach items="${CierreInversiones}" var="obj">
                                    <option disabled="disabled" <c:if test="${obj.key eq item.proyectoIOARR.cierreinv}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                </c:if>


                <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 72 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / SIN REGISTROS-->
                    <div class="form-group row">
                        <label class="col-sm-2">CIERRE DE INVERSION:</label>                                           
                        <div class="col-sm-10">
                            <form:select id="cboCierre" class="form-control" path="CierreInversiones">
                                <form:options items="${CierreInversiones}" />
                            </form:select>
                        </div>                    
                    </div>
                </c:if>

            </div>
        </div>
    </div>


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
                            <input type="text" class="form-control" id="txtNamefile" placeholder="Descripción del Archivo" value="Liquidacion de Inversion" /> 
                        </div>
                        <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_EJECUTORA)) {%>                        
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

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/liquidacionInversion/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/liquidacionInversion/controller.js' />"></script>


</body>
</html>


