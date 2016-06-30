package POI;

import java.util.Calendar;

import Geolocation.GeoLocation;

public class Banco extends POI {
	
	
	public boolean disponible(String servicio){
		if(servicio == "cajero" || servicio == ""){
			return true; //el cajero automatico siempre esta disponible
						//y si no pongo nada pide que devuelva si el banco tiene algun servicio
						// disponible. Como el cajero siempre está disponible entonces es true.
		}else{
			int dia = obtenerDia(); //obtengo el nro del dia de la semana
			if((Calendar.MONDAY <= dia) && (dia <=Calendar.FRIDAY)){
				dia = 0;
				return compararHora(); //si es de lunes a viernes, comparo la hora
			}else{
				return false; //sino, falso.
			}
		}
	}
	
	public int obtenerDia(){
		 Calendar calendario = Calendar.getInstance();
		 int dia = calendario.get(Calendar.DAY_OF_WEEK);//obtengo el nro de dia de la semana
				 										//ej: lunes = 1, martes = 2, etc
		return dia;
	}
	
	public boolean compararHora(){
		int horaInicio=10;
		int horaFin=15;
		Calendar calendario = Calendar.getInstance();
		if(horaInicio <= calendario.get(Calendar.HOUR_OF_DAY) && calendario.get(Calendar.HOUR_OF_DAY) < horaFin){
			return true; //si la hora actual esta entre 10 y 15 es true 
						//leer HOUR_OF_DAY antes de tocar los operadores de comparacion (?
		}else{
			return false; //sino es false
		}
	}
	
public static POI ConstructorBanco(String nombre, double latitud, double longitud){
		
		POI poi = new Banco();
		poi.Ubicacion = GeoLocation.fromDegrees(latitud, longitud);
		poi.setNombre(nombre);
		
		return poi;
	}

	

}
