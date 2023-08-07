<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<input type="hidden" value="" id="hdnFileName" />
<input type="hidden" value="" id="hdnFileURL" />
</div>
      <!-- End of conent -->

   <!-- Footer -->
      <footer class="sticky-footer bg-white">
        <div class="container my-auto">
          <div class="copyright text-right my-auto text-white">
              <span>Copyright <%=mil.fap.helpers.Util.getYearNow()%> SINFA - Derechos Reservados</span><br>
              <span><%=mil.fap.helpers.Constantes.App.sigla%> <%=mil.fap.helpers.Constantes.App.version%></span>
          </div>
        </div>
      </footer>
      <!-- End of Footer -->
  </div>
    <!-- End of Content Wrapper -->

  </div>
  <!-- End of Page Wrapper -->

  <!-- Scroll to Top Button-->
  <a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
  </a>
  
    <script src="<c:url value='/resources/js/jquery/jquery.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery/jquery-ui.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery/securityAjax.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/bootstrap/bootstrap.bundle.js' />" type="text/javascript"></script>
    <script src="<c:url value="/resources/js/bootstrap/bootstrap-dialog.js"/>" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery/jquery.easing.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/datatable/datatable.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/datatable/datatable.pageinfo.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/datatable/dataTable.bootstrap.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/nsScript/ns.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/admin/sb-admin-2.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/chartjs/Chart.min.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/chartjs/utils.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/jquery/jquery.number.js' />" type="text/javascript"></script>
    <script src="<c:url value='/resources/js/nsScript/layout.js' />" type="text/javascript" charset="utf-8"></script>
    <script src="<c:url value='/resources/js/nsScript/permisos.js' />" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/dataTables.buttons.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.5.6/js/buttons.html5.min.js"></script>
    <script type="text/javascript">
        $('[data-toggle="tooltip"]').tooltip();
         $('[data-toggle="popover"]').popover('show');
         
     ns('Web.SIGPI.URL')
     Web.SIGPI.URL.DownloadFile = "<%=request.getContextPath()%>/download/file/";
     Web.SIGPI.URL.changeFileUpload = "<%=request.getContextPath()%>/upload/changefile/";
     Web.SIGPI.URL.saveFileUpload = "<%=request.getContextPath()%>/upload/savefile/";
     Web.SIGPI.URL.deleteFileUpload = "<%=request.getContextPath()%>/upload/updateEstado/";
     Web.SIGPI.URL.listFileUpload = "<%=request.getContextPath()%>/upload/listfile/";
     ns('Web.SIGPI.Parametro')
     Web.SIGPI.Parametro.EnElaboracion = <%=mil.fap.helpers.Constantes.EstadosPIP_IOARR.EnElaboracion%>;
     Web.SIGPI.Parametro.PendienteRevision = <%=mil.fap.helpers.Constantes.EstadosPIP_IOARR.PendienteRevision%>;
     Web.SIGPI.Parametro.Aprobado = <%=mil.fap.helpers.Constantes.EstadosPIP_IOARR.Aprobado%>;
     Web.SIGPI.Parametro.ObservadoRechazado = <%=mil.fap.helpers.Constantes.EstadosPIP_IOARR.ObservadoRechazado%>;
     Web.SIGPI.Parametro.SinRegistros = <%=mil.fap.helpers.Constantes.EstadosPIP_IOARR.SinRegistros%>;
     Web.SIGPI.Parametro.Success = "<%=mil.fap.helpers.Constantes.Mensajes.typeSuccess%>";
     Web.SIGPI.Parametro.Error = "<%=mil.fap.helpers.Constantes.Mensajes.typeError%>";
     Web.SIGPI.Parametro.Sector = <%=mil.fap.helpers.Constantes.Parametros.Sector%>;
     Web.SIGPI.Parametro.NomUniFormuladora = <%=mil.fap.helpers.Constantes.Parametros.NombreDeLaUnidadFormuladora%>;
     Web.SIGPI.Parametro.Entidad = <%=mil.fap.helpers.Constantes.Parametros.EntidadUnidadFormuladora%>;
     Web.SIGPI.Parametro.RespUniformuladora = <%=mil.fap.helpers.Constantes.Parametros.ResponsableDeLaUnidadFormuladora%>;
     Web.SIGPI.Parametro.TipoIOARR= <%=mil.fap.helpers.Constantes.Parametros.TipoIOARR%>;
     Web.SIGPI.Parametro.TipoFinanciamiento= <%=mil.fap.helpers.Constantes.Parametros.Tipofinanciamiento%>;
     Web.SIGPI.Parametro.ModalidadEjecucion= <%=mil.fap.helpers.Constantes.Parametros.ModalidadEjecucion%>;
     Web.SIGPI.Parametro.DocumentoTecnico= <%=mil.fap.helpers.Constantes.Parametros.DocumentoTecnico%>;
     Web.SIGPI.Parametro.CierreInversion= <%=mil.fap.helpers.Constantes.Parametros.CierreInversiones%>;
     Web.SIGPI.Parametro.EstadosRegistro= <%=mil.fap.helpers.Constantes.Parametros.EstadosRegistrosSeguimientoPIP_IOARR%>;
     Web.SIGPI.Parametro.PMI_Institucional= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.PMI_Institucional%>;
     Web.SIGPI.Parametro.SinRevisionPMI= <%=mil.fap.helpers.Constantes.EstadosPMI.SinRevision%>; 
     Web.SIGPI.Parametro.AprobadoPMI= <%=mil.fap.helpers.Constantes.EstadosPMI.Aprobado%>;
     Web.SIGPI.Parametro.DesaprobadoPMI= <%=mil.fap.helpers.Constantes.EstadosPMI.Desaprobado%>;
     Web.SIGPI.Parametro.RegistroIdeaInversion= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion%>;
     Web.SIGPI.Parametro.PMI_Institucional= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.PMI_Institucional%>;
     Web.SIGPI.Parametro.ComiteTrabajo= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.ComiteTrabajo%>;
     Web.SIGPI.Parametro.Perfil= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.Perfil%>;
     Web.SIGPI.Parametro.PlanTrabajoTerminosRef= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.PlanTrabajoTerminosRef%>;
     Web.SIGPI.Parametro.AprobacionIOARR= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.AprobacionIOARR%>;
     Web.SIGPI.Parametro.ExpedienteTecnicoDocEquivalente= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.ExpedienteTecnicoDocEquivalente%>;
     Web.SIGPI.Parametro.InformeConsistencia= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.InformeConsistencia%>;
     Web.SIGPI.Parametro.EjecucionFisicaFinanciera= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.EjecucionFisicaFinanciera%>;
     Web.SIGPI.Parametro.LiquidacionInversion= <%=mil.fap.helpers.Constantes.ProcesosPIP_IOARR.LiquidacionInversion%>;
     ns('Web.SIGPI.MensajeSistema')
     Web.SIGPI.MensajeSistema.Confirmacion = "<%=mil.fap.helpers.Constantes.Mensajes.MensajeConfirmacion %>";
     Web.SIGPI.MensajeSistema.TituloMensajeConfirmacion = "<%=mil.fap.helpers.Constantes.Mensajes.TituloMensajeConfirmacion %>";
     Web.SIGPI.MensajeSistema.MensajeConfirmacionCambiarEstado = "<%=mil.fap.helpers.Constantes.Mensajes.MensajeConfirmacionCambiarEstado %>";
     Web.SIGPI.MensajeSistema.MensajeConfirmacionAdjuntar = "<%=mil.fap.helpers.Constantes.Mensajes.MensajeConfirmacionAdjuntar %>";
     </script>
