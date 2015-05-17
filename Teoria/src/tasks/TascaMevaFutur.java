package tasks;

/**
 * Implementacio propia d'una tasca que implementa Runnable i que retorna un resultat
 * @author Alberto Montes
 * @version 2014-04-24
 */
public class TascaMevaFutur extends TascaMeva implements Runnable{

	protected int resultat;
	protected boolean acabat = false;
	
	/**
	 * @return Retorna si ha acabat l'execucio o no
	 */
	public boolean haAcabat() {
		return acabat;
	}
	
	/**
	 * Metode bloquejant que esperar a que la tasca hagi acabat la seva execucio
	 * per tornar el resultat de la tasca
	 * @return
	 */
	public synchronized int obtenirResultat() {
		if(!acabat)
			try{wait();}catch(InterruptedException e) {e.printStackTrace();}
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
		synchronized (this) {
			acabat = true;
			notify();
		}
	}

}
