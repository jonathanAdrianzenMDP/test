

package mil.fap.service.impl;

import java.util.List;
import mil.fap.dao.UnidadMedidaData;
import mil.fap.models.UnidadMedida;
import mil.fap.service.UnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("unidadMedidaservice")
public class UnidadMedidaServiceImplement implements UnidadMedidaService {

    @Autowired
    UnidadMedidaData data;

    @Override
    public List<UnidadMedida> list(Integer idbrecindi) {
        return data.list(idbrecindi);
    }

}
