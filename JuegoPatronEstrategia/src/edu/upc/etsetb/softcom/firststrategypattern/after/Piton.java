/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.after;

/**
 *
 * @author JuanCarlos
 */
public class Piton extends Personaje {

    public Piton() {
        super("serpiente pitón");
        System.out.println("He creado a una serpiente pitón");

    }

    public void dibujar() {
        System.out.println("Estoy dibujando a una serpiente pitón");
    }
}
