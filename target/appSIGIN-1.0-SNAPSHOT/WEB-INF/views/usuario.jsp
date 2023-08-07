<%-- 
    Document   : brechasIndicadores
    Created on : 14-nov-2018, 8:05:29
    Author     : Jonathan
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>

 <!-- Static navbar -->
    <jsp:include page="template/header.jsp" />
    
    <div class="container-fluid">

      <div class="row">
        <div class="col-md-12 text-center text-uppercase"><h4>Bandeja principal de Usuarios</h4></div>
      </div>
      <hr>

    </div><!-- FIN DEL CONTAINER  -->

      
    <jsp:include page="template/footer.jsp" />
    
    <!-- Optional JavaScript -->
    
    <script src="<c:url value='/resources/js/nsScript/login/index.js' />"></script>
    <script src="<c:url value='/resources/js/nsScript/login/controller.js' />"></script>
    
  </body>
</html>