
public class FabricaProdsSistEcs extends FabricaProductosMEF{

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
		if (metodo == "EcsA")
			res = new ResolucionSistEcsA();
		else if (metodo == "EcsB")
			res = new ResolucionSistEcsB();
		return res;
	}

}
