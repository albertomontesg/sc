package nio;

import java.io.IOException;

public abstract class Seleccionable<T> {
	protected Selector<T> selector;
	
	public abstract boolean preparat() throws IOException;
	
	public abstract T obtenirResultat() throws IOException;
	
	public void asociarSelector(Selector<T> sel) { // Registre
		selector = sel;
	}
}
