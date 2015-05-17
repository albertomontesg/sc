

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Formulario extends ComponenteFormulario{
	
	protected List<Campo> componentes;
	protected Iterator iterator;
	
	
	public Formulario() {
		componentes = new ArrayList<Campo>();
		
		
	}
	/*
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
*/
	
	@Override
	public String getValue() {
		
		return null;
	}

	@Override
	public String getEtiqueta() {
		
		return null;
	}

	@Override
	public void setEtiqueta(String e) {
	}

	@Override
	public void setVerifier(Verifier v) {
	}

	@Override
	public boolean verify() {
		
		return false;
	}

	@Override
	public boolean isItOK() {
		
		return false;
	}

	@Override
	public void addComponente(ComponenteFormulario c) {
	}

	@Override
	public ComponenteFormulario removeComponente(ComponenteFormulario c) {
		
		return null;
	}

	@Override
	public String toString() {
		
		return null;
	}

	@Override
	public Iterator createIterator() {
		if(this.iterator==null || (this.iterator!=null && !this.iterator.hasNext())){
			this.iterator = new CompositeIterator(this.componentes.iterator()); 
		}
		return this.iterator;
	}

	@Override
	public boolean canAskValue() {
		
		return false;
	}

	@Override
	public void setValue(String val) {
	}
}
