/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.etsetb.softcom.firststrategypattern.after;

import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.Ando;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoAndo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoCorro;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoRepto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoSalto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.ComportamientoVuelo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.Corro;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.NoAndo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.NoCorro;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.NoRepto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.NoSalto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.NoVuelo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.Planeo;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.Repto;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.SaltoAdelante;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.SaltoAtras;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.SaltoLateral;
import edu.upc.etsetb.softcom.firststrategypattern.after.behaviours.Vuelo;

/**
 *
 * @author JuanCarlos
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Crear los diferentes personajes
        Humano corredor = new Humano("corredor");
        Leon leon = new Leon();
        Tigre tigre = new Tigre();
        Aguila aguila = new Aguila();
        Pato pato = new Pato();
        Piton piton = new Piton();

        // Crear los objetos comportamiento

        ComportamientoAndo ando = new Ando();
        ComportamientoAndo noAndo = new NoAndo();

        ComportamientoSalto noSalto = new NoSalto();
        ComportamientoSalto saltoAdelante = new SaltoAdelante();
        ComportamientoSalto saltoAtras = new SaltoAtras();
        ComportamientoSalto saltoLateral = new SaltoLateral();

        ComportamientoCorro corro = new Corro();
        ComportamientoCorro noCorro = new NoCorro();

        ComportamientoRepto repto = new Repto();
        ComportamientoRepto noRepto = new NoRepto();

        ComportamientoVuelo noVuelo = new NoVuelo();
        ComportamientoVuelo vuelo = new Vuelo();
        ComportamientoVuelo planeo = new Planeo();

        // Asignar comportamiento a personajes

        corredor.setAndo(ando);
        corredor.setCorro(corro);
        corredor.setVuelo(noVuelo);
        corredor.setRepto(noRepto);
        corredor.setSalto(saltoAdelante);

        leon.setAndo(ando);
        leon.setCorro(corro);
        leon.setVuelo(noVuelo);
        leon.setRepto(noRepto);
        leon.setSalto(saltoAdelante);

        tigre.setAndo(ando);
        tigre.setCorro(corro);
        tigre.setVuelo(noVuelo);
        tigre.setRepto(noRepto);
        tigre.setSalto(saltoAdelante);

        aguila.setAndo(ando);
        aguila.setCorro(noCorro);
        aguila.setVuelo(vuelo);
        aguila.setRepto(noRepto);
        aguila.setSalto(noSalto);

        pato.setAndo(ando);
        pato.setCorro(noCorro);
        pato.setVuelo(vuelo);
        pato.setRepto(noRepto);
        pato.setSalto(noSalto);
        
        piton.setAndo(noAndo);
        piton.setCorro(noCorro);
        piton.setVuelo(noVuelo);
        piton.setRepto(repto);
        piton.setSalto(noSalto);

        Personaje[] personajes = new Personaje[6];
        personajes[0] = corredor;
        personajes[1] = tigre;
        personajes[2] = leon;
        personajes[3] = aguila;
        personajes[4] = pato;
        personajes[5] = piton;

        System.out.println();

        Personaje p;
        for (int i = 0; i < personajes.length; i++) {
            p = personajes[i];
            p.andar();
            p.correr();
            p.saltar();
            p.volar();
            p.reptar();
            System.out.println();
        }
        System.out.println();
        System.out.println("** Cambio de comportamientos en tiempo de ejecucion ** ");
        System.out.println();
        corredor.setSalto(saltoAtras);
        corredor.saltar();
        corredor.setSalto(saltoLateral);
        corredor.saltar();
        aguila.setVuelo(planeo);
        aguila.volar();
    }
}
