package co.masivian.prueba.utilidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import co.masivian.prueba.constantes.Constantes;

/**
 * 
	 * Clase responsable de cargar las propiedades del archivo de configuracion<br>
	 * 
	 * @author Higgor Alexander Vargas Penuela<br>
	 * 
	 * @date 7/05/2020
	 * @version 1.0
 */
public class CargadorPropiedad {

    /**
     * Referencia al archivo de propiedades.
     */
    private Properties propiedades;
    
    /**
     * Ruta de archivo de propiedades.
     */
    private String rutaPropiedades;

    /**
     * Constructor de la clase.
     */
    public CargadorPropiedad(final String rutaPropiedades) {
        super();
        this.rutaPropiedades = rutaPropiedades;
    }

    /**
     * 
    	 * Metodo que crea una instancia de las propiedaes <br>
    	 * 
    	 * @author Higgor Alexander Vargas Penuela<br>
    	 * 
    	 * @date 7/05/2020
    	 * @version 1.0
    	 *@return
    	 *@throws FileNotFoundException
    	 *@throws IOException
    	 *
     */
    private Properties getPropiedades() throws FileNotFoundException, IOException {
        if (propiedades == null) {
            propiedades = new Properties();
            propiedades.load(new InputStreamReader(new FileInputStream(new File(rutaPropiedades)), "UTF-8"));
        }
        return propiedades;
    }

    /**
     * 
    	 * Metodo que obtiene una propiedad del archivo de propiedades <br>
    	 * 
    	 * @author Higgor Alexander Vargas Penuela<br>
    	 * 
    	 * @date 7/05/2020
    	 * @version 1.0
    	 *@param llave
    	 *@return
     * @throws Exception 
    	 *@throws ExcepcionGenerica
    	 *
     */
    public String getPropiedad(String llave) throws Exception {
        String propiedad = Constantes.CADENA_VACIA;
        try {
            if (llave == null) {
                return null;
            }
            propiedad = getPropiedades().getProperty(llave);
        } catch (FileNotFoundException e) {
            throw new Exception(e);
        } 
        return propiedad;
    }
}
