<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fn" uri = "http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="java.text.DecimalFormat" %>

<jsp:include page="template/header.jsp" />
<input type="hidden" id="hdnIdProyectoPIP" value="${item.proyectoPIP.idProyepip}" />
<input type="hidden" id="hdnIdEstadoActual" value="${seguimiento.estadoproc}" />
<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">PROYECTO DE INVERSION</label><br>
            <label>PROGRAMACIÓN MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">NUEVO FORMATO N° 05-A</label>
        </div>

        <div class="col-sm-12 text-center h5">
            <label class="badge badge-${seguimiento.styleProc}">${seguimiento.nombreEstado}</label>
        </div>

    </div>

    <hr>

    <br>
    <div class="form-group row">
        <div class="col-sm-12">
            <div class="float-left">
                <a href="./seguimientoPIP?id=${item.proyectoPIP.idProyepip}"><button type="button" class="btn btn-primary"><span class="fas fa-book"></span> Ver Seguimiento</button></a>
            </div>
            <div class="float-right">
                
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 41}"><!-- EN ELABORACION -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR) || Util.hasRole(Constantes.PerfilUsuario.PMI)) {%>
                <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                    <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                <c:if test="${seguimiento.estadoproc eq 44}"><!-- OBSERVADO -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <% }%>
                <button type="button" class="btn btn-primary" name="btnImprimir"><span class="fas fa-print"></span> Imprimir</button>

            </div>
        </div>    
    </div>
    <br>
    <div id="accordion">
        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" href="#item1" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        1. NOMBRE DE IDEA DEL PROYECTO/PROGRAMA DE INVERSIÓN</button>
                </h4>
            </div>
            <div id="item1" class="collapse" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-8">
                            <textarea class="form-control"  disabled="disabled" name="nomproyect">${item.proyectoPIP.nomproyect}</textarea>
                            Nota: en el caso de ideas de proyecto, se construye en base a la información consignada en el numeral 6 
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed"  data-toggle="collapse" data-target="#item2" aria-expanded="true">
                <h4 class="mb-0"><button class="btn btn-link">
                        2. RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN</button>
                </h4>
            </div>
            <div id="item2" class="collapse show" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Función:</label>

                        <div class="col-sm-4">
                            <form:select id="cboFuncion" class="form-control" path="funcion" required="required">
                                <c:forEach items="${funcion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idfuncion}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">División Funcional:</label>
                        <div class="col-sm-4">
                            <form:select id="cboDivFuncion" class="form-control" path="division" required="required">
                                <c:forEach items="${division}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.iddivfunci}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Grupo Funcional:</label>
                        <div class="col-sm-4">
                            <form:select id="cboGrupoFunc" class="form-control" path="grupoFuncion" required="required">
                                <c:forEach items="${grupoFuncion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idgrupofun}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">Sectot Responsable:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorCuatro" class="form-control" path="lstSector" required="required">
                                <c:forEach items="${lstSector}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idsectresp}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>
                    Nota: para programas se consigna la cadena funcional representativa del programa
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" href="#item3" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        3. ALINEAMIENTO A UNA BRECHA PRIORITARIA</button>
                </h4>
            </div>
            <div id="item3" class="collapse" data-parent="#accordion" aria-labelledby="headingTree">
                <div class="card-body">
                    <div class="form-group row">
                        <label class="col-sm-4">Servicios Públicos con Brecha Identificada y Priorizada: </label>
                        <div class="col-sm-8">
                            <form:select id="cboServTipologia" class="form-control" path="servTipologia" required="required">
                                <c:forEach items="${servTipologia}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.servpublic}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>               
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-4">Indicador de Brecha de Acceso a Servicios: </label>
                        <div class="col-sm-8">
                            <form:select id="cboIndiBrechaServicio" class="form-control" path="brecha" required="required">
                                <c:forEach items="${brecha}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idbrecindi}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>               
                        </div>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-bordered table-md" id="tblTipoPIP">
                            <thead>
                                <tr>
                                    <th>UNIDAD DE MEDIDA</th>     
                                    <th>ESPACIO GEOGRAFICO</th>   
                                    <th>AÑO</th>     
                                    <th>VALOR CAP. PRODUCCIÓN (%)</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr data-clone="1">
                                    <td><form:select id="cboUnidadMedida" class="form-control" path="unidadMedida" required="required">
                                            <c:forEach items="${unidadMedida}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.unidadmed}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>  </td>
                            <td> 
                                <form:select id="txtEspacioGeo" class="form-control" path="espacioGeografico">
                                    <c:forEach items="${espacioGeografico}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.espaciogeo}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                            </td>
                            <td><input type="number" class="form-control " id="txtAnio" maxlength="4" value="${item.proyectoPIP.anio}" /></td>
                            <td><input type="text" class="form-control number" id="txtValorIndi" value="${item.proyectoPIP.valorindi}" ></td>
                            </tr>
                            </tbody>
                        </table>
                    </div> 
                    <div class="form-group row">
                        <label class="col-sm-4">Contribución al Cierre de Brecha (%):</label>
                        <div class="col-sm-8"><input type="text" class="form-control number" id="txtValorContri" value="${item.proyectoPIP.valorcontri}"/>
                            Nota: Se Refiere a la Capacidad de Producción que Aporta el Proyecto(Incremental)
                        </div>

                    </div>
                    <br>
                    <div class="form-group row">
                        <label class="col-sm-4">Tipologia de Proyecto:</label>
                        <div class="col-sm-8">
                            <form:select id="cboTipologia" class="form-control" path="tipologia" required="required">
                                <c:forEach items="${tipologia}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.tipolopry}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select> 
                            Nota: Solo para Ideas de Proyecto<br>
                            Nota: Se Puede Incluir más de un Servicio Público con Brecha y más de un indicador<br>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <div class="card">
            <div class="card-header collapsed"  data-toggle="collapse" href="#item4" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        4. UNIDAD FORMULADORA</button>
                </h4>
            </div>
            <div id="item4" class="collapse" data-parent="#accordion" >
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
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item5" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        5. UNIDAD EJECUTORA DE INVERSIONES</button>
                </h4>
            </div>
            <div id="item5" class="collapse" data-parent="#accordion" >
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
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idnombruei}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                        <label class="col-sm-2">Responsable de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboRespUniEjecutora" class="form-control" path="lstResponsableUnidadEjecutora">
                                <c:forEach items="${lstResponsableUnidadEjecutora}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idrespouei}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item6" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        6. UNIDAD EJECUTORA PRESUPUESTAL</button>
                </h4>
            </div>
            <div id="item6" class="collapse" data-parent="#accordion">
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
                                    <option <c:if test="${obj.key eq item.proyectoPIP.identiduep}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
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
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item7" aria-expanded="false">
                <h4 class="panel-title"><button class="btn btn-link">
                        7. DATOS DE LA INVERSIÓN</button>
                </h4>
            </div>
            <div id="item7" class="collapse" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Objeto de intervención:</label>                                           
                        <div class="col-sm-10">
                            <td><input type="text" class="form-control" id="txtObjInterv" value="${item.proyectoPIP.objinterv}"  /></td> 
                        </div>                    
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Naturaleza de intervención:</label>

                        <div class="col-sm-10">
                            <form:select id="cboNaturaleza" class="form-control" path="naturalezaIntervencion">
                                <form:options items="${naturalezaIntervencion}" />
                            </form:select>
                        </div>       
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la Unidad Productora:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="txtNomUniProd" value="${item.proyectoPIP.nomuniprod}" disabled="disabled" />
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-10">Localización Geográfica de la Unidad Productora:</label>
                    </div>

                    <div class="table-responsive">
                        <table class="table table-bordered table-md">
                            <thead>
                                <tr>
                                    <th>DEPARTAMENTO</th>     
                                    <th>PROVINCIA</th>   
                                    <th>DISTRITO</th>     

                                </tr>
                            </thead>
                            <tbody>                             
                            <td class="col-xs-2">
                                <form:select id="cboDepartamento" class="form-control" path="ubigeo">
                                    <c:forEach items="${ubigeo}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idDepartamento}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            <td class="col-xs-2">
                                <form:select id="cboProvincia" class="form-control" path="provincia" required="required">
                                    <c:forEach items="${provincia}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idProvincia}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            <td class="col-xs-2">
                                <form:select id="cboDistrito" class="form-control" path="distrito" required="required">
                                    <c:forEach items="${distrito}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.idDistrito}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>
                            </tbody>
                        </table>
                    </div> 

                </div>
            </div>
        </div>



        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item8" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        8. DESCRIPCIÓN AGREGADA DEL PROYECTO/PROGRAMA</button>
                </h4>
            </div>
            <div id="item8" class="collapse" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-4">8.1 PARA PROYECTOS DE INVERSIÓN:</label>
                        <div class="col-sm-12">
                            <div class="form-group row">
                                <div class="col-sm-12">
                                    <div class="float-right">
                                        <button class="btn btn-primary" id="btnAgregarTipoItem"><span class="fas fa-plus"></span> Agregar</button>
                                    </div>    
                                </div>
                            </div>
                            <div class="table-responsive">
                                <table id="tblTipoItem" class="table table-bordered table-md">
                                    <thead>
                                    <th>TIPO DE ITEM</th>
                                    <th>COSTO REFERENCIAL (S/.)</th>
                                    <th>ACCIÓN</th>
                                    </thead>  
                                    <tbody>  
                                        <tr data-clone="1" class="d-none">
                                            <td><input  type="text" class="form-control" name="txttipoitem"></td>
                                            <td><input type="text" class="form-control number text-right" name="txtmontoitem" value="0"></td>
                                            <td class="text-center">
                                                <div name="btnEliminarTipoItem"><span class="fas fa-trash-alt"></span></div>
                                            </td>
                                        </tr>
                                        <c:forEach var="i" items="${item.listTipoItem}">
                                            <tr data-clone="0">  
                                                <td>                                 
                                                    <div>
                                                        <input  type="text" class="form-control" name="txttipoitem"  value="${i.tipoitem}">
                                                    </div>  
                                                </td>
                                                <td><input type="text" class="form-control number text-right" name="txtmontoitem"  value="${i.v_costoref}"></td>
                                                <td class="text-center">
                                                    <div name="btnEliminarTipoItem"><span class="fas fa-trash-alt"></span></div>
                                                </td>
                                            </tr>   
                                        </c:forEach>

                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td style="text-align: right;font-weight: bold;padding: 9px;"><label>TOTAL (S/.) </label></td>
                                            <td><input type="text" id="txtTotalItem" disabled="disabled" class="form-control number text-right" /></td>
                                        </tr>
                                    </tfoot>
                                </table>
                            </div>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-10">Capacidad de Producción Estimada con el Proyecto de Inversion:</label>
                    </div>

                    <div class="table-responsive">
                        <table id="tblServicioPIP" class="table table-bordered table-md">
                            <thead>
                                <tr>
                                    <th>SERVICIO</th>     
                                    <th>U/M</th>   
                                    <th>CAPACIDAD DE PRODUCCION</th>

                                </tr>
                            </thead>
                            <tbody>   


                            <td><form:select disabled="disabled" id="cboServTipologia1" class="form-control" path="servTipologia">
                                    <c:forEach items="${servTipologia}" var="obj">
                                    <option disabled="disabled" <c:if test="${obj.key eq item.proyectoPIP.servpublic}"> selected="selected"</c:if>  value="${obj.key}" disabled="disabled">${obj.value}</option>
                                </c:forEach>
                            </form:select></td>


                            <td><form:select id="cboUnidadMedida1" class="form-control" path="unidadMedida" required="required">
                                    <c:forEach items="${unidadMedida}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.unidadmed}">selected="selected"</c:if>  value="${obj.key}"disabled="disabled">${obj.value}</option>
                                </c:forEach>
                            </form:select> </td>

                            <td>

                                <form:select id="cboCapProduccion" class="form-control" path="capacidad" required="required">
                                    <c:forEach items="${capacidad}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.unidadmed}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select> 

                            </td>
                            </tbody>
                        </table>
                    </div> 

                    <div class="form-group row">
                        <label class="col-sm-12">8.2 PARA PROGRAMAS DE INVERSIÓN:</label>
                        <div class="col-sm-12">                 
                            <div class="table-responsive">
                                <table class="table table-bordered table-md" id="tblInversion">
                                    <thead>                               
                                    <th>INVERSIONES</th>     
                                    <th>COSTO REFERENCIAL (S/.)</th>                                       
                                    </thead>
                                    <tbody>  
                                        <c:forEach var="i" items="${item.listInversion}">
                                            <tr>
                                                <td>                                 
                                                    <div class="input-group">
                                                        ${i.inversion}
                                                        <input  type="hidden" class="form-control number" id="cboInversion" value="${i.idtipoinver}">
                                                    </div>  
                                                </td>
                                                <td><input type="text" class="form-control number text-right" id="txtCostoRefInv" value="${i.v_costoref}" /></td>
                                            </tr>   
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div> 
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-4">8.3 DocumentoTécnico para la declaracion de la viabilidad:</label>
                        <div class="col-sm-8">
                            <form:select id="cboDocumentoTecnico" class="form-control" path="documentoTecnico">
                                <c:forEach items="${documentoTecnico}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.docutec}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>

                            *   Nota: Solo para Proyectos de Inversión.<br>
                        </div>
                    </div>
                    <br>
                    <div class="form-group row">
                        <label class="col-sm-4">8.4 Costo Aproximado del Estudio de Preinversión o Ficha Técnica:</label>
                        <div class="col-sm-4">
                            <input type="text" class="form-control number text-right" id="txtValpreinv" value="${item.proyectoPIP.v_valpreinv}">
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item9" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        9. MODALIDAD DE EJECUCIÓN TENTATIVA</button>
                </h4>
            </div>
            <div id="item9" class="collapse" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboModalidadEjecucion" class="form-control" path="modalidadEjecucion">
                                <c:forEach items="${modalidadEjecucion}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.tipejecpro}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item10" aria-expanded="false">
                <h4 class="mb-0"><button class="btn btn-link">
                        10. TIPO DE FINANCIAMIENTO TENTATIVO</button>
                </h4>
            </div>
            <div id="item10" class="collapse" data-parent="#accordion">
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboTipoFinanciamiento" class="form-control" path="tipoFinanciamiento">>
                                <c:forEach items="${tipoFinanciamiento}" var="obj">
                                    <option <c:if test="${obj.key eq item.proyectoPIP.tipfinanpr}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                                </c:forEach>
                            </form:select>
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
                        <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                    </c:if>
                    <% }%>
                    <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                    <c:if test="${seguimiento.estadoproc eq 42}"><!-- EN REVISION -->
                        <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                        <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                    </c:if>
                    <% }%>
                    <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%>
                    <c:if test="${seguimiento.estadoproc eq 44}"><!-- OBSERVADO -->
                        <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                        <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                        <button name="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                    </c:if>
                    <% }%>
                    <button type="button" class="btn btn-primary" name="btnImprimir"><span class="fas fa-print"></span> Imprimir</button>

                </div>
            </div>    
        </div>

    </div>




</div>
<!-- Modal ADJUNTAR-->
<div class="modal fade" id="mdlAdjuntos" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">DOCUMENTOS ADJUNTOS</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>

            </div>

            <div class="modal-body">


                <div class="form-group row">

                    <div class="col-sm-4">   
                        <input type="file" id="txtfile" multiple="false">
                        <p class="help-block">Formatos jpg, pdf.</p>
                    </div>
                    <div class="col-sm-6">   
                        <input type="text" class="form-control text-uppercase" id="txtNamefile" placeholder="Descripción del Archivo" value="">
                    </div>
                    <div class="col-sm-2">
                        <div class="float-right">
                            <button id="btnAdjuntar" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                        </div>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="tblDocsAdjuntos"  width="100%" cellspacing="0" class="table table-bordered table-md">
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


            </div><!-- FIN MODAL-BODY -->
        </div><!-- FIN MODAL-CONTENT -->
    </div>
</div>

<!-- Modal OBSERVACION-->
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



<!-- Optional JavaScript -->
<jsp:include page="template/footer.jsp" />
<script src="<c:url value='/resources/js/nsScript/nuevoPIP/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/nuevoPIP/controller.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/permisos.js' />"></script>


</body>
</html>
