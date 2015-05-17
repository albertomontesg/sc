package xat.iu.consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import xat.iu.EntradaDades;

/**
 *
 * @author marcel
 */
public class EntradaDadesTeclat implements EntradaDades {
	protected BufferedReader input;
	
	public EntradaDadesTeclat() {
		input = new BufferedReader(new InputStreamReader(System.in));
	}

    public String obtenirEntradaUsuari() {
        String line = null;
        try {
			line = input.readLine();
			if (line == null)
	        	input.close();
		} catch (IOException e) {e.printStackTrace();}
    	return line;
    }

}
