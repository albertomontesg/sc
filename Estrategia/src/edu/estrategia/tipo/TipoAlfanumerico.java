package edu.estrategia.tipo;

public class TipoAlfanumerico implements Tipo{

	@Override
	public boolean verificar(String valor) {
		for(int i = 0; i < valor.length(); i++) {
			char c = valor.charAt(i);
			if(!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')))
				return false;
		}
		return true;
	}

}
