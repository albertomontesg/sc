
public abstract class FabricaProductosMEF implements Subject{

	public abstract Sistema createSistema(String tipo);
	public abstract Resolucion createObjetoResolucion(String metodo);
	
}
