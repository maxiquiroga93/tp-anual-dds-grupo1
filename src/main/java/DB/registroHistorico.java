package DB;

import java.sql.Timestamp;

public class registroHistorico {

	private Timestamp time;
	private long userID;
	private String busqueda;
	private long cantResultados;
	private double tiempoDeConsulta;

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}

	public String getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(String busqueda) {
		this.busqueda = busqueda;
	}

	public long getCantResultados() {
		return cantResultados;
	}

	public void setCantResultados(long cantResultados) {
		this.cantResultados = cantResultados;
	}

	public double getTiempoDeConsulta() {
		return tiempoDeConsulta;
	}

	public void setTiempoDeConsulta(double tiempoDeConsulta) {
		this.tiempoDeConsulta = tiempoDeConsulta;
	}

}
