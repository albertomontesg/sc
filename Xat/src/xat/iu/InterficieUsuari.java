package xat.iu;

import java.util.Observable;
import xat.patrons.mvc.ModelLlista;
import xat.patrons.mvc.Vista;

/**
 *
 * @author PCprofe
 */
public abstract class InterficieUsuari<T extends String> implements Vista {

    protected ModelLlista<T> modelLlista;
    protected EntradaDades entrada;
    protected SortidaDades sortida;
    
    public EntradaDades obtenirEntradaDades() {
        return entrada;
    }

    public SortidaDades obtenirSortidaDades() {
        return sortida;
    }

    @Override
    public void update(Observable o, Object arg) {
    		
    }
}

