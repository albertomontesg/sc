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
public class SaltoAdelante implements ComportamientoSalto{

    public void saltar(Personaje p) {
        System.out.println("Soy " +  p.getNombre() + " y salto hacia adelante") ;
    }

}
