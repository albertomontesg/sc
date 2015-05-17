/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.before;

/**
 *
 * @author JuanCarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Humano corredor = new Humano("corredor");
        Leon leon = new Leon();
        Tigre tigre = new Tigre();

        System.out.println();
        corredor.andar();
        corredor.correr();
        corredor.dibujar();

        System.out.println();
        leon.andar();
        leon.correr();
        leon.dibujar();

        System.out.println();
        tigre.andar();
        tigre.correr();
        tigre.dibujar();
    }
}
