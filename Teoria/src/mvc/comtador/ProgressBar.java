/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mvc.comtador;

import mvc.comtador.View;

import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

/**
 * 
 * @author Alberto Montes
 * @version Mar 7, 2014
 */
public class ProgressBar implements View {
	protected Counter model;
    protected JProgressBar progres;  //etiqueta que mostra el numero de clicks
    
    public ProgressBar(Counter m) {
        model = m;
        progres = new JProgressBar(0,10);  //Configurem la barra de progres de 0 a 10.
        progres.setValue(m.getValor());
        progres.setStringPainted(true);
        model.addObserver((Observer) this); //Important! afegir la vista com a observador.    
    }
    
    public void update(Observable ignorarObs, Object ignorarObj) {
        progres.setValue(model.getValor()); //actualitza el numero de clicks
    }
}