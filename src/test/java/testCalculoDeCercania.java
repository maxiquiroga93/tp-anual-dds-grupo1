import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import POI.POI;
import POI.CGP;
import POI.LocalComercial;
import POI.ParadaColectivo;
import POI.Rubro;
import POI.Banco;

public class testCalculoDeCercania {
	
	public POI POIreferencia;
	public POI cgp;
	public Rubro rubro;
	public POI local;
	public POI parada;
	public POI banco;
	
	
	@Before
	public void init() {
		// Definimos un POI de referencia contra el cual medir distancias
		POIreferencia = CGP.ConstructorCGP("POIreferencia",-34.594269, -58.430131);
		rubro = new Rubro();
		
	}
	//--------------------------------------------------------------------------------------------------------	
		//CGP
	//--------------------------------------------------------------------------------------------------------		

	@Test
	public void testcercaniaCGPFalso() {
		// LAs comunas deben ser distintas para que esten lejos los poi
		POIreferencia.setComuna(1);
		//Localizado a ~5 cuadras
		cgp = CGP.ConstructorCGP("cgp",-34.590785, -58.435354);
		cgp.setComuna(20);
		Assert.assertFalse(cgp.esCercano(POIreferencia));
	}
	
	@Test
	public void testcercaniaCGPVerdadero() {
		// LAs comunas deben ser distintas para que esten cerca los poi
		POIreferencia.setComuna(1);
		//Localizado a ~5 cuadras
		cgp = CGP.ConstructorCGP("cgp",-34.590785, -58.435354);
		cgp.setComuna(1);
		Assert.assertFalse(cgp.esCercano(POIreferencia));
	}	
	
	
	//--------------------------------------------------------------------------------------------------------	
		//LOCAL COMERCIAL
	//--------------------------------------------------------------------------------------------------------		
	
	@Test
	public void testcercaniaLocalFalso() {
		//Definimos el limite de cercania en 2 cuadras
		rubro.setCercania(2);	
		//Localizado a ~5 cuadras
		local = LocalComercial.ConstructorLocalComercial("Local",-34.590785, -58.435354,rubro);
		Assert.assertFalse(local.esCercano(POIreferencia));
	}
	
	@Test
	public void testcercaniaLocalVerdadero() {
		//Definimos el limite de cercania en 2 cuadras
		rubro.setCercania(10);	
		//Localizado a ~5 cuadras
		local = LocalComercial.ConstructorLocalComercial("Local",-34.590785, -58.435354,rubro);
		Assert.assertFalse(local.esCercano(POIreferencia));
	}
	//--------------------------------------------------------------------------------------------------------	
		//PARADA DE COLECTIVO
	//--------------------------------------------------------------------------------------------------------	
		
	@Test
	public void testcercaniaParadaFalso() {
		//El limite de cercania es de 1 cuadra	
		//Localizado a ~5 cuadras
		parada = ParadaColectivo.ConstructorParadaColectivo("Parada",-34.590785, -58.435354);
		Assert.assertFalse(parada.esCercano(POIreferencia));
	}
	
	@Test
	public void testcercaniaParadaVerdadero() {
		//El limite de cercania es de 1 cuadra
		//Localizado a ~1/2 cuadra
		parada = ParadaColectivo.ConstructorParadaColectivo("Parada",-34.593945, -58.430648);
		Assert.assertFalse(parada.esCercano(POIreferencia));
	}
	
	//--------------------------------------------------------------------------------------------------------	
		//BANCO o CASO GENERAL
	//--------------------------------------------------------------------------------------------------------	
		
	@Test
	public void testcercaniaBancoFalso() {
		//El limite de cercania es de 7 cuadras	
		//Localizado a ~5 cuadras
		banco = Banco.ConstructorBanco("Banco",-34.589586, -58.437212);
		Assert.assertFalse(banco.esCercano(POIreferencia));
	}

	@Test
	public void testcercaniaBancoVerdadero() {
		//El limite de cercania es de 5 cuadras
		//Localizado a ~1/2 cuadra
		banco = Banco.ConstructorBanco("Banco",-34.590785, -58.435354);
		Assert.assertFalse(banco.esCercano(POIreferencia));
	}

}
