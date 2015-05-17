package xat.client.nio;

import java.io.IOException;

/**
 * Clase que encapsula un objecte seleccionble pel selector
 * @author Alberto Montes
 * @version May 10, 2014
 * @param <T>
 */
public abstract class Seleccionable<T> {
	protected Selector<T> selector;
	
	public abstract boolean preparat() throws IOException;
	
	public abstract T obtenirResultat() throws IOException;
	
	/**
	 * Selecciona el selector al seleccionable registrant el seleccionable al selector 
	 * per a la recepcio de noves dades provinents del seleccionable
	 * @param sel
	 * @param tipus
	 */
	public void asociarSelector(Selector<T> sel, int tipus) {
		selector = sel;
		sel.addSeleccionable(this, tipus);
	}
}
