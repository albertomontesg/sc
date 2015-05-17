package executorTest;

/**
 * @author Marcel Fernandez & Jordi Forga
 */
public class Vector {
    protected double[] espai;
    
    public Vector(double[] espai) {
        this.espai = espai;
    }
   
    public Vector(int d) {
        espai = new double[d];
    }
    
    public void set(int pos, double elem) {
        espai[pos] = elem;
    }
    
    public double get(int pos) {
        return espai[pos];
    }
    
    public double dotProduct(Vector other) {
        double tmp = 0;
        for(int i = 0; i < espai.length; i++) {
            tmp = tmp + espai[i] * other.get(i);
        }
        return tmp;
    }

    public String toString() {
        if (espai.length == 0) {
            return "[]";
        } else {
            StringBuffer tmp = new StringBuffer();
            tmp.append("[").append(espai[0]);
            for(int i = 1; i  < espai.length; i++) {
                tmp.append(", ").append(espai[i]);
            }
            tmp.append("]");
            return tmp.toString();
        }
    }
    
}
