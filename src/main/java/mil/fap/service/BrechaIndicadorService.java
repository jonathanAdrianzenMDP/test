package mil.fap.service;

import java.util.List;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.BrechaIndicadorRequest;
import mil.fap.models.helpers.Message;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jmezas
 */
public interface BrechaIndicadorService {

    public List<BrechaIndicador> listPagination(BrechaIndicador item);
    
    public String register(BrechaIndicadorRequest item);

    public Message update(BrechaIndicador item);
    
    public String updateEstado(BrechaIndicador item);

    public BrechaIndicador buscarPorId(Integer idbrecindi);
    
    public List<BrechaIndicador> list(); 

}