import java.util.List;


public class FiniteElementsMethod {

	private Solucion solucion;
	private List<Object> elements;
	
	public void discretizar() {
		System.out.println("Estoy discretizando la region estudiada...");
	}
	
	public void renumerarNodos() {
		System.out.println("Estoy renumerando los nodos para minimizar almacenamiento requerido...");
	}
	
	public void postProcesar() {
		System.out.println("Estoy procesando la solución para presentarla...");
	}
	
	public Solucion getSolucion() {
		
		return solucion;
	}
	
	public static void main(String[] args) {
		FiniteElementsMethod fem = new FiniteElementsMethod();
		fem.discretizar();
		fem.renumerarNodos();
		Solver solver = new SistemaAutoValoresSolver(fem.elements);
		solver.resolver("MatrizSkyline");
		fem.solucion = solver.getSolucion();
		fem.postProcesar();
	}
	
}
