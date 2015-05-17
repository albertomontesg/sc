package nio;

import java.io.BufferedReader;
import java.io.IOException;

public class StreamSeleccionable extends Seleccionable<String> {
	
	protected BufferedReader entrada;
	
	public StreamSeleccionable(BufferedReader br) {
		entrada = br;
	}
	
	@Override
	public String obtenirResultat() throws IOException {	
		return entrada.readLine();
	}
	
	@Override
	public boolean preparat() throws IOException {
		return entrada.ready();
	}

}
