
package mil.fap.service.impl;

import java.util.List;
import mil.fap.models.helpers.Message;
import mil.fap.dao.GrupofuncData;
import mil.fap.models.Grupofunc;
import mil.fap.models.helpers.DataTable;
import mil.fap.service.GrupofuncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service ("grupofuncService")
public class GrupofuncServiceImplement implements GrupofuncService{

    @Autowired
    GrupofuncData data;
    
    @Override
    public DataTable<Grupofunc> paginar(Grupofunc item) {
        return data.paginar(item);
    }

    @Override
    public Message cambiarEstado(Integer idgrupofun) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String insertar(Grupofunc Grupofunc) {
       return data.insertar(Grupofunc);
    }

    @Override
    public String actualizar(Grupofunc grupofunc) {
       return data.actualizar(grupofunc);
    }

    @Override
    public Grupofunc buscarPorId(Integer idgrupofun) {
       return data.buscarPorId(idgrupofun);
    }

    @Override
    public List<Grupofunc> list(Integer iddivfuncion) {
       return data.list(iddivfuncion);
    }
    
}
