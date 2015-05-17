package xat.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import xat.utils.Comms;
import xat.utils.Comunicacions;

/**
 *
 * @author marcel
 */
public class ClientStream implements Comunicacions {
	protected Socket socket;
	protected BufferedReader reader;
	protected PrintWriter writer;
	
	public ClientStream() {
		try {
			socket = new Socket(Comms.host, Comms.portServidor);
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			writer = new PrintWriter(socket.getOutputStream(), true);
			
		} catch (UnknownHostException e) {e.printStackTrace();
		} catch (IOException e) {e.printStackTrace();}
		
	}
	
	
	@Override
	public void enviar(String s) {
		if (s == null)
			writer.close();
		writer.println(s);
	}

	@Override
	public String rebre() {
		String line = null;
		try {
			line = reader.readLine();
			if (line == null)
				reader.close();
		} catch (IOException e) {}
		return line;
	}

}
