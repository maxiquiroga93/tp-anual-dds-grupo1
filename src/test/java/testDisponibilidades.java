import org.junit.Before;
import org.junit.Test;

import POI.Banco;
import POI.CGP;
import POI.nodoServicioCGP;

import org.junit.Assert;

public class testDisponibilidades {
	public Banco banco;
	
	/// --------------------BANCO----------------------------
	@Before
	public void inicializarBanco(){
		banco = (Banco) Banco.ConstructorBanco("macro", 36, 53);
	}
	
	@Test
	public void chequearCajero(){
		boolean resultado = banco.disponible("cajero");
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void chequearVacio(){
		boolean resultado = banco.disponible("");
		Assert.assertTrue(resultado);
	}
	
	@Test
	public void chequearServicioDependienteDelHorario(){
		boolean resultado = banco.disponible("caja de ahorro");
		Assert.assertFalse(resultado);
	}
	
	///-----------------------CGP-----------------------
	
	public CGP cgp;
	
	@Before
	public void inicializarCGP(){
		cgp = (CGP) CGP.ConstructorCGP("mataderos", 23, 44);
		nodoServicioCGP nuevoNodo = new nodoServicioCGP();
		nuevoNodo.setName("Rentas");
		nuevoNodo.agregarDia(1);
		nuevoNodo.setHoras(9, 18);
		CGP.Servicios.add(nuevoNodo);
	}

}
