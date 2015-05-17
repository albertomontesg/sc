
package executorTest;

import java.util.concurrent.Callable;

/**
 * @author Marcel Fernandez & Jordi Forga.
 *
 * Tasca que realitza un producte escalar de fila(i) per columna(j).
 */
public class Tasca implements Callable<Resultat>
{
    
    private int numFila;
    private int numColumna;
    private Vector fila;
    private Vector columna;

    public Tasca(int f, int c, Vector fila, Vector columna) {
        numFila = f;
        numColumna = c;
        this.fila = fila;
        this.columna = columna;
    }
    
    public Resultat call(){
        double res = fila.dotProduct(columna);
        return new Resultat(numFila, numColumna, res);	
    }
    
    public String toString(){
        return "Tasca(" + numFila + "," + numColumna + ")";	
    }
    
}
