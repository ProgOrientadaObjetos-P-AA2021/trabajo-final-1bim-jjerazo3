/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;
import java.io.Serializable;
/**
 *
 * @author reroes
 */
public class Ubicacion implements Serializable {
    
    private String nombreBarrio;
    private String referencia;
    private int ncasa;
    
    public Ubicacion(String barrio, String referencia, int n){
        this.nombreBarrio = barrio;
        this.referencia = referencia;
        this.ncasa = n;
    }
    
    public Ubicacion(String barrio, String referencia){
        this.nombreBarrio = barrio;
        this.referencia = referencia;
    }
    
    public void establecerNombreBarrio(String barrio){
        this.nombreBarrio = barrio;
    }
    
    public String obtenerNombreBarrio(){
        return this.nombreBarrio;
    }
    
    public void establecerReferencia(String referencia){
        this.referencia = referencia;
    }
    
    public String obtenerReferencia(){
        return this.referencia;
    }
    
    public void setNCasa(int n){
        this.ncasa = n;
    }
    
    public int obtenerNCasa(){
        return this.ncasa;
    }
    
    @Override
    public String toString() {

        String cadena = String.format("Número de Casa:%d\nNombre Barrio:%s\n"
                + "Referencia:%s\n",
                obtenerNCasa(),
                obtenerNombreBarrio(),
                obtenerReferencia());
        return cadena;
    }
}
