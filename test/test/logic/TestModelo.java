package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(""+i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		
		assertTrue(modelo.darTamano()==0);
	}

	@Test
	public void testAgregar() {
		
		modelo.agregar(""+0);
		assertTrue(modelo.darTamano()==1);
	}
	

	@Test
	public void testBuscar() {
		setUp2();
		assertTrue(modelo.buscar(""+5).compareTo(""+5)==0);
		
	}

	@Test
	public void testEliminar() {
		
		setUp2();
		assertTrue(modelo.eliminar(""+5).compareTo(""+5)==0);
		assertTrue(modelo.darTamano()== 99);
	}

}
