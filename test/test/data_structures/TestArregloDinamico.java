package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	
	//-----------------
	// ATRIBUTOS
	//-----------------

	
	/**
	 *  Estructura
	 */
	private ArregloDinamico arreglo;
	
	/**
	 * constante del tamano
	 */
	private static int TAMANO=100;
	
	
	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(""+i);
		}
	}
	
	
	//-----------------
	// METODOS
	//-----------------

	@Test
	public void testArregloDinamico() {
		
		assertTrue(arreglo.darCapacidad() ==TAMANO);
		assertTrue(arreglo.darTamano()== 0); 
		
	}

	@Test
	public void testDarElemento() {
		
		setUp2();
		assertTrue(arreglo.darCapacidad()== 2*TAMANO);
		assertTrue(arreglo.darTamano() == 2*TAMANO); // esto es porque el factor de aumento es exactamente igual al numero de elementos que se le dio en el SetUp2.
		assertTrue(arreglo.darElemento(5).compareTo(""+5)==0);
	}
	
	
	@Test
	public void testEliminar() {
		
		setUp2();
		arreglo.eliminar(""+5);
		assertTrue(arreglo.buscar(""+5)== null);	// verifica que ya no este en la estructura.
		assertTrue(arreglo.darTamano()==199);		// verifica que el contador se haya  actualizado.
		
		for(int i=0; i < arreglo.darTamano(); i++) { // verifica que los datos hayan quedado compactos desde la posicion inicial (0).
			
			assertTrue(arreglo.darElemento(i)!= null);
		}
	}

}
