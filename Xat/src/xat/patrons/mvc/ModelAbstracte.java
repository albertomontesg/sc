/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package xat.patrons.mvc;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author marcel
 * @param <T>
 */
public abstract class ModelAbstracte<T> extends Observable {

    public void afegirObservador(Observer obsr) {
        addObserver(obsr);
    }

    protected void avisarObservadors() {
        setChanged();
        notifyObservers();
    }

    public abstract void setValor(T valor);

}
