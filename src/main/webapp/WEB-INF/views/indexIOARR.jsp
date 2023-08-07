<%-- 
    Document   : nuevoProyectoIOARR
    Created on : 09-oct-2018, 10:50:10
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<link href="<c:url value='/resources/css/steps/main.css' />" rel="stylesheet" />
<input type="hidden" id="hdnIdProyectoIOARR" value="${item.proyectoIOARR.idProIOARR}" />
<div class="container-fluid">

            <div class="text-center h4">
                <div>
                    <label>IOARR:</label><br>
                    <label class="text-uppercase">${item.proyectoIOARR.nombreInversion}</label>
                </div>
                <div class="text-center h5">
                     <div class="progress m-2">
                        <div class="progress-bar bg-info" role="progressbar" style="width: ${seguimiento.AVANCE_IOARR}%" aria-valuenow="${seguimiento.AVANCE_IOARR}" aria-valuemin="0" aria-valuemax="100">Porcentaje de avance del Ciclo de Inversion (${seguimiento.AVANCE_IOARR}%)</div>
                     </div> <label class="badge badge-${seguimiento.styleProc}">${seguimiento.nombreEstado}</label>
                </div>
            </div>
            <div class="table-responsive  mb-2">
               <table class="card shadow table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">
                      <tbody>
                           <tr>
                               <c:forEach items="${procesos}" var="obj">
                                   <c:if test="${obj.codproceso eq 58}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./getIOARR?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a></td>

                                   </c:if>
                                   <c:if test="${obj.codproceso eq 59}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./ideasInversion?idinver=${item.proyectoIOARR.v_idProIOARR}">${obj.nombreProc}</a></td>
                                   </c:if>
                                   <c:if test="${obj.codproceso eq 60}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./solicitudEjecucion?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a></td>
                                   </c:if>
                                   <c:if test="${obj.codproceso eq 61}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./comiteTrabajoIOARR?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a></td>
                                   </c:if>    
                                   
                                   <c:if test="${obj.codproceso eq 64}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./expTecnicoIOARR?id=${item.proyectoIOARR.idProIOARR}"  style="width: 16%" aria-valuenow="14">${obj.nombreProc}</a> </td>                                  
                                   </c:if>
                                   <c:if test="${obj.codproceso eq 65}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./inforConsistIOARR?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a></td>
                                   </c:if>
                                   <c:if test="${obj.codproceso eq 66}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./ejecucionFisicaIOARR?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a> </td>                                  
                                   </c:if>
                                   <c:if test="${obj.codproceso eq 67}">
                                       <td class="border-bottom-${obj.styleProc}"><a href="./liquidacionInversionIOARR?id=${item.proyectoIOARR.idProIOARR}">${obj.nombreProc}</a>    </td>                               
                                   </c:if>
                               </c:forEach>   
                           </tr>
                       </tbody>
               </table>
           </div>

            <div class="card mb-1">
                <div class="card-header collapsed" id="headingOne"data-toggle="collapse"  href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    <h4 class="mb-0">
                        <button class="btn btn-link"> DATOS GENERALES</button>
                    </h4>
                </div>
                <div id="collapseOne" class="collapse" aria-labelledby="headingOne">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-2">CODIGO DE IDEA:</label>
                            <div class="col-sm-10">
                                <label>${item.proyectoIOARR.codunimef}</label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 text-uppercase">NOMBRE DE INVERSION:</label>
                            <div class="col-sm-10">
                                <label class="text-uppercase">${item.proyectoIOARR.nombreInversion}</label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2 text-uppercase">COSTO DE INVERSIÓN (S/.):</label>
                            <div class="col-sm-10">
                                <label class="text-uppercase number">${totalInversion}</label>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- SECCION ADJUNTAR -->
            <div class="card mb-1">            
                <div class="card-header"  data-toggle="collapse"  href="#item3">
                    <h4 class="mb-0">
                        <button class="btn btn-link">DOCUMENTOS ADJUNTOS</button>
                    </h4>
                </div>
                <div id="item3" class="collapse show" >
                    <div class="card-body">

                        <div class="form-group row d-none">

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
                        <div class="table-responsive">
                            <table id="tblDocsAdjuntos" class="table table-bordered table-md" width="100%">
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


            <!-- SECCION OBSERVACION -->
            <div class="card">            
                <div class="card-header collapsed"  data-toggle="collapse"  href="#item4">
                    <h4 class="mb-0">
                        <button class="btn btn-link"> OBSERVACIONES REGISTRADAS </button>
                    </h4>
                </div>
                <div id="item4" class="collapse" >
                    <div class="card-body">
                        <div class="form-group row d-none">

                            <div class="col-sm-10">   
                                <input type="text" class="form-control" id="txtObservacion" placeholder="Ingresar la Observación">
                            </div>
                            <div class="col-sm-2">
                                <div class="float-right">
                                    <button class="btn btn-primary" id="btnGuardarObservacion"><span class="fas fa-save"></span> Guardar</button>
                                </div>
                            </div>
                        </div>
                        <div class="table-responsive">
                            <table class="table table-bordered table-md" id="tblObservacion" width="100%">
                                <thead>
                                    <tr>
                                        <th>Número</th>
                                        <th>Observación</th>
                                        <th>Proceso</th>
                                        <th>Fecha Creación</th>
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

<script src="<c:url value='/resources/js/nsScript/seguimientoIOARR/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/seguimientoIOARR/controller.js' />"></script>
</body>
</html>