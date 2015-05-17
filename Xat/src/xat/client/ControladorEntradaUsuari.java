package xat.client;

import xat.iu.InterficieUsuari;
import xat.patrons.mvc.ModelAbstracte;
import xat.utils.Comunicacions;

/**
 *
 * @author marcel
 */
public class ControladorEntradaUsuari extends Thread {

    protected Comunicacions comunicacions;
    private final InterficieUsuari<?> vista;
    @SuppressWarnings("unused")
	private final ModelAbstracte<String> model;

    public ControladorEntradaUsuari(ModelAbstracte<String> model,
            InterficieUsuari<?> vista,
            Comunicacions comunicacions) {

        this.comunicacions = comunicacions;
        this.vista = vista;
        this.model = model;
    }

    @Override
    public void run() {
    	while(true) {
    		String line = vista.obtenirEntradaDades().obtenirEntradaUsuari();// rebre del usuari
    		comunicacions.enviar(line);
    		if(line == null) break;
    	}
    }
}
