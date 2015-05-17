package xat.servidor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import xat.utils.Comms;

public class ServidorMonothreadNIO extends Thread{
	
	protected ServerSocketChannel ssc;
	protected Selector selector;
	protected List<SocketChannel> clients;
	
	public ServidorMonothreadNIO() {
		clients = new ArrayList<SocketChannel>();
		try {
			ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(Comms.portServidor));
			selector = Selector.open();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void run() {
		try {
			ssc.register(selector, SelectionKey.OP_ACCEPT);
		
			while (true) {
				selector.select();
				Set<SelectionKey> keys = selector.selectedKeys();
				Iterator<SelectionKey> iter = keys.iterator();
				while (iter.hasNext()) {
					SelectionKey key = iter.next();
					if(key.isAcceptable()) {
						// fer Accept clau
						accept(key);
					} else if(key.isReadable()) {
						// han arribat dades -> enviar el missatge a la resta de clients
						// fer eco clau
						receive(key);
					}
					iter.remove();
				}
			}
		} catch (IOException e) {e.printStackTrace();}
	}

	private void receive(SelectionKey key) {
		SocketChannel sc = (SocketChannel) key.channel();
		ByteBuffer espai = ByteBuffer.allocate(2048);
		// falla aqui
		try {
			// devuelve -1 si recibe del canal que el cliente se ha desconectado
			int r = sc.read(espai);
			if (r == -1) {
				clients.remove(sc);
				key.cancel();
				//se quita el cliente del selector para que deje de mirar si le viene informacion por eso te salia un
				//error que se repetia constatemente ya a cada iteracion del selector aparecia la llave de este cliente que estaba desconectado
				System.out.println("Cliente eliminado!");
				return;
				// ahora funcionarave
			}
			
			espai.flip();
			for (SocketChannel s : clients) {
				ByteBuffer espaiCopy = espai.duplicate();
				while (espaiCopy.hasRemaining())
					s.write(espaiCopy);
			}
			
		} catch (IOException e) {e.printStackTrace();}
		
	}//y eso??? espera
	

	private void accept(SelectionKey key) {
		try {
			SocketChannel socket = ((ServerSocketChannel) key.channel()).accept();
			socket.configureBlocking(false);
			socket.register(selector, SelectionKey.OP_READ);
			// Guardem el client
			clients.add(socket);
		} catch (IOException e) {e.printStackTrace();}
	}

}
