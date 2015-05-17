
public class FabricaProdsSistAuts extends FabricaProductosMEF{

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
		if (metodo == "AutA")
			res = new ResolucionSistAutsA();
		else if (metodo == "AutB")
			res = new ResolucionSistAutsB();
		return res;
	}

}
