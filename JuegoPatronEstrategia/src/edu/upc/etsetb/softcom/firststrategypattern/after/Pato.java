/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.after;

/**
 *
 * @author JuanCarlos
 */
public class Pato extends Personaje {

    public Pato() {
        super("pato");
        System.out.println("He creado a un pato");

    }

    public void dibujar() {
        System.out.println("Estoy dibujando a un pato");
    }
}
