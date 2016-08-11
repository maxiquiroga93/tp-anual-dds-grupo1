package POI;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;

import ABMC.POI_DTO;
import Geolocation.GeoLocation;
import Helpers.MetodosComunes;

public class LocalComercial extends POI {

	Rubro rubro; 
	public ArrayList<Integer> dias = new ArrayList<Integer>();
	public ArrayList<Integer> horas = new ArrayList<Integer>();
	
	public int getDistancia() {
		return rubro.getCercania();
	}
	
	public LocalComercial(String nombre, double latitud, double longitud, Rubro rubro){
		this.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		this.setNombre(nombre);
		this.setRubro(rubro);
	}
	
	public Rubro getRubro() {
		return rubro;
	}
	
	public void setRubro(Rubro rubro) {
		this.rubro = rubro;
	}
	
	public ArrayList<Integer> getDias(){
		return this.dias;
	}

	public ArrayList<Integer> getHoras(){
		return this.horas;
	}
	
	public void setDias(ArrayList<Integer> diasDisponibles){
		this.dias = diasDisponibles;
	}

	public void setHoras(ArrayList<Integer> horasDisponibles){
		this.horas = horasDisponibles;
	}
	
	public boolean disponible(){
		Calendar calendario = Calendar.getInstance();
		Iterator<Integer> iteradorDias = dias.iterator(); //obtengo los dias
		while(iteradorDias.hasNext()){ //recorro los dias
			int dia = iteradorDias.next(); //elijo un dia en particular
			if(calendario.get(Calendar.DAY_OF_WEEK) == dia){ //comparo si el dia de hoy es ese dia
				Iterator<Integer> iteradorHoras = horas.iterator(); //obtengo las horas
				while(iteradorHoras.hasNext()){ //recorro las horas
					int hora = iteradorHoras.next(); //elijo una hora en particular 
					if(calendario.get(Calendar.HOUR_OF_DAY) == hora){ //comparo si la hora de ahora es esa hora
						return true;
					} //sino paso a la siguiente hora
				}//sino paso al siguiente dia
			}
		}//sino es falso
		return false;
		
	}
	
	public void setDatos(POI_DTO dto,boolean esNuevo){
		super.setDatos(dto);
		this.setDias(dto.getDias());
		this.setHoras(dto.getHoras());
		
		if(!esNuevo){
			this.setRubro(dto.getRubro());
		}
	}
	
	public LocalComercial busqueda(String texto1, String texto2){
		 if(busquedaEstandar(texto1,texto2)!= null){
			 return this;
		 }
		
		String[] cadena = new String[2];
		for(int i=0; i<2;i++){
			if(rubro.getNombre()==cadena[i]){
				return this;
			}else{
				if(MetodosComunes.isNumeric(cadena[i])){
					Integer valor = Integer.parseInt(cadena[i]);
					if(dias.contains(valor)){
						return this;
					}else if(horas.contains(valor)){
						return this;
					}
				}
			}
		}
		return null;
	}
	
	
}