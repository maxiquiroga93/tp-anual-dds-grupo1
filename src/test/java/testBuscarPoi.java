import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DB.DB_Server;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.POIcontroller;
import POI.ParadaColectivo;
import POI.Rubro;

public class testBuscarPoi {
	private POIcontroller poiController;
	private DB_Server server;
	@Before
	public void init(){
		poiController = new POIcontroller();
		server = new DB_Server();
		
		Rubro unRubro = new Rubro("unRubro");
		POI cgpUno = CGP.ConstructorCGP("cgpUno",-34.5664823, -58.43407810000002);
		POI cgpDos = CGP.ConstructorCGP("cgpDos",-34.5658341, -58.43519549999996);
		POI localUno = LocalComercial.ConstructorLocalComercial("localUno", -34.5658341, -58.43519549999996, unRubro);
		POI localDos = LocalComercial.ConstructorLocalComercial("localDos", -34.5658341, -58.43519549999996, unRubro);
		POI pColUno = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColDos = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColTres = ParadaColectivo.ConstructorParadaColectivo("107",-34.5658341, -58.43519549999996);
		POI pColCuatro = ParadaColectivo.ConstructorParadaColectivo("35",-34.5658341, -58.43519549999996);
		
		cgpUno.setTipo("CGP");
		cgpDos.setTipo("CGP");
		localUno.setTipo("LocalComercial");
		localDos.setTipo("LocalComercial");
		pColUno.setTipo("ParadaColectivo");
		pColDos.setTipo("ParadaColectivo");
		pColTres.setTipo("ParadaColectivo");
		pColCuatro.setTipo("ParadaColectivo");
		
		server.getListado().add(cgpUno);
		server.getListado().add(cgpDos);
		server.getListado().add(localUno);
		server.getListado().add(localDos); 
		server.getListado().add(pColUno);
		server.getListado().add(pColDos); 
		server.getListado().add(pColTres); 
		server.getListado().add(pColCuatro); 
	}
	
	@Test
	public void testBuscarColectivo(){
		String linea = "114";
		Assert.assertNotNull(poiController.getPOIs(linea));
	}
	
	@Test
	public void testBuscarPorRubro(){
		String linea = "unRubro";
		Assert.assertNotNull(poiController.getPOIs(linea));
	}
}
