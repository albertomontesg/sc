/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.after;

/**
 *
 * @author JuanCarlos
 */
public class Aguila extends Personaje {

    public Aguila() {
        super("aguila");
        System.out.println("He creado a un aguila");

    }

    public void dibujar() {
        System.out.println("Estoy dibujando a un aguila");
    }
}
