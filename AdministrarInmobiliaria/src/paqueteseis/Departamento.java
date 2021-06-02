/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *Un departamento posee características como:

propietario (nombres, apellidos, identificación)
precio por metro cuadrado.
número de metros cuadrados.
valor alícuota mensual
costo final
precio
ubicación (número de casa, nombre del barrio, referencia)
ciudad (nombre ciudad, nombre provincia)
nombre de edificio
ubicacion del departamento en edificio
constructora (nombre constructora, id de la empresa)
 * @author reroes
 */
public class Departamento {
    
    private Propietario propietario;
    private double mCuadrados;
    private double mCuadradosPrecio;
    private double valorAlicuota;
    private double costoFinal;
    private Ubicacion ubicacion;
    private Ciudad ciudad;
    private String nombreEdificio;
    private String ubicacionEnEdificio;
    private Constructora constructora;
    
    public Departamento(Propietario propietario, double precioMetroCuadrado,
            double numMetroCuadrado, double cuotaMensual, Ubicacion ubicacion,
            Ciudad ciudad, String nombreEdificio,
            String ubicacionDepartamento,
            Constructora constructora) {
        this.propietario = propietario;
        this.mCuadradosPrecio = precioMetroCuadrado;
        this.mCuadrados = numMetroCuadrado;
        this.valorAlicuota = cuotaMensual;
        this.ubicacion = ubicacion;
        this.ciudad = ciudad;
        this.nombreEdificio = nombreEdificio;
        this.ubicacionEnEdificio = ubicacionDepartamento;
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
        this.costoFinal = (mCuadrados * mCuadradosPrecio) + (valorAlicuota * 12);
    }
    
    public void establecerUbicacion(Ubicacion ubicacion){
        this.ubicacion = ubicacion;
    }
    
    public void establecerCiudad(Ciudad ciudad){
        this.ciudad = ciudad;
    }
  
    public void establecerValorAlicuota(double alicuota){
        this.valorAlicuota = alicuota;
    }
    
    public void establecerConstructora(Constructora constructora){
        this.constructora = constructora;
    }
    public void establecerNombreEdificio(String nombreEdificio){
        this.nombreEdificio = nombreEdificio;
    }
    
    public void establecerUbicacionEnEdificio(String ubicacion){
        this.ubicacionEnEdificio = ubicacion;
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
    
    public Constructora obtenerConstructora(){
        return constructora;
    }
    
    public double obtenerValorAlicuota(){
        return valorAlicuota;
    }
    
    public String obtenerNombreEdificio(){
        return nombreEdificio;
    }
    
    public String obtenerUbicacionEnEdificio(){
        return ubicacionEnEdificio;
    }
    
    /**
 *Un departamento posee características como:

propietario (nombres, apellidos, identificación)
precio por metro cuadrado.
número de metros cuadrados.
valor alícuota mensual
costo final
precio
ubicación (número de casa, nombre del barrio, referencia)
ciudad (nombre ciudad, nombre provincia)
nombre de edificio
ubicacion del departamento en edificio
constructora (nombre constructora, id de la empresa)
 * @author reroes
 */
    
    @Override
    public String toString(){
        String cadena = String.format("Informacion del Departamento: \n"
                + "Propietario: \n"
                + "\tNombre: %s %s\n\tIdentificación: %s\n"
                + "Precio por metro cuadrado: %.2f\n"
                + "Numero de metros cuadrados: %.2f\n"
                + "Valor alícuota mensual: %.2f\n"
                + "Costo Final: %.2f\n"
                + "Ubicación: \n"
                + "\tNúmero de casa: %s\n\tBarrio: %s\n\t"
                + "Referencia: %s\n"
                + "Ciudad: %s\n\tProvincia: %s\n"
                + "Nombre del edificio: %s\n"
                + "Ubicación del departamento: %s\n"
                + "Informacion de la Costructora: \n"
                + "\tNombre: %s\n\tId: %d\n",
                obtenerPropietario().obtenerNombrePropietario(),
                obtenerPropietario().obtenerApellidoPropietario(),
                obtenerPropietario().obtenerIdPropietario(),
                obtenerPrecioM2(),
                obtenerM2(),
                obtenerValorAlicuota(),
                obtenerCostoFinal(),
                obtenerUbicacion().obtenerNCasa(),
                obtenerUbicacion().obtenerNombreBarrio(),
                obtenerUbicacion().obtenerReferencia(),
                obtenerCiudad().obtenerNombreCiudad(),
                obtenerCiudad().obtenerNombreProvincia(),
                obtenerNombreEdificio(),
                obtenerUbicacionEnEdificio(),
                obtenerConstructora().obtenerNombreConstructora(),
                obtenerConstructora().obtenerIdConstructora());
        return cadena;
    } 
}
