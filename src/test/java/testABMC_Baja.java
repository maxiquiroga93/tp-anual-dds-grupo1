import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_ABMC;
import ABMC.POI_DTO;
import POI.Rubro;
import POI.TiposPOI;

public class testABMC_Baja {
	POI_ABMC poi_abmc;
	POI_DTO poiDTOBanco; 
	POI_DTO poiDTOCGP;
	POI_DTO poiDTOComercial;
	POI_DTO poiDTOColectivo;
	Rubro rubro;
	
	@Before
	public void init(){
		
		poi_abmc =new POI_ABMC();
		
		poiDTOBanco = new POI_DTO();		
		poiDTOBanco.setTipo( TiposPOI.BANCO);
		poiDTOBanco.setNombre("unBanco");
		poiDTOBanco.setLatitud(-34.5664823);
		poiDTOBanco.setLongitud(-34.5664823);
		
		poiDTOCGP = new POI_DTO();
		poiDTOCGP.setTipo( TiposPOI.CGP);
		poiDTOCGP.setNombre("unBanco");
		poiDTOCGP.setLatitud(-34.5664823);
		poiDTOCGP.setLongitud(-34.5664823);
		poiDTOCGP.setRubro(rubro= new Rubro("unRubro"));
		
		poiDTOComercial = new POI_DTO();
		poiDTOComercial.setTipo( TiposPOI.LOCAL_COMERCIAL);
		poiDTOComercial.setNombre("unBanco");
		poiDTOComercial.setLatitud(-34.5664823);
		poiDTOComercial.setLongitud(-34.5664823);
		
		poiDTOColectivo = new POI_DTO();
		poiDTOColectivo.setTipo( TiposPOI.PARADA_COLECTIVO);
		poiDTOColectivo.setNombre("unBanco");
		poiDTOColectivo.setLatitud(-34.5664823);
		poiDTOColectivo.setLongitud(-34.5664823);
		poi_abmc.alta(poiDTOBanco);
		poi_abmc.alta(poiDTOCGP);
		poi_abmc.alta(poiDTOComercial);
		poi_abmc.alta(poiDTOColectivo);
}
	
	@Test
	public void altaBanco(){
		
		boolean respuesta=poi_abmc.delete(poiDTOBanco);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaCGP(){
		boolean respuesta=poi_abmc.delete(poiDTOCGP);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaLocalComercial(){
		boolean respuesta=poi_abmc.delete(poiDTOComercial);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaParadaColectivo(){
		boolean respuesta=poi_abmc.delete(poiDTOColectivo);
		Assert.assertTrue(respuesta);
	}
}
