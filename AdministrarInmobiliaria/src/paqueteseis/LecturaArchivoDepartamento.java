/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

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
public class LecturaArchivoDepartamento {
    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;

    public LecturaArchivoDepartamento(String nombre) {
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

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerListaDepartamentos() {
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
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

    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return departamentos;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Departamentos:\n";
        for (int i = 0; i < obtenerListaDepartamentos().size(); i++) {
            Departamento d = obtenerListaDepartamentos().get(i);
            cadena = String.format("%s(%d) Propietario:\n%s\n"
                    + "Precio por metro cuadrado: %.2f\n"
                    + "Numeros de metros cuadrados: %.2f\n"
                    + "Valor alícuota mensual: %.2f\n"
                    + "Costo Final: %.2f\n"
                    + "Ubicación:\n%s\nCiudad:\n%s\nNombre del edificio: %s\n"
                    + "Ubicación del edificio: %s\nConstructora:\n%s\n", cadena,
                    i + 1,
                    d.obtenerPropietario(),
                    d.obtenerPrecioM2(),
                    d.obtenerM2(),
                    d.obtenerValorAlicuota(),
                    d.obtenerCostoFinal(),
                    d.obtenerUbicacion(),
                    d.obtenerCiudad(),
                    d.obtenerNombreEdificio(),
                    d.obtenerUbicacionEnEdificio(),
                    d.obtenerConstructora());

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
