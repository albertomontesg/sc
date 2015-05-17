package executor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Yaiza Barrientos, Alberto Montes
 * @subject SC
 * @date 28 feb 2014
 * @exercise Practica 2
 * Practica Execucio Tasques
 */
public class ExecutorThread<R> implements Executor<R>{

	@Override
	public List<R> executar(List<Callable<R>> tasks) throws Exception {
		
		List<R> results = new ArrayList<R>();
		int size = tasks.size();
		List<MyRunnable<R>> runnables = new ArrayList<MyRunnable<R>>(size);
		List<Thread> threads = new ArrayList<Thread>(size);
		
		for (Callable<R> task : tasks) {
			MyRunnable<R> r = new MyRunnable<R>(task);
			runnables.add(r);
			Thread th = new Thread(r);
			th.start();
			threads.add(th);
		}
		
		for(Thread thread : threads) {
			thread.join();
		}
		
		for (MyRunnable<R> r : runnables) {
			R res = r.getResult();
			results.add(res);
		}
		
		return results;
	}

}

class MyRunnable<R> implements Runnable {
	private Callable<R> task;
	private R result;
	
	public MyRunnable(Callable<R> t) {
		this.task = t;
	}
	
	@Override
	public void run() {
		try {
			synchronized(this) {
				result = task.call();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public synchronized R getResult() {
		return result;
		
	}
	
}
