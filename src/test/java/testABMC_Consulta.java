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
	}
	
	@Test
	public void testConsulta() throws JSONException, MalformedURLException, IOException{
		ArrayList<POI> lista=null;
		
		lista = abmc.buscar(null, "Galicia", "sad");
		Assert.assertTrue(!(lista.isEmpty()));
			
	}
	
	public boolean esnull(ArrayList<POI> lista){
		return lista.size() == 0;
	}


	
}
