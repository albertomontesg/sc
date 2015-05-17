package mvc.tempsTasca;

/**
 * Tasca que es executada i passa el temps d'execucio al model
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class Tasca implements Runnable {
	protected Model model;
	
	public Tasca(Model m) {
		model = m;
	}
	
	@Override
	public void run() {
		int temps = 0;
		try {
			temps = 1 + (int) (Math.random() * 10);
			Thread.sleep(temps*1000);
		}catch (InterruptedException e) {e.printStackTrace();}
		model.tascaAcabada(temps);
	}

}
