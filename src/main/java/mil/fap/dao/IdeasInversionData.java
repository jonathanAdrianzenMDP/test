/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.IdeasInversion;
import mil.fap.models.helpers.DataTable;

/**
 *
 * @author mnieva
 */
public interface IdeasInversionData {

    public DataTable<IdeasInversion> listPagination(IdeasInversion item);

}
