package xat.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

import xat.utils.Comms;
import xat.utils.Comunicacions;

public class ClientNIO implements Comunicacions{

	protected SocketChannel sc;
	private ByteBuffer buf;
	private CharsetEncoder codificador;
	private CharsetDecoder decodificador;
	
	public ClientNIO() {
		try {
			sc = SocketChannel.open(new InetSocketAddress(Comms.host, Comms.portServidor));
			sc.configureBlocking(true);
			Charset caracters = Charset.forName("UTF_16");
			codificador = caracters.newEncoder();
			decodificador = caracters.newDecoder();
			buf = ByteBuffer.allocate(2048);
		} catch (IOException e) {e.printStackTrace();}
		
	}
	
	@Override
	public void enviar(String s) {
		try {
			buf = codificador.encode(CharBuffer.wrap(s));
			sc.write(buf);
			buf.clear();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String rebre() {
		String line = null;
		try {
			sc.read(buf);
			buf.flip();
			StringBuffer sb = new StringBuffer();
			sb.append(decodificador.decode(buf));
			line = sb.toString();
			buf.rewind();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return line;
	}
	
	
	
}
