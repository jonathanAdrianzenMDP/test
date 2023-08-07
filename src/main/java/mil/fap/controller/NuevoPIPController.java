package mil.fap.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import mil.fap.models.BrechaIndicador;
import mil.fap.service.BrechaIndicadorService;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.Funcion;
import mil.fap.models.Grupofunc;
import mil.fap.models.IndiBrechaServicio;
import mil.fap.models.Inversion;
import mil.fap.models.NuevoPIPRequest;
import mil.fap.models.Observacion;
import mil.fap.models.ParametroValor;
import mil.fap.models.ReporteProyectoPIP;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.ServTipologia;
import mil.fap.models.TipoItem;
import mil.fap.models.Ubigeo;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.UnidadMedida;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.models.helpers.SelectItem;
import mil.fap.service.DivisionFuncionService;
import mil.fap.service.FuncionService;
import mil.fap.service.GrupofuncService;
import mil.fap.service.IndiBrechaServicioService;
import mil.fap.service.ObservacionService;
import mil.fap.service.ParametroValorService;
import mil.fap.service.ProyectoIOARRService;
import mil.fap.service.ProyectoPIPService;
import mil.fap.service.ReporteProyectoPIPService;
import mil.fap.service.SeguimientoProyService;
import mil.fap.service.ServTipologiaService;
import mil.fap.service.UbigeoService;
import mil.fap.service.UnidadMedidaService;
import mil.fap.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Jonathan
 */
@Controller
@RequestMapping("/")
public class NuevoPIPController {

    @Autowired
    BrechaIndicadorService brechaService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    UbigeoService ubigeoService;
    @Autowired
    FuncionService funcionService;
    @Autowired
    GrupofuncService grupofuncService;
    @Autowired
    DivisionFuncionService divisionFuncionService;
    @Autowired
    BrechaIndicadorService brechaIndicadorService;
    @Autowired
    ParametroValorService parametroValorService;
    @Autowired
    ProyectoPIPService proyectoPIPService;
    @Autowired
    ReporteProyectoPIPService reporteProyectoPIPService;
    @Autowired
    ObservacionService observacionService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    @Autowired
    IndiBrechaServicioService indiBrechaServicioService;
    @Autowired
    ServTipologiaService servTipologiaService;
    @Autowired
    UnidadMedidaService unidadMedidaService;
    @Autowired
    ProyectoIOARRService proyectoIOARRService;

    @RequestMapping(value = {"/nuevoPIP"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
         model.addAttribute("infoPerfil", item.getIdperfil());
        List<ParametroValor> lstTipoItem = parametroValorService.list(Constantes.Parametros.TipoItem);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstTipoItem) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstTipoItem", hashMap);

        List<ParametroValor> lstInversion = parametroValorService.list(Constantes.Parametros.Inversiones);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstInversion) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstInversion", hashMap);

        List<Funcion> lFuncion = funcionService.list();
        Map<Integer, String> funcion = new LinkedHashMap<Integer, String>();
        for (Funcion oFuncion : lFuncion) {
            funcion.put(oFuncion.getIdfuncion(), oFuncion.getDescfuncion());
        }
        model.addAttribute("funcion", funcion);

        List<Ubigeo> lUbigeo = ubigeoService.list();
        Map<String, String> ubigeo = new LinkedHashMap<String, String>();
        for (Ubigeo oUbigeo : lUbigeo) {
            ubigeo.put(oUbigeo.getCodigo(), oUbigeo.getDescri());
        }
        model.addAttribute("ubigeo", ubigeo);

        List<BrechaIndicador> lBrechaIndicador = brechaIndicadorService.list();
        Map<String, String> brecha = new LinkedHashMap<String, String>();
        for (BrechaIndicador oItem : lBrechaIndicador) {
            brecha.put(oItem.getIdbrecindi().toString(), oItem.getIndicbrech());
        }
        model.addAttribute("brecha", brecha);

        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<String, String> tipoFinanciamiento = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);

        lstResult = parametroValorService.list(Constantes.Parametros.DocumentoTecnico);
        Map<String, String> documentoTecnico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            documentoTecnico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("documentoTecnico", documentoTecnico);

        lstResult = parametroValorService.list(Constantes.Parametros.EspacioGeografico);
        Map<String, String> espacioGeografico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            espacioGeografico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("espacioGeografico", espacioGeografico);

        lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<String, String> modalidadEjecucion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        List<ParametroValor> naturalezaIntervencion = parametroValorService.list(Constantes.Parametros.naturalezaIntervencion);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : naturalezaIntervencion) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("naturalezaIntervencion", hashMap);

        lstResult = parametroValorService.list(Constantes.Parametros.TipoItem);
        Map<String, String> tipoItem = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoItem.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoItem", tipoItem);

        lstResult = parametroValorService.list(Constantes.Parametros.Inversiones);
        Map<String, String> inversion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            inversion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("inversion", inversion);

        List<ParametroValor> lstSector = parametroValorService.list(Constantes.Parametros.Sector);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstSector) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstSector", hashMap);

        List<ParametroValor> lstEntidadUnidadF = parametroValorService.list(Constantes.Parametros.EntidadUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstEntidadUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadF", hashMap);

        List<ParametroValor> lstEntidadUnidadE = parametroValorService.list(Constantes.Parametros.EntidadUnidadEjecutoraPresupuestal);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstEntidadUnidadE) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadE", hashMap);

        List<ParametroValor> lstNombreUnidadF = parametroValorService.list(Constantes.Parametros.NombreDeLaUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstNombreUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstNombreUnidadF", hashMap);

        List<ParametroValor> lstResponsableUnidadF = parametroValorService.list(Constantes.Parametros.ResponsableDeLaUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResponsableUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstResponsableUnidadF", hashMap);

        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);

        hashMap = new LinkedHashMap<String, String>();
        hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
        model.addAttribute("lstResponsableUnidadEjecutora", hashMap);

        return "nuevoPIP";
    }

    @RequestMapping(value = "/cargarUbigeoProv", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarUbigeoProv(@RequestBody SelectItem item) {
        Message msj = new Message();

        List<Ubigeo> lUbigeoProv = ubigeoService.listProv(item.getValue());

        List<SelectItem> lItemsUbigeoProv = new ArrayList();
        for (Ubigeo oUbigeo : lUbigeoProv) {
            lItemsUbigeoProv.add(
                    new SelectItem(
                            oUbigeo.getCodigo(),
                            oUbigeo.getDescri()
                    )
            );
        }
        msj.setData(lItemsUbigeoProv);

        return msj;

    }

    @RequestMapping(value = "/cargarUbigeoDist", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarUbigeoDist(@RequestBody SelectItem item) {

        Message msj = new Message();
        List<Ubigeo> lUbigeoDist = ubigeoService.listDist(item.getValue());

        List<SelectItem> lItemsUbigeoDist = new ArrayList();
        for (Ubigeo oUbigeo : lUbigeoDist) {
            lItemsUbigeoDist.add(
                    new SelectItem(
                            oUbigeo.getCodigo(),
                            oUbigeo.getDescri()
                    )
            );
        }
        msj.setData(lItemsUbigeoDist);

        return msj;

    }

    @RequestMapping(value = "/cargarDivisionFuncionPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarDivFuncionalPIP(@RequestBody SelectItem item) {
        Message msj = new Message();

        List<DivisionFuncion> lDivisionFuncion = divisionFuncionService.list(Integer.parseInt(item.getValue()));

        //map.put("controlDesplegable", lItemsDivisionFuncion);
        List<SelectItem> lItemsDivisionFuncion = new ArrayList();
        for (DivisionFuncion oDivisionFuncion : lDivisionFuncion) {
            lItemsDivisionFuncion.add(
                    new SelectItem(
                            oDivisionFuncion.getIddivfuncion().toString(),
                            oDivisionFuncion.getDescdivfuncion()
                    )
            );
        }
        msj.setData(lItemsDivisionFuncion);

        return msj;

    }

    @RequestMapping(value = "/cargarGrupoFuncionalPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarGrupoFuncional(@RequestBody SelectItem item) {

        Message msj = new Message();
        List<Grupofunc> lGrupofunc = grupofuncService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsGrupofunc = new ArrayList();
        for (Grupofunc oGrupofunc : lGrupofunc) {
            lItemsGrupofunc.add(
                    new SelectItem(
                            oGrupofunc.getIdgrupofun().toString(),
                            oGrupofunc.getDescgrupofunc()
                    )
            );
        }
        msj.setData(lItemsGrupofunc);

        return msj;

    }

    @RequestMapping(value = "/cargarServicioTipologiaPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarServicioTipologia(@RequestBody SelectItem item) {
        Message msj = new Message();
        List<ServTipologia> lServTipologia = servTipologiaService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsGrupofunc = new ArrayList();
        for (ServTipologia oServTipologia : lServTipologia) {
            lItemsGrupofunc.add(
                    new SelectItem(
                            oServTipologia.getServtipolo(),//.toString(),
                            oServTipologia.getServtipolo()
                    )
            );
        }
        msj.setData(lItemsGrupofunc);

        return msj;
    }

    @RequestMapping(value = "/cargarIndicadorBrechaServicioPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarIndicadorBrechaServicio(@RequestBody SelectItem item) {
        Message msj = new Message();
        List<IndiBrechaServicio> lIndiBrechaServicio = indiBrechaServicioService.list(item.getValue());//list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsGrupofunc = new ArrayList();
        for (IndiBrechaServicio oServTipologia : lIndiBrechaServicio) {
            lItemsGrupofunc.add(
                    new SelectItem(
                            oServTipologia.getIdbrecindi().toString(),
                            oServTipologia.getIndicbrech()
                    )
            );
        }
        msj.setData(lItemsGrupofunc);

        return msj;
    }

    @RequestMapping(value = "/cargarUnidadMedidaPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarUnidadMedidaPIP(@RequestBody SelectItem item) {
        Message msj = new Message();
        List<UnidadMedida> lUnidadMedida = unidadMedidaService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsUnidadMedida = new ArrayList();
        for (UnidadMedida oUnidadMedida : lUnidadMedida) {
            lItemsUnidadMedida.add(
                    new SelectItem(
                            oUnidadMedida.getIdbrecindi().toString(),
                            oUnidadMedida.getUnimed()
                    )
            );
        }
        msj.setData(lItemsUnidadMedida);

        return msj;
    }

    @RequestMapping(value = "/cargarTipologiaPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarTipologiaPIP(@RequestBody SelectItem item) {
        Message msj = new Message();
        List<UnidadMedida> lUnidadMedida = unidadMedidaService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsUnidadMedida = new ArrayList();
        for (UnidadMedida oUnidadMedida : lUnidadMedida) {
            lItemsUnidadMedida.add(
                    new SelectItem(
                            oUnidadMedida.getIdbrecindi().toString(),
                            oUnidadMedida.getTipologia()
                    )
            );
        }
        msj.setData(lItemsUnidadMedida);

        return msj;
    }

    @RequestMapping(value = "/capacidadProduccionPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message capacidadProduccionPIP(@RequestBody SelectItem item) {
        Message msj = new Message();
        List<UnidadMedida> lUnidadMedida = unidadMedidaService.list(Integer.parseInt(item.getValue()));
        List<SelectItem> lItemsUnidadMedida = new ArrayList();
        for (UnidadMedida oUnidadMedida : lUnidadMedida) {
            lItemsUnidadMedida.add(
                    new SelectItem(
                            oUnidadMedida.getIdbrecindi().toString(),
                            oUnidadMedida.getCapprod()
                    )
            );
        }
        msj.setData(lItemsUnidadMedida);

        return msj;
    }

    @RequestMapping(value = "/cargarParametroValorPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarParametroValor(@RequestParam("idparametro") int idparametro) {
        Message msj = new Message();
        msj.setData(parametroValorService.list(idparametro));
        return msj;
    }

    @RequestMapping(value = "/setPIP", method = RequestMethod.POST)
    public @ResponseBody
    Message set(@RequestBody NuevoPIPRequest item) {
        Message msj = new Message();
        if (item.getProyectoPIP().getIdProyepip() == 0) {
            msj = proyectoPIPService.setProyectoPIP(item);
        } else {
            item.getProyectoPIP().setEstadoactu(Constantes.EstadosPIP_IOARR.EnElaboracion);
            item.getProyectoPIP().setProcactual(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
            msj = proyectoPIPService.updateProyectoPIP(item);
        }

        return msj;
    }

    @RequestMapping(value = {"/readPIP"}, method = RequestMethod.GET)
    public String readOnlyPIP(ModelMap model, @RequestParam("id") int id) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        List<ReporteProyectoPIP> result = reporteProyectoPIPService.ReporteProyectoPIP(id);
        model.addAttribute("item", result.get(0));
        List<TipoItem> item2 = proyectoPIPService.getTipoItem(id);
        model.addAttribute("item2", item2);

        List<UnidadEjecutoraInver> item4 = proyectoIOARRService.getUnidadEjecutoraInversiones(id);
        model.addAttribute("item4", item4);

        List<Inversion> item5 = proyectoPIPService.getInversion(id);
        model.addAttribute("item5", item5);

        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<Integer, String> modalidadEjecucion = new LinkedHashMap<Integer, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(oItem.getIdparamval(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        lstResult = parametroValorService.list(Constantes.Parametros.naturalezaIntervencion);
        Map<String, String> naturalezaIntervencion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            naturalezaIntervencion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("naturalezaIntervencion", naturalezaIntervencion);

        lstResult = parametroValorService.list(Constantes.Parametros.TipoItem);
        Map<String, String> tipoItem = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoItem.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoItem", tipoItem);

        lstResult = parametroValorService.list(Constantes.Parametros.Inversiones);
        Map<String, String> inversion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            inversion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("inversion", inversion);

        lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<Integer, String> tipoFinanciamiento = new LinkedHashMap<Integer, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(oItem.getIdparamval(), oItem.getValor());
        }
        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);

        lstResult = parametroValorService.list(Constantes.Parametros.DocumentoTecnico);
        Map<String, String> documentoTecnico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            documentoTecnico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("documentoTecnico", documentoTecnico);

        lstResult = parametroValorService.list(Constantes.Parametros.EntidadUnidadFormuladora);
        Map<String, String> lstEntidadUnidadF = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            lstEntidadUnidadF.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadF", lstEntidadUnidadF);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date date = new Date();
        model.addAttribute("dateNow", dateFormat.format(date));
        return "readPIP";
    }

    @RequestMapping(value = "/enviarPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarPIP(@RequestBody NuevoPIPRequest item) {
        Message msj = new Message();
        item.getProyectoPIP().setEstadoactu(Constantes.EstadosPIP_IOARR.EnElaboracion);
        item.getProyectoPIP().setProcactual(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getProyectoPIP().getIdProyepip());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        msj = proyectoPIPService.enviarProyectoPIP(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/aprobarP01PIP", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarP01PIP(@RequestBody SeguimientoProy item) {
        Message msj;

        item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        msj = _SeguimientoProyService.setPIP(item);

        item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
        msj = _SeguimientoProyService.setPIP(item);

        return msj;
    }

    @RequestMapping(value = "/insertObservacionPIP", method = RequestMethod.POST)
    @ResponseBody
    public Message insertObservacionPIP(@RequestBody Observacion item) {
        item.setIDPROIOARR(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproyepip(item.getIDPROYEPIP());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        Message msj = observacionService.insertObservacionPIP(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/getPIP", method = RequestMethod.GET)
    public String get(@RequestParam("id") int id, ModelMap model) {
        NuevoPIPRequest result;
        result = proyectoPIPService.getProyectoPIP(id);
        model.addAttribute("item", result);

        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        List<Funcion> lFuncion = funcionService.list();
        Map<Integer, String> funcion = new LinkedHashMap<Integer, String>();
        for (Funcion oFuncion : lFuncion) {
            funcion.put(oFuncion.getIdfuncion(), oFuncion.getDescfuncion());
        }
        model.addAttribute("funcion", funcion);
        
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        seguimiento.setIdproioarr(0);
        seguimiento.setIdproyepip(id);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        
        List<ParametroValor> lstSector = parametroValorService.list(Constantes.Parametros.Sector);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstSector) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstSector", hashMap);

        List<DivisionFuncion> lDivisionFuncion = divisionFuncionService.list(result.getProyectoPIP().getIdfuncion());
        Map<Integer, String> division = new LinkedHashMap<Integer, String>();
        for (DivisionFuncion oDivisionFuncion : lDivisionFuncion) {
            division.put(oDivisionFuncion.getIddivfuncion(), oDivisionFuncion.getDescdivfuncion());
        }
        model.put("division", division);

        List<Grupofunc> lGrupofunc = grupofuncService.list(result.getProyectoPIP().getIddivfunci());
        Map<Integer, String> grupoFuncion = new LinkedHashMap<Integer, String>();
        for (Grupofunc oGrupofunc : lGrupofunc) {
            grupoFuncion.put(oGrupofunc.getIdgrupofun(), oGrupofunc.getDescgrupofunc());
        }
        model.put("grupoFuncion", grupoFuncion);

        List<Ubigeo> lUbigeo = ubigeoService.list();
        Map<String, String> ubigeo = new LinkedHashMap<String, String>();
        for (Ubigeo oUbigeo : lUbigeo) {
            ubigeo.put(oUbigeo.getCodigo(), oUbigeo.getDescri());
        }
        model.addAttribute("ubigeo", ubigeo);

        List<Ubigeo> listProvincia = ubigeoService.listProv(result.getProyectoPIP().getIdDepartamento());
        Map<String, String> provincia = new LinkedHashMap<String, String>();
        for (Ubigeo obj : listProvincia) {
            provincia.put(obj.getCodigo(), obj.getDescri());
        }
        model.addAttribute("provincia", provincia);

        List<Ubigeo> listDistrito = ubigeoService.listDist(result.getProyectoPIP().getIdProvincia());
        Map<String, String> distrito = new LinkedHashMap<String, String>();
        for (Ubigeo obj : listDistrito) {
            distrito.put(obj.getCodigo(), obj.getDescri());
        }
        model.addAttribute("distrito", distrito);

        List<ServTipologia> lServTipologia = servTipologiaService.list(result.getProyectoPIP().getIdgrupofun());
        Map<String, String> servTipologia = new LinkedHashMap<String, String>();
        for (ServTipologia oItem : lServTipologia) {
            servTipologia.put(oItem.getServtipolo(), oItem.getServtipolo());
        }
        model.addAttribute("servTipologia", servTipologia);

        List<UnidadMedida> lunidad = unidadMedidaService.list(result.getProyectoPIP().getIdbrecindi());
        Map<String, String> unidadMedida = new LinkedHashMap<String, String>();
        for (UnidadMedida oItem : lunidad) {
            unidadMedida.put(oItem.getIdbrecindi().toString(), oItem.getUnimed());
        }
        model.addAttribute("unidadMedida", unidadMedida);

        Map<String, String> tipologia = new LinkedHashMap<String, String>();
        for (UnidadMedida oItem : lunidad) {
            tipologia.put(oItem.getIdbrecindi().toString(), oItem.getTipologia());
        }
        model.addAttribute("tipologia", tipologia);

        Map<String, String> capacidad = new LinkedHashMap<String, String>();
        for (UnidadMedida oItem : lunidad) {
            capacidad.put(oItem.getIdbrecindi().toString(), oItem.getCapprod());
        }
        model.addAttribute("capacidad", capacidad);

        List<IndiBrechaServicio> lBrechaIndicador = indiBrechaServicioService.list(result.getProyectoPIP().getServpublic());
        Map<String, String> brecha = new LinkedHashMap<String, String>();
        for (IndiBrechaServicio oItem : lBrechaIndicador) {
            brecha.put(oItem.getIdbrecindi().toString(), oItem.getIndicbrech());
        }
        model.addAttribute("brecha", brecha);

        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<String, String> tipoFinanciamiento = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);

        lstResult = parametroValorService.list(Constantes.Parametros.DocumentoTecnico);
        Map<String, String> documentoTecnico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            documentoTecnico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("documentoTecnico", documentoTecnico);

        lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<String, String> modalidadEjecucion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        lstResult = parametroValorService.list(Constantes.Parametros.naturalezaIntervencion);
        Map<String, String> naturalezaIntervencion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            naturalezaIntervencion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("naturalezaIntervencion", naturalezaIntervencion);

        lstResult = parametroValorService.list(Constantes.Parametros.EspacioGeografico);
        Map<String, String> espacioGeografico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            espacioGeografico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("espacioGeografico", espacioGeografico);

        lstResult = parametroValorService.list(Constantes.Parametros.TipoItem);
        Map<String, String> tipoItem = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoItem.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoItem", tipoItem);

        lstResult = parametroValorService.list(Constantes.Parametros.Inversiones);
        Map<String, String> inversion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            inversion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("inversion", inversion);

        List<ParametroValor> lstEntidadUnidadF = parametroValorService.list(Constantes.Parametros.EntidadUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstEntidadUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadF", hashMap);

        List<ParametroValor> lstEntidadUnidadE = parametroValorService.list(Constantes.Parametros.EntidadUnidadEjecutoraPresupuestal);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstEntidadUnidadE) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadE", hashMap);

        List<ParametroValor> lstNombreUnidadF = parametroValorService.list(Constantes.Parametros.NombreDeLaUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstNombreUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstNombreUnidadF", hashMap);

        List<ParametroValor> lstResponsableUnidadF = parametroValorService.list(Constantes.Parametros.ResponsableDeLaUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResponsableUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstResponsableUnidadF", hashMap);

        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoPIPService.getUnidadEjecutoraInversiones(Constantes.Todos.value);
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : _UnidadEjecutoraInver) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);

        List<UnidadEjecutoraInver> lstResponsableUnidadEjecutora = proyectoPIPService.getUnidadEjecutoraInversiones(result.getProyectoPIP().getIdnombruei());
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : lstResponsableUnidadEjecutora) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getResponsable());
        }
        model.addAttribute("lstResponsableUnidadEjecutora", hashMap);

        List<ParametroValor> lstTipoItem = parametroValorService.list(Constantes.Parametros.TipoItem);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstTipoItem) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstTipoItem", hashMap);

        List<ParametroValor> lstInversion = parametroValorService.list(Constantes.Parametros.Inversiones);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstInversion) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstInversion", hashMap);
        return "editPIP";
    }
}
