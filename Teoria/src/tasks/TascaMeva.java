package tasks;

/**
 * Classe que realitza una tasca i aquesta guarda el resultat. No ens assegurem
 * que retornem el resultat un cop la tasca hagi finalitzat.
 * @author Alberto Montes
 * @version 2014-04-24
 */
public class TascaMeva implements Runnable{

	protected int resultat;
	
	/** 
	 * Retorna el valor del resultat de la tasca pero si es crida abans de que la tasca hagi 
	 * acabat retornara un valor incorrecte i no dessitjat (0)
	 * @return
	 */
	public int obtenirResultat() {
		return resultat;
	}
	
	/**
	 * Codi d'execucio d'una tasca
	 */
	@Override
	public void run() {
		int temps = (int) (Math.random() * 1000);
		// temps que tirga la tasca a realitzar-se
		try {Thread.sleep(temps);} catch (InterruptedException e) {e.printStackTrace();}
		resultat = temps;
	}

}
