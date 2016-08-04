package ABMC;

import DB.DB_Server;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.TiposPOI;

public class POI_ABMC {
	
	public boolean alta(POI_DTO dto){
		POI nuevoPOI = null;
		
		if(dto.getTipo().equals(TiposPOI.CGP)){
			nuevoPOI = new CGP(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
			((CGP)nuevoPOI).setDatos(dto);
		}
		else if (dto.getTipo().equals(TiposPOI.LOCAL_COMERCIAL)){
			nuevoPOI = new LocalComercial(dto.getNombre(), dto.getLatitud(), dto.getLongitud(), dto.getRubro());
			((LocalComercial)nuevoPOI).setDatos(dto, true);
		}
		else if (dto.getTipo().equals(TiposPOI.BANCO)){
			nuevoPOI = new Banco(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		}
		else if (dto.getTipo().equals(TiposPOI.PARADA_COLECTIVO)){
			nuevoPOI = new ParadaColectivo(dto.getNombre(), dto.getLatitud(), dto.getLongitud());
		} 
		
		if(nuevoPOI.equals(null)){
			return false;
		} else {
			DB_Server.agregarPOI(nuevoPOI);
			return true;
		}
	}
	
	public boolean delete(POI_DTO dto){
		if(DB_Server.getPOIbyId(dto.getId()) != null){
			return DB_Server.eliminarPOI(dto.getId());
		}
		else 
			return false;
	}
	
	public boolean modificar(POI_DTO dto){
		POI poi = null;
		poi = DB_Server.getPOIbyId(dto.getId());
		if(poi != null){
			poi.setDatos(dto);
		}
		return false;
	}
	
	
	
	
}
