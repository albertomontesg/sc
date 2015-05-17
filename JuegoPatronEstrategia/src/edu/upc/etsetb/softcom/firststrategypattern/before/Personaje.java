/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.etsetb.softcom.firststrategypattern.before;

/**
 *
 * @author JuanCarlos
 */
public abstract class Personaje {
    protected String nombre ;

    public Personaje(String n){
        this.nombre = n ;
    }
    public void andar(){
        System.out.println("Soy " + this.nombre + " y estoy andando") ;
    }
    public void correr(){
        System.out.println("Soy " + this.nombre + " y estoy corriendo") ;
    }
    public String getNombre(){
        return this.nombre ;
    }
    public abstract void dibujar() ;
}
