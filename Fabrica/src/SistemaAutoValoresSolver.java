import java.util.List;


public class SistemaAutoValoresSolver extends Solver{

	public SistemaAutoValoresSolver(List<Object> elem) {
		super(elem);
	}

	@Override
	protected void resolverSistema() {
		System.out.println("Estoy resolviendo el sistema de ecuaciones sobre la matriz creada...");
	}

	@Override
	protected Sistema createSistema(String tipo) {
		Matriz m = (tipo == "MatrizCompleta") ? new MatrizCompleta() :
			     (tipo == "MatrizDiagonales") ? new MatrizDiagonales() :
			    	 							new MatrizSkyline();
		Sistema s = new SistemaAutoValores(m);
		return s;
	}

}
