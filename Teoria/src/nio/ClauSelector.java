package nio;

public class ClauSelector<T> {
	protected static final int TECLAT = 100;
	protected static final int SOCKET = 200;
	
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
