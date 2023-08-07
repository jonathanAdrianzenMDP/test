<%-- 
    Document: login
    Created on: 18/09/2017, 10:49:29 AM
    Author: Fabian Perez Vasquez
--%>

<%@page import="java.awt.Transparency"%>
<%@page import="java.awt.Color"%>
<%@page import="java.awt.RenderingHints"%>
<%@page import="java.awt.FontMetrics"%>
<%@page import="java.awt.Font"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.security.SecureRandom"%>
<%@page import="java.io.File"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.ByteArrayOutputStream"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <link rel="icon" type="image/png" href="<c:url value='/resources/images/escudo.png' />" />
        <title><%=mil.fap.helpers.Constantes.App.sistema%></title>
        <link href="<c:url value='/resources/css/login/animate.min.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/css/material-design-iconic-font.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/css/login/login.css' />" rel="stylesheet" />
        <link href="<c:url value='/resources/css/login/app_1.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/css/login/app_2.min.css' />" rel="stylesheet">
        <link href="<c:url value='/resources/css/footer.css' />" rel="stylesheet">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
        <script type="text/javascript">
            function dataCallback(response) {
                console.log("dataCallback", response)
                $('#btnIngresar').removeClass('d-none');
            }
            function dataExpiredCallback() {
                console.log("dataExpiredCallback")
            }

            function closeWindow() {
                window.open('', '_parent', '');
                window.close();
            }


        </script>
        <style>
            .encabezado {
                font-size: 2.15rem;
                font-weight: bold;
                letter-spacing: .2px;
                text-align: right;
                color: #fff;
            }
            .pieEncabezado {
                font-size: 1.25rem;
                font-weight: bold;
                letter-spacing: .2px;
                text-align: right;
                color: #fff;
            }
            .footerLeft {
                font-size: 1.20rem;
                letter-spacing: .2px;
                color: #fff;
                text-align: left;
            }
            .footerRight{
                font-size: 1.20rem;
                letter-spacing: .2px;
                color: #fff;
                text-align: right;
            }
            #footer{
                padding-top: 0px;
            }
        </style>
    </head>
    <body style="background-color: white">
        <header id="header" class="clearfix"  style="background-color: #003353;    min-height: 125px;">
            <ul class="h-inner ">
                <li class="hi-logo hidden-xs">
                    <img src="<c:url value='/resources/images/escudo.png' />" alt="" width="75"/>
                </li>
                <li class="pull-right">
                    <ul class="hi-menu encabezado  hidden-xs">
                        <li><%=mil.fap.helpers.Constantes.App.sistema%></li>                
                    </ul>
                    <ul class="hi-menu encabezado">
                        <li><%=mil.fap.helpers.Constantes.App.sigla%></li>                
                    </ul>
                    <ul class="hi-menu pieEncabezado">
                        <li><%=mil.fap.helpers.Constantes.App.version%></li>                
                    </ul>
                </li>
            </ul>
        </header>
        <div class="login-content" >
            <!-- Login -->
            <div class="lc-block toggled" id="l-login"  style="padding-top: 75px"> 
                <div class="row">
                    <div class="col-md-12 text-center text-uppercase h3"><label>MODIFICAR CONTRASEÑA</label></div>
                </div>
                <form id="frmLogin" method="post">
                    <div id="msj"></div>

                    <div class="lcb-form" style="background-color: #DEF1FF">
                        <div class="input-group m-b-20">
                            <span class="input-group-addon"></i></span>
                            <div class="fg-line">
                                <input type="hidden" id="txtDatos" class="form-control text h4" value="${userInfo.idusuario}" />
                                ${userInfo.grado} FAP ${userInfo.nombres}
                            </div>
                        </div>
                        <div class="input-group m-b-20">
                            <span class="input-group-addon"><i class="zmdi zmdi-lock"></i></span>
                            <div class="fg-line">
                                <input type="text" id="txtPassword" class="form-control text-center"  />
                            </div>  
                        </div>                                     
                        <a href="javascript:closeWindow();">
                            <button  type="button" id="btnGuardarPasswordPropio" class="btn btn-primary "> Guardar </button>
                        </a>
                          
                        <a href="javascript:closeWindow();">
                            <button  type="button"  class="btn btn-primary "> Cancelar </button>
                        </a>
                    </div>
                    <input type="hidden"
                           name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </form>
            </div>
        </div>

        <jsp:include page="template/footer.jsp" />

        <script src="<c:url value='/resources/js/nsScript/controlAccesos/index.js' />"></script>
        <script src="<c:url value='/resources/js/nsScript/controlAccesos/controller.js' />"></script>
    </body>
</html>

