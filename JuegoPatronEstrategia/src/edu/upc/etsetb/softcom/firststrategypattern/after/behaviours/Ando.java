/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.etsetb.softcom.firststrategypattern.after.behaviours;

import edu.upc.etsetb.softcom.firststrategypattern.after.Personaje;

/**
 *
 * @author JuanCarlos
 */
public class Ando implements ComportamientoAndo{

    public void andar(Personaje p) {
        System.out.println("Soy " +  p.getNombre() + " y estoy andando") ;
    }

}
