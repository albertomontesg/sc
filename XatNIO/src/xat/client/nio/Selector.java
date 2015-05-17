package xat.client.nio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Implementacio propia d'un selector amb el metode select() i un thread detector d'events
 * @author Alberto Montes
 * @version May 10, 2014
 * @param <R>
 */
public class Selector<R>{

	private static final long miliSegons = 20; 
	protected HashMap<Seleccionable<R>, Integer> seleccionables;
	protected ArrayList<ClauSelector<R>> preparats;
	
	private final ReentrantLock lock = new ReentrantLock();
	private final Condition hiHaPreparats = lock.newCondition();
	private final Condition selectAcabat = lock.newCondition();
	
	protected ThreadDetector detector;
	
	public Selector() {
		seleccionables = new HashMap<Seleccionable<R>, Integer>();
		preparats = new ArrayList<ClauSelector<R>>();
		// Arranca el thread detector
		detector = new ThreadDetector();
		detector.start();
	}
	
	/**
	 * Implementacio propia del metode select() de la classe Selector que emmagatzema els seleccionables
	 * que contenen nova informacio en claus per a que es pugui recollir la informacio
	 * @return
	 */
	public int select() {
		
		int result = 0;
		/*try {
			Thread.sleep(50);
		} catch (InterruptedException e2) {
			e2.printStackTrace();
		}	*/
		// Protect the variable seleccionables
		lock.lock();
		try{
			if(lock.getWaitQueueLength(selectAcabat) == 0) {
				try {
					hiHaPreparats.await();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
			
			// Mira a veure quins seleccionables tenen nova informacio i els encapsula en claus
			Iterator<Entry<Seleccionable<R>, Integer>> iter = seleccionables.entrySet().iterator();
			while (iter.hasNext()) {
				Map.Entry<Seleccionable<R>, Integer> me = (Map.Entry<Seleccionable<R>, Integer>) iter.next();
				Seleccionable<R> h = (Seleccionable<R>) me.getKey();
				try {
					if(h.preparat()) {
						result++;
						int tipus = seleccionables.get(h);
						ClauSelector<R> clau = new ClauSelector<R>(h, tipus);
						preparats.add(clau);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			//
			selectAcabat.signal();
		} finally {
			lock.unlock();
		}
		
		// Retorna el nombre de seleccionables que estan preparats (tenen nova informacio)
		return result;
	}
	
	/**
	 * Retorna les claus dels seleccionables preparats (amb nova informacio)
	 * @return
	 */
	public ArrayList<ClauSelector<R>> clausSeleccionades() {
		ArrayList<ClauSelector<R>> temp = new ArrayList<ClauSelector<R>>(preparats);
		preparats.clear();
		return temp;
	}
	
	/**
	 * Registra un seleccionable del tipus especificat
	 * @param s
	 * @param tipus
	 */
	public void addSeleccionable(Seleccionable<R> s, int tipus) {
		seleccionables.put(s, tipus);
	}
	
	/*
	private synchronized void hiHaPreparats() {
		notify();
	}*/

	/**
	 * Thread detector d'events en els seleccionables registrats mirant si hi ha nova informacio en aquests
	 * @author Alberto Montes
	 * @version May 10, 2014
	 */
	class ThreadDetector extends Thread {
		
		public void run() {
			while (true) {
				// Fa una repasada a tots els seleccionables cada cert temps
				try {
					sleep(miliSegons);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				// Protect the variable seleccionables
				lock.lock();try {
					// Fa una iteracio sobre tots els seleccionables registrats
					Iterator<Entry<Seleccionable<R>, Integer>> iter = seleccionables.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<Seleccionable<R>, Integer> me = (Map.Entry<Seleccionable<R>, Integer>) iter.next();
						Seleccionable<R> sel = (Seleccionable<R>) me.getKey();
						try {
							// Si hi ha preparats ho notifica a la classe Selector per a que retorni les claus de seleccionables preparats
							if(sel.preparat()) {
								//hiHaPreparats();
								//
								hiHaPreparats.signal();
								if(lock.getWaitQueueLength(hiHaPreparats) == 0)
									selectAcabat.await();
							}
						} catch (IOException e) {
							e.printStackTrace();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				} finally {
					lock.unlock();
				}
			}
		}
	}
}
