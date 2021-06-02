/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;
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
public class LecturaArchivoConstructora {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> listaConstructoras;
    private String nombreArchivo;
    private Constructora objetoConstructora;

    public LecturaArchivoConstructora(String nombre) {
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

    public void establecerConstructoraObjeto(String n) {
        for (int i = 0; i < listaConstructoras.size(); i++) {
            if (listaConstructoras.get(i).obtenerIdConstructora() == n) {
                objetoConstructora = listaConstructoras.get(i);
            }
        }
    }
    
    public Constructora obtenerConstructoraObjeto() {
        return objetoConstructora;
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void establecerListaConstructoras() {
        listaConstructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    listaConstructoras.add(registro);
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

    public ArrayList<Constructora> obtenerListaConstructoras() {
        return listaConstructoras;
    }
    
    @Override
    public String toString() {
        String cadena = "Lista de la Constructora\n";
        for (int i = 0; i < obtenerListaConstructoras().size(); i++) {
            Constructora c = obtenerListaConstructoras().get(i);
            cadena = String.format("%s(%d) Nombre de Constructora: %s\n"
                    + "Id de la Constructora:%s\n", cadena,
                    i + 1,
                    c.obtenerNombreConstructora(),
                    c.obtenerIdConstructora());
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
