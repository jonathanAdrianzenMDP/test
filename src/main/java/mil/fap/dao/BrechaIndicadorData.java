/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;
import java.util.List;
import mil.fap.models.BrechaIndicador;
import mil.fap.models.helpers.DataTable;

/**
 *
 * @author jmezas
 */
public interface BrechaIndicadorData {

    public List<BrechaIndicador> listPagination(BrechaIndicador item);

    public String register(BrechaIndicador item);

    public String update(BrechaIndicador item);

    public String updateEstado(BrechaIndicador item);

    public BrechaIndicador buscarPorId(Integer idbrecindi);

    public List<BrechaIndicador> list();
}
