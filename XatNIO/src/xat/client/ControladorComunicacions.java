package xat.client;

import xat.patrons.mvc.ModelAbstracte;
import xat.utils.Comunicacions;

/**
 *
 * @author marcel
 */
public class ControladorComunicacions extends Thread {

    protected ModelAbstracte<String> model;
    protected Comunicacions comms;

    public ControladorComunicacions(ModelAbstracte<String> model,
            Comunicacions comms) {
        this.model = model;
        this.comms = comms;
    }

    public void run() {
    	while(true) {
    		String line = comms.rebre();
    		//System.out.println("Rebut: " + line);
    		if (line == null) break;
    		model.setValor(line);
    	}
    }
}
