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
<input type="hidden" id="hdnIdProyectoIOARR" value="0" />
<input type="hidden" id="txtCodunidpro" value="${userInfo.codigo}" />
<div class="container-fluid">

    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">IOARR</label><br>
            <label>PROGRAMACIÓN MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">NUEVO FORMATO N° 05-B</label>
        </div>
    </div>

    <hr>
    <div class="form-group row">
        <div class="col-sm-12">
            <div class="float-right">
                <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div>    
    </div>
    
        <div id="accordion">

            <div class="card">
                <div class="card-header" data-toggle="collapse" data-target="#item11" aria-expanded="true" aria-controls="item11">
                   <h5 class="mb-0">
                    <button class="btn btn-link">
                      NOMBRE DE IDEA DE IOARR
                    </button>
                  </h5>
                </div>
                <div id="item11" class="collapse show">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-4">Nombre de la Inversión (Compuesto):</label>
                            <div class="col-sm-8">
                                <textarea class="form-control"  disabled name="nombreInversion"></textarea>
                            </div>
                        </div>   

                    </div>
                </div>
            </div>     
            <div class="card">
                <div class="card-header" data-toggle="collapse" data-target="#item4" aria-expanded="false" aria-controls="item4">
                    <h5 class="mb-0">
                        <button class="btn btn-link" >RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN </button>
                    </h5>
                </div>
                <div id="item4" class="collapse show">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-2">Función:</label>
                            <div class="col-sm-4">
                                <form:select id="cboFuncion" class="form-control" path="funcion" required="required">
                                    <form:options items="${funcion}" />
                                </form:select>
                            </div>
                            <label class="col-sm-2">División Funcional:</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="cboDivFuncion">
                                    <option>-- Seleccione --</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2">Grupo Funcional:</label>
                            <div class="col-sm-4">
                                <select class="form-control" id="cboGrupoFunc">
                                    <option>-- Seleccione --</option>
                                </select>
                            </div>
                            <label class="col-sm-2">Sector Responsable:</label>
                            <div class="col-sm-4">
                                <form:select id="txtSectorCuatro" class="form-control" path="lstSector">
                                    <form:options items="${lstSector}" />
                                </form:select>
                            </div>
                        </div>

                    </div>
                </div>
            </div>

            <div class="card">                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          
                <div class="card-header" id="headingThree"data-toggle="collapse" href="#item5" aria-expanded="false" aria-controls="item5">
                    <h5 class="mb-0">
                        <button class="btn btn-link"> ALINEAMIENTO A UNA BRECHA PRIORITARIA </button>
                    </h5>
                </div>
                <div id="item5" class="collapse show" aria-labelledby="item5">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-4">Servicios Públicos con Brecha Identificada y Priorizada:</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="cboServTipologia">
                                    <option>-- Seleccione --</option>
                                </select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-4">Indicador de Brecha de Acceso a Servicios:</label>
                            <div class="col-sm-8">
                                <select class="form-control" id="cboIndiBrechaServicio">
                                    <option>-- Seleccione --</option>
                                </select>
                            </div>
                        </div>

                        <div class="table-responsive">
                            <table class="table table-bordered table-md" >
                                <thead>
                                    <tr>
                                        <th>UNIDAD DE MEDIDA</th>     
                                        <th>ESPACIO GEOGRAFICO</th>   
                                        <th>AÑO:</th>     
                                        <th>VALOR CAP. PRODUCCIÓN (%)</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr data-clone="1">
                                        <td><div><select class="form-control number" id="cboUnidadMed">
                                                    <option>-- Seleccione --</option>
                                                </select>
                                            </div></td>
                                        <td>   
                                            <form:select id="txtEspacioGeo" class="form-control" path="espacioGeografico">
                                                <form:option value="-1" label="-- Seleccione --"/>
                                                <form:options items="${espacioGeografico}" />
                                            </form:select>
                                        </td>                                           
                                        <td><input type="text" class="form-control " maxlength="4" id="txtAnio"/></td>
                                        <td><input type="text" class="form-control number"  id="txtValorIndicador" value="0"></td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>              
                        <div class="form-group row">
                            <label class="col-sm-4">Contribución al Cierre de Brecha (%):</label>
                            <div class="col-sm-4">
                                <input type="text" class="form-control number" id="txtValorContri">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
            <div class="card">       
                <div class="card-header" id="headingOne"data-toggle="collapse" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    <h5 class="mb-0">
                       <button class="btn btn-link"> UNIDAD FORMULADORA</button>
                    </h5>
                </div>
                <div id="collapseOne" class="collapse show" aria-labelledby="headingOne">
                    <div class="card-body">

                        <div class="form-group row">
                            <label class="col-sm-2">Sector:</label>
                            <div class="col-sm-4">
                                <form:select id="txtSector" class="form-control" path="lstSector">
                                    <form:options items="${lstSector}" />
                                </form:select>
                            </div>
                            <label class="col-sm-2">Entidad:</label>
                            <div class="col-sm-4">
                                <form:select id="txtEntidad" class="form-control" path="lstEntidadUnidadF">
                                    <form:options items="${lstEntidadUnidadF}" />
                                </form:select>
                            </div>
                        </div>

                        <div class="form-group row">
                            <label class="col-sm-2">Nombre de la UF:</label>
                            <div class="col-sm-4">
                                <form:select id="txtNomUniFormuladora" class="form-control" path="lstNombreUnidadEjecutora">
                                    <form:options items="${lstNombreUnidadF}" />
                                </form:select>
                            </div>
                            <label class="col-sm-2">Responsable de la UF:</label>
                            <div class="col-sm-4">
                                <form:select id="txtRespUniformuladora" class="form-control" path="lstResponsableUnidadEjecutora">
                                    <form:options items="${lstResponsableUnidadF}" />
                                </form:select>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        
        <div class="card">
            <div class="card-header" id="headingTwo"  data-toggle="collapse" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <h5 class="mb-0">
                    <button class="btn btn-link"> UNIDAD EJECUTORA DE INVERSIONES</button>
                </h5>
            </div>
            <div id="collapseTwo" class="collapse show" aria-labelledby="headingTwo">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorDos" class="form-control" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Entidad:</label>
                        <div class="col-sm-4">
                            <form:select id="txtEntidadDos" class="form-control" path="lstEntidadUnidadF">
                                <form:options items="${lstEntidadUnidadF}" />
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboNombreUniEjecutora" class="form-control" path="lstNombreUnidadEjecutora">
                                <form:options items="${lstNombreUnidadEjecutora}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Responsable de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboRespUniEjecutora" class="form-control" path="lstResponsableUnidadEjecutora">
                                <form:options items="${lstResponsableUnidadEjecutora}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingThree" data-toggle="collapse" href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h5 class="mb-0">
                    <button class="btn btn-link"> UNIDAD EJECUTORA PRESUPUESTAL</button>
                </h5>
            </div>
            <div id="collapseThree" class="collapse show" aria-labelledby="headingThree">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorTres" class="form-control" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Entidad:</label>
                        <div class="col-sm-4">
                            <form:select id="cboEntidad" class="form-control" path="lstEntidadUnidadE">
                                <form:options items="${lstEntidadUnidadE}" />
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la UE:</label>
                        <div class="col-sm-4">
                            <form:select id="txtUniEjecutora" class="form-control" path="lstEntidadUnidadF">
                                <form:options items="${lstEntidadUnidadF}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="headingThree"data-toggle="collapse" href="#item6" aria-expanded="false" aria-controls="item6">
                <h5 class="mb-0">
                    <button class="btn btn-link">  DATOS DE LA INVERSIÓN</button>
                </h5>
            </div>
            <div id="item6" class="collapse show" aria-labelledby="item6">
                <div class="card-body">
                    <div class="form-group row">
                        <label class="col-sm-4" title="Nota: Las UP deben referirse a un mismo grupo funcional correspondiente">Nombre Genérico de las Unidades Productoras:</label>
                        <div class="col-sm-8">
                            <label type="text" class="form-control" id="txtNomUnidadProductora" >${userInforData}</label>
                        </div>
                    </div>

                    <div class="row">
                        <label class="col-sm-12">Localización Geografica:</label>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-bordered table-md">
                            <thead>
                                <tr class="text-center">
                                    <th>DEPARTAMENTO</th>     
                                    <th>PROVINCIA</th>   
                                    <th>DISTRITO</th>     
                                </tr>
                            </thead>
                            <tbody>
                            <td class="col-xs-3"><form:select id="cboDepartamento" class="form-control" path="ubigeo">
                                    <form:options items="${ubigeo}" />
                                </form:select></td>
                            <td class="col-xs-3"><select class="form-control"id="cboProvincia">
                                </select></td>
                            <td class="col-xs-3"><select class="form-control"id="cboDistrito">
                                </select></td>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header" id="headingThree" data-toggle="collapse" href="#item7" aria-expanded="false" aria-controls="item7">
                <h5 class="mb-0">
                    <button class="btn btn-link"> DESCRIPCIÓN AGREGADA DE LAS IOARR</button>
                </h5>
            </div>
            <div id="item7" class="collapse show" aria-labelledby="item7">
                <div class="card-body">
                    <div class="form-group row">                    
                       
                            <label class="col-sm-2">Objeto de intervención:</label>                                           
                            <div class="col-sm-10">
                                <td><textarea class="form-control" id="txtObjInterv" > </textarea></td>
                            </div>                    
                                              
                          <div class="col-sm-12 d-none">
                            <div class="float-right">
                                <button type="button" class="btn btn-primary" name="btnAgregarTipoIOARR" data-toggle="tooltip" data-placement="top" title="Agregar otro Tipo de Inversión"><span class="fas fa-plus"></span> Agregar</button>
                            </div>    
                        </div>
                    </div>
                    <div class="table-responsive">
                        <table class="table table-bordered table-md" id="tblTipoIOARR">
                            <thead>
                                <tr>
                                    <th>TIPO DE IOARR (*)</th>     
                                    <th>MONTO DE INVERSIÓN (S/.)</th>   
                                    <th class="d-none">Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr data-clone="1">
                                    <td><form:select id="cboTipoIOARR" class="form-control" path="lstTipoIOARR">
                                            <form:options items="${lstTipoIOARR}" />
                                        </form:select></td>

                                    <td><input type="text" class="form-control number" id="txtMontoInversion"></td>
                                    <td class="accion d-none">
                                        <button class="btn btn-primary hidden" data-toggle="tooltip" data-placement="top" title="Eliminar registro" name="btnEliminarTipoIOARR"><span class="fas fa-trash-alt"></span></button>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>  
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header"data-toggle="collapse" href="#item9" aria-expanded="false">
                <h5 class="mb-0">
                    <button class="btn btn-link"> MODALIDAD DE EJECUCIÓN TENTATIVA</button>
                </h5>
            </div>
            <div id="item9" class="collapse show" >
                <div class="card-body">

                    <div class="row">
                        <div class="col-sm-12">
                            <form:select id="cboModalidadEjecucion" class="form-control" path="modalidadEjecucion">
                                <form:options items="${modalidadEjecucion}" />
                            </form:select>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header"data-toggle="collapse" href="#item10" aria-expanded="false">
                <h5 class="mb-0">
                    <button class="btn btn-link"> FUENTE DE FINANCIAMIENTO</button>
                </h5>
            </div>
            <div id="item10" class="collapse show" >
                <div class="card-body">

                    <div class="row">
                        <div class="col-sm-12">
                            <form:select id="cboTipoFinanciamiento" class="form-control" path="tipoFinanciamiento">
                                <form:options items="${tipoFinanciamiento}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingThree"data-toggle="collapse" href="#item8" aria-expanded="false">
                <h5 class="mb-0">
                    <button class="btn btn-link"> ¿ALGUNA DE LAS IOARR SE FINANCIA TOTAL O PARCIALMENTE CON RECURSOS POR OPERACIONES OFICIALES DE CRÉDITO?</button>
                </h5>
            </div>
            <div id="item8" class="collapse show" >
                <div class="card-body">

                    <div class="radio">
                        <label>
                            <input type="radio" name="pregunta8" value="1">
                            SI: Se requiere adelantar el registro de las IOARR (Formato N° 02 -Directiva N° 002-2017-EF/63.01) para las cuales solicitan el financiamiento con Recursos por Operaciones Oficiales de Crédito.
                        </label>
                    </div>
                    <div class="radio">
                        <label>
                            <input type="radio" name="pregunta8" value="0">
                            No
                        </label>
                    </div>

                </div>
            </div>
        </div>

    </div>

    <div class="mt-2 form-group row">
        <div class="col-sm-12">
            <div class="float-right">
                <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div>    
    </div>

</div><!-- FIN DEL CONTAINER  -->

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/nuevoIOARR/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/nuevoIOARR/controller.js' />"></script>
</body>
</html>