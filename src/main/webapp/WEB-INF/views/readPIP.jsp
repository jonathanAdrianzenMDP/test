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
        <link href="<c:url value='/resources/css/bootstrap/bootstrap.css' />" rel="stylesheet" />
        <link href="<c:url value='/resources/css/dashboard.css' />" rel="stylesheet" />
        <link href="<c:url value='/resources/css/print.css' />" rel="stylesheet" />
        <title><%=mil.fap.helpers.Constantes.App.sistema%></title>
    </head>
    <body style="font-size: 8px;">


        <div class="container" style="background-color: white">

            <table style="border: none !important; font-size: 9px; width: 100%">
                <tbody>
                    <tr>
                        <td style="font-size:12px; border: thin solid black; font-weight: bold;" class="text-center">
                            FORMATO N° 05-A:<br>
                            REGISTRO DE IDEA DE PROYECTO O PROGRAMA DE INVERSIÓN<p>
                        </td>
                    </tr>
                    <tr>
                        <td style="font-size:8px;" class="text-center">
                            (La información registrada en este formato tiene carácter de Declaración Jurada - D.S. N° 284-2018-EF)</td>
                    </tr>
                </tbody>
            </table>    
            <br>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr> 
                        <td style="border: none;  width: 15px;"><label>1</label></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">NOMBRE DE IDEA DEL PROYECTO/PROGRAMA DE INVERSIÓN</label></td>
                        <td style="border: 1px solid black;width: 700px;">${item.NOMPROYECT}</td>
                    </tr>
                    <tr> 
                        <td></td>
                        <td colspan="2">
                            <label>Nota: en el caso de ideas de proyecto, se construye en base a la información consignada en el numeral 6</label>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label style="font-size: 9px;">2</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px">RESPONSABILIDAD FUNCIONAL DE LA INVERSIÓN</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">FUNCIÓN</td>
                        <td style="border: 1px solid black;">${item.DESCFUNCION}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">DIVISIÓN FUNCIONAL</td>
                        <td style="border: 1px solid black;">${item.DESCDIVFUNCION}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">GRUPO FUNCIONAL</td>
                        <td style="border: 1px solid black;">${item.DESCGRUPOFUNC}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 300px;">SECTOR RESPONSABLE</td>
                        <td style="border: 1px solid black;">${item.SECRESPONS}</td>
                    </tr>
                <br>
                <tr>
                    <td></td>
                    <td colspan="2"><label>Nota: para programas se consigna la cadena funcional representativa del programa</label></td>
                </tr>
                </tbody>
            </table>
            <br>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>3</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">ALINEAMIENTO A UNA BRECHA PRIORITARIA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">  SERVICIOS PÚBLICOS CON BRECHA IDENTIFICADA Y PRIORIZADA: </label></td>
                        <td style="border: 1px solid black;">${item.SERVPUBLIC}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">  INDICADOR DE BRECHA DE ACCESO A SERVICIOS:</label></td>
                        <td style="border: 1px solid black; width: 40px;">Nombre:</td>
                        <td style="border: 1px solid black;">${item.INDICBRECH}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
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
                        <td style="border: 1px solid black;">${item.UNIDADMED}</td>
                        <td style="border: 1px solid black;">${item.ESPACIOGEO}</td>
                        <td style="border: 1px solid black;">${item.ANIO}</td>
                        <td style="border: 1px solid black;"  class="number">${item.VALORINDI}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px; "></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">CONTRIBUCIÓN AL CIERRE DE BRECHA:</label></td>
                        <td style="border: 1px solid black; width: 40px;">%</td>
                        <td style="border: 1px solid black;" class="number">${item.VALORCONTRI}</td>
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
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">TIPOLOGIA DE PROYECTO</label></td>
                        <td style="border: 1px solid black;">${item.TIPOLOGIA}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">
                            <label>Nota: solo para ideas de proyecto</label>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td colspan="2">   
                            <span>Nota: Se puede incluir más de un servicio público con brecha y más de un indicador</span>
                        </td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>4</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">UNIDAD FORMULADORA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr> 
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">SECTOR:</td>
                        <td style="border: 1px solid black;">${item.DESCSECTOR}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">ENTIDAD:</td>
                        <td style="border: 1px solid black;">${item.DESCENTIDAD}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">NOMBRE DE LA UF:</td>
                        <td style="border: 1px solid black;">${item.NOMBREUF}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">RESPONSABLE DE LA UF:</td>
                        <td style="border: 1px solid black;">${item.RESPONSABLEUF}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>5</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">UNIDAD EJECUTORA DE INVERSIONES</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">SECTOR:</td>
                        <td style="border: 1px solid black;">${item.DESCSECTOR}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">ENTIDAD:</td>
                        <td style="border: 1px solid black;">${item.DESCENTIDAD}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">NOMBRE DE LA UEI:</td>
                        <td style="border: 1px solid black;">${item.NOMBREUEI}</td>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">RESPONSABLE DE LA UEI:</td>
                        <td style="border: 1px solid black;">${item.RESPONSABLEUEI}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>6</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">UNIDAD EJECUTORA PRESUPUESTAL</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">SECTOR:</td>
                        <td style="border: 1px solid black;">${item.DESCSECTOR}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">ENTIDAD:</td>
                        <td style="border: 1px solid black;">${item.ENTIDUEP}</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 200px;">NOMBRE DE LA UE:</td>
                        <td style="border: 1px solid black;">${item.DESCENTIDAD}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none;  width: 15px;"><label>7</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">DATOS DE LA INVERSIÓN</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">  Objeto de intervención</label></td>                       
                        <td style="border: 1px solid black;">${item.OBJINTERV}</td>
                    </tr>
                </tbody>
            </table>
            <br>  
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border:none; width: 15px"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">  Naturaleza de intervención</label></td>
                        <td style="border: 1px solid black;">${item.NATINTERVE}</td>
                    </tr>
                </tbody>
            </table>     
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border:none; width: 15px"></td>
                        <td style="border: none;  width: 400px;"><label style="font-size: 9px">  Nombre de la unidad productora</label></td>
                        <td style="border: 1px solid black;">${item.NOMUNIPROD}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table  style="width: 75%">
                <thead>
                    <tr>
                        <td style="border:none; width: 15px;"></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">Localización geográfica de la unidad productora</label></td>
                    </tr>
                    <tr class="text-center">
                        <th></th>
                        <th style="border: 1px solid black;">DEPARTAMENTO</th>     
                        <th style="border: 1px solid black;">PROVINCIA</th>
                        <th style="border: 1px solid black;">DISTRITO</th>
                    </tr>
                </thead>
                <tbody>
                    <tr class="text-center">
                        <td></td>
                        <td style="border: 1px solid black;">${item.DEPARTAMENTO}</td>
                        <td style="border: 1px solid black;">${item.PROVINCIA}</td>
                        <td style="border: 1px solid black;">${item.DISTRITO}</td>
                    </tr>
                </tbody>
            </table>
            <br>
            <div class="page-break"></div>
            <table  style="width: 75%">
                <thead>
                    <tr>
                        <td style="border:none; width: 15px;"><label>8</label></td>
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">DESCRIPCIÓN AGREGADA DEL PROYECTO/PROGRAMA</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td><br></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td style="border:none; width: 15px;"><label>8.1</label></td> 
                        <td style="border: none;  width: 300px;"><label style="font-size: 9px">Para proyectos de inversión</label></td> 
                    </tr>
                    <tr class="text-center">
                        <th></th>
                        <th style="border: 1px solid black;">TIPO DE ITEM</th>     
                        <th style="border: 1px solid black;">COSTO REFERENCIAL</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ite" items="${item2}">
                        <tr class="text-center">
                            <td></td>
                            <td style="border: 1px solid black;" class="text-left">${ite.tipoitem}</td>
                            <td style="border: 1px solid black;" class="number text-right">${ite.v_costoref}</td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;" class="text-center">TOTAL:</td>
                        <td style="border: 1px solid black;" class="number text-right">${item.v_totalMontoItem}</td>
                    </tr>
                </tfoot>
            </table>
            <br>
            <table  style="width: 75%">
                <thead>
                    <tr>
                        <td style="border:none; width: 15px;"></td> 
                        <td style="border:none; width: 300px;"><label style="font-size: 9px">Capacidad de producción estimada con el proyecto de inversión</label></td>
                        <td></td>
                    </tr>
                    <tr class="text-center"> 
                        <th></th>
                        <th style="border: 1px solid black;">SERVICIO</th>     
                        <th style="border: 1px solid black;">UM</th>
                        <th style="border: 1px solid black;">CAPACIDAD DE PRODUCCION</th>
                    </tr>
                </thead>
                <tbody>
   
                        <tr class="text-center">
                            <td></td>
                            <td style="border: 1px solid black;">${item.SERVPUBLIC}</td>
                            <td style="border: 1px solid black;">${item.UNIDADMED}</td>
                            <td style="border: 1px solid black;">${item.CAPPRODUC}</td>
                        </tr>
         
                </tbody>
            </table>
            <br>
            <table  style="width: 75%">
                <thead>
                    <tr>
                        <td style="border:none; width: 15px;"><label>8.2</label></td> 
                        <td style="border:none; width: 300px;"><label style="font-size: 9px">Para programas de inversión</label></td>
                    </tr>
                    <tr class="text-center"> 
                        <th></th>
                        <th style="border: 1px solid black;">INVERSIONES</th>     
                        <th style="border: 1px solid black;">COSTO REFERENCIAL</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ite" items="${item5}">
                        <tr class="text-center">
                            <td></td>
                            <td style="border: 1px solid black;" class="text-left">${ite.inversion}</td>
                            <td style="border: 1px solid black;" class="number text-right">${ite.v_costoref}</td>                            
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <table style="width: 75%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>8.3</label></td> 
                        <td style="border: none; width: 300px;"><label style="font-size: 9px">Documento técnico para la declaración de viabilidad</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black; width: 700px;">${item.DOCUTEC}</td>

                    </tr>
                    <tr>
                        <td></td>
                        <td><label>Nota: solo para proyectos de inversión</label></td>
                    </tr>
                </tbody>
            </table>
            <br>
            <table style="width: 75%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>8.4</label></td>
                        <td style="border: none; width: 300px;"><label style="font-size: 9px">Costo aproximado del estudio de preinversión o ficha técnica (S/.)</label></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td style="border: 1px solid black;width: 700px;" class="number text-right">${item.VALPREINV}</td>
                    </tr>
                </tbody>
            </table>
            <br>

            <table style="width: 75%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>9</label></td>
                        <td style="border: none"><label style="font-size: 9px">MODALIDAD DE EJECUCIÓN TENTATIVA</label></td>
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
                            <td class="text-center" style="border: 1px solid black;"><c:if test = "${i.key.equals(item.TIPEJECPRO)}">X</c:if></td> 
                            </tr>
                    </c:forEach>

                </tbody>
            </table>
            <br>
            <table style="width: 75%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"><label>10</label></td>
                        <td style="border: none"><label style="font-size: 9px">FUENTE DE FINANCIAMIENTO</label></td>
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
                    <c:forEach var="it" items="${tipoFinanciamiento}" varStatus="myIndex">
                        <tr>
                            <td></td>
                            <td style="border: 1px solid black;">${myIndex.index+1}. ${it.value}</td>
                            <td  class="text-center" style="border: 1px solid black;"><c:if test = "${it.key.equals(item.TIPFINANPR)}">X</c:if></td>
                            </tr>
                    </c:forEach>

                </tbody>
            </table>
            <br>
            <table style="width: 100%;">
                <tbody>
                    <tr>
                        <td style="border: none; width: 15px;"></td>
                        <td style="background-color: black; color: white;">Para efectos de cumplir con lo establecido en el numeral 14.7 del artículo 14 del Reglamento del Decreto Legislativo 1252, se debe elaborar una Nota Conceptual que complemente al presente formato para su remisión a la Dirección General deL y Tesoro Público del Ministerio de Economía y Finanzas.<br>
                            El contenido mínimo de dicha nota conceptual es el seguiente:</td>
                    </tr>
                </tbody>
            </table>

            <br>
            <table style="width: 100%;">
                <tr>
                    <td style="border: none; width: 15px;"></td>
                    <td style="border: 1px solid black;">
                        <div>
                            a)Se debe ampliar la información planteada en el formato de idea del proyecto o programa de inversión, sobre la base de lo siguiente:
                            •    Explicar cómo el proyecto o programa de inversión se enmarca en los objetivos del plan estratégico sectorial, plan de desarrollo concertado regional o local, de corresponder.</br>
                            •    Explicar si el proyecto o programa de inversión se articula o genera sinergias con otras intervenciones públicas de la cartera  de proyectos de la entidad, sector, gobierno regional o gobierno local.</br>
                            •    Justificación del planteamiento del proyecto o programa de inversión en términos de su prioridad y de su contribución al cierre de brechas.</br>
                            •    Hipótesis del problema central, causas y efectos.</br>
                            •    Delimitación preliminar del área geográfica a intervenir de los beneficiarios directos.</br>
                            •    Planteamiento preliminar del proyecto de inversión, en términos de su objetivo central, sus componentes, principales acciones, metas físicas referenciales de producto y costo de inversión  preliminar.  </br>
                            •    Descripción cualitativa de los beneficios sociales que genera el proyecto o programa de inversión.</br>
                            •    ¿Cómo se plantea garantizar la operación y mantenimiento del proyecto?</br>
                            •	Descripción cualitativa de los principales riesgos (institucional, legal, operacional, presupuestal, desastres, entre otros) que el proyecto podría enfrentar durante su ejecución y funcionamiento.</br>
                            </br>
                            b) La nota conceptual tendrá un límite máximo de seis (06) páginas, sin contar con los anexos que la unidad formuladora juague conveniente alcanzar para tener una mejor compresión del planteamiento de la idea del proyecto o programa de inversión. 
                        </div>
                    </td>

                </tr>
                <tr>
                    <td></td>
                    <td style="border: none;">
                        *La Nota Conceptual se deberá adjuntar junto con el presente formato.
                    </td>
                </tr>
            </table>   


            <script src="<c:url value='/resources/js/jquery/jquery-2.1.4.js' />" type="text/javascript"></script>
            <script src="<c:url value='/resources/js/jquery/jquery.number.js' />" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    $('.number').number(true, 2);
                    $('table td').css('padding-left', '2px');
                    $('table td').css('padding-right', '2px');
                })
            </script>
    </body>
</html>