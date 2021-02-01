package model.data_structures;

import java.util.ArrayList;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	
	
		//-----------------
		// ATRIBUTOS
		//-----------------
	
		/**
		 * Capacidad maxima del arreglo
		 */
        private int tamanoMax;
        
		/**
		 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
		 */
        private int tamanoAct;
        
        /**
         * Arreglo de elementos de tamaNo maximo (tamanoMax)
         */
        private String elementos[ ];

        
		//-----------------
		// CONSTRUCTOR
		//-----------------
        
        /**
         * Construir un arreglo con la capacidad maxima inicial.
         * @param max Capacidad maxima inicial
         */
		public ArregloDinamico( int max )
        {
               elementos = new String[max];
               tamanoMax = max;
               tamanoAct = 0;
               
        }
		
		//-----------------
		// METODOS
		//-----------------
        
		public void agregar( String dato )
        {
               if ( tamanoAct == tamanoMax )
               {  // caso de arreglo lleno (aumentar tamaNo)
                    tamanoMax = 2 * tamanoMax;
                    String [ ] copia = elementos;
                    elementos = new String[tamanoMax];
                    for ( int i = 0; i < tamanoAct; i++)
                    {
                     	 elementos[i] = copia[i];
                    } 
            	    System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
               }	
               elementos[tamanoAct] = dato;
               tamanoAct++;
       }

		public int darCapacidad() {
			return tamanoMax;
		}

		public int darTamano() {
			return tamanoAct;
		}

		public String darElemento(int i) {
			
			return elementos[i];
			
		}

		public String buscar(String dato) {
			
			for(int i =0; i< tamanoAct; i ++){
				
				if(elementos[i].compareTo(dato)==0) {
					
					return elementos[i];
				}
			}
			return null;
		}
		
		public String eliminar(String dato) {
			
			String eliminado = null;
			
			for(int i=0; i < tamanoAct; i++) {		// accede a la estructura
				
				if(elementos[i].compareTo(dato)==0) { //compara los elementos buscando el dato.
					
					eliminado = elementos[i];
					elementos[i] = null;			// lo elimina
					
					for(int j=i+1; j < tamanoAct ; j++) { // reorganiza para compactar los datos.
						
						elementos[j-1] = elementos[j]; 
					}
					tamanoAct --;
				}
			}

			return eliminado;
		}
		
}
