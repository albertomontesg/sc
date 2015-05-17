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
		
		FabricaProductosMEF fabrica = new FabricaProdsSistEcs();
		Solver solver = new Solver(fem.elements);
		solver.setFabricaProductosMEF(fabrica);
		solver.resolver("Skyline", "EcsA");
		
		/*
		FabricaProductosMEF fabrica = new FabricaProdsSistAuts();
		Solver solver = new Solver(fem.elements);
		solver.setFabricaProductosMEF(fabrica);
		solver.resolver("MatrizCompleta", "AutA");
		*/
		
		fem.postProcesar();
	}
	
}
