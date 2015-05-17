
public class Observer1 implements Observador{

	private int id;
	
	public Observer1(int id) {
		this.id = id;
	}
	
	@Override
	public void update(String mess) {
		System.out.println("[" + id + "]: " + mess);
	}

}
