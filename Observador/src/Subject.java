
public interface Subject {

	public void registerObserver(Observador o);
	
	public void unregisterObserver(Observador o);
	
	public void notifyObservers(String mess);
	
}
