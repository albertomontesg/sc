

public class TipoEntero implements Verifier{

	@Override
	public boolean verificar(String valor) {
		for(int i = 0; i < valor.length(); i++) {
			char c = valor.charAt(i);
			if(!(c >= '0' && c <= '9'))
				return false;
		}
		return true;
	}

}
