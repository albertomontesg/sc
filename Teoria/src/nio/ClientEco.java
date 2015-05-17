package nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class ClientEco extends Thread {
	protected SocketChannel sc;
	protected BufferedReader teclat;
	
	@SuppressWarnings("static-access")
	public ClientEco(int port) {
		try {
			sc.open(new InetSocketAddress(port));
			sc.configureBlocking(true);
			teclat = new BufferedReader(new InputStreamReader(System.in));
		} catch (IOException e) {e.printStackTrace();}
		
	}
	
	public void run() {
		String linia;
		ByteBuffer buf;
		Charset caracters = Charset.forName("UTF_16");
		CharsetEncoder codificador = caracters.newEncoder();
		CharsetDecoder decodificador = caracters.newDecoder();
		while (true) {
			try {
				linia = teclat.readLine();
				buf = codificador.encode(CharBuffer.wrap(linia));
				sc.write(buf);
				buf.clear();
				sc.read(buf);
				buf.flip();
				StringBuffer sb = new StringBuffer();
				sb.append(decodificador.decode(buf));
				System.out.println(new String(sb));
			} catch (IOException e) {e.printStackTrace();}
		}
	}
}
