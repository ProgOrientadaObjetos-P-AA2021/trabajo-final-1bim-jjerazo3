/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author USUARIO 2020
 */
public class LecturaArchivoCiudad {

    private ObjectInputStream entrada;
    private ArrayList<Ciudad> ciudades;
    private String nombreArchivo;
    private Ciudad objetoCiudad;

    public LecturaArchivoCiudad(String nombre) {
        nombreArchivo = nombre;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(nombre));
            } catch (IOException ioException) {
                System.err.println("Error al abrir el archivo." + ioException);
            }
        }
    }

    public void establecerCiudadObjeto(String n) {
        for (int i = 0; i < ciudades.size(); i++) {
            if (ciudades.get(i).obtenerNombreCiudad().equals(n)) {
                objetoCiudad = ciudades.get(i);

            }
        }
    }
    
    public Ciudad obtenerCiudadObjeto() {
        return objetoCiudad;
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerListaCiudades() {
        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return ciudades;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Ciudades:\n";
        for (int i = 0; i < obtenerListaCiudades().size(); i++) {
            Ciudad c = obtenerListaCiudades().get(i);
            cadena = String.format("%s(%d) Nombre ciudad: %s - "
                    + "Nombre Provincia: %s\n", cadena,
                    i + 1,
                    c.obtenerNombreCiudad(),
                    c.obtenerNombreProvincia());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        }
 catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}