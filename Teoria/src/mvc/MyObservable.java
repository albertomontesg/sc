package mvc;

import java.util.*;

public class MyObservable extends Observable{
	
	private List<Observer> observers = new ArrayList<Observer>();
	private boolean changed = false;
	
	public synchronized void addObserver(Observer o) {
		observers.add(o);
	}
	
	protected void clearChanged() {
		changed = false;
	}
	
	public int countObservers() {
		return observers.size();
	}
	
	public synchronized void deleteObserver(Observer o) {
		observers.remove(o);
	}
	
	public void deleteObservers() {
		observers.clear();
	}
	
	public boolean hasChanged() {
		return changed;
	}
	
	public void notifyObservers() {
		notifyObservers(null);
	}
	
	public void notifyObservers(Object arg) {
		if (hasChanged()) {
			for (Observer o : observers) {
				o.update(this, arg);
			}
		}
		clearChanged();
	}
	
	protected void setChanged() {
		changed = true;
	}
}
