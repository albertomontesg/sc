package xat.iu.consola;

import java.util.Observable;

import xat.iu.InterficieUsuari;
import xat.patrons.mvc.ModelLlista;
import xat.patrons.mvc.Vista;

/**
 *
 * @author marcel
 * @param <T>
 */
public class InterficieUsuariConsola<T extends String> extends InterficieUsuari<T> implements Vista {
	
	public InterficieUsuariConsola(ModelLlista<T> model) {
    	modelLlista = model;
    	modelLlista.addObserver(this);
    	sortida = new SortidaDadesPantalla();
    	entrada = new EntradaDadesTeclat();
    }
    
    /**
     * Quan arriba un nou missatge al model llista, s'impremeix per pantalla 
     * aquest ultim missatge deixat un registre de la conversa impressa
     */
    public void update(Observable o, Object arg) {
    	sortida.escriureDades((String) modelLlista.getUltimAfegit());
    }

}
