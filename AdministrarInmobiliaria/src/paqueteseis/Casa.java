/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;

/**
 *
 * @author reroes
 * Una casa tiene propiedades como:

propietario (nombres, apellidos, identificación)
precio por metro cuadrado.
número de metros cuadrados.
costo final
ubicación (nombre del barrio, referencia)
ciudad (nombre ciudad, nombre provincia)
numero de cuartos
constructora (nombre constructora, id de la empresa)
 */

public class Casa implements Serializable{
    
    private Propietario propietario;
    private double mCuadrados;
    private double mCuadradosPrecio;
    private double costoFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private int nCuartos;
    private Constructora constructora;
    

    public Casa(Propietario propietario, double precioMetroCuadrado, double numMetroCuadrado,
            Ubicacion ubicacion, Ciudad ciudad, int numCuartos, Constructora constructora) {
        this.propietario = propietario;
        this.mCuadradosPrecio = precioMetroCuadrado;
        this.mCuadrados = numMetroCuadrado;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.nCuartos = numCuartos;
        this.constructora = constructora;
    }
    
    public void establecerPropietario(Propietario propietario){
        this.propietario = propietario;
    }
    
    public void establecerPrecioM2(double precio){
        this.mCuadradosPrecio = precio;
    }
    
    public void establecerM2(double m2){
        this.mCuadrados = m2;
    }
    
    public void calcularCostoFinal(double costo){
        this.costoFinal = mCuadrados * mCuadradosPrecio;
    }
    
    public void establecerUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public void establecerCiudad(Ciudad ciudad){
        this.ciudad = ciudad;
    }
    
    public void establecerCuartos(int n){
        this.nCuartos = n;
    }
    
    public void establecerConstructora(Constructora constructora){
        this.constructora = constructora;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public double obtenerPrecioM2(){
        return mCuadradosPrecio;
    }
    
    public double obtenerM2(){
        return mCuadrados;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public Ubicacion obtenerUbicacion(){
        return ubicacion;
    }
    
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public int obtenerNCuartos(){
        return nCuartos;
    }
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
    
    /**
 *
 * @author reroes
 * Una casa tiene propiedades como:

propietario (nombres, apellidos, identificación)
precio por metro cuadrado.
número de metros cuadrados.
costo final
ubicación (nombre del barrio, referencia)
ciudad (nombre ciudad, nombre provincia)
numero de cuartos
constructora (nombre constructora, id de la empresa)
 */
    
    @Override
    public String toString(){
        
        String cadena = String.format("Informacion de la casa : \n"
                + "Propietario:  \n"
                + "\tNombre: %s %s\n"
                + "\tIdentificacion: %s\nPrecio por metro cuadrado: %.2f\n"
                + "Numero de metros cuadrados: %.2f\nCosto Final: %.2f\n"
                + "Ubicación: \n"
                + "\tNombre del Barrio: %s\n\tReferencia: %s\n"
                + "\tCiudad: %s\n\tProvincia: %s\n"
                + "Numero de cuartos: %d\nInformacion de la Constructora:\n"
                + "\tNombre: %s\n\tId: %d\n",
                obtenerPropietario().obtenerNombrePropietario(),
                obtenerPropietario().obtenerApellidoPropietario(),
                obtenerPropietario().obtenerIdPropietario(),
                obtenerPrecioM2(),
                obtenerM2(),
                obtenerCostoFinal(),
                obtenerUbicacion().obtenerNombreBarrio(),
                obtenerUbicacion().obtenerReferencia(),
                obtenerCiudad().obtenerNombreCiudad(),
                obtenerCiudad().obtenerNombreProvincia(),
                obtenerNCuartos(),
                obtenerConstructora().obtenerNombreConstructora(),
                obtenerConstructora().obtenerIdConstructora()
                );
      return cadena;  
    }
}
