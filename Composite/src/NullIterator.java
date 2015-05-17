/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Iterator;

/**
 *
 * @author Juan Carlos
 */
public class NullIterator implements Iterator{

    public boolean hasNext() {
        return false ;
    }

    public Object next() {
    	throw new UnsupportedOperationException("Not supported yet.");
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
