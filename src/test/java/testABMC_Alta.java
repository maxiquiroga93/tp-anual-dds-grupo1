

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import ABMC.POI_ABMC;
import ABMC.POI_DTO;
import POI.Rubro;
import POI.TiposPOI;


public class testABMC_Alta {
	POI_ABMC abmc = new POI_ABMC();
	POI_ABMC poi_abmc;
	List<POI> poiList;
	POI_DTO poiDTOBanco; 
	POI_DTO poiDTOCGP;
	POI_DTO poiDTOComercial;
	POI_DTO poiDTOColectivo;
	Rubro rubro;
	DB_Server unServer;
	DB_Server instancia;
	
	@Before
	public void init(){
		poi_abmc =new POI_ABMC();
		poiList = new ArrayList<POI>();
		unServer = new DB_Server();
		instancia = unServer.getInstance();
		
		poiDTOBanco = new POI_DTO();		
		poiDTOBanco.setTipo(TiposPOI.BANCO);
		poiDTOBanco.setNombre("unBancoJorge!");
		poiDTOBanco.setLatitud((long) 99);
		poiDTOBanco.setLongitud((long) 99);
		
		poiDTOCGP = new POI_DTO();
		poiDTOCGP.setTipo( TiposPOI.CGP);
		poiDTOCGP.setNombre("unCGP");
		poiDTOCGP.setLatitud((long) 99);
		poiDTOCGP.setLongitud((long) 99);
		poiDTOCGP.setRubro(rubro= new Rubro("unRubro"));
		
		poiDTOComercial = new POI_DTO();
		poiDTOComercial.setTipo( TiposPOI.LOCAL_COMERCIAL);
		poiDTOComercial.setNombre("unLocalComercial");
		poiDTOComercial.setLatitud((long) 99);
		poiDTOComercial.setLongitud((long) 99);
		
		poiDTOColectivo = new POI_DTO();
		poiDTOColectivo.setTipo( TiposPOI.PARADA_COLECTIVO);
		poiDTOColectivo.setNombre("unaParadaDeColectivo");
		poiDTOColectivo.setLatitud((long) 99);
		poiDTOColectivo.setLongitud((long) 99);
	}
	
	@Test
	public void altaBanco(){
		//Agregar conversion de DTO_POI a POI
		boolean resultado = instancia.agregarPOI(poiDTOBanco);
		
		int tamanio = poiList.size(unServer.getInstance());
		nombreTest = poiList.get(DB_Server.getListado() .size()-1).getNombre();
		Assert.assertTrue(poiDTOBanco.getNombre() == poiList.get(poiList.size()-1).getNombre());
		
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
