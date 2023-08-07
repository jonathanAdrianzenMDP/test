


package mil.fap.service.impl;


import java.util.List;
import mil.fap.dao.ServTipologiaData;
import mil.fap.models.ServTipologia;
import mil.fap.service.ServTipologiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("servtipologiaService")
public class ServTipologiaServiceImplement implements ServTipologiaService{
      @Autowired
    ServTipologiaData data;
      
    @Override
    public List<ServTipologia> list(Integer idgrupofun) {
       return data.list(idgrupofun);
    }
    
}
 