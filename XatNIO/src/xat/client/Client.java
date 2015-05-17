package xat.client;

import xat.iu.InterficieUsuari;
import xat.iu.consola.InterficieUsuariConsola;
import xat.patrons.mvc.ModelLlista;

/**
 * @author marcel
 */
public class Client {

    public static void main(String[] args) {
        
        //Model
        ModelLlista<String> modelMissatgesRebuts = new ModelLlista<String>();

        //Vista
		@SuppressWarnings("unused")
		final InterficieUsuari<String> vista =  new InterficieUsuariConsola<String>(modelMissatgesRebuts);
		
        //Client NIO
        ClientNIO client = new ClientNIO(modelMissatgesRebuts);
        client.start();
        
    }
}
