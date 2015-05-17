package edu.estrategia;

import edu.estrategia.tipo.Tipo;

public class Campo {
	
	protected Tipo tipo;
	
	protected String etiqueta;
	protected String valor;
	
	public Campo(String n) {
		this.etiqueta = n;
	}
	
	public void setValor(String v) {
		this.valor = v;
	}
	
	public void setTipo(Tipo t) {
		this.tipo = t;
	}
	
	public boolean verificar() {
		return tipo.verificar(valor);
	}
}
