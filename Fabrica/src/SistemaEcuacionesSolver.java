import java.util.List;


public class SistemaEcuacionesSolver extends Solver{

	public SistemaEcuacionesSolver(List<Object> elem) {
		super(elem);
	}

	@Override
	protected void resolverSistema() {
		System.out.println("Estoy resolviendo el sistema de ecuaciones sobre la matriz creada y terminos independientes en el vector creado...");
	}

	@Override
	protected Sistema createSistema(String tipo) {
		Matriz m = (tipo == "MatrizCompleta") ? new MatrizCompleta() :
		     	(tipo == "MatrizDiagonales") ? new MatrizDiagonales() :
		     									new MatrizSkyline();
		Sistema s = new SistemaEcuaciones(m, new MiVector());
		return s;
	}

}
