import java.util.Iterator;



public class Campo extends ComponenteFormulario{
	
	protected Verifier tipo;
	
	protected String etiqueta;
	protected String valor;
	
	public Campo(String n) {
		this.etiqueta = n;
	}
	
	public void setValor(String v) {
		this.valor = v;
	}
	
	public void setTipo(Verifier t) {
		this.tipo = t;
	}
	
	public boolean verificar() {
		return tipo.verificar(valor);
	}

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
		
		return new NullIterator();
	}

	@Override
	public boolean canAskValue() {
		
		return true;
	}

	@Override
	public void setValue(String val) {
	}
}
