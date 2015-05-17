package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class ServidorEco extends Thread {
	protected ServerSocketChannel ssc;
	protected Selector selector;
	
	public ServidorEco(int port) {
		try {
			ssc = ServerSocketChannel.open();
			ssc.configureBlocking(false);
			ssc.socket().bind(new InetSocketAddress(port));
			selector = Selector.open();
		} catch (IOException e) {e.printStackTrace();}
	}
	
	public void run() {
		try {
			ssc.register(selector, SelectionKey.OP_ACCEPT);
		
			while (true) {
				selector.select();
				Set<SelectionKey> claus = selector.selectedKeys();
				Iterator<SelectionKey> iter = claus.iterator();
				while (iter.hasNext()) {
					SelectionKey clau = iter.next();
					if(clau.isAcceptable()) {
						// fer Accept clau
						ferAccept(clau);
					} else if(clau.isReadable()) {
						// han arribat dades
						// fer eco clau
						ferEco(clau);
					}
					iter.remove();
				}
			}
		} catch (IOException e) {e.printStackTrace();}
			
		
	}

	protected void ferAccept(SelectionKey clau) {
		try {
			SocketChannel socket = ((ServerSocketChannel) clau.channel()).accept();
			socket.configureBlocking(false);
			socket.register(selector, SelectionKey.OP_READ);
			
		} catch (IOException e) {e.printStackTrace();}
	}

	@SuppressWarnings("unused")
	protected void ferEco(SelectionKey clau) {
		SocketChannel sc = (SocketChannel) clau.channel();
		ByteBuffer espai = ByteBuffer.allocate(2048);
		int bytesLlegir = 0;
		try {
			bytesLlegir = sc.read(espai);
			espai.flip();
			while(espai.hasRemaining()) {
				sc.write(espai);
			}
		} catch (IOException e) {e.printStackTrace();}
		
	}
}
