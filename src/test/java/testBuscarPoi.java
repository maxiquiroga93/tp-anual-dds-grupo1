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
		POI localTres = LocalComercial.ConstructorLocalComercial("localTres", -34.5658341, -58.43519549999996, unRubro);
		POI pColUno = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColDos = ParadaColectivo.ConstructorParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColTres = ParadaColectivo.ConstructorParadaColectivo("107",-34.5658341, -58.43519549999996);
		POI pColCuatro = ParadaColectivo.ConstructorParadaColectivo("35",-34.5658341, -58.43519549999996);
		
		cgpUno.setTipo("CGP");
		cgpDos.setTipo("CGP");
		localUno.setTipo("LocalComercial");
		localDos.setTipo("LocalComercial");
		localTres.setTipo("LocalComercial");
		pColUno.setTipo("ParadaColectivo");
		pColDos.setTipo("ParadaColectivo");
		pColTres.setTipo("ParadaColectivo");
		pColCuatro.setTipo("ParadaColectivo");
		
		String[] listaEtiquetaNombres1={"a","b","c"};
		String[] listaEtiquetaNombres2={"a","e"};
		String[] listaEtiquetaNombres3={"d"};
		cgpUno.setEtiquetas(listaEtiquetaNombres1);
		cgpDos.setEtiquetas(listaEtiquetaNombres1);
		localUno.setEtiquetas(listaEtiquetaNombres1);
		localDos.setEtiquetas(listaEtiquetaNombres2);
		localTres.setEtiquetas(listaEtiquetaNombres2);
		pColUno.setEtiquetas(listaEtiquetaNombres2);
		pColDos.setEtiquetas(listaEtiquetaNombres2);
		pColTres.setEtiquetas(listaEtiquetaNombres2);
		pColCuatro.setEtiquetas(listaEtiquetaNombres3);
		
		server.getListado().add(cgpUno);
		server.getListado().add(cgpDos);
		server.getListado().add(localUno);
		server.getListado().add(localDos);
		server.getListado().add(localTres);
		server.getListado().add(pColUno);
		server.getListado().add(pColDos); 
		server.getListado().add(pColTres); 
		server.getListado().add(pColCuatro); 
	}
	
	@Test
	public void testBuscarColectivo(){
		String linea = "114";
		Assert.assertNotNull(poiController.getPOIs(linea));
		Assert.assertTrue(poiController.getPOIs(linea).size() == 2);
	}
	
	@Test
	public void testBuscarPorRubro(){
		String rubro = "unRubro";
		Assert.assertNotNull(poiController.getPOIs(rubro));
		Assert.assertTrue(poiController.getPOIs(rubro).size() == 3);
	}
	@Test
	public void testBuscarPorEtiquetaNombre(){
		String etiquetaNombre = "a";
		Assert.assertNotNull(poiController.getPOIs(etiquetaNombre));
		Assert.assertTrue(poiController.getPOIs(etiquetaNombre).size() == 8);
	}
	

	@Test
	public void testBuscarPorServicio(){
		String servicio = "servicio";
		Assert.assertNotNull(poiController.getPOIs(servicio));
	}
}
