package co.masivian.prueba.procesador;

import co.masivian.prueba.constantes.Constantes;
import co.masivian.prueba.utilidades.CargadorPropiedad;

/**
 * Clase responsable de realizar el procesamiento de la prueba Masivian<br>
 * 
 * @author Higgor Alexander Vargas Penuela<br>
 * 
 * @date 7/05/2020
 * @version 1.0
 */
public class ProcesadorPrinter {

	/** Se instancia el cargador de propiedades */
	CargadorPropiedad cargador;
	/** Representa la cantidad de primos a encontrar */
	private int CANTIDAD_PRIMOS;
	/** Representa la constante RR */
	private int REGISTROS_COLUMNA;
	/** Representa la constante CC */
	private int NUMERO_COLUMNAS;
	/** Representa la constante ORD_MAX */
	private int ORDMAX;
	/** Representa la constante PAGENUMBER */
	private int PAGENUMBER;
	/** Representa la constante PAGEOFFSET */
	private int PAGEOFFSET;
	/** Representa la variable ROWOFFSET */
	private int ROWOFFSET;
	/** Representa la variable ord */
	private int ord;
	/** Representa la variable square */
	private int square;
	/** Representa la variable j */
	private int j;
	/** Representa la variable k */
	private int k;
	/** Representa la variable jprime */
	boolean jprime;
	/** Representa la variable n */
	int n;

	public ProcesadorPrinter(String rutaArchivoConfiguracion) {
		// Se instancia el cargador de las propiedades
		cargador = new CargadorPropiedad(rutaArchivoConfiguracion);
		try {
			CANTIDAD_PRIMOS = Integer.parseInt(cargador.getPropiedad(Constantes.CANTIDAD_PRIMOS));
			REGISTROS_COLUMNA = Integer.parseInt(cargador.getPropiedad(Constantes.REGISTROS_COLUMNA));
			NUMERO_COLUMNAS = Integer.parseInt(cargador.getPropiedad(Constantes.NUMERO_COLUMNAS));
			ORDMAX = Integer.parseInt(cargador.getPropiedad(Constantes.CONSTANTE_ORD_MAX));
			PAGENUMBER = Integer.parseInt(cargador.getPropiedad(Constantes.CONSTANTE_PAGENUMBER));
			PAGEOFFSET = Integer.parseInt(cargador.getPropiedad(Constantes.CONSTANTE_PAGEOFFSET));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * Metodo que Realiza el proceso de pruebas de Masivian<br>
	 * 
	 * @author Higgor Alexander Vargas Penuela<br>
	 * 
	 * @date 7/05/2020
	 * @version 1.0
	 * @throws Exception
	 *
	 */
	public void procesar() throws Exception {
		// Se asigna valor a las variables generales del proceso
		ord = Integer.parseInt(cargador.getPropiedad(Constantes.CONSTANTE_ORD));
		square = Integer.parseInt(cargador.getPropiedad(Constantes.CONSTANTE_SQUARE));
		j = 1;
		k = 1;
		
		int MULT[] = new int[ORDMAX + 1];
		int P[] = new int[CANTIDAD_PRIMOS + 1];
		P[1] = 2;
		while (k < CANTIDAD_PRIMOS) {
			do {
				j += 2;
				if (j == square) {
					ord++;
					square = P[ord] * P[ord];
					MULT[ord - 1] = j;
				}
				n = 2;
				jprime = true;
				while (n < ord && jprime) {
					while (MULT[n] < j)
						MULT[n] += P[n] + P[n];
					if (MULT[n] == j)
						jprime = false;
					n++;
				}
			} while (!jprime);
			k++;
			P[k] = j;
		}

		// Se puestra el resultado en pantalla
		mostrarResultado(P);

	}

	/**
	 * 
	 * Metodo que muestra el resultado del proceso<br>
	 * 
	 * @author Higgor Alexander Vargas Penuela<br>
	 * 
	 * @date 7/05/2020
	 * @version 1.0
	 * @param P
	 *
	 */
	public void mostrarResultado(int P[]) {
		while (PAGEOFFSET <= CANTIDAD_PRIMOS) {
			System.out.print("The First ");
			System.out.print(Integer.toString(CANTIDAD_PRIMOS));
			System.out.print(" Prime Numbers === Page ");
			System.out.print(Integer.toString(PAGENUMBER));
			System.out.println("\n");
			for (ROWOFFSET = PAGEOFFSET; ROWOFFSET <= PAGEOFFSET + REGISTROS_COLUMNA - 1; ROWOFFSET++) {
				for (int i = 0; i <= NUMERO_COLUMNAS - 1; i++)
					if (ROWOFFSET + i * REGISTROS_COLUMNA <= CANTIDAD_PRIMOS)
						System.out.printf("%10d", P[ROWOFFSET + i * REGISTROS_COLUMNA]);
				System.out.println();
			}
			System.out.println("\n");
			PAGENUMBER++;
			PAGEOFFSET += REGISTROS_COLUMNA * NUMERO_COLUMNAS;
		}
	}

}
