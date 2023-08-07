<%-- 
    Document   : nuevoProyectoIOARR
    Created on : 09-oct-2018, 10:50:10
    Author     : Jonathan
--%>
<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<input type="hidden" id="hdnIdProyectoIOARR" value="${item.proyectoIOARR.idProIOARR}" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<input type="hidden" id="txtCodunidpro" value="${userInfo.codigo}" />
<div class="container-fluid">

    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">IOARR</label><br>
            <label>PROGRAMACIÓN MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">NUEVO FORMATO N° 05-B</label>
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
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 41 or seguimiento.estadoproc eq 44}"><!-- EN ELABORACION / OBSERVADO -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button name="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR) || Util.hasRole(Constantes.PerfilUsuario.PMI)) {%>
                <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button  name="btnObservar" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                    <button name="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                
                <button name="btnImprimir" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Imprimir"><span class="fas fa-print"></span> Imprimir</button>

            </div>
        </div>    
    </div>
    <div id="accordion">


        <div class="card">
            <div class="card-header" id="headingThree" data-toggle="collapse" data-target="#item11" aria-expanded="true" aria-controls="item11">
                <h4 class="mb-0">
                    <button class="btn btn-link">NOMBRE DE IDEA DE IOARR</button></h4>
            </div>
            <div id="item11" class="collapse show" aria-labelledby="item11">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-4">Nombre de la Idea de IOARR:(Agregado y Simplificado)</label>
                        <div class="col-sm-8">
                            <textarea class="form-control"  disabled="disabled"name="nombreInversion">${item.proyectoIOARR.nombreInversion}</textarea>
                        </div>
                    </div>   

                </div>
            </div>
        </div>            
        <div class="card">
            <div class="card-header" id="headingThree"data-toggle="collapse" data-target="#item4" aria-expanded="false" aria-controls="item4">
                <h4 class="mb-0"><button class="btn btn-link">
                        RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN
                    </button></h4>
            </div>
            <div id="item4" class="collapse show" aria-labelledby="item4">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Función:</label>
                        <div class="col-sm-4">
                            <form:select id="cboFuncion" class="form-control" path="funcion" required="required">
                                <c:forEach items="${funcion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idFuncion}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">División Funcional:</label>
                        <div class="col-sm-4">
                            <form:select id="cboDivFuncion" class="form-control" path="division" required="required">
                                <c:forEach items="${division}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idDivFuncion}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Grupo Funcional:</label>
                        <div class="col-sm-4">
                            <form:select id="cboGrupoFunc" class="form-control" path="grupoFuncion" required="required">
                                <c:forEach items="${grupoFuncion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idGrupoFuncion}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">Sector Responsable:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorCuatro" class="form-control" path="lstSector">
                                <c:forEach items="${lstSector}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idSectorResponsable}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" id="headingThree"data-toggle="collapse" data-target="#item5" aria-expanded="false" aria-controls="item5">
                <h4 class="mb-0"><button class="btn btn-link">
                        ALINEAMIENTO A UNA BRECHA PRIORITARIA
                    </button></h4>
            </div>
            <div id="item5" class="collapse show" aria-labelledby="item5">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-4">Servicios Públicos con Brecha Identificada y Priorizada:</label>

                        <div class="col-sm-8">
                            <form:select id="cboServTipologia" class="form-control" path="servTipologia">
                                <c:forEach items="${servTipologia}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.servicioPulico}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4">Indicador de Brecha de Acceso a Servicios:</label>
                        <div class="col-sm-8">
                            <form:select id="cboIndiBrechaServicio" class="form-control" path="brecha">
                                <c:forEach items="${brecha}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idBrechaIndicador}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
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
                                    <td><form:select id="cboUnidadMed" class="form-control" path="unidadMedida" required="required">
                                            <c:forEach items="${unidadMedida}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.unidadmed}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>  </td>
                            <td> 
                                <form:select id="txtEspacioGeo" class="form-control" path="espacioGeografico">
                                    <c:forEach items="${espacioGeografico}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.espaciogeo}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                            </td>
                            <td><input type="number" class="form-control number" id="txtAnio" maxlength="4" value="${item.proyectoIOARR.anio}" /></td>
                            <td><input type="text" class="form-control number" id="txtValorIndicador" value="${item.proyectoIOARR.valorindicador}">
                            </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>              
                    <div class="form-group row">
                        <label class="col-sm-4">Contribución al Cierre de Brecha (%):</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control number" id="txtValorContri" value="${item.proyectoIOARR.valorcontri}">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingOne"data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                <h4 class="mb-0"><button class="btn btn-link">
                        UNIDAD FORMULADORA
                    </button></h4>
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
            <div class="card-header" id="headingTwo" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <h4 class="mb-0"><button class="btn btn-link">
                        UNIDAD EJECUTORA DE INVERSIONES
                    </button></h4>
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
                                <c:forEach items="${lstNombreUnidadEjecutora}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idNombreUEI}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">Responsable de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboRespUniEjecutora" class="form-control" path="lstResponsableUnidadEjecutora">
                                <c:forEach items="${lstResponsableUnidadEjecutora}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idResponsableUEI}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingThree" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h4 class="mb-0"><button class="btn btn-link">
                        UNIDAD EJECUTORA PRESUPUESTAL
                    </button></h4>
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
                                <c:forEach items="${lstEntidadUnidadE}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idEntidadUEP}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
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
            <div class="card-header" id="headingThree"data-toggle="collapse" data-target="#item6" aria-expanded="false" aria-controls="item6">
                <h4 class="mb-0"><button class="btn btn-link">
                        DATOS DE LA INVERSIÓN
                    </button></h4>
            </div>
            <div id="item6" class="collapse show" aria-labelledby="item6">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-4" title="Nota: Las UP deben referirse a un mismo grupo funcional correspondiente">Nombre Genérico de las Unidades Productoras:</label>
                        <div class="col-sm-8">
                            <label type="text" class="form-control" id="txtNomUnidadProductora" >${item.proyectoIOARR.unidadProductora}</label>
                        </div>
                    </div>

                    <div class="row">
                        <label class="col-sm-5">Localización Geografica:</label>
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
                            <td class="col-xs-3">
                                <form:select id="cboDepartamento" class="form-control" path="ubigeo" required="required">
                                    <c:forEach items="${ubigeo}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idDepartamento}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            <td class="col-xs-3">
                                <form:select id="cboProvincia" class="form-control" path="provincia" required="required">
                                    <c:forEach items="${provincia}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idProvincia}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            <td class="col-xs-3">
                                <form:select id="cboDistrito" class="form-control" path="distrito" required="required">
                                    <c:forEach items="${distrito}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.idDistrito}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            </tbody>
                        </table>
                    </div>


                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingThree" data-toggle="collapse" data-target="#item7" aria-expanded="false" aria-controls="item7">
                <h4 class="mb-0"><button class="btn btn-link">
                        DESCRIPCIÓN AGREGADA DE LAS IOARR
                    </button></h4>
            </div>

            <div id="item7" class="collapse show" aria-labelledby="item7">
                <div class="card-body">
                    <div class="form-group row">

                        <label class="col-sm-2">Objeto de intervención:</label>                                           
                        <div class="col-sm-8">
                            <td><textarea type="text" class="form-control" id="txtObjInterv">${item.proyectoIOARR.objinterv}</textarea></td> 
                        </div>                    

                        <div class="col-sm-12">
                            <div class="float-right d-none">
                                <button type="button" class="btn btn-primary" id="btnAgregarTipoIOARR" name="btnAgregarTipoIOARR" data-toggle="tooltip" data-placement="top" title="Agregar otro Tipo de Inversión"><span class="fas fa-plus"></span> Agregar</button>
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
                                <c:forEach var="i" items="${item.listProyectoTipoIOARR}">
                                    <tr>
                                        <td>
                                            <form:select id="cboTipoIOARR" class="form-control" path="lstTipoIOARR">
                                                <c:forEach items="${lstTipoIOARR}" var="obj">
                                        <option <c:if test="${obj.key eq i.idTipoIOARR}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                    </c:forEach>
                                </form:select></td>
                                <td>
                                    <input type="text" class="form-control number" id="txtMontoInversion" value="${i.v_montoInversion}">
                                </td>

                                <td class="accion d-none">
                                    <button class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Eliminar registro" name="btnEliminarTipoIOARR"><span class="fas fa-trash-alt"></span></button>
                                </td>
                                </tr>   
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>  
                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header" data-toggle="collapse" data-target="#item9" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        MODALIDAD DE EJECUCIÓN TENTATIVA
                    </button></h4>
            </div>
            <div id="item9" class="collapse show" >
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboModalidadEjecucion" class="form-control" path="modalidadEjecucion">
                                <c:forEach items="${modalidadEjecucion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.modalidadEjecucion}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" data-toggle="collapse" data-target="#item10" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        FUENTE DE FINANCIAMIENTO
                    </button></h4>
            </div>
            <div id="item10" class="collapse show" >
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboTipoFinanciamiento" class="form-control" path="tipoFinanciamiento">
                                <c:forEach items="${tipoFinanciamiento}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoIOARR.fuenteFinanciamiento}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" id="headingThree"data-toggle="collapse" data-target="#item8" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        ¿ALGUNA DE LAS IOARR SE FINANCIA TOTAL O PARCIALMENTE CON RECURSOS POR OPERACIONES OFICIALES DE CRÉDITO?
                    </button></h4>
            </div>
            <div id="item8" class="collapse show" >
                <div class="card-body">

                    <div class="radio">
                        <label>
                            <input type="radio" name="pregunta8" value="1" <c:if test="${item.proyectoIOARR.financiaTotalParcial eq 1}">checked="chekced"</c:if>>
                                SI: Se requiere adelantar el registro de las IOARR (Formato N° 07--C) para las cuales solicitan el financiamiento con Recursos por Operaciones Oficiales de Crédito.
                            </label>
                        </div>
                        <div class="radio">
                            <label>
                                <input type="radio" name="pregunta8" value="0" <c:if test="${item.proyectoIOARR.financiaTotalParcial eq 0}">checked="chekced"</c:if>>
                                No
                            </label>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <div class="form-group row mt-2">
            <div class="col-sm-12">
                <div class="float-right">
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 41}"><!-- EN ELABORACION -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button name="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button  name="btnObservar" type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                    <button name="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 44}"><!-- OBSERVADO -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button name="btnAdjuntarModal" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <button name="btnImprimir" class="btn btn-primary" data-toggle="tooltip" data-placement="top" title="Imprimir"><span class="fas fa-print"></span> Imprimir</button>
            </div>    
        </div>
    </div>


</div><!-- FIN DEL CONTAINER  -->


<!-- Modal ADJUNTAR-->
<div class="modal fade" id="mdlAdjuntos" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">DOCUMENTOS ADJUNTOS</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>

            </div>
            <div class="modal-body">


                <form action="fileUpload" method="post" enctype="multipart/form-data">
                    <div class="form-group row">
                        <div class="col-sm-4">   
                            <input type="file" id="txtfile" multiple="multiple" name="file" />
                            <p class="help-block">Formatos jpg, pdf.</p>
                        </div>
                        <div class="col-sm-6">   
                            <input type="text" class="form-control" id="txtNamefile" placeholder="Descripción del Archivo">
                        </div>
                        <div class="col-sm-2">
                            <div class="float-right">
                                <div id="btnAdjuntar" title="Subir Archivo al sistema" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</div>
                            </div>
                        </div>
                    </div>
                </form>

                <div class="table-responsive">
                    <table class="table table-bordered table-md" id="tblDocsAdjuntos"  width="100%" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Codigo Documento</th>
                                <th>Descripción del Documento</th>
                                <th>Fecha Creación</th>
                                <th>Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>

            </div><!-- FIN MODAL-BODY -->
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>

<!-- Modal OBSERVAR-->
<div class="modal fade" id="mdlObservar" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Registrar Observación</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
            </div>

            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-12">
                        <textarea class="form-control" id="txtObservacion" placeholder="Ingresar la Observación"></textarea>
                    </div>
                </div>
            </div><!-- FIN MODAL-BODY -->
            <div class="modal-footer">
                <button id="btnGuardarObservacion" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
            </div>
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/nuevoIOARR/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/nuevoIOARR/controller.js' />"></script>
</body>
</html>
