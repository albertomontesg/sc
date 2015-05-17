package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * Pool de threads que encapsula un nombre determinat de threads i executa tasques que
 * li van pujan. Amb la gestio de les tasques a realitzar, es segueix el cas productor
 * consumidor en el qual el productor es l'executor que li va passan les tasques que te
 * que realitzar, mentre que el consumidor seria cada thread que va agafant la seguent
 * tasca que cal realitzar i l'executa.
 * @author Alberto Montes
 * @version 2014-04-24
 */
public class ThreadPool{

	protected int numThreads;
	protected List<Worker> threads;
	protected List<FutureTask<?>> tasks;
	private boolean working;
	private boolean canSubmit;
	
	/** 
	 * Constructor on inicialitza el nombre passat de threads.
	 * @param nt
	 * Nombre de threads
	 */
	public ThreadPool(int nt) {
		numThreads = nt;
		threads = new ArrayList<Worker>(numThreads);
		working = true;
		canSubmit = true;
		for(int i = 0; i < numThreads; i++) {
			Worker w = new Worker();
			threads.add(w);
			w.start();
		}
		tasks = new ArrayList<FutureTask<?>>();
	}
	
	/**
	 * Metode que finalitza amb el pool de threads de manera instantanea. 
	 * No es poden penjar mes tasques i les que queden per executar-se es 
	 * cancelen.
	 * @return
	 * Es retorna la llista de {@code FutureTask} que s'han cancelat i no
	 * s'han pogut executar
	 */
	public synchronized List<FutureTask<?>> shutdownNow() {
		working = false; // Make the thread to stop working
		canSubmit = false; // Unable to submit new tasks
		notifyAll(); // Notify all the threads waiting
		for(FutureTask<?> f : tasks) // Cancell all the tasks
			f.cancel(false);
		//System.out.println("ShutdownNow");
		return tasks; // Return the undone tasks
	}
	
	/**
	 * Metode per tancar el pool de threads. Aquest s'espera a que acabin d'executar-se
	 * les tasques que hi queden pero no accepta que s'hi pengin mes tasques
	 */
	public synchronized void shutdown() {
		canSubmit = false; // Unable to submit new tasks
		if(!tasks.isEmpty()) // Waits until all the tasks are completed
			try{wait();} catch(InterruptedException e) {}
		working = false; // Make the thread to stop working
		notifyAll(); // Notify all the threads waiting
		
	}
	
	/**
	 * Metode per trametre una tasca al pool de threads.
	 * Correspon amb el metode put() del problema productor consumidor.
	 * @param task
	 * Tasca que implementa {@code Callable<R>} (Runnable amb resultat de tipus R.
	 * @return
	 * Retorna el {@code Future<R>} de la tasca tramessa
	 */
	public synchronized <R>Future<R> submit (Callable<R> task) {
		if(canSubmit) {
			FutureTask<R> ft = new FutureTask<R>(task);
			tasks.add(ft);
			notifyAll();
			return ft;
		} else return null;
		
	}
	
	/**
	 * Metode per obtenir la seguent tasca a realitzar del pool de threads.
	 * Correspon amb el metode get() del problema productor consumidor.
	 * @return
	 * Retorna el {@code FutureTask<R>} de la tasca tramessa per poder-la executar.
	 */
	private synchronized FutureTask<?> getTask() {
		
		// Es bloqueja si la llista de tasques per executar esta buida
		while (tasks != null && tasks.isEmpty() && working)
			try {wait();} catch(InterruptedException e) {}
		
		// Si hi ha tasques s'obte la seguent a executar i es retorna
		if (tasks != null && !tasks.isEmpty()) {
			FutureTask<?> t = tasks.remove(0);
			if(tasks.isEmpty() && !canSubmit) notify(); // Notify the shutdown method when all the tasks are done
			return t;
		}
		else return null;
		
	}
	
	/**
	 * Classe corresponent a cada thread del pool de threads. Aquests seran els consumidors
	 * de tasques i aniran, sempre que el pool de threads estigui treballant, agafant la seguent
	 * tasca a realitzar i executar-la.
	 * @author Alberto Montes
	 * @version 2014-04-24
	 */
	class Worker extends Thread {
		
		public void run() {
			while(working) { // The thread is running while the ThreadPool is working
				FutureTask<?> futureTask = getTask();
				if (futureTask != null)
					futureTask.run();
			}
		}
		
	}
}
