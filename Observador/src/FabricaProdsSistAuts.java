import java.util.ArrayList;
import java.util.List;


public class FabricaProdsSistAuts extends FabricaProductosMEF implements Subject {

	protected List<Observador> observers = new ArrayList<Observador>();
	
	@Override
	public Sistema createSistema(String tipo) {
		Matriz m = (tipo == "MatrizCompleta") ? new MatrizCompleta() :
		     (tipo == "MatrizDiagonales") ? new MatrizDiagonales() :
		    	 							new MatrizSkyline();
		return new SistemaAutoValores(m);
	}

	@Override
	public Resolucion createObjetoResolucion(String metodo) {
		Resolucion res = null;
		if (metodo == "AutA") {
			res = new ResolucionSistAutsA();
			notifyObservers("Sistema Resolucion AutA creado");
		}
		else if (metodo == "AutB") {
			res = new ResolucionSistAutsB();
			notifyObservers("Sistema Resolucion AutB creado");
		}
	
		return res;
	}
	
	public void registerObserver(Observador o) {
		observers.add(o);
	}

	public void unregisterObserver(Observador o) {
		throw new UnsupportedOperationException("Impossible unregister observer");
	}

	public void notifyObservers(String mess) {
		for(Observador o : observers)
			o.update(mess);
	}

}
