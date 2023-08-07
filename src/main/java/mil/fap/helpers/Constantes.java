/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.helpers;

/**
 *
 * @author Jonathan
 */
public class Constantes {

    public static class App {

        public final static String sistema = "SISTEMA DE GESTIÓN DE INVERSIONES FAP";
        public final static String sigla = "SIGIN";
        public final static String version = "v0.4";
    }

    public static class Parametros {

        public final static int AnioActualHaciaAtras = 3;

        public final static int Sector = 2;
        public final static int EntidadUnidadFormuladora = 4;
        public final static int EntidadUnidadEjecutoraPresupuestal = 10;
        public final static int NombreDeLaUnidadFormuladora = 6;
        public final static int ResponsableDeLaUnidadFormuladora = 7;
        public final static int TipoIOARR = 12;
        public final static int ProcesosProyectosInversionPIP_IOARR = 14;
        public final static int EstadosRegistrosSeguimientoPIP_IOARR = 15;
        public final static int DocumentoTecnico = 16;
        public final static int Tipofinanciamiento = 17;
        public final static int ModalidadEjecucion = 18;
        public final static int TipoItem = 19;
        public final static int Inversiones = 20;
        public final static int naturalezaIntervencion = 21;
        public final static int EspacioGeografico = 22;
        public final static int CierreInversiones = 23;
        public final static int URL = 25;

    }

    public static class BDContext {

        public final static String Schema = "SIGPIFA";
        public final static String PKG_BrechasIndicadores = "PKG_BRECHASINDICADORES";
        public final static String PKG_ADMINISTRACION = "PKG_ADMINISTRACION";
        public final static String PKG_EJECUCION = "PKG_EJECUCION";
        public final static String PKG_FORMULACIONYEVALUACION = "PKG_FORMULACIONYEVALUACION";
        public final static String PKG_PMI = "PKG_PMI";
        public final static String PKG_REPORTE = "PKG_REPORTE";

    }

    public static class TipoInversion {

        public final static String PIP = "PIP";
        public final static String IOARR = "IOARR";
        public final static String nombrePIP = "PROYECTO DE INVERSION";
        public final static String nombreIOARR = "INVERSION";
        public final static int idPIP = 1;
        public final static int idIOARR = 2;
    }

    public static class Todos {

        public final static int value = 0;
        public final static String text = "Todos";

    }

    public static class Seleccione {

        public final static String value = "-1";
        public final static String text = "-- Seleccione --";

    }

    public static class EstadosPIP_IOARR {

        public final static int SinRegistros = 72;
        public final static int EnElaboracion = 41;
        public final static int PendienteRevision = 42;
        public final static int Aprobado = 43;
        public final static int ObservadoRechazado = 44;
    }

    public static class EstadosPMI {

        public final static int SinRevision = 0;
        public final static int Aprobado = 1;
        public final static int Desaprobado = 2;
    }

    public static class ProcesosPIP_IOARR {

        public final static int RegistroIdeaInversion = 58;
        public final static int PMI_Institucional = 59;
        public final static int AprobacionIOARR = 60;
        public final static int ComiteTrabajo = 61;
        public final static int PlanTrabajoTerminosRef = 62;
        public final static int Perfil = 63;
        public final static int ExpedienteTecnicoDocEquivalente = 64;
        public final static int InformeConsistencia = 65;
        public final static int EjecucionFisicaFinanciera = 66;
        public final static int LiquidacionInversion = 67;
    }

    public static class EstadoRegistro {

        public final static String EstadoActivo = "1";
        public final static String EstadoInActivo = "0";
    }

    public static class Mensajes {

        public final static String typeSuccess = "S";
        public final static String typeError = "E";
        public final static String ErrorExcepcion = "-1";
        public final static String MensajeErrorExcepcion = "danger|Ocurrió un error en el Sistema.";
        public final static String MensajeConfirmacion = "Está seguro de guardar los datos?";
        public final static String MensajeGuardarExito = "success|Los datos se guardaron con Éxito.";
        public final static String MensajeModificoEstado = "success|El Estado se Modifico Correctamente.";
        public final static String TituloMensajeConfirmacion = "Mensaje de Confirmación";
        public final static String MensajeFileUploadExito = "success|Se subió el archivo con Éxito.";
        public final static String MensajeCambiarEstado = "success|El registro fue desactivado correctamente";
        public final static String MensajeCambiarEstadoActivo = "success|El registro fue activado correctamente";
        public final static String MensajeConfirmacionCambiarEstado = "Está seguro de eliminar el registro?";
        public final static String MensajeConfirmacionAdjuntar = "Está seguro de adjuntar el archivo?";
        public final static String MensajeUsuarioDuplicado = "danger|El usuario se encuentra registrado";
        public final static String MensajeUsuarioNoEncontrado = "danger|Usuario invalido";

    }

    public static class PerfilUsuario {

        public final static String UNIDAD_PRESTADORA_DE_SERVICIO_FAP = "UNIDAD_FAP";
        public final static String PMI = "PMI";
        public final static String FORMULADOR = "FORMULADOR";
        public final static String EJECUCION_EMGRA = "EJECUTOR";
        public final static String SUPERVISOR = "SUPERVISOR";
        public final static String COMITE_TRABAJO = "COMITE_TRABAJO";
        public final static String UNIDAD_EJECUTORA = "UNIDAD_EJECUTORA";
        public final static String ADMINISTRADOR = "ADMINISTRADOR";
    }
}
