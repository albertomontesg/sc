import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Juan Carlos
 */
public class CompositeIterator implements Iterator{
    private Stack stack = new Stack() ;

    public CompositeIterator(Iterator iterator){
        this.stack.push(iterator) ;
    }


    public boolean hasNext() {
        if(stack.empty()){
            return false ;
        }
        Iterator iterator = (Iterator)stack.peek() ;
        if(!iterator.hasNext()){
            stack.pop() ;
            return this.hasNext() ;
        }else{
            return true ;
        }
    }

    public Object next() {
        if(this.hasNext()){
            Iterator iterator = (Iterator) stack.peek() ;
            ComponenteFormulario comp = (ComponenteFormulario)iterator.next() ;
            if(comp instanceof Formulario){
                stack.push(comp.createIterator()) ;
            }
            return comp ;
        }else{
            return null ;
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
