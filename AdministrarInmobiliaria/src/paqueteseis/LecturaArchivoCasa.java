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
public class LecturaArchivoCasa {
    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private String nombreArchivo;

    public LecturaArchivoCasa(String nombre) {
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

    public void establecerListaCasas() {
        casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se puede crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public ArrayList<Casa> obtenerListaCasas() {
        return casas;
    }

    @Override
    public String toString() {
        String cadena = "Lista de Casas\n";
        for (int i = 0; i < obtenerListaCasas().size(); i++) {
            Casa s = obtenerListaCasas().get(i);
            cadena = String.format("%s(%d) Informacion del Propietario:\n%s\n"
                    + "Precio por metro cuadrado: %.2f\nNumero de metros "
                    + "cuadrados: %.2f\nCosto Final: %.2f\nUbicacion:\n%s\n"
                    + "Ciudad:\n%s\nNúmero de cuartos: %d\nConstructora:"
                    + "\n%s\n", cadena, i + 1,
                    s.obtenerPropietario(),
                    s.obtenerPrecioM2(),
                    s.obtenerM2(),
                    s.obtenerCostoFinal(),
                    s.obtenerUbicacion(),
                    s.obtenerCiudad(),
                    s.obtenerNCuartos(),
                    s.obtenerConstructora());

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
