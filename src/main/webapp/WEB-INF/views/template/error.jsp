<%@page import="mil.fap.helpers.Util"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!-- Static navbar -->
<jsp:include page="header.jsp" />
<div class="container-fluid">
    <div class="row title">
        <div class="col-sm-12 text-center h4">
            <label style="color:red;">ACCESO DENEGADO</label><br><br>
            <span class="mb-5 fas fa-lock" style="color:red;font-size:115px;"></span><br>
            <span></span><label class="ml-1">SU PERFIL DE <span class="text-primary"><%=Util.getRole()%> </span>  NO TIENE PERMISO A ESTE MÓDULO</label>
        </div>

    </div>     
</div><!-- FIN DEL CONTAINER  -->

<jsp:include page="footer.jsp" />

</body>
</html>