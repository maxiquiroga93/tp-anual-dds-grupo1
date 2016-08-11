package POI;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;

import ABMC.POI_DTO;
import Geolocation.GeoLocation;
import Helpers.MetodosComunes;
import POI.FlyweightFactoryEtiqueta;
import POI.Etiqueta;
import DTOs.Banco_Converter;
import DTOs.CGP_Converter;
import POI.nodoServicio;


public abstract class POI {

	int id;
	String nombre;//1
	String callePrincipal;
	String calleLateral;
	int numeracion;//4
	int piso;
	String departamento;
	String unidad;
	int codigoPostal;
	String localidad;
	String barrio;//2
	String provincia;
	String pais;
	GeoLocation Ubicacion;
	// TipoPOI tipo;
	int comuna;
	// define cuando otro punto es cercano.
	int cercania = 500;
	// este atributo hay que ver si nos sirve porque
	// las subclases tienen el nombre del tipo, de por si.

	TiposPOI tipo;
	public ArrayList<nodoServicio> Servicios = new ArrayList<nodoServicio>();


	// pueden ser varias y se crean a travez de
	// FlyweightFactoryEtiqueta.listarEtiquetas(String etiquetas[])
	Etiqueta[] etiquetas;

	public boolean estaXMetrosDePOI(double x, POI unPOI) {
		return (distanciaCoordDosPOIs(this, unPOI) * 1000 < x);
	}

	public static double distanciaEntreDosPuntos(double lat1, double lng1, double lat2, double lng2) {
		// double radioTierra = 3958.75;//en millas
		double radioTierra = 6371;// en kil�metros
		double dLat = Math.toRadians(lat2 - lat1);
		double dLng = Math.toRadians(lng2 - lng1);
		double sindLat = Math.sin(dLat / 2);
		double sindLng = Math.sin(dLng / 2);
		double va1 = Math.pow(sindLat, 2)
				+ Math.pow(sindLng, 2) * Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2));
		double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));
		double distancia = radioTierra * va2;

		return distancia;
	}

	public static double distanciaCoordDosPOIs(POI unPOI, POI segundoPOI) {
		double lat1 = segundoPOI.Ubicacion.getLatitudeInDegrees();
		double lng1 = segundoPOI.Ubicacion.getLongitudeInDegrees();
		double lat2 = unPOI.Ubicacion.getLatitudeInDegrees();
		double lng2 = unPOI.Ubicacion.getLongitudeInDegrees();
		return distanciaEntreDosPuntos(lat1, lng1, lat2, lng2);
	}

	// Se le pregunta a un POI si es cercano.
	public boolean esCercano(POI poi) {
		double distancia = this.Ubicacion.distanceTo(poi.Ubicacion);
		int tcercania = this.getCercania();
		int retval = Double.compare(distancia, tcercania);
		if (retval > 0)
			return false;
		else
			return true;
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

	public double getLatitud() {
		return Ubicacion.getLatitudeInDegrees();
	}

	public void setLatitud(double latitud) {
		this.Ubicacion.setDegLat(latitud);
	}

	public double getLongitud() {
		return Ubicacion.getLongitudeInDegrees();
	}

	public void setLongitud(double longitud) {
		this.Ubicacion.setDegLon(longitud);
	}

	public int getComuna() {
		return comuna;
	}

	public void setComuna(int comuna) {
		this.comuna = comuna;
	}

	public int getCercania() {
		return cercania;
	}

	public void setCecania(int valor) {
		this.cercania = valor;
	}

	public POI getPOI() {
		return this;
	}

	public GeoLocation getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(GeoLocation ubicacion) {
		Ubicacion = ubicacion;
	}

	public TiposPOI getTipo() {
		return tipo;
	}

	public void setTipo(TiposPOI tipo) {
		this.tipo = tipo;
	}

	public void setCercania(int cercania) {
		this.cercania = cercania;
	}

	public void setEtiquetas(String nombres[]) {
		this.etiquetas = new Etiqueta[nombres.length];
		for (int i = 0; i < nombres.length; i++) {
			this.etiquetas[i] = FlyweightFactoryEtiqueta.getEtiqueta(nombres[i]);
		}
	}

	public String[] getEtiquetas() {
		String[] nombres = new String[etiquetas.length];
		for (int i = 0; i < etiquetas.length; i++) {
			nombres[i] = etiquetas[i].nombre;
		}
		return nombres;
	}

	public String getEtiqueta(int num) {

		return etiquetas[num].nombre;
	}

	public Boolean buscarEtiqueta(String etiquetaNombre) {

		for (int i = 0; i < etiquetas.length; i++) {
			if (etiquetaNombre == this.etiquetas[i].nombre) {
				return true;
			}
		}
		return false;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean determinarCercaniaPOI(GeoLocation ubicacion) {
		double lat1 = this.Ubicacion.getLatitudeInDegrees();
		double lng1 = this.Ubicacion.getLongitudeInDegrees();
		double lat2 = ubicacion.getLatitudeInDegrees();
		double lng2 = ubicacion.getLongitudeInDegrees();
		double distancia = distanciaEntreDosPuntos(lat1, lng1, lat2, lng2);

		return (this.cercania > distancia);
	}

	public void setDatos(POI_DTO dto) {
		this.setCallePrincipal(dto.getCallePrincipal());
		this.setCalleLateral(dto.getCalleLateral());
		this.setNumeracion(dto.getNumeracion());
		this.setPiso(dto.getPiso());
		this.setDepartamento(dto.getDepartamento());
		this.setUnidad(dto.getUnidad());
		this.setCodigoPostal(dto.getCodigoPostal());
		this.setLocalidad(dto.getLocalidad());
		this.setBarrio(dto.getBarrio());
		this.setProvincia(dto.getProvincia());
		this.setPais(dto.getPais());
		this.setComuna(dto.getComuna());
	}
	// No esta completo

	public  List<POI_DTO> buscarPOIsExternos(String url,String textoLibre1,String textoLibre2) throws JSONException, MalformedURLException, IOException{

		List<POI_DTO> listaResultado=null;
		//	int contieneBanco=url.indexOf("Consultas/banco?");
		//	int contieneCentro=url.indexOf("/Consultas/centro?");
		/*contieneCentro!=-1*/
		System.out.println(tipo.name());
		if(tipo.name()=="CGP"){
			//nombre calle o zona
			//http://trimatek.org/Consultas/centro?zona=Boedo
			//http://trimatek.org/Consultas/centro?domicilio=
			url=url+"centro?zona="+textoLibre1;
			System.out.println(url);
			listaResultado=CGP_Converter.getCGPs(url);
			if(listaResultado==null){
				url=url+"centro?domicilio="+textoLibre2;
				System.out.println(url);
				listaResultado=CGP_Converter.getCGPs(url);

			}
			
		}
		if(tipo.name()=="BANCO"){
			
			//nombre de banco y servicio
			//http://trimatek.org/Consultas/banco?banco=Santander&servicio=Pagos
			url=url+"banco?banco="+textoLibre1+"&servicio="+textoLibre2;
			System.out.println(url);
			listaResultado=Banco_Converter.getBancos(url);
		}
		
		//busqueda calle y zona
		return listaResultado;

	}

	public POI busquedaEstandar(String texto1,String texto2){

		String[] cadena = new String[2];
		cadena[0]=texto1;
		cadena[1]=texto2;

		//quedamos en que bruno hacia levenshtein y lo agregabamos aca

		for(int i=0; i<2; i++){
			if(nombre==cadena[i]){
				return this;
			}else if(callePrincipal == cadena[i]){
				return this;
			}else if(calleLateral == cadena[i]){
				return this;
			}else if(calleLateral==cadena[i]){
				return this;
			}else if(departamento == cadena[i]){
				return this;
			}else if(unidad == cadena[i]){
				return this;
			}else if(localidad == cadena[i]){
				return this;
			}else if(barrio == cadena[i]){
				return this;
			}else if(provincia == cadena[i]){
				return this;
			}else if(pais == cadena[i]){
				return this;
			}else if(MetodosComunes.isNumeric(cadena[i])){
				int valor = Integer.parseInt(cadena[i]);
				if(numeracion == valor){
					return this;
				}else if(piso == valor){
					return this;
				}else if(codigoPostal == valor){
					return this;
				}else if(comuna == valor){
					return this;
				}
			}else if(TiposPOI.BANCO.name() == cadena[i]){
				return this;
			}else if(TiposPOI.CGP.name() == cadena[i]){
				return this;
			}else if(TiposPOI.LOCAL_COMERCIAL.name() == cadena[i]){
				return this;
			}else if(TiposPOI.PARADA_COLECTIVO.name() == cadena[i]){
				return this;
			}else if(buscarEtiqueta(cadena[i])){
				return this;
			}
		}

		return null;

	}
	public POI compararServicios(String[] cadena){
		for(int i = 0; i<2;i++){
			for(nodoServicio servicio: Servicios){
				if(servicio.nombre == cadena[i]){
					return this;
				}else if(MetodosComunes.isNumeric(cadena[i])){
					int valor = Integer.parseInt(cadena[i]);
					if(servicio.horaInicio<valor && valor<servicio.horaFin){
						return this;
					}else if(servicio.listaDias.contains(valor)){
						return this;
					}
				}
			}
		}
		return null;
	}
}
