/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO 2020
 */
public class EscrituraArchivoConstructora {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registro;
    private ArrayList<Constructora> lista;

    public EscrituraArchivoConstructora(String nombre) {
        nombreArchivo = nombre;
        establecerLista();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerLista().size() > 0) {
                for (int i = 0; i < obtenerLista().size(); i++) {
                    establecerRegistro(obtenerLista().get(i));
                    establecerSalida();
                }
            }
        } catch (IOException ioException) {
            System.err.println("Error para abrir el archivo.");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerRegistro(Constructora n) {
        registro = n;
    }
    
    public Constructora obtenerRegistro(){
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

    public void establecerLista() {
        LecturaArchivoConstructora l = new LecturaArchivoConstructora(obtenerNombreArchivo());
        l.establecerListaConstructoras();
        lista = l.obtenerListaConstructoras();
    }

    public ArrayList<Constructora> obtenerLista() {
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