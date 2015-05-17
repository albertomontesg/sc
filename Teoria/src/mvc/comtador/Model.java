package mvc.comtador;

import java.util.Observable;

/**
 * 
 * @author Alberto Montes
 * @version Mar 7, 2014
 */
public abstract class Model extends Observable{
    
    public void avisarVistes(){
        setChanged();
        notifyObservers();
    }

}
