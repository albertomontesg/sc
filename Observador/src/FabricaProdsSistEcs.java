import java.util.ArrayList;
import java.util.List;


public class FabricaProdsSistEcs extends FabricaProductosMEF implements Subject{

	protected List<Observador> observers = new ArrayList<Observador>();
	
	@Override
	public Sistema createSistema(String tipo) {
		Matriz m = (tipo == "MatrizCompleta") ? new MatrizCompleta() :
	     	(tipo == "MatrizDiagonales") ? new MatrizDiagonales() :
	     									new MatrizSkyline();
	    MiVector v = new MiVector();
		return new SistemaEcuaciones(m,v);
	}

	@Override
	public Resolucion createObjetoResolucion(String metodo) {
		Resolucion res = null;
		if (metodo == "EcsA") {
			res = new ResolucionSistEcsA();
			notifyObservers("Sistema Resolucion EcsA creado");
		}
		else if (metodo == "EcsB") {
			res = new ResolucionSistEcsB();
			notifyObservers("Sistema Resolucion EcsB creado");
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
