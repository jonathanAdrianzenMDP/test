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
<link href="<c:url value='/resources/css/onOff.css' />" rel="stylesheet" type="text/css"/>

<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label>GESTIÓN DE USUARIOS</label>
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
             <div class="col-md-2">
                 <input type="text" placeholder="GRADO" type="text" class="form-control" id="txtGrado" disabled />
             </div>
            <div class="col-md-4">
                <input type="text" placeholder="NOMBRES" type="text" class="form-control" id="txtNombres" disabled />
            </div>
            <div class="col-md-2">
                <input type="text" placeholder="UNIDAD" type="text" class="form-control" id="txtUnidad" disabled />
            </div>
            <div class="col-md-2">
                 <form:select id="txtIdperfil1" class="form-control" path="lperfil" required="required">
                    <form:options items="${lperfil}" />
                </form:select>
            </div>
            <div class="col-md-2">
                <button id="btnAgregar" data-toggle="tooltip" data-placement="top" title="Agregar Personal FAP al Sistema" class="btn btn-primary"><span class="fas fa-plus"></span> Agregar </button>
            </div>
        </div>
       
    </div>
    <hr>

    <div class="card shadow mb-4">
        <div class="card-body">
            <div class="table-responsive">
                <table id="tblControlAccesos" class="table table-md table-bordered"  width="100%">
                    <thead>
                        <tr>
                            <th>Nsa</th>
                            <th>Nombres y Apellidos</th>
                            <th>Unidad</th>
                            <th>Perfil</th>
                            <th>Fecha de Creación</th>
                            <th>Estado</th>  
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

<!-- Editar Password Modal NUEVO-->

<div class="modal fade" id="mdlEditarPassword" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Contraseña</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label class="col-sm-6">Usuario</label>
                        <div class="col-sm-12">
                            <input type="text" id="txtDatos" class="form-control" readonly />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-6">Nueva Contraseña:</label>
                        <div class="col-sm-12">
                            <input type="text" id="txtPassword" class="form-control" />
                        </div>
                    </div>
                </form>
            </div><!-- FIN modal-body-->
            <div class="modal-footer">
                <button type="button" id="btnGuardarPassword" class="btn btn-primary"><span class="fas fa-save"></span> Guardar </button>
            </div>
        </div>
    </div>
</div>


<!-- Editar perfil Modal NUEVO-->

<div class="modal fade bs-example-modal-lg" id="mdlEditarPerfil" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Editar Perfil</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group row">
                        <label class="col-sm-6">Usuario</label>
                        <div class="col-sm-12">
                            <input type="text" id="txtDatos1" class="form-control" readonly />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-6">Cambiar Perfil:</label>
                        <div class="col-sm-12">
                            <form:select id="txtIdperfil" class="form-control" path="lperfil">
                                <form:options items="${lperfil}" />
                            </form:select>
                        </div>
                    </div>
                </form>
            </div><!-- FIN modal-body-->
            <div class="modal-footer">
                <button type="button" id="btnGuardarPerfil" class="btn btn-primary"><span class="fas fa-save"></span> Guardar </button>
            </div>
        </div><!-- FIN modal-content-->
    </div><!-- FIN modal-dialog-->
</div><!-- FIN Modal NUEVO-->




<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/controlAccesos/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/controlAccesos/controller.js' />"></script>

</body>
</html>