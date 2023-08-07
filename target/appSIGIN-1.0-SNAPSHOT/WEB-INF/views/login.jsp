<%-- 
    Document   : brechasIndicadores
    Created on : 04-oct-2018, 8:05:29
    Author     : Jonathan
--%>

<%@page import="mil.fap.helpers.Constantes"%>
<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!doctype html>

<!-- Static navbar -->
<jsp:include page="template/header.jsp" />
<spring:url value="/reportebrecha" var="reportLink" />
<div class="container-fluid">
    
 <!-- Outer Row -->
    <div class="row justify-content-center">

      <div class="col-xl-10 col-lg-12 col-md-9">

        <div class="my-5">
          <div>
            <!-- Nested Row within Card Body -->
            <div class="row">
               <div class=" col-lg-6 lc-block toggled hidden-md hidden-sm hidden-xs">  
                    <!-- Carousel -->
                    <div id="carousel-generic" class="p-5 carousel slide" data-ride="carousel" data-interval="3000">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner" role="listbox">
                            <div class="item active" >
                                <img src="<c:url value='/resources/images/escudo.png' />" width="250" height="270" alt="" style=" margin-left: auto; margin-right: auto;display: block;">
                            </div>
                        </div>
                    </div>
                </div>
              <div class="col-lg-6">
                <div class="p-5">
                  <div class="text-center">
                    <h1 class="h4 text-gray-900 mb-4">INICIAR SESIÓN</h1>
                  </div>
                  <form class="user" id="frmLogin" method="post">
                    <div class="form-group">
                      <input type="text" name="username" class="form-control form-control-user" placeholder="Ingresar Usuario...">
                    </div>
                    <div class="form-group">
                      <input type="password" name="password" class="form-control form-control-user" placeholder="Clave">
                    </div>
                    
                      <input type="submit" id="btnIngresar" name="submit" class="btn btn-primary btn-user btn-block" value="Ingresar" />
                    <hr>
                    <input type="hidden"
                    name="${_csrf.parameterName}"
                    value="${_csrf.token}"/>
                    
                  </form>
                  
                  <div class="text-center">
                    <a class="small" href="#">Forgot Password?</a>
                  </div>
                  <div class="text-center d-none">
                    <a class="small" href="register.html">Create an Account!</a>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>

      </div>

    </div>

</div>


<jsp:include page="template/footer.jsp" />

<!-- Optional JavaScript -->

<script src="<c:url value='/resources/js/nsScript/login/index.js' />"></script>
<script src="<c:url value='/resources/js/nsScript/login/controller.js' />"></script>

</body>
</html>