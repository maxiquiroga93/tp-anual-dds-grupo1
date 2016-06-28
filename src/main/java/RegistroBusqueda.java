import java.sql.Time;

public class RegistroBusqueda {

	String datosdeBusqueda;
	int ID_terminal;
	Time TimestampBusqueda;
	public String getDatosdeBusqueda() {
		return datosdeBusqueda;
	}
	public void setDatosdeBusqueda(String datosdeBusqueda) {
		this.datosdeBusqueda = datosdeBusqueda;
	}
	public int getID_terminal() {
		return ID_terminal;
	}
	public void setID_terminal(int iD_terminal) {
		ID_terminal = iD_terminal;
	}
	public Time getTimestampBusqueda() {
		return TimestampBusqueda;
	}
	public void setTimestampBusqueda(Time timestampBusqueda) {
		TimestampBusqueda = timestampBusqueda;
	}
	
	
}

