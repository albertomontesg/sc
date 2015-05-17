package xat.client.nio;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Clase que encapsula un stream i que ulitza el selector per veure quan es produeixen events
 * en aquest i tractar les dades rebudes d'aquest stream
 * @author Alberto Montes
 * @version May 10, 2014
 */
public class StreamSeleccionable extends Seleccionable<String> {
	
	protected BufferedReader entrada;
	
	/**
	 * Es crea a partir d'un buffer
	 * @param br buffer del stream que encapsula
	 */
	public StreamSeleccionable(BufferedReader br) {
		entrada = br;
	}
	
	/**
	 * Retorna les dades que hi ha al stream
	 */
	@Override
	public String obtenirResultat() throws IOException {	
		return entrada.readLine();
	}
	
	/**
	 * Indica si hi ha nova informacio al buffer del stream
	 */
	@Override
	public boolean preparat() throws IOException {
		return entrada.ready();
	}

}
