<%-- 
    Document   : p01Formato2IOARR
    Created on : 04/01/2019, 10:27:37 AM
    Author     : cristina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<!-- Static navbar -->

<jsp:include page="template/header.jsp" />
<input type="hidden" id="hdnIdProyectoIOARR" value="${item.proyectoIOARR.idProIOARR}" />
<input type="hidden" id="hdnIdEstadoActual" value="${item.proyectoIOARR.idEstadoActual}" />

<div class="container-fluid">
     <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label>PROGRAMACIÓN MULTIANUAL DE INVERSIONES</label>
            <span class="fas fa-chevron-right"></span><label class="ml-1">REGISTRO DE IDEA DE INVERSIONES:</label>
            <label>FORMATO N° 02: REGISTRO DE INVERSIONES EN OPTIMIZACIÓN, AMPLIACIÓN MARGINAL, REPOSICIÓN Y REHABILITACIÓN (IOARR)</label>
        </div>
        
        <div class="col-sm-12 text-center h5">
            <c:if test="${item.proyectoIOARR.idEstadoActual eq 41}"><!-- EN ELABORACION -->
                <label class="badge badge-info">${item.proyectoIOARR.desc_estadoactu}</label>
            </c:if>
            <c:if test="${item.proyectoIOARR.idEstadoActual eq 42}"><!-- EN REVISION -->
                <label class="badge badge-warning">${item.proyectoIOARR.desc_estadoactu}</label>
            </c:if>
            <c:if test="${item.proyectoIOARR.idEstadoActual eq 43}"><!-- APROBADO -->
                <label class="badge badge-success">${item.proyectoIOARR.desc_estadoactu}</label>
            </c:if>
            <c:if test="${item.proyectoIOARR.idEstadoActual eq 44}"><!-- OBSERVADO -->
                <label class="badge badge-danger">${item.proyectoIOARR.desc_estadoactu}</label>
            </c:if>
        </div>
        
    </div>
    <div class="stepwizard">
        <div class="stepwizard-row setup-panel">
          <div class="stepwizard-step">
            <a href="#step-1" type="button" class="btn btn-primary btn-circle">1</a>

          </div>
          <div class="stepwizard-step">
            <a href="#step-2" type="button" class="btn btn-default btn-circle">2</a>

          </div>
          <div class="stepwizard-step">
            <a href="#step-3" type="button" class="btn btn-default btn-circle">3</a>

          </div>
          <div class="stepwizard-step">
            <a href="#step-4" type="button" class="btn btn-default btn-circle">4</a>

          </div>
        </div>
    </div>
  <br>
    <div class="form-group row">
        <div class="col-sm-12">
            <div class="float-left">
                <a href="./seguimientoPIP?id=${item.proyectoIOARR.idProIOARR}"><button type="button" class="btn btn-primary"><span class="fas fa-book"></span> Ver Seguimiento</button></a>
            </div>
            <div class="float-right">
                <c:if test="${item.proyectoIOARR.idEstadoActual eq 41}"><!-- EN ELABORACION -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button id="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <c:if test="${item.proyectoIOARR.idEstadoActual eq 42}"><!-- EN REVISION -->
                    <button type="button" class="btn btn-success" name="btnAprobar"><span class="fas fa-check"></span> Aprobar</button>
                    <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#mdlObservar"><span class="fas fa-bug"></span> Observar</button>
                    <button id="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                <c:if test="${item.proyectoIOARR.idEstadoActual eq 44}"><!-- OBSERVADO -->
                    <button type="button" class="btn btn-primary" name="btnGuardar"><span class="fas fa-save"></span> Guardar</button>
                    <button type="button" class="btn btn-primary" name="btnEnviar"><span class="fas fa-paper-plane"></span> Enviar</button>
                    <button id="btnAdjuntarModal" type="button" class="btn btn-primary"><span class="fas fa-paperclip"></span> Adjuntar</button>
                </c:if>
                    <button type="button" class="btn btn-primary" name="btnImprimir"><span class="fas fa-print"></span> Imprimir</button>
            </div>
        </div>    
    </div>

    <hr>
    <form>
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

        <div class="row">
            <div class="col-sm-12">
                <input type="button" id="btnMayorUIT" value="Inversión > 75 UIT" class="btn btn-default" />
                <input type="button" id="btnMenorUIT" value="Inversión <= 75 UIT" class="btn btn-default" />
            </div>
        </div>
        <br>


        <!-- CONTENEDOR PANEL SECCION B -->
        <div class="panel panel-default hide">

            <div class="card-header" id="headingOne"data-toggle="collapse"  href="#seccionB" aria-expanded="true">
                <h4 class="panel-title uppercase">
                    B. Datos de Inversión para el registro de activos asociados a IOARR con montos de inversion mayores a 75 UIT
                </h4>
            </div>
            <div id="seccionB" class="collapse show" >
                <div class="card-body">
                    <div class="panel-group" id="accordionB" role="tablist" aria-multiselectable="true">

                        <!-- PUNTOS B1 HASTAL B5 -->

                        <!--  B.1. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse" href="#seccionB1">
                                <h4 class="mb-0">
                                    DESCRIPCIÓN DEL TIPO DE INVERSIÓN
                                </h4>
                            </div>

                            <div id="seccionB1" class="collapse show" >
                                <div class="card-body">
                                    <div>
                                        <div class="form-group row">
                                            <div class="col-sm-2 form-group">
                                                <select class="form-control" name="tipoInversion">
                                                    <option>-- Seleccione Tipo IOARR --</option>
                                                    <option value="1">OPTIMIZACIÓN</option>
                                                    <option value="2">REHABILITACIÓN</option>
                                                    <option value="3">REPOSICIÓN</option>
                                                    <option value="4">AMPLIACIÓN MARGINAL</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-3 form-group">
                                                <select class="form-control" name="ddlItem">
                                                    <option>-- Seleccione Naturaleza --</option>
                                                    <option value="1">Caso 1 Adquisicion</option>
                                                    <option value="2">Caso 1 Saneamiento tecnico legal</option>
                                                    <option value="3">Caso 2 Adquisicion</option>
                                                    <option value="3">Caso 2 Construccion</option>
                                                    <option value="3">Caso 2 Remodelacion</option>
                                                    <option value="3">Caso 2 Capacitacion</option>
                                                    <option value="3">Caso 2 Reforestacion</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-2 form-group">
                                                <select class="form-control" name="ddlItem">
                                                    <option>-- Seleccione Item --</option>
                                                    <option value="1">Terrenos</option>
                                                    <option value="2">Equipamiento</option>
                                                    <option value="3">Mobiliario</option>
                                                    <option value="4">Intangibles</option>
                                                </select>
                                            </div>
                                            <div class="col-sm-4 form-group">
                                                <input type="text" class="form-control" placeholder="Ingrese Activo" />
                                            </div>
                                            <div class="col-sm-1 form-group">
                                                <div class="float-right">
                                                    <button class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                                </div>
                                            </div>
                                        </div>


                                    </div>


                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="tblTipoInverionB1">
                                            <thead>
                                                <tr>
                                                    <th title="Esta en función a la cantidad de registros (Tipos de Inversión) realizados en el Formato 8.">TIPO DE IOARR</th>     
                                                    <th>NATURALEZA</th>   
                                                    <th>ITEM</th>     
                                                    <th>ACTIVO</th>
                                                    <th>ACCIÓN</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <tr data-clone="1">
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td></td>
                                                    <td class="text-center">

                                                        <div class="btn btn-primary"><span data-toggle="tooltip" data-placement="top" class="glyphicon glyphicon-th" title="Registrar datos adicionales del Tipo de Inversion/Naturaleza/Item/Activo" id="openModalB2B4"></span></div>

                                                        <div class="btn btn-primary"><span data-toggle="tooltip" data-placement="top" title="Eliminar" class="fas fa-trash-alt"></span></div>

                                                    </td>
                                                </tr>
                                            </tbody>
                                        </table>
                                    </div>

                                    <div class=" row">
                                        <label class="col-sm-2 col-xs-5">Nombre de Inversión:</label>
                                        <div class="col-sm-10 col-xs-7">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                </div><!-- FIN PANEL-BODY B1 -->
                            </div>
                        </div><!-- FIN PANEL  B1 -->

                        <!--  B.5. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse" href="#seccionB5">
                                <h4 class="mb-0">
                                    ENTIDAD QUE SERA RESPONSABLE DEL MANTENIMIENTO
                                </h4>
                            </div>

                            <div id="seccionB5" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Sector:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control">
                                                <option>-- Seleccione --</option>
                                            </select>
                                        </div>
                                        <label class="col-sm-2">Entidad:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control">
                                                <option>-- Seleccione --</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-2">Nombre de la UE:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control">
                                                <option>-- Seleccione --</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>

                                </div><!-- FIN PANEL-BODY B5 -->
                            </div>
                        </div><!-- FIN PANEL  B5 -->


                    </div><!-- FIN PANEL GROUP B -->
                </div><!-- FIN PANEL BODY B -->
            </div> <!-- FIN PANEL SECCION B -->
        </div> <!-- FIN CONTENEDOR PANEL SECCION B -->

        <!-- CONTENEDOR PANEL SECCION C -->
        <div class="panel panel-default hide">

            <div class="card-header"data-toggle="collapse" href="#seccionC" aria-expanded="true">
                <h4 class="mb-0">
                    C. DESCRIPCION ESPECIFICA PARA EL REGISTRO DE ACTIVOS ASOCIADOS A IOARR CON MONTOS DE INVERSION MAYORES A 75 UIT
                </h4>
            </div>
            <div id="seccionC" class="collapse show" >
                <div class="card-body">
                    <div class="panel-group" id="accordionC" role="tablist">

                        <!-- PUNTOS C1 HASTAL C4 -->


                        <!--  C.1. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionC1">
                                <h4 class="mb-0">
                                    C.1. OPTIMIZACIÓN
                                </h4>
                            </div>

                            <div id="seccionC1" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-6">C.1.1 CASO 1: OPTIMIZACION (ADQ. TERRENO)</label>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-8">Indique el documento o informe de planificación de la ampliacion de la oferta de servicios publicos priorizados en el PMI (*)</label>
                                        <div class="col-sm-4">
                                            <input type="file" id="fileC1">
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-8">Área del terreno requerida en m2 (*)</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="txtAreaTerrenoC1" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-12">Ubicación estimada:</label>
                                        <div class="col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th>DEPARTAMENTO</th>     
                                                            <th>PROVINCIA</th>   
                                                            <th>DISTRITO</th>     
                                                            <th>CENTRO POBLADO</th>
                                                            <th>LATITUD/LONGITUD</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                    <td class="col-xs-2"><label></label></td>
                                                    <td class="col-xs-2"><label></label></td>
                                                    <td class="col-xs-2"><label></label></td>
                                                    <td class="col-xs-2"><label></label></td>
                                                    <td class="col-xs-2"><label></label></td>
                                                    </tbody>
                                                </table>
                                            </div> 
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-12">Uso futuro del terreno y justificación del dimensionamiento del área del terreno (*)</label>
                                        <div class="col-sm-12">
                                            <textarea class="form-control" id="txtJustificacionTerreroC1"></textarea>
                                        </div>
                                    </div>

                                    <hr>

                                    <div class="form-group row">
                                        <label class="col-sm-12">C.1.2 CASO 2: INVERSIONES DE OPTIMIZACIÓN</label>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-12">Descripción del estado situacional de la oferta existente que motiva la inversión en optimización (*)</label>
                                        <div class="col-sm-12">
                                            <textarea class="form-control" id="txtDescripcion1Caso2C2"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-12">Descripción de su mejoramiento como resultado de la optimización (*)</label>
                                        <div class="col-sm-12">
                                            <textarea class="form-control" id="txtDescripcion2Caso2C2"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Unidad de medida de la capacidad de producción del servicio:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">Valor actual del activo asociado a la optimización (soles):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Capacidad de producción actual del servicio:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">Estimación del incremento de la capacidad de producción con optimización del servicio (%):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Capacidad de produccion del servicio con optimización:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionC2">
                                <h4 class="mb-0">
                                    C.2. REHABILITACION
                                </h4>
                            </div>

                            <div id="seccionC2" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-12">Causas de deterioro o daño del activo a rehabilitar:</label>
                                        <div class="col-sm-12">
                                            <textarea class="form-control" id="txtCausasDeterioroC2"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Antigüedad del activo a rehabilitar (años):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">Estado actual del activo a rehabilitar:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control">
                                                <option value="0">--Seleccione--</option>
                                                <option>Regular</option>
                                                <option>Malo</option>
                                                <option>Muy Malo</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Costo anual de mantenimiento del activo a rehabilitar:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">Expectativa de vida útil (años) del activo rehabilitado:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Costo anual de mantenimiento del activo rehabilitado:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionC3">
                                <h4 class="mb-0">
                                    C.3. REPOSICION
                                </h4>
                            </div>

                            <div id="seccionC3" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-12">Causas de deterioro o daño del activo a reponer:</label>
                                        <div class="col-sm-12">
                                            <textarea class="form-control" id="txtCausasDeterioroC2"></textarea>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Antigüedad del activo a reponer (años):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">Estado actual del activo a reponer:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control">
                                                <option value="0">--Seleccione--</option>
                                                <option>Regular</option>
                                                <option>Malo</option>
                                                <option>Muy Malo</option>
                                                <option>Irrecuperable</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Costo anual de mantenimiento del activo a reponer:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4 col-xs-8">Expectativa de vida útil (años) del activo nuevo:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">Costo anual de mantenimiento del activo nuevo:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>

                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionC4">
                                <h4 class="mb-0">
                                    C.4. AMPLIACION MARGINAL
                                </h4>
                            </div>

                            <div id="seccionC4" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-4">C.4.1 ¿Modifica capacidad de producción de servicios?</label>
                                        <div class="col-sm-2">
                                            <select class="form-control">
                                                <option value="0">--Seleccione--</option>
                                                <option value="1">SI</option>
                                                <option value="0">NO</option>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">C.4.2 Código del Proyecto Estándar (en caso se haya ejecutado en la UPS):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">C.4.3 Unidad de medida de la capacidad de producción del servicio:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <label class="col-sm-4">C.4.4 Capacidad de producción actual del servicio:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                        <label class="col-sm-4">C.4.5 Estimación del incremento de la capacidad de producción con ampliación marginal del servicio (%):</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" />
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>


                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div> 
        </div> 
        <div class="panel panel-default hide">

            <div class="card-header"data-toggle="collapse" href="#seccionD" aria-expanded="true">
                <h4 class="mb-0">
                    D. COSTOS Y CRONOGRAMAS PARA EL REGISTRO DE ACTIVOS ASOCIADOS A IOARR CON MONTOS DE INVERSION MAYORES A 75 UIT
                </h4>
            </div>
            <div id="seccionD" class="collapse show" >
                <div class="card-body">
                    <div class="panel-group" id="accordionD" role="tablist">

                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionD1">
                                <h4 class="mb-0">
                                    D.1. CRONOGRAMA DE INVERSION
                                </h4>
                            </div>

                            <div id="seccionD1" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Fecha prevista de inicio de ejecución:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="txtD1FechaPrevista" placeholder="Mes/Año" />
                                        </div>

                                        <label class="col-sm-1">Tipo de Periodo:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control">
                                                <option>Año</option>
                                                <option>Mes</option>
                                            </select>
                                        </div>
                                        <label class="col-sm-1">Número de Periodos:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="txtD1NumeroPeriodos">
                                        </div>
                                        <div class="col-sm-2">
                                            <button class="btn btn-primary float-right" id="btnD1Generar"><span class="glyphicon glyphicon-th"></span> Generar</button> 
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th rowspan="2">NATURALEZA / ACTIVO</th>     
                                                            <th colspan="12">PERIODOS</th>   
                                                            <th rowspan="2">COSTO TOTAL(*)(SOLES)</th>     
                                                        </tr>
                                                        <tr>
                                                            <th>1</th>
                                                            <th>2</th>
                                                            <th>3</th>
                                                            <th>4</th>
                                                            <th>5</th>
                                                            <th>6</th>
                                                            <th>7</th>
                                                            <th>8</th>
                                                            <th>9</th>
                                                            <th>10</th>
                                                            <th>11</th>
                                                            <th>12</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>[Naturaleza/activo]</td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td title="Expediente Técnico">Exp. Técnico</td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Supervisión</td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="13">Total</td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div> 
                                        </div>
                                        <div class="col-sm-12">
                                            <button class="btn btn-primary float-right" id="btnD1Guardar"><span class="fas fa-save"></span> Guardar</button> 
                                        </div>
                                    </div><!-- FIN form-group row -->



                                </div><!-- FIN PANEL-BODY D1 -->
                            </div>
                        </div><!-- FIN PANEL  D1 -->

                        <!--  D.2. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionD2">
                                <h4 class="mb-0">
                                    D.2. CRONOGRAMA DE METAS FÍSICAS ESPERADAS DE LA INVERSIÓN
                                </h4>
                            </div>

                            <div id="seccionD2" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th rowspan="2">NATURALEZA / ACTIVO</th>     
                                                            <th  rowspan="2">UNIDAD DE MEDIDA</th>
                                                            <th colspan="12">PERIODOS</th>   
                                                            <th rowspan="2">TOTAL</th>     
                                                        </tr>
                                                        <tr>
                                                            <th>1</th>
                                                            <th>2</th>
                                                            <th>3</th>
                                                            <th>4</th>
                                                            <th>5</th>
                                                            <th>6</th>
                                                            <th>7</th>
                                                            <th>8</th>
                                                            <th>9</th>
                                                            <th>10</th>
                                                            <th>11</th>
                                                            <th>12</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>[Naturaleza/activo]</td>
                                                            <td><select><option>Seleccione</option></select></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td title="Expediente Técnico">Exp. Técnico</td>
                                                            <td><select><option>Documento</option></select></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td>Supervisión</td>
                                                            <td><select><option>Informe</option></select></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div> 
                                        </div>
                                    </div>

                                </div><!-- FIN PANEL-BODY D2 -->
                            </div>
                        </div><!-- FIN PANEL  D2 -->

                        <!--  D.3. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionD3">
                                <h4 class="mb-0">
                                    D.3. COSTO DE MANTENIMIENTO
                                </h4>
                            </div>

                            <div id="seccionD3" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Fecha prevista de inicio de operación y mantenimiento:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="txtD3FechaPrevista" placeholder="Mes/Año" />
                                        </div>
                                        <label class="col-sm-1">Tipo de Periodo:</label>
                                        <div class="col-sm-2">
                                            <select class="form-control">
                                                <option>Año</option>
                                                <option>Mes</option>
                                            </select>
                                        </div>
                                        <label class="col-sm-1">Número de Periodos:</label>
                                        <div class="col-sm-2">
                                            <input type="text" class="form-control" id="txtD3NumeroPeriodos">
                                        </div><div class="col-sm-2">
                                            <button class="btn btn-primary float-right" id="btnD1Generar"><span class="glyphicon glyphicon-th"></span> Generar</button> 
                                        </div>
                                    </div>

                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered">
                                                    <thead>
                                                        <tr>
                                                            <th rowspan="2">ACTIVO</th>     
                                                            <th colspan="12">PERIODOS</th>   
                                                            <th rowspan="2">COSTO TOTAL (SOLES)</th>     
                                                        </tr>
                                                        <tr>
                                                            <th>1</th>
                                                            <th>2</th>
                                                            <th>3</th>
                                                            <th>4</th>
                                                            <th>5</th>
                                                            <th>6</th>
                                                            <th>7</th>
                                                            <th>8</th>
                                                            <th>9</th>
                                                            <th>10</th>
                                                            <th>11</th>
                                                            <th>12</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td>[Naturaleza/activo]</td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td></td>
                                                        </tr>
                                                        <tr>
                                                            <td colspan="13">Total</td>
                                                            <td></td>
                                                        </tr>
                                                    </tbody>
                                                </table>
                                            </div> 
                                        </div>
                                        <div class="col-sm-12">
                                            <button class="btn btn-primary float-right" id="btnD3Guardar"><span class="fas fa-save"></span> Guardar</button> 
                                        </div>
                                    </div>

                                </div><!-- FIN PANEL-BODY D3 -->
                            </div>
                        </div><!-- FIN PANEL  D3 -->


                        <!--  D.4. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionD4">
                                <h4 class="mb-0">
                                    D.4. MODALIDAD DE EJECUCIÓN PREVISTA
                                </h4>
                            </div>

                            <div id="seccionD4" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Modalidad de ejecución:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control">
                                                <option>--Seleccione--</option>
                                                <option>Administración Directa</option>
                                                <option>Administración Indirecta - Por contrata</option>
                                                <option>Administración Indirecta - Núcleo Ejecutor</option>
                                                <option>Obras por impuesto</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <button class="btn btn-primary float-right" id="btnD1Generar"><span class="fas fa-save"></span> Guardar</button> 
                                        </div>
                                    </div>
                                </div><!-- FIN PANEL-BODY D4 -->
                            </div>
                        </div><!-- FIN PANEL  D4 -->

                        <!--  D.5. -->
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionD5">
                                <h4 class="mb-0">
                                    D.5. FUENTE DE FINANCIAMIENTO
                                </h4>
                            </div>

                            <div id="seccionD5" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Fuente de Financiamiento:</label>
                                        <div class="col-sm-4">
                                            <select class="form-control">
                                                <option>--Seleccione--</option>
                                                <option>Recursos Ordinarios</option>
                                                <option>Recursos Directamente Recaudados</option>
                                                <option>Recursos por Operaciones Oficiales de Crédito</option>
                                                <option>Donaciones y transferencias</option>
                                                <option>Recursos Determinados</option>
                                            </select>
                                        </div>
                                        <div class="col-sm-6">
                                            <button class="btn btn-primary float-right" id="btnD5Guardar"><span class="fas fa-save"></span> Guardar</button> 
                                        </div>
                                    </div>
                                </div><!-- FIN PANEL-BODY D5 -->
                            </div>
                        </div><!-- FIN PANEL  D5 -->

                    </div><!-- FIN PANEL GROUP D -->
                </div><!-- FIN PANEL BODY D -->
            </div> <!-- FIN PANEL SECCION D -->
        </div> <!-- FIN CONTENEDOR PANEL SECCION D -->



        <!-- CONTENEDOR PANEL SECCION E -->
        <div class="panel panel-default hide">

            <div class="card-header"data-toggle="collapse" href="#seccionE" aria-expanded="true">
                <h4 class="mb-0">
                    E. REGISTRO SIMPLIFICADO DE ACTIVOS ASOCIADOS A IOARR CON MONTOS DE INVERSION MENORES O IGUALES A 75 UIT
                </h4>
            </div>
            <div id="seccionE" class="collapse show" >
                <div class="card-body">
                    <div class="panel-group" id="accordionE" role="tablist">

                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionE1">
                                <h4 class="mb-0">
                                    E.1 NOMBRE DE LA INVERSIÓN
                                </h4>
                            </div>

                            <div id="seccionE1" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <label class="col-sm-2">Nombre de la Inversión:</label>
                                        <div class="col-sm-10">
                                            <textarea class="form-control" id="txtE1Nombre"></textarea>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="float-right">
                                            <div class="col-sm-12">
                                                <button type="button" id="btnE1Nombre" class="btn btn-primary"><span class="fas fa-save"></span> Guardar</button>
                                            </div> 
                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>
                        <div class="card">

                            <div class="card-header"data-toggle="collapse"  href="#seccionE2">
                                <h4 class="mb-0">
                                    E.2 REGISTRO SIMPLIFICADO
                                </h4>
                            </div>

                            <div id="seccionE2" class="collapse show" >
                                <div class="card-body">

                                    <div class="form-group row">
                                        <div class="col-sm-12">
                                            <div class="table-responsive">
                                                <table class="table table-bordered" id="tblE2Activos">
                                                    <thead>
                                                        <tr>
                                                            <th rowspan="2">ACTIVO</th>     
                                                            <th rowspan="2">TIPO DE IOARR</th>
                                                            <th rowspan="2">NATURALEZA</th>
                                                            <th rowspan="2">ITEM</th>
                                                            <th rowspan="2">UNIDAD DE MEDIDA</th>
                                                            <th rowspan="2">META</th>
                                                            <th rowspan="2">COSTO INVERSIÓN (Soles)</th>
                                                            <th colspan="2">CRONOGRAMA DE EJECUCIÓN</th>
                                                            <th rowspan="2">ACCIÓN</th>
                                                        </tr>
                                                        <tr>
                                                            <th>FECHA INICIO (Mes/Año)</th>
                                                            <th>FECHA FIN (Mes/Año)</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <tr>
                                                            <td><input type="text" name="txtActivo" class="form-control" /></td>
                                                            <td><select class="form-control"><option>Seleccione</option></select></td>
                                                            <td><select class="form-control"><option>Seleccione</option></select></td>
                                                            <td><select class="form-control"><option>Seleccione</option></select></td>
                                                            <td><input class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td><input type="text" name="txtcostoInversion" class="form-control" /></td>
                                                            <td class="text-center"><span title="Guardar Activo" data-toggle="tooltip" data-placement="top" class="fas fa-save" data-original-title="" id="saverow"></span></td>
                                                        </tr>

                                                    </tbody>
                                                </table>
                                            </div> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div> 
        </div> 


    </div>



</form>

<div class="modal fade" tabindex="-1" role="dialog" id="mdlDatosB2B4">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h5 class="modal-title" id="mdlTitle">Tipo de Inversion/Naturaleza/Activo: <span id="TitlemdlDatosB2B4"></span> </h5>
            </div>
            <div class="modal-body">

                <div class="card">

                    <div class="card-header"data-toggle="collapse"  href="#seccionB2">
                        <h4 class="panel-title uppercase">
                            Descripción del estado situacional del activo sujeto a intervención (Tipo de Inversion/Naturaleza/Activo)(*)
                        </h4>
                    </div>

                    <div id="seccionB2" class="collapse show" >
                        <div class="card-body">

                            <div class=" row">
                                <div class="col-sm-12">
                                    <textarea class="form-control" id="txtDescripcionEnB2"></textarea>
                                    <label>(*)Describir el problema que se busca resolver</label>
                                </div>
                            </div>

                            <div class=" row">
                                <label class="col-sm-12">¿En caso de Infraestructura, el activo sujeto a rehabilitación, optimización y ampliación marginal tiene inscripción registral?</label>

                                <div class="col-sm-12">

                                    <div class="form-inline">  
                                        <div class="form-group">
                                            <select class="form-control">
                                                <option value="1">SI</option>
                                                <option value="0">NO</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Número de Partida Registral:</label>
                                            <input type="text" id="" class="form-control" placeholder="Número de Partida Registral">
                                        </div>
                                        <div class="form-group">
                                            <label>Nombre de Oficina Registral:</label>
                                            <input type="text" class="form-control" placeholder="Nombre de Oficina Registral">
                                        </div>
                                    </div>
                                </div>
                            </div>  

                            <div class=" row">
                                <label class="col-sm-12">¿El activo se encuentra registrado en el inventario de la entidad pública?</label>

                                <div class="col-sm-12">  
                                    <div class="form-inline">  
                                        <div class="form-group">
                                            <select class="form-control">
                                                <option value="1">SI</option>
                                                <option value="0">NO</option>
                                            </select>
                                        </div>
                                        <div class="form-group">
                                            <label>Código del Inventario:</label>
                                            <input type="text" id="" class="form-control" placeholder="Código del Inventario">
                                        </div>
                                    </div>
                                </div>

                            </div>  

                        </div>
                    </div>
                </div>

                 <div class="card">

                    <div class="card-header"data-toggle="collapse"  href="#seccionB3">
                        <h4 class="mb-0">
                            DESCRIBIR Y EXPLICAR EN QUE CONSISTE LA INTERVENCION
                        </h4>
                    </div>

                    <div id="seccionB3" class="collapse show" >
                        <div class="card-body">

                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>TIPO DE IOARR/NATURALEZA/ACTIVO</th>     
                                            <th>DESCRIPCIÓN</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="col-sm-4"></td>
                                            <td><textarea class="form-control"></textarea> </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <label class="col-sm-12 hide">En caso que en la UPS se requiera intervenir en más de un tipo de inversión se deberá de agregar las veces que sean necesarias el contenido señalado en B.2.</label>
                            </div>

                        </div>
                    </div>
                </div>


                
                <div class="card">

                    <div class="card-header"data-toggle="collapse"  href="#seccionB4">
                        <h4 class="mb-0">
                            JUSTIFICACIÓN TECNICA DE LA INTERVENCIÓN
                        </h4>
                    </div>

                    <div id="seccionB4" class="collapse show" >
                        <div class="card-body">

                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>TIPO DE IOARR/NATURALEZA/ACTIVO</th>     
                                            <th>DESCRIPCIÓN</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="col-sm-4"></td>
                                            <td><textarea class="form-control"></textarea> </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <label class="col-sm-12 hide">En caso que en la UPS se requiera intervenir en más de un tipo de inversión se deberá de agregar las veces que sean necesarias el contenido señalado en B.3.</label>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="button" class="btn btn-primary">Guardar</button>
            </div>
        </div>
    </div>
</div>


<!-- Modal ADJUNTAR-->
<div class="modal fade" id="mdlAdjuntar" tabindex="-1" role="dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title">Adjuntar Documento(s)</h4>
            </div>

            <div class="modal-body">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group row">

                            <div class="col-sm-4">   
                                <input type="file" id="txtfile" multiple="false">
                                <p class="help-block">Formatos jpg, pdf.</p>
                            </div>
                            <div class="col-sm-6">   
                                <input type="text" class="form-control" id="txtNamefile" placeholder="Descripción del Archivo">
                            </div>
                            <div class="col-sm-2">
                                <div class="float-right">
                                    <button class="btn btn-primary"><span class="fas fa-paperclip" id="btnAdjuntar"></span> Adjuntar</button>
                                </div>
                            </div>

                        </div>
                    </div>
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
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                <h4 class="modal-title">Registrar Observación</h4>
            </div>

            <div class="modal-body">

                <div class="row">
                    <div class="col-sm-12">
                        <div class="form-group">

                            <div class="col-sm-10">   
                                <textarea class="form-control" id="txtObservacion" placeholder="Ingresar la Observación"></textarea>
                            </div>
                            <div class="col-sm-2">
                                <div class="float-right">
                                    <button class="btn btn-primary"><span class="fas fa-save" id="btnAObservacion"></span> Guardar</button>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- FIN DEL CONTAINER -->


</div>

<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/p01Formato2IOARR/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/p01Formato2IOARR/controller.js' />"></script>


</body>
</html>
