package xat.client.nio;

/**
 * Clase que es la clau que encapsula un seleccionable que te nova informacio emmagatzemada
 * @author Alberto Montes
 * @version May 10, 2014
 * @param <T>
 */
public class ClauSelector<T> {
	public static final int TECLAT = 100;
	public static final int SOCKET = 200;
	
	protected int tipus;
	protected Seleccionable<T> seleccionable;
	
	public ClauSelector(Seleccionable<T> s, int t) {
		tipus = t;
		seleccionable = s;
	}
	
	public boolean esTeclat() {
		return tipus == TECLAT;
	}
	
	public boolean esSocket() {
		return tipus == SOCKET;
	}
	
	public Seleccionable<T> obtenirSeleccionable() {
		return seleccionable;
	}

}
