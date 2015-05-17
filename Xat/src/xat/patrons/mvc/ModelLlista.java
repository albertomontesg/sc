/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xat.patrons.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marcel
 * @param <U>
 */
public class ModelLlista<U> extends ModelAbstracte<U> {

    protected ArrayList<U> llista;
    protected U ultimAfegit;

    public ModelLlista() {
        llista = new ArrayList<U>();
    }

    public List<U> getValor() {
        return llista;
    }

    public U getUltimAfegit() {
       return ultimAfegit;
    }

    public void setValor(U valor) {
    	//completar
    	ultimAfegit = valor;
    	llista.add(valor);
    	setChanged();
    	notifyObservers();

    }
}