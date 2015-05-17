package swing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;

/**
 * Implementacio propia de la classe {@code SwingUtilities}
 * @author Alberto Montes
 * @version Mar 24, 2014
 */
public class SwingUtilities {
	// Correspon al thread EDT (Event Dispatch Thread)
	private static Thread EDT;
	
	/**
	 * Implementacio del {@code ThreadFactory} per crear el thread EDT
	 * @author Alberto Montes
	 * @version Mar 24, 2014
	 */
	private static class SwingThreadFactory implements ThreadFactory {
		public Thread newThread (Runnable r) {
			EDT = new Thread(r);
			return EDT;
		}
	}
	
	/**
	 * Executor que nomes conte un thread i aquest es el EDT
	 */
	public static ExecutorService exec = Executors.newSingleThreadExecutor(new SwingThreadFactory());
	
	/**
	 * Metode per correr una tasca en el thread EDT
	 * @param r Tasca a executar en el thread d'events
	 */
	public static void invokeLater(Runnable r) {
		exec.submit(r);
	}
	
	/**
	 * Metode per correr una tasca en el thread EDT i esperar
	 * a que aquest finalitzi
	 * @param r
	 */
	public static void invokeAndWait(Runnable r) {
		Future<?> future = exec.submit(r);
		try {
			future.get();
		} catch (InterruptedException e) {e.printStackTrace();
		} catch (ExecutionException e) {e.printStackTrace();}
	}
	
	/**
	 * @return Retorna si el thread des de el que el crides es el thread d'events
	 */
	public static boolean isEventDispatchThread() {
		return Thread.currentThread() == EDT;
	}
	
}
