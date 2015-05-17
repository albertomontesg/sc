/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.upc.etsetb.softcom.firststrategypattern.after;

import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoAndo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoCorro;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoRepto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoSalto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoVuelo;

/**
 *
 * @author JuanCarlos
 */
public abstract class Personaje {
    protected ComportamientoAndo ando ;
    protected ComportamientoVuelo vuelo ;
    protected ComportamientoCorro corro ;
    protected ComportamientoRepto repto ;
    protected ComportamientoSalto salto ;

    protected String nombre ;

    public Personaje(String n){
        this.nombre = n ;
    }
    public String getNombre(){
        return this.nombre ;
    }
    public void setVuelo(ComportamientoVuelo v){
        this.vuelo = v ;
    }
    public void setAndo(ComportamientoAndo a){
        this.ando = a ;
    }
    public void setCorro(ComportamientoCorro c){
        this.corro = c ;
    }
    public void setRepto(ComportamientoRepto r){
        this.repto = r ;
    }
    public void setSalto(ComportamientoSalto s){
        this.salto = s ;
    }

    public void andar(){
        this.ando.andar(this) ;
    }
    public void saltar(){
        this.salto.saltar(this);
    }
    public void correr(){
        this.corro.correr(this);
    }
    public void volar(){
        this.vuelo.volar(this);
    }
    public void reptar(){
        this.repto.reptar(this);
    }
    public abstract void dibujar() ;
}
