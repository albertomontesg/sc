package tasks;

import java.util.ArrayList;

/**
 * Classe que executa una llista de TascaMeva y que despres de executar-les imprimeix la suma dels
 * resultats de totes les tasques. A l'hora d'obtenir els resultats es necessari esperar a que totes
 * les tasques s'hagin executat i per aixo fem us del metode esperarFinsQueAcabin() el qual es 
 * bloquejant fins que totes les tasques hagin acabat.
 * @author Alberto Montes
 * @version 2014-04-24
 */
public class Executor {

	// Escull si vols utilitzar TascaMevaFutur o TascaMeva
	protected static boolean FUTUR = false;
	
	protected ArrayList<Thread> threads = new ArrayList<Thread>();
	
	/**
	 * Metode que al passar-li una llista de TascaMeva les executa cadascuna en un thread diferent.
	 * Si les tasques son curtes i molt nombroses no es optim executar-les cadascuna en un thread
	 * diferent.
	 * @param tasques
	 */
	public void executar(ArrayList<TascaMeva> tasques) {
		for(TascaMeva tasca : tasques) {
			Thread t = new Thread(tasca);
			threads.add(t);
			t.start();
		}
	}
	
	/**
	 * Metode que espera a que acabin totes les tasques de executar-les i aixi poder consultar 
	 * el resultat amb la seguretat de que sera el resultat final
	 */
	public void esperarFinsQueAcabin() {
		for(Thread t : threads) {
			try {t.join();} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
	/**
	 * Exemple de execucio
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicialitzem tasques
		ArrayList<TascaMeva> tasques = new ArrayList<TascaMeva>();
		for (int i = 0; i < 10; i++)
			tasques.add((FUTUR) ? new TascaMevaFutur() : new TascaMeva());
		
		// Es crea el executor i es passa la llista de tasques a executar
		Executor exec = new Executor();
		exec.executar(tasques);
		
		/* Abans de recorrer les tasques per obtenir els resultats ens haurem d'assegurar
		 * que totes les tasques hagin acabat, o lo que es el mateix, a que el thread que
		 * executa cada tasca hagi acabat la seva execucio (join()).
		 */
		if (!FUTUR) exec.esperarFinsQueAcabin();
		
		int tempsTotal = 0;
		for (TascaMeva tasca : tasques) {
			tempsTotal += tasca.obtenirResultat();
		}
		System.out.println("Temps Total: " + tempsTotal);
	}
} 
