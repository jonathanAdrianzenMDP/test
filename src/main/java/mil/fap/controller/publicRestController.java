/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.controller;

import java.util.List;
import mil.fap.models.IdeasInversion;
import mil.fap.models.Pagination;
import mil.fap.models.UnidadServicio;
import mil.fap.models.helpers.DataTable;
import mil.fap.service.IdeasInversionService;
import mil.fap.service.UnidadServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jadrianzen
 */
@RestController
public class publicRestController {
    @Autowired
    UnidadServicioService UnidadServicioService;
    @Autowired
    IdeasInversionService ideasInversionService;
    
    @RequestMapping(value = "/api/user/", method = RequestMethod.GET)
  public ResponseEntity<List<UnidadServicio>> all() {
     List<UnidadServicio> lst =  UnidadServicioService.listaUnidadServicio();
     return new ResponseEntity<List<UnidadServicio>>(lst, HttpStatus.OK);
  }
  
  @RequestMapping(value = "/api/inversiones/", method = RequestMethod.GET)
    public ResponseEntity<DataTable<IdeasInversion>> buscarIdeasInversion() {
    IdeasInversion item = new IdeasInversion();
        item.setAnio("2019");
        item.setSigla("0");
        item.setTipo("0");
        item.setEstado_registro("0");
        Pagination pageInfo = new Pagination();
        pageInfo.setiEnd(0);
        pageInfo.setiFilteredTotal(0);
        pageInfo.setiLength(10);
        pageInfo.setiPage(0);
        pageInfo.setiStart(0);
        pageInfo.setiTotal(0);
        pageInfo.setiTotalPages(0);
        item.setPageInfo(pageInfo);
        DataTable<IdeasInversion> oData = ideasInversionService.listPagination(item);
        return new ResponseEntity<DataTable<IdeasInversion>>(oData, HttpStatus.OK);

    }
}
