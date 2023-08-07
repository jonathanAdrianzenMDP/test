/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.service;

import java.util.List;
import mil.fap.models.IdeasInversion;
import mil.fap.models.helpers.DataTable;

/**
 *
 * @author mnieva
 */
public interface IdeasInversionService {
    
    public DataTable<IdeasInversion> listPagination(IdeasInversion item);
}
