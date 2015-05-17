

public class TipoEmail implements Verifier{

	@Override
	public boolean verificar(String valor) {
		//Unimplemented
		return valor.contains("@") && !valor.contains(" ");
	}

}
