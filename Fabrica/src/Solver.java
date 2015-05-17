import java.util.List;


public abstract class Solver {

	protected Sistema sistema;
	protected Solucion solucion;
	protected List<Object> elementos;
	
	public Solver(List<Object> elem) {
		this.elementos = elem;
	}
	
	public void ensamblarElementos() {
		System.out.println("Estoy ensamblando contribuciones de elementos en matriz creada...");
	}
	
	public Solucion getSolucion() {
		return solucion;
	}
	
	protected abstract void resolverSistema();
	protected abstract Sistema createSistema(String tipo);
	
	public void resolver(String tipoM) {
		sistema = createSistema(tipoM);
		ensamblarElementos();
		resolverSistema();
		solucion = new Solucion();
	}
	
}
