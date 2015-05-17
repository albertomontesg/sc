package mvc.comtador;

/**
 * 
 * @author Alberto Montes
 * @version Mar 7, 2014
 */
public class Counter extends Model{
    
    protected int valor;
    
    public void inc(){
        valor++;
        avisarVistes();
    }
    
    public int getValor(){
    	return valor;
    }
}
