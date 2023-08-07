package mil.fap.service;

import java.util.List;
import mil.fap.models.helpers.Message;
import mil.fap.models.Grupofunc;
import mil.fap.models.helpers.DataTable;

public interface GrupofuncService {
    
    public List<Grupofunc> list(Integer iddivfuncion);
    
    public DataTable<Grupofunc> paginar(Grupofunc item);
    
    public Message cambiarEstado(Integer idgrupofun);
    
    public String insertar(Grupofunc Grupofunc);
    
    public String actualizar(Grupofunc grupofunc);
    
    public Grupofunc buscarPorId(Integer idgrupofun);
    
}
