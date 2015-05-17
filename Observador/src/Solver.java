import java.util.ArrayList;
import java.util.List;


public class Solver implements Subject{

	protected Sistema sistema;
	protected Solucion solucion;
	protected List<Object> elementos;
	protected Resolucion resolucion;
	protected FabricaProductosMEF fabrica;
	
	protected List<Observador> observers;
	
	public Solver(List<Object> elem) {
		this.elementos = elem;
		observers = new ArrayList<Observador>();
	}
	
	public void setFabricaProductosMEF(FabricaProductosMEF f) {
		this.fabrica = f;
	}
	
	public void ensamblarElementos() {
		System.out.println("Estoy ensamblando contribuciones de elementos en matriz creada...");
	}
	
	public Solucion getSolucion() {
		return solucion;
	}
	
	public void resolver(String tipoM, String tipoRS) {
		this.sistema = this.fabrica.createSistema(tipoM);
		notifyObservers("Sistema creado");
		this.resolucion = this.fabrica.createObjetoResolucion(tipoRS);
		notifyObservers("Objeto Resolucion creado");
		
		ensamblarElementos();
		notifyObservers("Ensamblados elementos");
		
		if (resolucion != null) {
			resolucion.resolverSistema();
			notifyObservers("Sistema resuelto");
		}
		else
			System.out.println("Metodo de resolucion no valido");
	}

	@Override
	public void registerObserver(Observador o) {
		observers.add(o);
	}

	@Override
	public void unregisterObserver(Observador o) {
		throw new UnsupportedOperationException("Impossible unregister observer");
	}

	@Override
	public void notifyObservers(String mess) {
		for(Observador o : observers)
			o.update(mess);
	}
	
}