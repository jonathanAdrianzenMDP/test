package mil.fap.models.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Fabi�n P�rez V�squez
 *
 * @param <T> Clase que heredar� para poder tomar sus atributos y verlos en la vista del cliente
 */

public class DataTable<T> {

	/**
	 * N�mero de registros totales que existen en la tabla
	 */
	private Integer iTotalDisplayRecords;
	/**
	 * N�mero de registro visualiz�ndose en la tabla
	 */
	private Integer iDisplayRecords;
	/**
	 * Datos visualiz�ndose en la tabla
	 */
	private List<T> aaData;
	
	public DataTable() {
            iDisplayRecords = 0;
            iTotalDisplayRecords = 0;
            aaData = new ArrayList<>();
	}
	
	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}
	
	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}
	
	public Integer getiDisplayRecords() {
		return iDisplayRecords;
	}
	
	public void setiDisplayRecords(Integer iDisplayRecords) {
		this.iDisplayRecords = iDisplayRecords;
	}
	
	public List<T> getAaData() {
		return aaData;
	}
	
	public void setAaData(List<T> aaData) {
		this.aaData = aaData;
	}
	
}