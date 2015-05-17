import java.util.List;


public class Solver {

	protected Sistema sistema;
	protected Solucion solucion;
	protected List<Object> elementos;
	protected Resolucion resolucion;
	protected FabricaProductosMEF fabrica;
	
	public Solver(List<Object> elem) {
		this.elementos = elem;
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
		this.resolucion = this.fabrica.createObjetoResolucion(tipoRS);
		
		ensamblarElementos();
		if (resolucion != null)
			resolucion.resolverSistema();
		else
			System.out.println("Metodo de resolucion no valido");
	}
	
}