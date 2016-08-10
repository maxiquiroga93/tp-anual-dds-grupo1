import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DB.DB_Server;
import POI.CGP;
import POI.Banco;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.Rubro;
import POI.TiposPOI;
import userInterface.Buscador;


public class testBuscarPoi {
	private Buscador poiController;
	private DB_Server server;
	@SuppressWarnings("static-access")
	@Before
	public void init() throws JSONException, MalformedURLException, IOException{
		poiController = new Buscador();
		server = new DB_Server();
		
		Rubro unRubro = new Rubro("unRubro");
		POI cgpUno = new CGP("cgpUno",-34.5664823, -58.43407810000002);
		POI cgpDos = new CGP("cgpDos",-34.5658341, -58.43519549999996);
		POI localUno = new LocalComercial("localUno", -34.5658341, -58.43519549999996, unRubro);
		POI localDos = new LocalComercial("localDos", -34.5658341, -58.43519549999996, unRubro);
		POI localTres = new LocalComercial("localTres", -34.5658341, -58.43519549999996, unRubro);
		POI pColUno = new ParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColDos = new ParadaColectivo("114",-34.5658341, -58.43519549999996);
		POI pColTres = new ParadaColectivo("107",-34.5658341, -58.43519549999996);
		POI pColCuatro = new ParadaColectivo("35",-34.5658341, -58.43519549999996);
		
		cgpUno.setTipo(TiposPOI.CGP);
		cgpDos.setTipo(TiposPOI.CGP);
		localUno.setTipo(TiposPOI.LOCAL_COMERCIAL);
		localDos.setTipo(TiposPOI.LOCAL_COMERCIAL);
		localTres.setTipo(TiposPOI.LOCAL_COMERCIAL);
		pColUno.setTipo(TiposPOI.PARADA_COLECTIVO);
		pColDos.setTipo(TiposPOI.PARADA_COLECTIVO);
		pColTres.setTipo(TiposPOI.PARADA_COLECTIVO);
		pColCuatro.setTipo(TiposPOI.PARADA_COLECTIVO);
		
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
		/**/
		//server.agregarListaBancos("http://trimatek.org/Consultas/banco?banco",poiController);
		
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
		String etiquetaNombre = "f";
		Assert.assertNotNull(poiController.getPOIs(etiquetaNombre));
		Assert.assertTrue(poiController.getPOIs(etiquetaNombre).size() == 1);
	}
	

	@Test
	public void testBuscarPorServicio(){
		String servicio = "servicio";
		Assert.assertNotNull(Banco.);
	}
	


}
