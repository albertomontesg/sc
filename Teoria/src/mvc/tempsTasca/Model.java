package mvc.tempsTasca;

import java.util.*;

/**
 * Model que al acabar una tasca se li pasa el temps d'execucio
 * i aquest actualitzara als observador (Vista en aquest cas) per
 * que actualitzin les dades mostrades.
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class Model extends Observable{
	protected int tempsUltima, tempsTotal, numTasques;
	
	public synchronized void tascaAcabada(int t) {
		numTasques++;
		tempsUltima = t;
		tempsTotal += t;
		/* S'indica que s'ha canvia l'objecte observat i notifica 
		 * als que l'estan observant */
		setChanged();
		notifyObservers();
	}

	public synchronized int getTempsUltima() {
		return tempsUltima;
	}

	public synchronized int getTempsTotal() {
		return tempsTotal;
	}

	public synchronized int getNumTasques() {
		return numTasques;
	}
	
}
