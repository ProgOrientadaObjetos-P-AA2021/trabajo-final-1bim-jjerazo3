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
public class EscrituraArchivoDepartamento {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> lista;

    public EscrituraArchivoDepartamento(String nombre) {
        nombreArchivo = nombre;
        establecerListaDepartamentos();
        try {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));

            if (obtenerListaDepartamentos().size() > 0) {
                for (int i = 0; i < obtenerListaDepartamentos().size(); i++) {
                    establecerRegistro(obtenerListaDepartamentos().get(i));
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

    public void establecerRegistro(Departamento n) {
        registro = n;
    }
    
    public Departamento obtenerRegistro(){
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

    public void establecerListaDepartamentos() {
        LecturaArchivoDepartamento d = new LecturaArchivoDepartamento(obtenerNombreArchivo());
        d.establecerListaDepartamentos();
        lista = d.obtenerListaDepartamentos();
    }

    public ArrayList<Departamento> obtenerListaDepartamentos() {
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
