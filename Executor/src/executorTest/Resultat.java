
package executorTest;

/**
 * @author Marcel Fernandez & Jordi Forga.
 *
 * Resultat del producte escalar de fila(i) per columna(j).
 */
public class Resultat {

    private int fila;
    private int columna;
    private double valor;

    public Resultat(int f, int c, double v){
        fila = f;
        columna = c;
        valor = v;
    }

    /**
     * @return the fila
     */
    public int getFila() {
        return fila;
    }

    /**
     * @return the columna
     */
    public int getColumna() {
        return columna;
    }
    
    /**
     * @return the valor
     */
    public double getValor() {
        return valor;
    }
    
    
}
