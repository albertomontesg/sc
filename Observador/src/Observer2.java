
public class Observer2 implements Observador{

	private int id;
	
	public Observer2(int id) {
		this.id = id;
	}
	
	@Override
	public void update(String mess) {
		System.out.println("[" + id + "]: " + mess);
	}

}
