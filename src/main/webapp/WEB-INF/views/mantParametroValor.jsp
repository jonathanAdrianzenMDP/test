<%-- 
    Document   : mantParametroValor
    Created on : 30/01/2019, 09:41:24 AM
    Author     : jadrianzen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!-- Static navbar -->
<jsp:include page="template/header.jsp" />

<link href="<c:url value='/resources/css/onOff.css' />" rel="stylesheet" type="text/css"/>

<input type="hidden" id="hdnIdParametroValor" value="0" />

<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label>MANTENIMIENTO</label><BR>
            <label>PARAMETRO VALOR</label>
        </div>
    </div>
    <hr>
    <div>
        <div class="row">
             <div class="col-sm-2">
                <label>Parametro:</label>
             </div>
            <div class="col-sm-8">
                 <form:select id="cboParametro" class="form-control" path="parametroValor">
                    <c:forEach items="${parametroValor}" var="obj">
                        <option value="${obj.idparame}">${obj.nomParam}</option>
                    </c:forEach>
                 </form:select>

            </div>
            <div class="col-sm-2">
                <button id="btnAgregar" class="btn btn-primary"><span class="fas fa-plus"></span> Agregar Valor</button>
            </div>
        </div>
          
    </div>
    
    <hr>
    <!-- Bandeja Principal -->
    
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table  id="tblParametroValor" class="table table-md table-bordered" width="100%">
                    <thead>
                        <tr>
                            <th>Codigo</th>
                            <th>Parametro</th>
                            <th>Valor</th>
                            <th>Estado</th>
                            <th>Acción</th>           
                        </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

 <div class="modal fade" id="mdlParametroValor" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-md" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    
                </div>
                <div class="modal-body">

                    <div class="row">
                            <div class="col-sm-12">   
                                <label>Parametro:</label>
                                <label class="form-control" id="lblParametro"></label>
                            </div>
                    </div>
                    <div class="row">
                            <div class="col-sm-12">   
                                <label>Parametro Valor:</label>
                                <input type="text" class="form-control" name='txtParametroValor' />
                            </div>
                    </div>
                        
                    
                </div><!-- FIN modal-body-->
            <div class="modal-footer">
                <button type="button" id="btnGuardar" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
            </div><!-- FIN modal-content-->
        </div><!-- FIN modal-dialog-->
    </div><!-- FIN Modal-->

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/parametroValor/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/parametroValor/controller.js' />"></script>
</body>
</html>
