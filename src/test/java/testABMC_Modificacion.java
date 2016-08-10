import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_ABMC;
import ABMC.POI_DTO;
import POI.Rubro;
import POI.TiposPOI;

public class testABMC_Modificacion {
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
	public void bajaBanco(){
		
		boolean respuesta=poi_abmc.modificar(poiDTOBanco.getId());
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void bajaCGP(){
		boolean respuesta=poi_abmc.modificar(poiDTOCGP.getId());
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void bajaLocalComercial(){
		boolean respuesta=poi_abmc.modificar(poiDTOComercial.getId());
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void bajaParadaColectivo(){
		boolean respuesta=poi_abmc.modificar(poiDTOColectivo.getId());
		Assert.assertTrue(respuesta);
	}
}
