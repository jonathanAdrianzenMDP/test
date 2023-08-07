<%--
Document   : nuevoPIP
Created on : 18-oct-2018, 11:53:18
Author     : Jonathan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="template/header.jsp" />
<input type="hidden" id="hdnIdProyectoPIP" value="0" />
<input type="hidden" id="txtCodunidpro" value="${userInfo.codigo}" />
<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label class="ml-1">PROYECTO DE INVERSION</label><br>
            <label>PROGRAMACIÓN MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">NUEVO FORMATO N° 05-A</label>
        </div>
    </div>
    <hr>
    <div class="row m-2">
            <div class="col-sm-12">
                <div class="float-right">
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                </div>
            </div>    
    </div>
    <div id="accordion">
        <div class="card">
            <div class="card-header" data-toggle="collapse"data-target="#item1" aria-expanded="false">
                <h4 class="mb-0">
                    <button class="btn btn-link">1. NOMBRE DE IDEA DEL PROYECTO/PROGRAMA DE INVERSIÓN</button>
                </h4>
            </div>
            <div id="item1" class="collapse" data-parent="#accordion" >
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <textarea class="form-control text-uppercase"  disabled="disabled" name="nomproyect"></textarea>
                            Nota: en el caso de ideas de proyecto, se construye en base a la información consignada en
                            el numeral 6
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header" data-toggle="collapse" data-target="#item2" aria-expanded="true">
                <h4 class="mb-0"><button class="btn btn-link">
                    2. RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN</button>
                </h4>
            </div>
            <div id="item2" class="collapse show" data-parent="#accordion" >
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Función:</label>

                        <div class="col-sm-4">
                            <form:select id="cboFuncion" class="form-control text-uppercase" path="funcion"  required="required">
                                <form:option value="-1" label="-- Seleccione --"/>
                                <form:options items="${funcion}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">División Funcional:</label>
                        <div class="col-sm-4">
                            <select class="form-control text-uppercase" id="cboDivFuncion"  required="required">
                                <option value="-1">-- Seleccione --</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Grupo Funcional:</label>
                        <div class="col-sm-4">
                            <select class="form-control text-uppercase" id="cboGrupoFunc" required="required">
                                <option value="-1">-- Seleccione --</option>
                            </select>
                        </div>
                        <label class="col-sm-2">Sector Responsable:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorCuatro" class="form-control text-uppercase" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>

                    </div>
                </div>

            </div>
        </div>
        
        <div class="card">
            <div class="card-header collapsed" id="headingThree" data-toggle="collapse" data-target="#item3" aria-expanded="false" aria-controls="item3">
                <h4 class="mb-0"><button class="btn btn-link">
                    3. ALINEAMIENTO A UNA BRECHA PRIORITARIA</button>
                </h4>
            </div>
            <div id="item3" class="collapse" data-parent="#accordion" aria-labelledby="headingThree">
                <div class="card-body">
                    <!--   nuevo datos-->
                    <div class="form-group row">
                        <label class="col-sm-4">Servicios Públicos con Brecha Identificada y Priorizada:</label>
                        <div class="col-sm-8">
                            <select class="form-control text-uppercase" id="cboServTipologia">
                                <option>-- Seleccione --</option>
                            </select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-4"> Indicador de brecha de acceso a servicios:</label>
                        <div class="col-sm-8">
                            <select class="form-control text-uppercase" id="cboIndiBrechaServicio">
                                <option>-- Seleccione --</option>
                            </select>
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
                                    <td><div><select class="form-control text-uppercase" id="cboUnidadMedida">
                                                <option>-- Seleccione --</option>
                                            </select>
                                        </div></td>
                                    <td>   
                                        <form:select id="txtEspacioGeo" class="form-control text-uppercase" path="espacioGeografico">
                                            <form:option value="-1" label="-- Seleccione --"/>
                                            <form:options items="${espacioGeografico}" />
                                        </form:select>
                                    </td>
                                    <td><input type="number" class="form-control text-uppercase" maxlength="4" id="txtAnio"/></td>
                                    <td><input type="text" class="form-control number" id="txtValorIndi"></td>
                                </tr>
                            </tbody>
                        </table>
                    </div> 
                    <div class="form-group row">
                        <label class="col-sm-4">Contribución al Cierre de Brecha (%):</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control number" id="txtValorContri" />
                                Nota: Se Refiere a la Capacidad de Producción que Aporta el Proyecto(Incremental)
                        </div>

                    </div>
                    <br>
                    <div class="form-group row">
                        <label class="col-sm-4">Tipologia de Proyecto:</label>
                        <div class="col-sm-8">
                            <select class="form-control text-uppercase" id="cboTipologia">
                                <option>-- Seleccione --</option>
                            </select>
                            Nota: Solo para Ideas de Proyecto<br>
                            Nota: Se Puede Incluir más de un Servicio Público con Brecha y más de un indicador<br>
                        </div>
                    </div>
                </div>
            </div>

        </div>
       
        <div class="form-group row d-none">
            <div class="col-sm-12">
                <div class="float-right">
                    <button type="button" class="btn btn-primary nextBtn"><span class="glyphicon glyphicon-chevron-right"></span> Siguiente</button>
                </div>
            </div>    
        </div>
    

    <!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->
    
        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse" data-target="#item4" aria-expanded="false" aria-controls="collapseOne">
                <h4 class="mb-0"><button class="btn btn-link">
                    4. UNIDAD FORMULADORA</button>
                </h4>
            </div>
            <div id="item4" class="collapse" data-parent="#accordion" aria-labelledby="item4">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSector" class="form-control text-uppercase" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Entidad:</label>
                        <div class="col-sm-4">
                            <form:select id="txtEntidad" class="form-control text-uppercase" path="lstEntidadUnidadF">
                                <form:options items="${lstEntidadUnidadF}" />
                            </form:select>
                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la UF:</label>
                        <div class="col-sm-4">
                            <form:select id="txtNomUniFormuladora" class="form-control text-uppercase" path="lstNombreUnidadEjecutora">
                                <form:options items="${lstNombreUnidadF}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Responsable de la UF:</label>
                        <div class="col-sm-4">
                            <form:select id="txtRespUniformuladora" class="form-control text-uppercase" path="lstResponsableUnidadEjecutora">
                                <form:options items="${lstResponsableUnidadF}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed" id="headingTwo" data-toggle="collapse"data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                <h4 class="mb-0"><button class="btn btn-link">
                    5. UNIDAD EJECUTORA DE INVERSIONES</button>
                </h4>
            </div>
            <div id="collapseTwo" class="collapse" data-parent="#accordion" aria-labelledby="headingTwo">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorDos" class="form-control text-uppercase" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Entidad:</label>
                        <div class="col-sm-4">
                            <form:select id="txtEntidadDos" class="form-control text-uppercase" path="lstEntidadUnidadF">
                                <form:options items="${lstEntidadUnidadF}" />
                            </form:select>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboNombreUniEjecutora" class="form-control text-uppercase" path="lstNombreUnidadEjecutora">
                                <form:options items="${lstNombreUnidadEjecutora}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Responsable de la UEI:</label>
                        <div class="col-sm-4">
                            <form:select id="cboRespUniEjecutora" class="form-control text-uppercase" path="lstResponsableUnidadEjecutora">
                                <form:options items="${lstResponsableUnidadEjecutora}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header collapsed" id="headingThree" data-toggle="collapse"data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                <h4 class="mb-0"><button class="btn btn-link">
                    6. UNIDAD EJECUTORA PRESUPUESTAL</button>
                </h4>
            </div>
            <div id="collapseThree" class="collapse" data-parent="#accordion" aria-labelledby="headingThree">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Sector:</label>
                        <div class="col-sm-4">
                            <form:select id="txtSectorTres" class="form-control text-uppercase" path="lstSector">
                                <form:options items="${lstSector}" />
                            </form:select>
                        </div>
                        <label class="col-sm-2">Entidad:</label>
                        <div class="col-sm-4">
                            <form:select id="cboEntidad" class="form-control text-uppercase" path="lstEntidadUnidadE">
                                <form:options items="${lstEntidadUnidadE}" />
                            </form:select>

                        </div>
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la UE:</label>
                        <div class="col-sm-4">
                            <form:select id="txtUniEjecutora" class="form-control text-uppercase" path="lstEntidadUnidadF">
                                <form:options items="${lstEntidadUnidadF}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse"data-target="#item7" aria-expanded="false" aria-controls="item2">
                <h4 class="mb-0"><button class="btn btn-link">
                    7. DATOS DE LA INVERSIÓN</button>
                </h4>
            </div>
            <div id="item7" class="collapse" data-parent="#accordion" aria-labelledby="headingTwo">
                <div class="card-body">

                    <div class="form-group row">
                        <label class="col-sm-2">Objeto de intervención:</label>                                           
                        <div class="col-sm-10">
                            <td><input type="text" class="form-control text-uppercase" id="txtObjInterv" /></td>
                        </div>                    
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Naturaleza de intervención:</label>                                           
                        <div class="col-sm-10">
                            <form:select id="cboNaturaleza" class="form-control text-uppercase" path="naturalezaIntervencion">
                                <form:options items="${naturalezaIntervencion}" />
                            </form:select>
                        </div>                    
                    </div>

                    <div class="form-group row">
                        <label class="col-sm-2">Nombre de la Unidad Productora:</label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-uppercase" id="txtNomUniProd" disabled="disabled" value="${userInforData}" />
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
                            <td class="col-xs-2"><form:select id="cboDepartamento" class="form-control text-uppercase" path="ubigeo">
                                    <form:option value="-1" label="-- Seleccione --"/>
                                    <form:options items="${ubigeo}" />
                                </form:select></td>
                            <td class="col-xs-2"><select class="form-control text-uppercase" id="cboProvincia">
                                    <option value="-1">-- Seleccione --</option>
                                </select></td>
                            <td class="col-xs-2"><select class="form-control text-uppercase" id="cboDistrito">
                                    <option value="-1">-- Seleccione --</option>
                                </select></td>
                            </tbody>
                        </table>
                    </div> 

                </div>
            </div>
        </div>
        
    
    <!--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------->

    
        
        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse"data-target="#item5" aria-expanded="false" aria-controls="item5">
                <h4 class="mb-0"><button class="btn btn-link">
                    8. DESCRIPCIÓN AGREGADA DEL PROYECTO/PROGRAMA</button>
                </h4>
            </div>
            <div id="item5" class="collapse" data-parent="#accordion" aria-labelledby="item5">
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
                                        <tr>
                                            <th>TIPO DE ITEM</th>
                                            <th>COSTO REFERENCIAL(S/.)</th>
                                            <th>ACCIÓN</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr data-clone="1" class="d-none">
                                            <td><input  type="text" class="form-control text-uppercase" name="txttipoitem"></td>
                                            <td><input type="text" class="form-control number text-right" name="txtmontoitem" value="0"></td>
                                            <td class="text-center">
                                                <div name="btnEliminarTipoItem"><span class="fas fa-trash-alt"></span></div>
                                            </td>
                                        </tr>
                                        <c:forEach var="i" items="${lstTipoItem}" varStatus="myIndex">
                                            <tr data-clone="0"> 
                                                <td><div>
                                                        <input type="text" class="form-control text-uppercase" name="txttipoitem" value="${i.value}">
                                                    </div>
                                                </td>

                                                <td>
                                                    <input type="text" class="form-control number text-right" name="txtmontoitem" value="0">
                                                </td>
                      
                                                <td class="text-center">
                                                    <div name="btnEliminarTipoItem"><span class="fas fa-trash-alt"></span></div>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                                <td style="text-align: right;font-weight: bold;padding: 9px;"><label>TOTAL (S/.)</label></td>
                                                <td>
                                                    <div class="input-group">
                                                        <input type="text" id="txtTotalItem" disabled="disabled" class="form-control number text-right" />
                                                    </div></td>
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
                        <table class="table table-bordered table-md" id="tblServicioPIP">
                            <thead>
                                <tr>
                                    <th>SERVICIO</th>     
                                    <th>U/M</th>   
                                    <th>CAPACIDAD DE PRODUCCION</th> 
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td><div><select disabled="disabled" class="form-control text-uppercase" id="cboServTipologia1">
                                                <option>-- Seleccione --</option>
                                            </select>
                                        </div></td>
                                    <td><div><select disabled="disabled" class="form-control text-uppercase" id="cboUnidadMedida1">
                                                <option>-- Seleccione --</option>
                                            </select></div></td>
                                    <td><div><select class="form-control text-uppercase" id="cboCapProduccion">
                                                <option>-- Seleccione --</option>
                                            </select></div></td>
                                </tr>
                            </tbody>
                        </table>
                    </div> 

                    <div class="form-group row">
                        <label class="col-sm-12">8.2 PARA PROGRAMAS DE INVERSIÓN:</label>
                        <div class="col-sm-12">
                            <div class="table-responsive">
                                <table class="table table-bordered table-md" id="tblInversion">
                                    <thead>
                                        <tr>
                                            <th>INVERSIONES</th>     
                                            <th>COSTO REFERENCIAL(S/.)</th>   
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="i" items="${lstInversion}" varStatus="myIndex">
                                            <tr>
                                                <td><div class="input-group">${i.value}
                                                        <input type="hidden" class="form-control number" id="cboInversion" value="${i.key}">
                                                    </div>
                                                </td>
                                                <td><input type="text" class="form-control number text-right" id="txtCostoRef" value="0">
                                                 
                                                </td>
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
                            <form:select id="cboDocumentoTecnico" class="form-control text-uppercase" path="documentoTecnico">
                                <form:option value="-1" label="-- Seleccione --"/>
                                <form:options items="${documentoTecnico}" />
                            </form:select>

                            *   Nota: Solo para Proyectos de Inversión.<br>
                        </div>
                    </div>
                    <br>
                    <div class="form-group row">
                        <label class="col-sm-4">8.4 Costo Aproximado del Estudio de Preinversión o Ficha Técnica:</label>
                        <div class="input-group col-sm-4">
                            <input type="text" class="form-control number" id="txtValpreinv">
                        </div>
                    </div>
                   
                </div>
            </div>
        </div>
        
         <div class="card">
            <div class="card-header collapsed" data-toggle="collapse"data-target="#item8" aria-expanded="false" aria-controls="item8">
                <h4 class="mb-0"><button class="btn btn-link">
                    9. MODALIDAD DE EJECUCIÓN TENTATIVA</button>
                </h4>
            </div>
            <div id="item8" class="collapse" data-parent="#accordion" aria-labelledby="item8">
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboModalidadEjecucion" class="form-control text-uppercase" path="modalidadEjecucion">
                                <form:option value="-1" label="-- Seleccione --"/>
                                <form:options items="${modalidadEjecucion}" />
                            </form:select>
                        </div>

                    </div>

                </div>
            </div>
        </div>

        <div class="card">
            <div class="card-header collapsed" data-toggle="collapse"data-target="#item9" aria-expanded="false" aria-controls="item9">
                <h4 class="mb-0"><button class="btn btn-link">
                    10. TIPO DE FINANCIAMIENTO TENTATIVO</button>
                </h4>
            </div>
            <div id="item9" class="collapse" data-parent="#accordion" >
                <div class="card-body">

                    <div class="form-group row">
                        <div class="col-sm-12">
                            <form:select id="cboTipoFinanciamiento" class="form-control text-uppercase" path="tipoFinanciamiento">
                                <form:option value="-1" label="-- Seleccione --"/>
                                <form:options items="${tipoFinanciamiento}" />
                            </form:select>
                        </div>
                    </div>

                </div>
            </div>
        </div>
       <div class="row m-2">
            <div class="col-sm-12">
                <div class="float-right">
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                </div>
            </div>    
    </div>
    </div>

</div>

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/nuevoPIP/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/nuevoPIP/controller.js' />"></script>

</body>
</html>