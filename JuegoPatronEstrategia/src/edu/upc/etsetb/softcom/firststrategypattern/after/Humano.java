/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.etsetb.softcom.firststrategypattern.after;

/**
 *
 * @author JuanCarlos
 */
public class Humano extends Personaje{

    public Humano(String n){
        super(n) ;
        System.out.println("He creado a " + n) ;

    }

    @Override
    public void dibujar() {
        System.out.println("Estoy dibujando a " + this.nombre) ;
    }
}
