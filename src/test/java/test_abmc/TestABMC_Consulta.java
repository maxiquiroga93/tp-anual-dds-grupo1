package test_abmc;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import abmc.POI_ABMC;
import db.DB_Server;
import poi.Banco;
import poi.CGP;
import poi.LocalComercial;
import poi.POI;
import poi.ParadaColectivo;

public class TestABMC_Consulta {
	POI_ABMC abmc;
	String ServicioAPI;
	
	Banco banco = new Banco("Santander", 0, 0);
	LocalComercial local = new LocalComercial("Localcito", 0, 0,null);
	ParadaColectivo parada = new ParadaColectivo("47", 0, 0);
	CGP cgp = new CGP("Mataderos", 0, 0);
	
	@Before
	public void inicializar(){
		abmc = new POI_ABMC();

		new DB_Server();
		
		
		banco.setBarrio("Mataderos");
		banco.setPais("Argentina");
		banco.setCallePrincipal("Alberdi");
		banco.setCalleLateral("Escalada");
		ServicioAPI = "http://trimatek.org/Consultas/";
	}
	
	@Test
	public void testConsultaVacia() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		lista = abmc.buscar(ServicioAPI, "");
		Assert.assertTrue(lista.isEmpty());
			
	}
	
	@Test
	public void testConsultaLocal() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		lista = abmc.buscar("", "Alberdi");
		Assert.assertTrue(lista.size() == 1);
			
	}
	
	@Test
	public void testConsultaLocal2() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		lista = abmc.buscar("", "Mataderos");
		Assert.assertTrue(lista.size() == 2);
			
	}
	
	@Test
	public void testConsultaRemota() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(ServicioAPI, "Mataderos");
		Assert.assertTrue(lista.size() == 15);
			
	}
	// deberia devolver 1 solo resultado, pero como el servicio remoto ServiciosAPI no filtra bien,
	// devuelve todos los CGPs y el banco encontrado (en total 16)	
	@Test
	public void testConsultaRemota2() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(ServicioAPI, "Galicia");
		Assert.assertTrue(lista.size() == 16);
			
	}
	
	
	@Test
	public void testConsultaRemotaVariasPalabras() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(ServicioAPI, "Galicia Mataderos");
		Assert.assertTrue(lista.size() == 16);
			
	}
	
	
	@Test
	public void testConsulta() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		lista = abmc.buscar(ServicioAPI, "Galicia");
		Assert.assertTrue(!(lista.isEmpty()));
			
	}
	
	
	@Test
	public void testConsultavariasPalabras() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		lista = abmc.buscar(ServicioAPI, "Galicia Mataderos");
		Assert.assertTrue(lista.size() == 18);
			
	}
	


	
}
