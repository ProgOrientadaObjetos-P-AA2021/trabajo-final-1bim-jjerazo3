/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 *
 * @author USUARIO 2020
 */
public class EscrituraArchivoCiudad {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Ciudad registro;
    private ArrayList<Ciudad> lista;

    public EscrituraArchivoCiudad(String nombre) {
        nombreArchivo = nombre;
        establecerListaCiudades();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaCiudades().size() > 0) {
                for (int i = 0; i < obtenerListaCiudades().size(); i++) {
                    establecerRegistro(obtenerListaCiudades().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerRegistro(Ciudad n) {
        registro = n;
    }
    
    public Ciudad obtenerRegistro(){
        return registro;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void establecerListaCiudades() {
        LecturaArchivoCiudad l = new LecturaArchivoCiudad(obtenerNombreArchivo());
        l.establecerListaCiudades();
        lista = l.obtenerListaCiudades();
    }

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return lista;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");

        }
    }
}
