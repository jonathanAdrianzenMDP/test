/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mil.fap.dao;

import java.util.List;
import mil.fap.models.Inversion;

/**
 *
 * @author nlarico
 */
public interface InversionData {

    public List<Inversion> list(Integer idproyepip);

    public Integer set(Inversion item);

    public Integer update(Inversion item);

}
