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
public class ExecutorSequencial<R> implements Executor<R>{

	@Override
	public List<R> executar(List<Callable<R>> tasks) throws Exception {
		
		List<R> results = new ArrayList<R>();
		
		for (Callable<R> task : tasks) {
			R res = task.call();
			results.add(res);
		}
		
		return results;
	}

}
