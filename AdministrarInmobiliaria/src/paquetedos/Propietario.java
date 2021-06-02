/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;
import java.io.Serializable;
/**
 *
 * @author reroes
 */
public class Propietario implements Serializable{
    
    private String nombrePropietario;
    private String apellidoPropietario;
    private String idPropietario;
    
    public Propietario(String nombre, String apellido, String id){
        this.nombrePropietario = nombre;
        this.apellidoPropietario = apellido;
        this.idPropietario = id;
    }
    
    public void establecerNombrePropietario(String nombre){
        this.nombrePropietario = nombre;
    }
    
    public void establecerApellidoPropietario(String apellido){
        this.apellidoPropietario = apellido;
    }
    
    public void establecerIdPropietario(String id){
        this.idPropietario = id;
    }
    
    public String obtenerNombrePropietario(){
        return nombrePropietario;
    }
    
    public String obtenerApellidoPropietario(){
        return apellidoPropietario;
    }
    
    public String obtenerIdPropietario(){
        return idPropietario;
    }
    
    @Override
    public String toString() {

        String cadena = String.format("Nombre:%s\nApellido:%s\n"
                + "Identificación:%s\n",
                obtenerNombrePropietario(),
                obtenerApellidoPropietario(),
                obtenerIdPropietario());
        return cadena;
    }
}
