import java.util.Iterator;


public abstract class ComponenteFormulario {
	
	public abstract String getValue() ;
	public abstract String getEtiqueta() ;
	public abstract void setEtiqueta(String e) ;
	public abstract void setVerifier(Verifier v) ;
	public abstract boolean verify() ;
	public abstract boolean isItOK() ;
	public abstract void addComponente(ComponenteFormulario c) ;
	public abstract ComponenteFormulario removeComponente(ComponenteFormulario c) ;
	@Override
	public abstract String toString() ;
	public abstract Iterator createIterator() ;
	public abstract boolean canAskValue() ; // informa de si para el componente puede preguntarse un valor
	public abstract void setValue(String val) ;
}
