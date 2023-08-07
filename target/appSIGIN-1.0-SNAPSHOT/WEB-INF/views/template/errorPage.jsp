<%-- 
    Document   : error
    Created on : 25/01/2018, 11:54:55 AM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Error</title>        
    <!-- Vendor CSS -->
    <link href="<c:url value='/resources/vendors/bower_components/animate.css/animate.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/vendors/bower_components/material-design-iconic-font/dist/css/material-design-iconic-font.min.css'/>" rel="stylesheet">
    <!-- CSS -->
    <link href="<c:url value='/resources/css/app_1.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/resources/css/app_2.min.css'/>" rel="stylesheet">
</head>   
    <body>
        <div class="four-zero" style="background: #003353;">
            <div class="fz-block" style="background: #1b4f6f;">
                <h2 style="font-size: 70px; text-transform: uppercase;"><${text}</h2>
                <div class="fzb-links">
                    <a href="http://sigho.fap.mil.pe:7777/Sigsa/logout"><i class="zmdi zmdi-home"></i></a>
                </div>
            </div>
        </div>

        <!-- Older IE warning message -->
        <!--[if lt IE 9]>
            <div class="ie-warning">
                <h1 class="c-white">Warning!!</h1>
                <p>You are using an outdated version of Internet Explorer, please upgrade <br/>to any of the following web browsers to access this website.</p>
                <div class="iew-container">
                    <ul class="iew-download">
                        <li>
                            <a href="http://www.google.com/chrome/">
                                <img src="img/browsers/chrome.png" alt="">
                                <div>Chrome</div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.mozilla.org/en-US/firefox/new/">
                                <img src="img/browsers/firefox.png" alt="">
                                <div>Firefox</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://www.opera.com">
                                <img src="img/browsers/opera.png" alt="">
                                <div>Opera</div>
                            </a>
                        </li>
                        <li>
                            <a href="https://www.apple.com/safari/">
                                <img src="img/browsers/safari.png" alt="">
                                <div>Safari</div>
                            </a>
                        </li>
                        <li>
                            <a href="http://windows.microsoft.com/en-us/internet-explorer/download-ie">
                                <img src="img/browsers/ie.png" alt="">
                                <div>IE (New)</div>
                            </a>
                        </li>
                    </ul>
                </div>
                <p>Sorry for the inconvenience!</p>
            </div>   
        <![endif]-->
    </body>
</html>