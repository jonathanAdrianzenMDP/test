<%-- 
    Document   : ideasInversion
    Created on : 29-oct-2018, 10:40:16
    Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!doctype html>

<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<input type="hidden" id="txtCodigo" />
<link href="<c:url value='/resources/css/onOff.css' />" rel="stylesheet" type="text/css"/>

<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label>RESPONSABLE DE LA UNIDAD EJECUTORA DE INVERSIONES</label>
        </div>
    </div>
        <hr>
    
    <div class="form-group row">
            <div class="col-sm-3">
            </div>
            <label class="col-md-1">NSA:</label>
            <div class="col-sm-4">
                <input type="text" data-findenter="1" class="form-control" id="txtNumSerie" />
            </div>
            <div class="col-sm-3">
                <button id="btnBuscar" data-toggle="tooltip" data-placement="top" title="Buscar Personal FAP" class="btn btn-primary"><span class="fas fa-search"></span></button>
            </div>
    </div>
    <hr>
        <div>
        <div class="form-group row d-none">
            <label class="col-md-2">NSA:</label>
            <label type="text" class="col-md-2 form-control" id="txtNsa"></label>
            
        </div>
        <div class="form-group row">
             <div class="col-md-1">      
             </div>
            <div class="col-md-4">
                <input type="text" placeholder="NOMBRE Y APELLIDOS" type="text" class="form-control" id="txtGradoNombre" disabled />
            </div>
            <div class="col-md-4">
                <input type="text" placeholder="UNIDAD" type="text" class="form-control" id="txtDescri" disabled />
            </div>
            <div class="col-md-1">
                <button id="btnAgregar" data-toggle="tooltip" data-placement="top" title="Agregar Personal FAP al Sistema" class="btn btn-primary"><span class="fas fa-plus"></span> Agregar </button>
            </div>
        </div>
       
    </div>
    <hr>
    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table id="tablaUnidadEjecutora" class="table table-md table-bordered"  width="100%">
                    <thead>
                        <tr>
                            <th>NSA</th>
                            <th>Descripcion de la Unidad</th>
                            <th>Responsable</th>
                            <th>Fecha de Creacion</th>         
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

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/unidadEjecutoraInver/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/unidadEjecutoraInver/controller.js' />"></script>

</body>
</html>
