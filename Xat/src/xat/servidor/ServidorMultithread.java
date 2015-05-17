package xat.servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

import xat.utils.Comms;

/**
 *
 * @author marcel
 */
public class ServidorMultithread extends Thread {
	private CopyOnWriteArrayList<Worker> clients;
	private ServerSocket server;
	
	public ServidorMultithread() {
		clients = new CopyOnWriteArrayList<Worker>();
	}
	
	public void run() {
		try {
		
			server = new ServerSocket(Comms.portServidor);
			while (true) {
				// Get the socket of the input connection
				Socket socket = server.accept();
				
				// Create and start the Thread for this new connection/client
				Worker w = new Worker(socket);
				clients.add(w);
				w.start();
			}
			
		} catch(Exception e) {}
	}
	
	class Worker extends Thread {
		private Socket socket;
		protected BufferedReader reader;
		protected PrintWriter writer;
		
		public Worker(Socket s) {
			this.socket = s;
			try {
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer = new PrintWriter(socket.getOutputStream(), true);
				System.out.println("New Worker started " + this.getName());
			} catch (IOException e) {e.printStackTrace();}
		}
		
		public void run() {
			
			try {
				
				String line;
				
				// While there isn't an EOF keep reading from the client and sending the echo answer
				while ((line = reader.readLine()) != null) {
					System.out.println(this.getName() + ": " + line);
					for(Worker w : clients)
						w.writer.println(line);
				}
				System.out.println("Worker ended");
				// Send an End of Stream so the client would receive and EOF
				socket.shutdownInput();
				
				// Close all the streams and connections
				reader.close();
				writer.close();
				socket.close();
			} catch (Exception e) {e.printStackTrace();}
			
		}

	}
	
}


