package xat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import xat.client.nio.ClauSelector;
import xat.client.nio.Selector;
import xat.client.nio.StreamSeleccionable;
import xat.patrons.mvc.ModelLlista;
import xat.utils.Comms;

/**
 * Clase que executa la connexio amb el servidor i que respon a la recepcio de dades tan 
 * del teclat com de la conexio amb el servidor.
 * @author Alberto Montes
 * @version May 10, 2014
 */
public class ClientNIO extends Thread {

	protected Socket socket;
	protected BufferedReader teclat;
	protected BufferedReader reader;
	protected PrintWriter writer;
	protected ModelLlista<String> model;
	
	public ClientNIO(ModelLlista<String> model) {
		this.model = model;
		
		try {
			// Estableix la connexio amb el servidor i crea els streams per communicar-se amb ell
			socket = new Socket(Comms.host, Comms.portServidor);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			// Crea el stream d'entrada del teclat
			teclat = new BufferedReader(new InputStreamReader(System.in));
			
		} catch (UnknownHostException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();}
		
		
	}
	
	public void run() {
		// Encapsula a dos seleccionables els streams del teclat i de recepcio del socket
		StreamSeleccionable streamSocket = new StreamSeleccionable(reader);
		StreamSeleccionable streamTeclat = new StreamSeleccionable(teclat);
		
		// Crea el selector
		Selector<String> sel = new Selector<String>();
		
		// Regstra els dos seleccionables al Selector
		streamSocket.asociarSelector(sel, ClauSelector.SOCKET);
		streamTeclat.asociarSelector(sel, ClauSelector.TECLAT);
		
		/* Per a cada pasada del bucle mira a veure si te nova informacio de qualsevol dels dos
		 * streams i realitza la tasca corresponent
		 */
		while (true) {
			sel.select();
			ArrayList<ClauSelector<String>> claus = sel.clausSeleccionades();
			for (ClauSelector<String> clau : claus) {
				if (clau.esSocket()) {
					rebreMissatge(clau);
				} else if(clau.esTeclat()) {
					enviarMissatge(clau);
				}
			}
		}
	}
	
	/**
	 * Si s'introdueixen noves dades per teclat, s'envia el missatge al Socket
	 * @param clau
	 */
	public void enviarMissatge(ClauSelector<String> clau) {
		try {
			writer.println(clau.obtenirSeleccionable().obtenirResultat());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Si s'han rebut dades del Socket s'afegeix el missatge rebut al model per a que actualitzi 
	 * la consola a partir del MVC
	 * @param clau
	 */
	public void rebreMissatge(ClauSelector<String> clau) {
		try {
			model.setValor(clau.obtenirSeleccionable().obtenirResultat());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
