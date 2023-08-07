<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<link href="<c:url value='/resources/css/steps/main.css' />" rel="stylesheet" />
<input type="hidden" id="hdnIdProyectoPIP" value="${item.proyectoPIP.idProyepip}" />
<div class="container-fluid">


        <div class="text-center h4">
            <div>
                <label>PROYECTO DE INVERSIÓN: </label><br>
                <label class="text-uppercase">${item.proyectoPIP.nomproyect}</label>
            </div>
            <div class="text-center h5">
                  <div class="progress m-2">
                    <div class="progress-bar bg-info" role="progressbar" style="width: ${seguimiento.AVANCE_PIP}%" aria-valuenow="${seguimiento.AVANCE_PIP}" aria-valuemin="0" aria-valuemax="100">Porcentaje de avance del Ciclo de Inversion (${seguimiento.AVANCE_PIP}%)</div>
                </div> <label class="badge badge-${seguimiento.styleProc}">${seguimiento.nombreEstado}</label>
            </div>
        </div>
            <div >
            <div class="table-responsive mb-2">
                <table class="card shadow table table-bordered text-center" id="dataTable" width="100%" cellspacing="0">

                    <tbody>
                          <tr>
                            <c:forEach items="${procesos}" var="obj">
                                <c:if test="${obj.codproceso eq 58}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./getPIP?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                                <c:if test="${obj.codproceso eq 59}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./ideasInversion?idinver=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                                <c:if test="${obj.codproceso eq 61}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./comiteTrabajo?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                                <c:if test="${obj.codproceso eq 62}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./planDeTrabajo?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a> </td>                                  
                                </c:if>
                                <c:if test="${obj.codproceso eq 63}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./p02Perfil?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a> </td>                                  
                                </c:if>
                                <c:if test="${obj.codproceso eq 64}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./expTecnicoPIP?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                                <c:if test="${obj.codproceso eq 65}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./inforConsistPIP?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                                <c:if test="${obj.codproceso eq 66}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./ejecucionFisicaPIP?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>                                  
                                </c:if>
                                <c:if test="${obj.codproceso eq 67}">
                                    <td class="border-bottom-${obj.styleProc}"><a href="./liquidacionInversionPIP?id=${item.proyectoPIP.idProyepip}">${obj.nombreProc}</a></td>
                                </c:if>
                            </c:forEach>   
                            </tr>
                         </tbody>
                  </table>
              </div>
            </div>
            
            <!-- DATOS GENERALES  -->
            <div class="card mb-1">
                <div class="card-header collapsed" id="headingOne"data-toggle="collapse"  href="#collapseOne" aria-expanded="false" aria-controls="collapseOne">
                    <h4 class="mb-0">
                        <button class="btn btn-link">DATOS GENERALES</button> 
                    </h4>
                </div>
                <div id="collapseOne" class="collapse" aria-labelledby="headingOne">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-2">CODIGO UNICO MEF:</label>
                            <div class="col-sm-4">
                                <label>${item.proyectoPIP.codunimef}</label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2">NOMBRE PROYECTO DE INVERSIÓN:</label>
                            <div class="col-sm-4">
                                <label class="text-uppercase">${item.proyectoPIP.nomproyect}</label>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2">COSTO DE INVERSION (S/.):</label>     
                            <div class="col-sm-4">
                                <label class="number">${item.proyectoPIP.v_totalMontoItem}</label>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

            <!-- SECCION ADJUNTAR -->
            <div class="card mb-1">            
                <div class="card-header collapsed"  data-toggle="collapse"  data-target="#item3">
                    <h4 class="mb-0">
                        <button class="btn btn-link">DOCUMENTOS ADJUNTOS</button>
                    </h4>
                </div>
                <div id="item3" class="collapse" >
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
            <div class="card mb-1">            
                <div class="card-header collapsed"  data-toggle="collapse"  data-target="#item4">
                    <h4 class="mb-0">
                        <button class="btn btn-link">OBSERVACIONES REGISTRADAS</button>
                    </h4>
                </div>
                <div id="item4" class="collapse" >
                    <div class="card-body">
                        <div class="form-group row d-none">

                            <div class="col-sm-10">   
                                <input type="text" class="form-control" id="txtObservacion" placeholder="Ingresar la Observación">
                            </div>
                            <div class="col-sm-2 d-none">
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

<script src="<c:url value='/resources/js/nsScript/seguimiento/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/seguimiento/controller.js' />"></script>

</body>
</html>