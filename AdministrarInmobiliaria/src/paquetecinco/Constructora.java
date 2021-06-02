/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String idConstructora;

    public Constructora(String nc, String id) {
        nombreConstructora = nc;
        idConstructora = id;
    }

    public void establecerNombreConstructora(String n) {
        nombreConstructora = n;
    }

    public void establecerId(String n) {
        idConstructora = n;
    }

    public String obtenerNombreConstructora() {
        return nombreConstructora;
    }

    public String obtenerIdConstructora() {
        return idConstructora;
    }
    
    @Override
    public String toString() {

        String cadena = String.format("Informacion de la constructora: \n"
                + "Nombre: %s\n"
                + "Id de la Constructora: %s\n",
                obtenerNombreConstructora(),
                obtenerIdConstructora());
        return cadena;
    }
}
