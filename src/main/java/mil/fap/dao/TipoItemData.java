/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.TipoItem;

/**
 *
 * @author mnieva
 */
public interface TipoItemData {
    
        public Integer set(TipoItem item);  
        public Integer update(TipoItem item);
        public List<TipoItem> list(Integer idproyepip);
}
