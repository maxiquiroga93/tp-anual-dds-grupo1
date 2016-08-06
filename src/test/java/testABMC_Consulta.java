import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import DB.DB_Server;
import POI.Banco;
import POI.CGP;
import POI.LocalComercial;
import POI.POI;
import POI.ParadaColectivo;
import POI.Rubro;
import ABMC.POI_ABMC;

public class testABMC_Consulta {

	@Before
	public void inicializar(){
		Banco banco = new Banco("Santander", 0, 0);
		LocalComercial local = new LocalComercial("Localcito", 0, 0,null);
		ParadaColectivo parada = new ParadaColectivo("47", 0, 0);
		CGP cgp = new CGP("Mataderos", 0, 0);
		DB_Server base = new DB_Server();
		base.agregarPOI(cgp);
		base.agregarPOI(parada);
		base.agregarPOI(local);
		base.agregarPOI(banco);
		
		banco.setBarrio("Mataderos");
		banco.setPais("Argentina");
		banco.setCallePrincipal("Alberdi");
		banco.setCalleLateral("Escalada");
	}
	
	@Test
	public void testConsulta(){
		ArrayList<POI> lista=null;
		
		lista = consultaLocal("Mataderos");
		Assert.assertFalse(esnull(lista));
			
	}
	
	public boolean esnull(ArrayList<POI> lista){
		return lista.size() == 0;
	}


	
}
