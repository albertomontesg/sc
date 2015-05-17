package executorTest;

import executor.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Marcel Fernandez & Jordi Forga.
 * 
 * Test de la practica d'executors: Obtencio del quadrat d'una matriu quadrada.
 */
public class ExecucioTasques {
	public static int SIZE = 10;
	
    public static void main(String[] args)
    {
        // Creacio de la matriu quadrada inicial de dimensio SIZE.
        SquareMatrix matriu = new SquareMatrix(SIZE);
        for(int i = 0; i  < matriu.getDimension(); i++){
            for(int j = 0; j < matriu.getDimension(); j++){
                matriu.set(i,j, i+j);
            }
        }
        System.out.println(matriu);
        // Creacio de la llista de les corresponents 4^4=16 tasques.
        // Cada tasca realitzara el producte escalar d'una fila amb una columna.
        ArrayList<Callable<Resultat>> llistaTasques = new ArrayList<Callable<Resultat>>();
        for(int i = 0; i  < matriu.getDimension(); i++){
            for(int j = 0; j < matriu.getDimension(); j++){
                Tasca p = new Tasca(
                        i, j, 
                        matriu.getRow(i), 
                        matriu.getColumn(j)
                );
                llistaTasques.add(p);
            }
        }

        // Selector de l'executor concret.
        // ATENCIO: Escolliu 1, 2 o 3
        int versio = 1;
        Executor<Resultat> exec =
            (versio == 1) ? new ExecutorSequencial<Resultat>() : // (1)
            (versio == 2) ? new ExecutorThread<Resultat>() :     // (2)
                            new ExecutorThreadPool<Resultat>(2); // (3)

        // Execucio i obtencio de la matriu resultant.
        try {
        	// Calcular temps de execucio
        	long time_start, time_end;
        	time_start = System.currentTimeMillis();
        	
            List<Resultat> results = exec.executar(llistaTasques);
            
        	time_end = System.currentTimeMillis();
        	
            SquareMatrix m2 = new SquareMatrix(SIZE,0);
            for(Resultat r : results){
                m2.set(r.getFila(), r.getColumna(), r.getValor());
            }

            System.out.println(m2);
            
            // Print time
        	System.out.println("the execution has taken "+ ( time_end - time_start ) +" milliseconds");

        } catch (Exception ex) {
                Logger.getLogger(ExecucioTasques.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}