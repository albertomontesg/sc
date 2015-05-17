/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.before;

/**
 *
 * @author JuanCarlos
 */
public class Tigre extends Personaje {

    public Tigre() {
        super("tigre");
        System.out.println("He creado a un tigre");

    }

    public void dibujar() {
        System.out.println("Estoy dibujando a un tigre");
    }
}
