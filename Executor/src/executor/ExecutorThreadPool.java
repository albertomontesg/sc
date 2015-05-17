package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author Yaiza Barrientos, Alberto Montes
 * @subject SC
 * @date 7 mar 2014
 * @exercise Practica 2
 * Practica Execucio Tasques
 */
public class ExecutorThreadPool<R> implements Executor<R>{
	
	protected ThreadPool threadPool;
	
	public ExecutorThreadPool(int numThreads) {
		threadPool = new ThreadPool(numThreads);
	}

	@Override
	public List<R> executar(List<Callable<R>> tasks) throws Exception {
		List<R> resultats = new ArrayList<R>();
		List<Future<R>> futures = new ArrayList<Future<R>>();
		for(Callable<R> task : tasks) {
			futures.add(threadPool.submit(task));
		}
		
		// Shutdown Thread's Pool
		threadPool.shutdown();
		
		for(Future<R> future : futures) {
			if (!future.isCancelled()) // Check if the tasks has not been cancelled to return the result
				resultats.add(future.get());
		}
		return resultats;
	}
}

class ThreadPool {
	protected int numThreads;
	protected List<Worker> threads;
	protected List<FutureTask<?>> tasks;
	private boolean working;
	private boolean canSubmit;
	
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
	
	public synchronized List<FutureTask<?>> shutdownNow() {
		working = false; // Make the thread to stop working
		canSubmit = false; // Unable to submit new tasks
		notifyAll(); // Notify all the threads waiting
		for(FutureTask<?> f : tasks) // Cancell all the tasks
			f.cancel(false);
		//System.out.println("ShutdownNow");
		return tasks; // Return the undone tasks
	}
	
	public synchronized void shutdown() {
		canSubmit = false; // Unable to submit new tasks
		if(!tasks.isEmpty()) // Waits until all the tasks are completed
			try{wait();} catch(InterruptedException e) {}
		working = false; // Make the thread to stop working
		notifyAll(); // Notify all the threads waiting
		
		//System.out.println("Shutdown");
	}
	
	public synchronized <R>Future<R> submit (Callable<R> task) {
		if(canSubmit) {
			FutureTask<R> ft = new FutureTask<R>(task);
			tasks.add(ft);
			notifyAll();
			return ft;
		} else return null;
		
	}
	
	private synchronized FutureTask<?> getTask() {
		
		while (tasks != null && tasks.isEmpty() && working)
			try {wait();} catch(InterruptedException e) {}
		
		if (tasks != null && !tasks.isEmpty()) {
			FutureTask<?> t = tasks.remove(0);
			if(tasks.isEmpty() && !canSubmit) notify(); // Notify the shutdown method when all the tasks are done
			return t;
		}
		else return null;
		
	}
	
	class Worker extends Thread {
		
		public void run() {
			while(working) { // The thread is running while the ThreadPool is working
				FutureTask<?> futureTask = getTask();
				if (futureTask != null)
					futureTask.run();
			}
			//System.out.println(this.getName() + " Finished");
		}
		
	}
}


