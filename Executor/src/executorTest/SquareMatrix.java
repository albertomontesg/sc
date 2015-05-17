
package executorTest;

/**
 * @author Marcel Fernandez & Jordi Forga
 */
public class SquareMatrix {
    
    protected Vector[] rows;
    
    public SquareMatrix(int d) {
        rows = new Vector[d];
        for(int i = 0; i  < d; i++) {
            rows[i] = new Vector(d);
        }
    }
    
    public SquareMatrix(int d, double v) {
        this(d);
        for(int i = 0; i  < d; i++) {
            for(int j = 0; j < d; j++) {
                rows[i].set(j, v);
            }
        }
    }

    public int getDimension() {
        return rows.length;
    }
    
    public double get(int i, int j) {
        return rows[i].get(j);
    }
    
    public void set(int i, int j, double elem) {
        rows[i].set(j, elem);
    }
    
    public Vector getRow(int i) {
        return rows[i];
    }
    
    public Vector getColumn(int j) {
        Vector v = new Vector(rows.length);
        for(int i = 0; i < rows.length; i++ ) {
            v.set(i , rows[i].get(j));
        }
        return v;
    }
    
    public String toString() {
        if (rows.length == 0) {
            return "[]";
        } else {
            StringBuffer tmp = new StringBuffer();
            tmp.append("[").append(rows[0]);
            for(int i = 1; i  < rows.length; i++) {
                tmp.append(",\n ").append(rows[i]);
            }
            tmp.append("]");
            return tmp.toString();
        }
    }

}
