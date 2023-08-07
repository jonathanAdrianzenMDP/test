/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mil.fap.helpers.Constantes;
import mil.fap.helpers.Format;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.DivisionFuncion;
import mil.fap.models.Funcion;
import mil.fap.models.Grupofunc;
import mil.fap.models.IndiBrechaServicio;
import mil.fap.models.NuevoIOARRRequest;
import mil.fap.models.Observacion;
import mil.fap.models.ParametroValor;
import mil.fap.models.ProyectoTipoIOARR;
import mil.fap.models.ReportePoyectoIoarr;
import mil.fap.models.SeguimientoProy;
import mil.fap.models.ServTipologia;
import mil.fap.models.Ubigeo;
import mil.fap.models.UnidadEjecutoraInver;
import mil.fap.models.UnidadMedida;
import mil.fap.models.Usuario;
import mil.fap.models.helpers.Message;
import mil.fap.models.helpers.SelectItem;
import mil.fap.service.BrechaIndicadorService;
import mil.fap.service.DivisionFuncionService;
import mil.fap.service.FuncionService;
import mil.fap.service.GrupofuncService;
import mil.fap.service.IndiBrechaServicioService;
import mil.fap.service.ObservacionService;
import mil.fap.service.ParametroValorService;
import mil.fap.service.ProyectoIOARRService;
import mil.fap.service.ReporteProyectoIoarrService;
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

@Controller
@RequestMapping("/")
public class NuevoIOARRController {

    @Autowired
    ServTipologiaService servTipologiaService;
    @Autowired
    UbigeoService ubigeoService;
    @Autowired
    IndiBrechaServicioService indiBrechaServicioService;
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
    ProyectoIOARRService proyectoIOARRService;
    @Autowired
    UsuarioService usuarioService;
    @Autowired
    ReporteProyectoIoarrService reporteProyectoIoarrService;
    @Autowired
    ObservacionService observacionService;
    @Autowired
    SeguimientoProyService _SeguimientoProyService;
    @Autowired
    UnidadMedidaService unidadMedidaService;

    @RequestMapping(value = {"/nuevoIOARR"}, method = RequestMethod.GET)
    public String index(ModelMap model) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        List<ParametroValor> lstSector = parametroValorService.list(Constantes.Parametros.Sector);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
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

        List<ParametroValor> lstNombreUnidadF = parametroValorService.list(Constantes.Parametros.NombreDeLaUnidadFormuladora);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstNombreUnidadF) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstNombreUnidadF", hashMap);

        List<ParametroValor> lstEntidadUnidadE = parametroValorService.list(Constantes.Parametros.EntidadUnidadEjecutoraPresupuestal);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstEntidadUnidadE) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstEntidadUnidadE", hashMap);

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

        List<Funcion> lFuncion = funcionService.list();
        Map<String, String> funcion = new LinkedHashMap<String, String>();
        for (Funcion oFuncion : lFuncion) {
            funcion.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            funcion.put(oFuncion.getIdfuncion().toString(), oFuncion.getDescfuncion());
        }
        model.addAttribute("funcion", funcion);

        List<Ubigeo> lUbigeo = ubigeoService.list();
        Map<String, String> ubigeo = new LinkedHashMap<String, String>();
        for (Ubigeo oUbigeo : lUbigeo) {
            ubigeo.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            ubigeo.put(oUbigeo.getCodigo(), oUbigeo.getDescri());
        }
        model.addAttribute("ubigeo", ubigeo);

        List<BrechaIndicador> lBrechaIndicador = brechaIndicadorService.list();
        Map<String, String> brecha = new LinkedHashMap<String, String>();
        for (BrechaIndicador oItem : lBrechaIndicador) {
            brecha.put(oItem.getIdbrecindi().toString(), oItem.getIndicbrech());
        }
        model.addAttribute("brecha", brecha);

        List<ParametroValor> lstTipoIOARR = parametroValorService.list(Constantes.Parametros.TipoIOARR);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstTipoIOARR) {
            hashMap.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstTipoIOARR", hashMap);

        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<String, String> tipoFinanciamiento = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            tipoFinanciamiento.put(oItem.getIdparamval().toString(), oItem.getValor());
        }

        lstResult = parametroValorService.list(Constantes.Parametros.EspacioGeografico);
        Map<String, String> espacioGeografico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            espacioGeografico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("espacioGeografico", espacioGeografico);

        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);
        lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<String, String> modalidadEjecucion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            modalidadEjecucion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        return "nuevoIOARR";
    }

    @RequestMapping(value = "/cargarUbigeoProvIOARR", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cargarResponsableUEI", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarResponsableUEI(@RequestBody SelectItem item) {

        Message msj = new Message();
        List<UnidadEjecutoraInver> _UnidadEjecutoraInver = proyectoIOARRService.getUnidadEjecutoraInversiones(Format.toInt(item.getValue()));

        List<SelectItem> lItems = new ArrayList();
        for (UnidadEjecutoraInver i : _UnidadEjecutoraInver) {
            lItems.add(
                    new SelectItem(
                            i.getIdentificador().toString(),
                            i.getResponsable()
                    )
            );
        }
        msj.setData(lItems);

        return msj;

    }

    @RequestMapping(value = "/cargarUbigeoDistIOARR", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cargarDivisionFuncionIOARR", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarDivisionFuncionIOARR(@RequestBody SelectItem item) {
        Message msj = new Message();

        List<DivisionFuncion> lDivisionFuncion = divisionFuncionService.list(Integer.parseInt(item.getValue()));
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

    @RequestMapping(value = "/cargarGrupoFuncionalIOARR", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cargarServicioTipologiaIOARR", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cargarIndicadorBrechaServicioIOARR", method = RequestMethod.POST)
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

    @RequestMapping(value = "/cargarUnidadMedidaIOARR", method = RequestMethod.POST)
    public @ResponseBody
    Message cargarUnidadMedidaIOARR(@RequestBody SelectItem item) {
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

    @RequestMapping(value = "/saveIOARR", method = RequestMethod.POST)
    public @ResponseBody
    Message saveIOARR(@RequestBody NuevoIOARRRequest item) {
        Message msj;
        if (item.getProyectoIOARR().getIdProIOARR() > 0) {
            msj = proyectoIOARRService.updateProyectoIOARR(item);
        } else {
            msj = proyectoIOARRService.setProyectoIOARR(item);
        }
        return msj;
    }

    @RequestMapping(value = {"/readIOARR"}, method = RequestMethod.GET)
    public String readOnlyIOARR(ModelMap model, @RequestParam("id") int id) {
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        List<ReportePoyectoIoarr> result = reporteProyectoIoarrService.ReportePoyectoIoarr(id);
        model.addAttribute("item", result.get(0));
        List<ProyectoTipoIOARR> item2 = proyectoIOARRService.getProyectoTipoIOARR(id);
        model.addAttribute("item2", item2);
        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<Integer, String> modalidadEjecucion = new LinkedHashMap<Integer, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(oItem.getIdparamval(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<Integer, String> tipoFinanciamiento = new LinkedHashMap<Integer, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(oItem.getIdparamval(), oItem.getValor());
        }
        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);
        return "readIOARR";
    }

    @RequestMapping(value = "/enviarIOARR", method = RequestMethod.POST)
    @ResponseBody
    public Message enviarIOARR(@RequestBody NuevoIOARRRequest item) {
        Message msj;
        item.getProyectoIOARR().setIdEstadoActual(Constantes.EstadosPIP_IOARR.EnElaboracion);
        item.getProyectoIOARR().setIdProcesoActual(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproioarr(item.getProyectoIOARR().getIdProIOARR());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.PendienteRevision);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        msj = proyectoIOARRService.enviarProyectoIOARR(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/aprobarP01IOARR", method = RequestMethod.POST)
    @ResponseBody
    public Message aprobarP01IOARR(@RequestBody SeguimientoProy item) {
        Message msj;
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.Aprobado);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        msj = _SeguimientoProyService.setIOARR(item);
        item.setEstadoproc(Constantes.EstadosPIP_IOARR.SinRegistros);
        item.setCodproceso(Constantes.ProcesosPIP_IOARR.PMI_Institucional);
        msj = _SeguimientoProyService.setIOARR(item);
        return msj;
    }

    @RequestMapping(value = "/insertObservacion", method = RequestMethod.POST)
    @ResponseBody
    public Message insert(@RequestBody Observacion item) {
        item.setIDPROYEPIP(0);
        item.setPROCACTUAL(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        SeguimientoProy seguimientoProy = new SeguimientoProy();
        seguimientoProy.setIdproioarr(item.getIDPROIOARR());
        seguimientoProy.setEstadoproc(Constantes.EstadosPIP_IOARR.ObservadoRechazado);
        seguimientoProy.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        Message msj = observacionService.insertObservacionIOARR(item, seguimientoProy);
        return msj;
    }

    @RequestMapping(value = "/getIOARR", method = RequestMethod.GET)
    public String get(@RequestParam("id") int id, ModelMap model) {
        NuevoIOARRRequest result;
        result = proyectoIOARRService.getProyectoIOARR(id);
        model.addAttribute("item", result);
        Usuario item = usuarioService.getLogin(new Usuario());
        model.addAttribute("userInfo", item);
        model.addAttribute("userInforData", item.getResumendatos());
        model.addAttribute("infoPerfil", item.getIdperfil());
        
        SeguimientoProy seguimiento = new SeguimientoProy();
        seguimiento.setCodproceso(Constantes.ProcesosPIP_IOARR.RegistroIdeaInversion);
        seguimiento.setIdproioarr(id);
        seguimiento.setIdproyepip(0);
        seguimiento = _SeguimientoProyService.getUltimoEstadoPorProceso(seguimiento);
        model.addAttribute("seguimiento", seguimiento);
        
        List<ParametroValor> lstSector = parametroValorService.list(Constantes.Parametros.Sector);
        Map<String, String> hashMap = new LinkedHashMap<String, String>();
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
            hashMap.put(oItem.getIdentificador().toString(), oItem.getDescunidad());
        }
        model.addAttribute("lstNombreUnidadEjecutora", hashMap);

        List<UnidadEjecutoraInver> lstResponsableUnidadEjecutora = proyectoIOARRService.getUnidadEjecutoraInversiones(result.getProyectoIOARR().getIdNombreUEI());
        hashMap = new LinkedHashMap<String, String>();
        for (UnidadEjecutoraInver oItem : lstResponsableUnidadEjecutora) {
            hashMap.put(oItem.getIdentificador().toString(), oItem.getResponsable());
        }
        model.addAttribute("lstResponsableUnidadEjecutora", hashMap);

        List<Funcion> lFuncion = funcionService.list();
        Map<String, String> funcion = new LinkedHashMap<String, String>();
        for (Funcion oFuncion : lFuncion) {
            funcion.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            funcion.put(oFuncion.getIdfuncion().toString(), oFuncion.getDescfuncion());
        }
        model.addAttribute("funcion", funcion);

        List<DivisionFuncion> lDivisionFuncion = divisionFuncionService.list(result.getProyectoIOARR().getIdFuncion());
        Map<String, String> division = new LinkedHashMap<String, String>();
        for (DivisionFuncion oDivisionFuncion : lDivisionFuncion) {
            division.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            division.put(oDivisionFuncion.getIddivfuncion().toString(), oDivisionFuncion.getDescdivfuncion());
        }
        model.put("division", division);

        List<Grupofunc> lGrupofunc = grupofuncService.list(result.getProyectoIOARR().getIdDivFuncion());
        Map<Integer, String> grupoFuncion = new LinkedHashMap<Integer, String>();
        for (Grupofunc oGrupofunc : lGrupofunc) {
            grupoFuncion.put(oGrupofunc.getIdgrupofun(), oGrupofunc.getDescgrupofunc());
        }
        model.put("grupoFuncion", grupoFuncion);

        List<Ubigeo> lUbigeo = ubigeoService.list();
        Map<String, String> ubigeo = new LinkedHashMap<String, String>();
        for (Ubigeo oUbigeo : lUbigeo) {
            ubigeo.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            ubigeo.put(oUbigeo.getCodigo(), oUbigeo.getDescri());
        }
        model.addAttribute("ubigeo", ubigeo);

        List<Ubigeo> listProvincia = ubigeoService.listProv(result.getProyectoIOARR().getIdDepartamento());
        Map<String, String> provincia = new LinkedHashMap<String, String>();
        for (Ubigeo obj : listProvincia) {
            provincia.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            provincia.put(obj.getCodigo(), obj.getDescri());
        }
        model.addAttribute("provincia", provincia);

        List<Ubigeo> listDistrito = ubigeoService.listDist(result.getProyectoIOARR().getIdProvincia());
        Map<String, String> distrito = new LinkedHashMap<String, String>();
        for (Ubigeo obj : listDistrito) {
            distrito.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            distrito.put(obj.getCodigo(), obj.getDescri());
        }
        model.addAttribute("distrito", distrito);

        List<ServTipologia> lServTipologia = servTipologiaService.list(result.getProyectoIOARR().getIdGrupoFuncion());
        Map<String, String> servTipologia = new LinkedHashMap<String, String>();
        for (ServTipologia oItem : lServTipologia) {
            servTipologia.put(oItem.getServtipolo(), oItem.getServtipolo());
        }
        model.addAttribute("servTipologia", servTipologia);

        List<IndiBrechaServicio> lBrechaIndicador = indiBrechaServicioService.list(result.getProyectoIOARR().getServicioPulico());
        Map<String, String> brecha = new LinkedHashMap<String, String>();
        for (IndiBrechaServicio oItem : lBrechaIndicador) {
            brecha.put(oItem.getIdbrecindi().toString(), oItem.getIndicbrech());
        }
        model.addAttribute("brecha", brecha);

        List<ParametroValor> lstTipoIOARR = parametroValorService.list(Constantes.Parametros.TipoIOARR);
        hashMap = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstTipoIOARR) {
            hashMap.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("lstTipoIOARR", hashMap);

        List<ParametroValor> lstResult = parametroValorService.list(Constantes.Parametros.Tipofinanciamiento);
        Map<String, String> tipoFinanciamiento = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            tipoFinanciamiento.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            tipoFinanciamiento.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("tipoFinanciamiento", tipoFinanciamiento);

        List<UnidadMedida> lunidad = unidadMedidaService.list(result.getProyectoIOARR().getIdBrechaIndicador());
        Map<String, String> unidadMedida = new LinkedHashMap<String, String>();
        for (UnidadMedida oItem : lunidad) {
            unidadMedida.put(oItem.getIdbrecindi().toString(), oItem.getUnimed());
        }
        model.addAttribute("unidadMedida", unidadMedida);

        lstResult = parametroValorService.list(Constantes.Parametros.ModalidadEjecucion);
        Map<String, String> modalidadEjecucion = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            modalidadEjecucion.put(Constantes.Seleccione.value, Constantes.Seleccione.text);
            modalidadEjecucion.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("modalidadEjecucion", modalidadEjecucion);

        lstResult = parametroValorService.list(Constantes.Parametros.EspacioGeografico);
        Map<String, String> espacioGeografico = new LinkedHashMap<String, String>();
        for (ParametroValor oItem : lstResult) {
            espacioGeografico.put(oItem.getIdparamval().toString(), oItem.getValor());
        }
        model.addAttribute("espacioGeografico", espacioGeografico);

        return "editIOARR";
    }
}
