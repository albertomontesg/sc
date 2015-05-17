
package executor;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Marcel Fernandez & Jordi Forga.
 * 
 * Executor de multiples tasques amb resultat.
 */
public interface Executor<R> {

        /**
         * Executa cadascuna de les tasques de la llista indicada i retorna la
         * llista dels resultats corresponents (de tipus generic R).
         * Cada tasca implementa la interficie Callable<R>, on R es el tipus del
         * resultat que retorna.
         */
        public List<R> executar(List<Callable<R>> tasks) throws Exception;

}

