/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;
import java.io.Serializable;
/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    private String nombreCiudad;
    private String nombreProvincia;

    public Ciudad(String ciudad, String provincia) {
        nombreCiudad = ciudad;
        nombreProvincia = provincia;
    }

    public void establecerNombreCiudad(String ciudad) {
        nombreCiudad = ciudad;
    }
    
    public String obtenerNombreCiudad() {
        return nombreCiudad;
    }

    public void establecerNombreProvincia(String provincia) {
        nombreProvincia = provincia;
    }

    public String obtenerNombreProvincia() {
        return nombreProvincia;
    }

    @Override
    public String toString() {

        String cadena = String.format("Ciudad: %s\n"
                + "Provincia: %s\n",
                obtenerNombreCiudad(),
                obtenerNombreProvincia());
        return cadena;
    }

}