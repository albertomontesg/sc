package tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Executor que executa tasques que li van passan en un numbre determinat de threads, 
 * tasques les quals retornen un resultat
 * @author Alberto Montes
 * @version 2014-04-24
 * @param <R>
 * Tipus del resultat de les tasques amb les quals es treballara
 */
public class ExecutorThreadPool<R> {

	protected ThreadPool threadPool;
	
	/**
	 * Constructor que inicialitza el pool de threads amb un nombre determinat de threads.
	 * @param numThreads
	 */
	public ExecutorThreadPool(int numThreads) {
		threadPool = new ThreadPool(numThreads);
	}

	/**
	 * Executa una llista de tasques que implementen Callable (Runnables amb resultat).
	 * El metode espera a que hagi acabat la execucio de les tasques i retorna el resultat.
	 * Per cada tasca, aquesta es pasa al pool de threads i amb el futur obtingut despres
	 * s'espera a la seva finalitzacio i a la obtencio del resultat.
	 * @param tasks Llista de tasques que es vol trametre
	 * @return resultats Resultats de les tasques trameses
	 * @throws Exception
	 */
	public List<R> executar(List<Callable<R>> tasks) throws Exception {
		List<R> resultats = new ArrayList<R>();
		List<Future<R>> futures = new ArrayList<Future<R>>();
		for(Callable<R> task : tasks) {
			futures.add(threadPool.submit(task));
		}
		
		for(Future<R> future : futures) {
			if (!future.isCancelled()) // Check if the tasks has not been cancelled to return the result
				resultats.add(future.get());
		}
		return resultats;
	}
}
