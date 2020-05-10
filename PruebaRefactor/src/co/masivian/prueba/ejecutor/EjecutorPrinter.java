package co.masivian.prueba.ejecutor;

import co.masivian.prueba.procesador.ProcesadorPrinter;

/**
 * Clase responsable de ejecutar el proceso Prnter<br>
 * 
 * @author INDRA <br>
 *         Higgor Alexander Vargas Penuela<br>
 *         havargasp@indracompany.com<br>
 * 
 * @date 7/05/2020
 * @version 1.0
 */
public class EjecutorPrinter {

	/**
	 * Metodo que ejecuta el proceso Printer<br>
	 * 
	 * @author Higgor Alexander Vargas Penuela<br>
	 * 
	 * @date 7/05/2020
	 * @version 1.0
	 * @param args
	 * @throws Exception
	 * 
	 */
	public static void main(String[] args) throws Exception {
		if (args.length != 1 || args[0].trim() == "") {

			System.out.println("Los parametros enviados a la aplicacion no son correctos.");
			System.out.println("FALLO_EJECUCION_PROCESO");

			throw new Exception();
		}

		String rutaArchivoConfiguracion = args[0];

		try {

			System.out.println("Se inicia la ejecucion del proceso de pruebas Masivian");
			ProcesadorPrinter proceso = new ProcesadorPrinter(rutaArchivoConfiguracion);
			proceso.procesar();
			System.out.println("Finaliza la ejecucion del proceso de pruebas Masivian");

		} catch (Exception e) {

			System.out.println("FALLO_EJECUCION_PROCESO");
			throw e;

		}

	}

}
