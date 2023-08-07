

package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.IndiBrechaServicioData;
import mil.fap.models.IndiBrechaServicio;
import mil.fap.service.IndiBrechaServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("indibrechaservicioservice")
public class IndiBrechaServicioServiceImplement implements IndiBrechaServicioService {

    @Autowired
    IndiBrechaServicioData data;

    @Override
    public List<IndiBrechaServicio> list(String servtipolo) {
        return data.list(servtipolo);
    }

}
