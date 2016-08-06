

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_ABMC;
import ABMC.POI_DTO;
import POI.Rubro;
import POI.TiposPOI;


public class testABMC_Alta {
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
		poiDTOBanco.setLatitud((long) 99);
		poiDTOBanco.setLongitud((long) 99);
		
		poiDTOCGP = new POI_DTO();
		poiDTOCGP.setTipo( TiposPOI.CGP);
		poiDTOCGP.setNombre("unBanco");
		poiDTOCGP.setLatitud((long) 99);
		poiDTOCGP.setLongitud((long) 99);
		poiDTOCGP.setRubro(rubro= new Rubro("unRubro"));
		
		poiDTOComercial = new POI_DTO();
		poiDTOComercial.setTipo( TiposPOI.LOCAL_COMERCIAL);
		poiDTOComercial.setNombre("unBanco");
		poiDTOComercial.setLatitud((long) 99);
		poiDTOComercial.setLongitud((long) 99);
		
		poiDTOColectivo = new POI_DTO();
		poiDTOColectivo.setTipo( TiposPOI.PARADA_COLECTIVO);
		poiDTOColectivo.setNombre("unBanco");
		poiDTOColectivo.setLatitud((long) 99);
		poiDTOColectivo.setLongitud((long) 99);
		
}
	
	@Test
	public void altaBanco(){
		
		boolean respuesta=poi_abmc.alta(poiDTOBanco);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaCGP(){
		boolean respuesta=poi_abmc.alta(poiDTOCGP);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaLocalComercial(){
		boolean respuesta=poi_abmc.alta(poiDTOComercial);
		Assert.assertTrue(respuesta);
	}
	
	@Test
	public void altaParadaColectivo(){
		boolean respuesta=poi_abmc.alta(poiDTOColectivo);
		Assert.assertTrue(respuesta);
	}
}
