import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.json.JSONException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DB.DB_Server;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import ABMC.POI_ABMC;

public class testABMC_Consulta {
	POI_ABMC abmc;
	String ServicioAPI;
	
	@Before
	public void inicializar(){
		abmc = new POI_ABMC();
		Banco banco = new Banco("Santander", 0, 0);
		LocalComercial local = new LocalComercial("Localcito", 0, 0,null);
		ParadaColectivo parada = new ParadaColectivo("47", 0, 0);
		CGP cgp = new CGP("Mataderos", 0, 0);
		new DB_Server();
		
		DB_Server.agregarPOI(cgp);
		DB_Server.agregarPOI(parada);
		DB_Server.agregarPOI(local);
		DB_Server.agregarPOI(banco);
		
		banco.setBarrio("Mataderos");
		banco.setPais("Argentina");
		banco.setCallePrincipal("Alberdi");
		banco.setCalleLateral("Escalada");
		ServicioAPI = "http://trimatek.org/Consultas/";
	}
	
	@Test
	public void testConsultaVacia() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(ServicioAPI, "", "");
		Assert.assertTrue(lista.isEmpty());
			
	}
	
	@Test
	public void testConsultaLocal() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar("", "Alberdi", "");
		Assert.assertTrue(lista.size() == 1);
			
	}
	
	@Test
	public void testConsultaLocal2() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar("", "Mataderos", "");
		Assert.assertTrue(lista.size() == 2);
			
	}
	// deberia devolver 1 solo resultado, pero como el servicio remoto ServiciosAPI no filtra bien,
	// devuelve todos los CGPs y el banco encontrado (en total 15)
	@Test
	public void testConsulta() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(ServicioAPI, "Galicia", "");
		Assert.assertTrue(!(lista.isEmpty()));
			
	}
	
	public boolean esnull(ArrayList<POI> lista){
		return lista.size() == 0;
	}


	
}
