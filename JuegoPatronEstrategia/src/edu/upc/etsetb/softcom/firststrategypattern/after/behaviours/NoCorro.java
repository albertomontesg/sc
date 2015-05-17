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
public class NoCorro implements ComportamientoCorro{

    public void correr(Personaje p) {
        System.out.println("Soy " +  p.getNombre() + " y no puedo correr") ;
    }

}
