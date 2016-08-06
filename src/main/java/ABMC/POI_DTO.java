package ABMC;

import java.util.ArrayList;

import Geolocation.GeoLocation;
import POI.Rubro;
import POI.TiposPOI;
import POI.nodoServicio;

public class POI_DTO {
	double id;
	String nombre;
	String callePrincipal;
	String calleLateral ;
	int numeracion;
	int piso;
	String departamento;
	String unidad;
	int codigoPostal;
	String localidad;
	String barrio;
	String provincia;
	String pais;
	GeoLocation Ubicacion;
	int comuna;
	TiposPOI tipo;
	double latitud;
	double longitud;
	Rubro rubro;
	ArrayList<Integer> dias;
	ArrayList<Integer> horas;
	ArrayList<nodoServicio> servicios;
	
	public double getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCallePrincipal() {
		return callePrincipal;
	}
	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}
	public String getCalleLateral() {
		return calleLateral;
	}
	public void setCalleLateral(String calleLateral) {
		this.calleLateral = calleLateral;
	}
	public int getNumeracion() {
		return numeracion;
	}
	public void setNumeracion(int numeracion) {
		this.numeracion = numeracion;
	}
	public int getPiso() {
		return piso;
	}
	public void setPiso(int piso) {
		this.piso = piso;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public int getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getBarrio() {
		return barrio;
	}
	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public GeoLocation getUbicacion() {
		return Ubicacion;
	}
	public void setUbicacion(GeoLocation ubicacion) {
		Ubicacion = ubicacion;
	}
	public int getComuna() {
		return comuna;
	}
	public void setComuna(int comuna) {
		this.comuna = comuna;
	}
	public TiposPOI getTipo() {
		return tipo;
	}
	public void setTipo(TiposPOI tipo) {
		this.tipo = tipo;
	}
	public double getLatitud() {
		return latitud;
	}
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	public double getLongitud() {
		return longitud;
	}
	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	public Rubro getRubro() {
		return rubro;
	}
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	public ArrayList<Integer> getDias() {
		return dias;
	}
	public void setDias(ArrayList<Integer> dias) {
		this.dias = dias;
	}
	public ArrayList<Integer> getHoras() {
		return horas;
	}
	public void setHoras(ArrayList<Integer> horas) {
		this.horas = horas;
	}
	public ArrayList<nodoServicio> getServicios() {
		return servicios;
	}
	public void setServicios(ArrayList<nodoServicio> servicios) {
		this.servicios = servicios;
	}
	
	
}
