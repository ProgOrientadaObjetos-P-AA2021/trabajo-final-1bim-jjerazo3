/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

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
public class LecturaArchivoPropietario {
    private ObjectInputStream entrada;
    private ArrayList<Propietario> propietarios;
    private String nombreArchivo;
    private Propietario objetoPropietario;

    public LecturaArchivoPropietario(String nombre) {
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

    public void establecerObjetoPropietario(String n) {

        for (int i = 0; i < propietarios.size(); i++) {
            if (propietarios.get(i).obtenerIdPropietario() == n) {
                objetoPropietario = propietarios.get(i);

            }
        }
    }
    
    public Propietario obtenerObjetoPropietario() {
        return objetoPropietario;
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerListaPropietarios() {
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
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

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return propietarios;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Propietarios\n";
        for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
            Propietario p = obtenerListaPropietarios().get(i);
            cadena = String.format("%s(%d) Nombre: %s - Apellido: %s - "
                    + "Identificacion: %s\n", cadena,
                    i + 1,
                    p.obtenerNombrePropietario(),
                    p.obtenerApellidoPropietario(),
                    p.obtenerIdPropietario());
        }
        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        }
    }
}
