
public class SistemaEcuaciones extends Sistema{

	protected MiVector vector;
	
	public SistemaEcuaciones(Matriz m, MiVector mv) {
		super(m);
		this.vector = mv;
	}
	
	public MiVector getVector() {
		return this.vector;
	}

}
