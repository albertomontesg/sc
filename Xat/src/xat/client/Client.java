package xat.client;

import xat.iu.InterficieUsuari;
import xat.iu.consola.InterficieUsuariConsola;
import xat.iu.gui.InterficieUsuariGui;
import xat.patrons.mvc.ModelLlista;
import xat.utils.Comunicacions;

/**
 * @author marcel
 */
public class Client {

    public static void main(String[] args) {

        Comunicacions clientComunicacions = new ClientStream();
    
        //Model
        ModelLlista<String> modelMissatgesRebuts = new ModelLlista<String>();

        //Vista
        int opcio = 1;
		final InterficieUsuari<String> vista = 
        		(opcio == 1) ? new InterficieUsuariConsola<String>(modelMissatgesRebuts) : 
        				   			new InterficieUsuariGui<String>(modelMissatgesRebuts);
        
        //Controladors
        ControladorEntradaUsuari controladorEntradaUsuaris = 
                new ControladorEntradaUsuari(modelMissatgesRebuts, vista, clientComunicacions);
        controladorEntradaUsuaris.start();
        ControladorComunicacions controladorComunicacions = 
                new ControladorComunicacions(modelMissatgesRebuts, clientComunicacions);
        controladorComunicacions.start();
    }
}
