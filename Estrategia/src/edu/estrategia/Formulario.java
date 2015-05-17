package edu.estrategia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.estrategia.tipo.TipoAlfanumerico;
import edu.estrategia.tipo.TipoEmail;
import edu.estrategia.tipo.TipoEntero;

public class Formulario {
	
	public List<Campo> campos;
	
	
	public Formulario() {
		campos = new ArrayList<Campo>();
		
		Campo c1 = new Campo("Nombre");
		c1.setTipo(new TipoAlfanumerico());
		campos.add(c1);
		
		Campo c2 = new Campo("Edad");
		c2.setTipo(new TipoEntero());
		campos.add(c2);
		
		Campo c3 = new Campo("Mail");
		c3.setTipo(new TipoEmail());
		campos.add(c3);
	}
	
	public void verificar() {
		List<Campo> incorrectos = new ArrayList<Campo>();
		for(Campo c : campos) {
			boolean correcto = c.verificar();
			String response = (correcto) ? (c.etiqueta + ": " + c.valor + " CORRECTO"):
				(c.etiqueta + ": " + c.valor + " INCORRECTO");
			System.out.println(response);
			if(!correcto) incorrectos.add(c);
		}
		
		// repreguntar els incorrectes
		if(incorrectos.size() > 0) {
			for(Campo c : incorrectos) preguntarCampo(c);
			verificar();
		}
	}
	
	public void preguntar() {
		for(Campo c : campos) {
			preguntarCampo(c);
		}
	}
	
	public void preguntarCampo(Campo c) {
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(c.etiqueta + ": ");
		String valor = "";
		try {valor = input.readLine();
		} catch (IOException e) {}
		c.setValor(valor);
	}
	
	public static void main(String[] args) {
		Formulario formulario = new Formulario();
		formulario.preguntar();
		formulario.verificar();
	}
}
