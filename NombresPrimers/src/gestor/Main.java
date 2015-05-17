package gestor;

import java.util.ArrayList;

/**
 * @author Yaiza Barrientos, Alberto Montes
 * @subject SC
 * @date 21 feb 2014
 * @exercise Practica 1
 * Generacio de Nombres Primers
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("Starting...\n3");
		int N = 1000;
		int num_threads = 20;
		Gestor g = new Gestor(N);
		ArrayList<Treballador> threads = new ArrayList<Treballador>(num_threads);
		for (int i = 0; i<num_threads; i++) {
			Treballador tr = new Treballador(N, g);
			tr.start();
			threads.add(tr);
		 }
	}
}
