<%-- 
    Document   : dashboard
    Created on : 10/05/2019, 09:08:33 AM
    Author     : jadrianzen
--%>

<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page import="mil.fap.models.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta Content-Type="text/html; charset=UTF-8'">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="_csrf" content="${_csrf.token}"/>
        <meta name="_csrf_header" content="${_csrf.headerName}"/>
        <meta name="description" content="sistema de gestion de inversiones fap">
        <meta name="author" content="fuerza aérea del perú">

        <link href="<c:url value='/resources/css/admin/all.min.css' />" rel="stylesheet" />
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
        <!-- Custom styles for this template-->
        <link href="<c:url value='/resources/css/admin/sb-admin-2.css' />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/datatable/dataTables.bootstrap.css" />" rel="stylesheet" />
        <link href="<c:url value="/resources/css/jquery-ui.css" />" rel="stylesheet" /> 
        <link href="<c:url value='/resources/css/loading/loading.css' />" rel="stylesheet" />    
        <link href="<c:url value='/resources/css/form-steps/form-steps.css' />" rel="stylesheet" />    
        <link href="<c:url value='/resources/css/checkRadio.css' />" rel="stylesheet" />   
        <link href="<c:url value='/resources/css/dashboard.css' />" rel="stylesheet" />   
        <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.5.6/css/buttons.dataTables.min.css">

        <link rel="icon" type="image/png" href="<c:url value='/resources/images/escudo.png' />" />
        <% List<Usuario> lMenus = (List<Usuario>) session.getAttribute("menus");%>

        <title><%=mil.fap.helpers.Constantes.App.sistema%></title>

    </head>
    <div class="modal-preload d-none" style="">
        <div class="circles">
            <div class="circle"></div>
            <div class="mainLogo"><i class="preloadEc"></i> Procesando... </div>
        </div>
    </div>

    <body id="page-top">


        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion toggled">
                <%if (Util.isUserloged()) {%> 
                <!-- Sidebar - Brand -->
                <div class="sidebar-brand d-flex align-items-center justify-content-center">
                    <img src="<c:url value='/resources/images/escudo.png' />" width="50px" />
                </div>

                <!-- Divider -->               
                <hr class="sidebar-divider my-0">   
                
                
                
                <%if (Util.hasRole(Constantes.PerfilUsuario.ADMINISTRADOR)) {%>
                <!-- Nav Item - Dashboard -->
                <li class="nav-item">                    
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/dashboard">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ideasInversion">
                        <i class="fas fa-list-alt"></i>
                        <span>Bandeja de Ideas</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">
                
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/nuevoIOARR">
                        <i class="fas fa-laptop"></i>
                        <span>IOARR</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/nuevoPIP">
                        <i class="fas fa-laptop"></i>
                        <span>Proyecto de Inversión</span>
                    </a>
                </li>
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/brechaIndicador">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Brechas e Indicadores</span></a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/controlAcceso">
                        <i class="fas fa-address-card"></i>
                        <span>Control de Acceso</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/mantParametroValor">
                        <i class="fas fa-fw fa-cog"></i>
                        <span>Parámetro del Sistema</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/unidadEjecutoraInver">
                        <i class="fas fa-address-card"></i>
                        <span>Unidad Ejecutora de Inversion</span></a>
                </li>

                <% } %>

                <hr class="sidebar-divider my-0">
                <%if (Util.hasRole(Constantes.PerfilUsuario.SUPERVISOR)) {%>
                <!-- Nav Item - Dashboard -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/admin/dashboard">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Dashboard</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ideasInversion">
                        <i class="fas fa-list-alt"></i>
                        <span>Bandeja de Ideas</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/brechaIndicador">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Brechas e Indicadores</span></a>
                </li>

                <% } %>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <%if (Util.hasRole(Constantes.PerfilUsuario.UNIDAD_PRESTADORA_DE_SERVICIO_FAP)) {%> 
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ideasInversion">
                        <i class="fas fa-list-alt"></i>
                        <span>Bandeja de Ideas</span>
                    </a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Nuevo
                </div>

                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/nuevoIOARR">
                        <i class="fas fa-laptop"></i>
                        <span>IOARR</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/nuevoPIP">
                        <i class="fas fa-laptop"></i>
                        <span>Proyecto de Inversión</span>
                    </a>
                </li>

                <% } %>
                <%if (Util.hasRole(Constantes.PerfilUsuario.PMI)) {%> 
                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ideasInversion">
                        <i class="fas fa-list-alt"></i>
                        <span>Bandeja de Ideas</span>
                    </a>
                </li>
                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Nav Item - Charts -->
                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/brechaIndicador">
                        <i class="fas fa-fw fa-chart-area"></i>
                        <span>Brechas e Indicadores</span></a>
                </li>

                <% } %>
                <%if (Util.hasRole(Constantes.PerfilUsuario.EJECUCION_EMGRA) || Util.hasRole(Constantes.PerfilUsuario.FORMULADOR)
                            || Util.hasRole(Constantes.PerfilUsuario.COMITE_TRABAJO) || Util.hasRole(Constantes.PerfilUsuario.UNIDAD_EJECUTORA)) {%> 

                <li class="nav-item">
                    <a class="nav-link" href="<%=request.getContextPath()%>/ideasInversion">
                        <i class="fas fa-list-alt"></i>
                        <span>Bandeja de Ideas</span>
                    </a>
                </li>

                <% } %>

                <!-- End of Main Content -->
                <hr class="sidebar-divider d-none d-md-block">
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>
                <% }%><!-- End isUserloged() -->
            </ul>

            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn d-md-none rounded-circle mr-3 text-white">
                            <i class="fa fa-bars"></i>
                        </button>


                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <li class="nav-item no-arrow">
                                <a class="nav-link " href="<%=request.getContextPath()%>/ideasInversion" >
                                    <strong class="mr-2 d-lg-inline"><%=mil.fap.helpers.Constantes.App.sistema%></strong>
                                </a>
                            </li>
                            <%if (Util.isUserloged()) {%> 
                            <div class="topbar-divider d-none d-sm-block"></div>
                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown"data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-user mr-1"> </i> <strong class="mr-2 d-none d-lg-inline" id="datosUsuario">${userInfo.unidad} - ${userInfo.perfil}</strong>
                                    <input type="hidden" name="hdnidperfil" value="${userInfo.idperfil}">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        ${userInfo.resumen}
                                    </a>
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/ideasInversion">
                                        <i class="fas fa-home fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Inicio
                                    </a>
                                    <div class="dropdown-divider"></div>

                                    <a class="dropdown-item" target="_blank" onclick="window.open(this.href, this.target, 'width=700,height=400'); return false;" href="<%=request.getContextPath()%>/admin/actualizarContraseña">
                                        <i class="fas fa-key fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Cambiar Contraseña                                                                             
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="<%=request.getContextPath()%>/logout">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>
                            <% }%><!-- End isUserloged() -->
                        </ul>

                    </nav>
                    <!-- End of Topbar -->

                    <div id="divAlerta" class="fixed-top"></div>
