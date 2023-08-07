<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <link rel="icon" type="image/png" href="<c:url value='/resources/images/escudo.png' />" />


        <!-- CSS -->
        <link href="<c:url value='/resources/css/bootstrap/bootstrap.css'  />" rel="stylesheet" />
        <link href="<c:url value='/resources/css/dashboard.css' />" rel="stylesheet" />
        <link href="<c:url value='/resources/css/print.css' />" rel="stylesheet" />
        <title><%=mil.fap.helpers.Constantes.App.sistema%></title>

    </head>
    <body style="font-size: 9px">


        <div class="container" style="background-color: white">


            <table style="border: none !important; width: 100%">
                <tbody>
                    <tr>
                        <td style="font-size:12px; border: 1px solid black; font-weight: bold;" class="text-center">
                            FORMATO N° 05-B:<br>
                            REGISTRO AGREGADO DE IDEAS DE IOARR 
                        </td>
                    </tr>
                    <tr>
                        <td style="font-size:8px;" class="text-center">
                            (La información registrada en este formato tiene carácter de Declaración Jurada - D.S. N° 284-2018-EF)                         </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>1</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">NOMBRE DE IDEA DE IOARR (agregado y simplificado)</label></td>
                        <td style="border: 1px solid black;">${item.nombreproy}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <span><label>Nota: con base en la información consignada en los numerales 6 y 7</label></span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>
            <table style="width: 100%">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">2</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Función:</td>
                        <td style="border: 1px solid black;">${item.descfuncion}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">División Funcional:</td>
                        <td style="border: 1px solid black;">${item.descdivfuncion}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Grupo Funcional:</td>
                        <td style="border: 1px solid black;">${item.descgrupofunc}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Sector Responsable:</td>
                        <td style="border: 1px solid black;">${item.descsector}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>

            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">3</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">ALINEAMIENTO A UNA BRECHA PRIORITARIA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">SERVICIOS PÚBLICOS CON BRECHA IDENTIFICADA Y PRIORIZADA: </label></td>
                        <td style="border: 1px solid black;">${item.serviciopublico}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="width: 15px; border:none"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">INDICADOR DE BRECHA DE ACCESO A SERVICIOS:</label></td>
                        <td style="border: 1px solid black; width: 40px;">Nombre:</td>
                        <td style="border: 1px solid black;">${item.indicbrech}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td>
                            <span>Nota: Se puede incluir más de un servicio público con brecha y más de un indicador</span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table  style="width: 75%">
                <thead>
                    <tr class="text-center">  
                        <th style="width: 15px; border:none"></th>
                        <th style="border: 1px solid black;">UNIDAD MEDIDA</th>     
                        <th style="border: 1px solid black;">ESPACIO GEOGRAFICO</th>
                        <th style="border: 1px solid black;">AÑO</th>
                        <th style="border: 1px solid black;">VALOR CAP. PRODUCCIÓN (%)</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="text-center">
                        <th style="width: 15px; border:none"></th>
                        <td style="border: 1px solid black;">${item.unidadmed}</td>
                        <td style="border: 1px solid black;">${item.espaciogeo}</td>
                        <td style="border: 1px solid black;">${item.anio}</td>
                        <td style="border: 1px solid black;"  class="number">${item.valorindicador}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table>
                <tbody>
                    <tr>
                        <td style="width: 15px; border:none"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">CONTRIBUCIÓN AL CIERRE DE BRECHA:</label></td>
                        <td></td>
                        <td style="border: 1px solid black; width: 40px;">%</td>
                        <td style="border: 1px solid black;" class="number">${item.valorcontri}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <span>Nota: Se refiere a la capacidad de producción que aporta el proyecto (incremental)</span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>

            <table style="width: 100%">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">4</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;"> UNIDAD FORMULADORA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Sector:</td>
                        <td style="border: 1px solid black;">${item.descsector}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Entidad:</td>
                        <td style="border: 1px solid black;">${item.descentidad}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Nombre de la UF:</td>
                        <td style="border: 1px solid black;">${item.nombreuf}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Responsable de la UF:</td>
                        <td style="border: 1px solid black;">${item.responsableuf}</td>
                    </tr>
                </tbody>
            </table>

            <br>
            <br>

            <table style="width: 100%">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">5</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">UNIDAD EJECUTORA DE INVERSIONES</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Sector:</td>
                        <td style="border: 1px solid black;">${item.descsector}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Entidad:</td>
                        <td style="border: 1px solid black;">${item.descentidad}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Nombre de la UEI:</td>
                        <td style="border: 1px solid black;">${item.nomuei}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;; width: 300px;">Responsable de la UEI:</td>
                        <td style="border: 1px solid black;">${item.responsableuei}</td>
                    </tr>
                </tbody>
            </table>

            <br>
            <br>

            <table style="width: 100%">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">6</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">UNIDAD EJECUTORA PRESUPUESTAL</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Sector:</td>
                        <td style="border: 1px solid black;">${item.descsector}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Entidad:</td>
                        <td style="border: 1px solid black;">${item.entiduep}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">Nombre de la UE:</td>
                        <td style="border: 1px solid black;">${item.descentidad}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">7</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">DATOS DE LA INVERSIÓN</label></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: none;  width: 400px;">Nombre genérico de las Unidades Productoras</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: none;  width: 400px;"><label>Nota: Las UP deben referirse a un mismo grupo funcional correspondiente</label></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;width: 700px;">${item.unidproduc}</td>
                    </tr>

                </tbody>
            </table>
            <br>
            <table style="width: 50%">
                <thead>
                    <tr>
                        <th style="border:none; width: 15px;"></th>
                        <th style="text-align: left;">Localización geográfica</th>
                    </tr>
                    <tr class="text-center">
                        <th></th>
                        <th style="border: 1px solid black;">Departamento</th>     
                        <th style="border: 1px solid black;">Provincia</th>   
                        <th style="border: 1px solid black;">Distrito</th>     
                    </tr>
                </thead>
                <tbody>
                    <tr class="text-center">
                        <td></td>
                        <td style="border: 1px solid black;">${item.departamento}</td>
                        <td style="border: 1px solid black;">${item.provincia}</td>
                        <td style="border: 1px solid black;">${item.distrito}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table  style="width: 80%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">8</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px;">DESCRIPCIÓN AGREGADA DE LAS IOARR</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <th style="border: none;  width: 20px;"><label style="font-size: 9px">OBJETO DE INTERVENCION:</label></th>
                        <td style="border: 1px solid black;">${item.objinterv}</td>
                    </tr>
                <br>
                <tr>
                    <td><br></td>
                    <td></td>
                    <td></td>
                </tr>
                <tr class="text-center">  
                    <td></td>
                    <td style="border: 1px solid black;">TIPO DE IOARR(*)</td>     
                    <td style="border: 1px solid black;">COSTO REFERENCIAL DE LA INVERSIÓN</td>
                </tr>
                <c:forEach var="i" items="${item2}">
                    <tr class="text-center">
                        <td></td>
                        <td style="border: 1px solid black;" class="text-left">${i.tipoIOARR}</td>
                        <td style="border: 1px solid black;" class="number text-right">${i.v_montoInversion}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>

            <div class="page-break"></div>
            <table style="width: 80%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>9</label></td>
                        <td style="border: none;"><label style="font-size: 9px;">MODALIDAD DE EJECUCIÓN TENTATIVA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; font-weight: bold;">MODALIDAD DE EJECUCIÓN</td>
                        <td class="text-center" style="border: 1px solid black;font-weight: bold;">MARQUE CON UNA "X" LA MODALIDAD DE EJECUCION TENTATIVA</td>
                    </tr>
                    <c:forEach var="i" items="${modalidadEjecucion}" varStatus="myIndex">
                        <tr>
                            <td></td>
                            <td style="border: 1px solid black;">${myIndex.index+1}. ${i.value}</td>
                            <td class="text-center" style="border: 1px solid black;"><c:if test = "${i.key.equals(item.modaliejec)}">X</c:if></td>
                            </tr>
                    </c:forEach>

                </tbody>
            </table>
            <br>
            <br>
            <table style="width: 80%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>10</label></td>
                        <td style="border: none;"><label style="font-size: 9px;">FUENTE DE FINANCIAMIENTO</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; font-weight: bold;">FUENTE DE FINANCIAMIENTO</td>
                        <td class="text-center" style="border: 1px solid black;font-weight: bold;">MARQUE CON UNA "X" LA FUENTE DE FINANCIAMIENTO</td>
                    </tr>
                    <c:forEach var="i" items="${tipoFinanciamiento}" varStatus="myIndex">
                        <tr>
                            <td></td>
                            <td style="border: 1px solid black;">${myIndex.index+1}. ${i.value}</td>
                            <td class="text-center" style="border: 1px solid black;"><c:if test = "${i.key.equals(item.fuentfinan)}">X</c:if></td>
                            </tr>
                    </c:forEach>

                </tbody>
            </table>


            <br>
            <br>
            <div class="row">
                <div class="col-sm-12">
                    <label style="font-size: 9px;">10.1 ¿ALGUNA DE LAS IOARR SE FINANCIA TOTAL O PARCIALMENTE CON RECURSOS POR OPERACIONES OFICIALES DE CRÉDITO?</label>
                </div>
            </div>
            <p>
            <table style="width: 100%">
                <tbody>
                    <tr>
                        <td style="width: 50px; height: 20px;">SI</td>
                        <td style="border: 1px solid black; width: 50px; text-align: center;">
                            <c:if test = "${item.recursoperador.equals('SI')}">X</c:if>   
                            </td>
                            <td style="width: 30px; height: 20px;"></td>
                            <td>Se requiere adelantar el registro de las IOARR (Formato N° 07-C) para las cuales solicitan el financiamiento con Recursos por Operaciones Oficiales de Crédito.</td>
                        </tr>
                        <tr>
                            <td colspan="3"><br></td>
                        </tr>
                        <tr>
                            <td style="width: 50px;">NO</td>
                            <td style="border: 1px solid black; width: 50px; text-align: center">
                            <c:if test = "${item.recursoperador.equals('NO')}">X</c:if>   
                            </td>
                            <td style="width: 30px; height: 20px;"></td>
                            <td>Continua al numeral 10.2</td>
                        </tr>
                    </tbody>
                </table>
                <br>
                <br>
                <div class="row">
                    <div class="col-sm-12">
                        <label style="font-size: 9px;">10.2 EN CASO QUE LAS IOARR SE FINANCIEN MEDIANTE TRANSFERENCIAS DEL GOBIERNO NACIONAL O GOBIERNOS REGIONALES A OTROS NIVELES DE GOBIERNO</label>
                    </div>
                </div>
                <div>
                    La UF que realiza el registro de este formato corresponde al GN o GR que realice la transferencia.<br><br>
                    En dicho caso:<br><br>
                    Añadir las Unidades Formuladoras que registrarán los Formatos 07-C para las IOARR individualizadas
                </div>
            </div>

            <script src="<c:url value='/resources/js/jquery/jquery-2.1.4.js' />" type="text/javascript"></script>
        <script src="<c:url value='/resources/js/jquery/jquery.number.js' />" type="text/javascript"></script>
        <script type="text/javascript">
            $(document).ready(function () {


                $('.number').number(true, 2);
                $('table td').css('padding-left', '2px');//espacio de las celdas con el texto
            })
        </script>
    </body>
</html>