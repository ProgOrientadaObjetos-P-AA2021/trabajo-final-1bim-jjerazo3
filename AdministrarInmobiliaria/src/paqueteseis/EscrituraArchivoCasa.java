/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO 2020
 */
public class EscrituraArchivoCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> lista;

    public EscrituraArchivoCasa(String nombre) {
        nombreArchivo = nombre;
        establecerListaCasas();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaCasas().size() > 0) {
                for (int i = 0; i < obtenerListaCasas().size(); i++) {
                    establecerRegistro(obtenerListaCasas().get(i));
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

    public void establecerRegistro(Casa n) {
        registro = n;
    }
    
    public Casa obtenerRegistro(){
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

    public void establecerListaCasas() {
        LecturaArchivoCasa l = new LecturaArchivoCasa(obtenerNombreArchivo());
        l.establecerListaCasas();
        lista = l.obtenerListaCasas();
    }

    public ArrayList<Casa> obtenerListaCasas() {
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
