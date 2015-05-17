package nio;

import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;

import javax.management.monitor.Monitor;

/**
 * 
 * @author Alberto Montes
 * @version Mar 28, 2014
 * @param <R>
 */
public class Selector<R> extends Monitor{

	private static final long segons = 2;
	protected HashMap<Seleccionable, Integer> seleccionables;
	protected ArrayList<ClauSelector<R>> preparats;
	protected Condition hiHaPreparats, selectAcabat;
	
	protected ThreadDetector detector;
	
	/**
	 * No esta acabado
	 * @return
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public synchronized int select() {
		//enterMonitor();
		
		// selectAcabat.signal();
		
		try {
			hiHaPreparats.wait();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int result = 0;
		// Hi ha algu preparat
		Iterator<Entry<Seleccionable, Integer>> iter = seleccionables.entrySet().iterator();
		while (iter.hasNext()) {
			Map.Entry me = (Map.Entry) iter.next();
			Seleccionable h = (Seleccionable) me.getKey();
			if(h.preparat()) {
				result++;
				int tipus = seleccionables.get(h);
				ClauSelector clau = new ClauSelector(h, tipus);
				preparats.add(clau);
				
			}
		}
		
		// sortirMonitor()
		
		return result;
	}
	
	
	
	@Override
	public void start() {
		
	}
	
	
	@Override
	public void stop() {
		
	}

	class ThreadDetector extends Thread {
		Condition comprovar;
		
		public void run() {
			while (true) {
				try {
					comprovar.wait(segons);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Iterator<Entry<Seleccionable, Integer>> iter = seleccionables.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry me = (Map.Entry) iter.next();
					Seleccionable sel = (Seleccionable) me.getKey();
					try {
						if(sel.preparat()) {
							hiHaPreparats.signal();
							selectAcabat.wait();
						}
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
