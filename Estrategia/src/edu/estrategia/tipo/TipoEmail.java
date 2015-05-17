package edu.estrategia.tipo;

public class TipoEmail implements Tipo{

	@Override
	public boolean verificar(String valor) {
		//Unimplemented
		return valor.contains("@") && !valor.contains(" ");
	}

}
