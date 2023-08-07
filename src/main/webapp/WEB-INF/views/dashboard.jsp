<%-- 
    Document   : dashboard
    Created on : 10/05/2019, 09:08:33 AM
    Author     : jadrianzen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="template/header.jsp" />


            <!-- Begin Page Content -->
            <div class="container-fluid">

                <div class="d-sm-flex align-items-center justify-content-between mb-4">
                    <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                </div>

              <!-- Content Row -->
               <div class="form-group">
                    <div>
                         <form:select id="txtanio" class="custom-select mr-sm-2" path="anios">
                            <c:forEach items="${anios}" var="obj">
                                <option <c:if test="${obj.key eq anioActual}">selected="selected"</c:if>  value="${obj.key}">${obj.value}</option>
                            </c:forEach>
                         </form:select>
                    </div>
                </div>

              <div class="row">

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                  <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                      <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                          <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">CANT. PROYECTOS DE INVERSION</div>
                          <div class="h5 mb-0 font-weight-bold text-gray-800"><label name="lblCantPIP">0</label></div>
                        </div>
                        <div class="col-auto">
                          <i class="fas fa-chart-pie fa-2x text-gray-300"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                 <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                  <div class="card border-left-primary shadow h-100 py-2">
                    <div class="card-body">
                      <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                          <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">Costo Proyecto de Inversión (Acum.)</div>
                          <div class="row no-gutters align-items-center">
                            <div class="col-auto">
                              <div class="h5 mb-0 mr-3 font-weight-bold text-gray-800">S/. <label class="number" name="lblCostoPIP">0</label></div>
                            </div>
                          </div>
                        </div>
                        <div class="col-auto">
                          <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>

                <!-- Earnings (Monthly) Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                  <div class="card border-left-success shadow h-100 py-2">
                    <div class="card-body">
                      <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                          <div class="text-xs font-weight-bold text-success text-uppercase mb-1">CANT. IOARR</div>
                          <div class="h5 mb-0 font-weight-bold text-gray-800"><label name="lblCantIOARR">0</label></div>
                        </div>
                        <div class="col-auto">
                          <i class="fas fa-chart-pie fa-2x text-gray-300"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>



                <!-- Pending Requests Card Example -->
                <div class="col-xl-3 col-md-6 mb-4">
                  <div class="card border-left-success shadow h-100 py-2">
                    <div class="card-body">
                      <div class="row no-gutters align-items-center">
                        <div class="col mr-2">
                          <div class="text-xs font-weight-bold text-success text-uppercase mb-1">COSTO DE IOARR (Acum.)</div>
                          <div class="h5 mb-0 font-weight-bold text-gray-800">S/. <label class="number" name="lblCostoIOARR">0</label></div>
                        </div>
                        <div class="col-auto">
                          <i class="fas fa-dollar-sign fa-2x text-gray-300"></i>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
              </div>

              <!-- Content Row -->

              <div class="row">

                  <!-- Pie Chart -->
                <div class="col-xl-12 col-lg-5">
                  <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                      <h6 class="m-0 font-weight-bold text-primary">Cantidad de Proyectos de Inversión e IOARR - Aprobadas PMI</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                      <div class="chart-pie pt-4 pb-2">
                        <canvas id="myPieChart"></canvas>
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <div class="row">
                <div class="col-xl-12 col-lg-7">
                  <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                      <h6 class="m-0 font-weight-bold text-primary">Costos Totales de Fuentes de Financiamiento de Proyectos de Inversión e IOARR</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                      <div class="col-12">
                          <div id="chartBarFuenteFinanciero" style="height: 750px;"></div>
                      </div>
                    </div>
                  </div>
                </div> 
              </div>
              <div class="row">
                <!-- Area Chart -->
                <div class="col-xl-12 col-lg-7">
                  <div class="card shadow mb-4">
                    <!-- Card Header - Dropdown -->
                    <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
                      <h6 class="m-0 font-weight-bold text-primary">Costos Proyectos de Inversión e Inversiones  - Aprobadas PMI</h6>

                    </div>
                    <!-- Card Body -->
                    <div class="card-body">
                      <div class="chart-area">
                        <canvas class="chartBar"></canvas>
                      </div>
                    </div>
                  </div>
                </div>



              </div>
            </div>
            <!-- /.container-fluid -->

   <jsp:include page="template/footer.jsp" />
<!-- Optional JavaScript -->

    <script src="<c:url value='/resources/js/nsScript/dashboard/index.js' />"></script>
    <script src="<c:url value='/resources/js/nsScript/dashboard/controller.js' />"></script>
    <script src="<c:url value='/resources/js/chartjs/Chart.bundle.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/chartjs/utils.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/highcharts/highcharts.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/highcharts/exporting.js' />" type="text/javascript"></script>
    
    
</body>
</html>


  
