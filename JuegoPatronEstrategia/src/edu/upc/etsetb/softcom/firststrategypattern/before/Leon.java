/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.etsetb.softcom.firststrategypattern.before;

/**
 *
 * @author JuanCarlos
 */
public class Leon extends Personaje{
    public Leon(){
        super("leon") ;
        System.out.println("He creado a un leon");
    }

public void dibujar() {
        System.out.println("Estoy dibujando a un le??n ") ;
    }
}
