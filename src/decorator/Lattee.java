package decorator;

public class Lattee extends Decorator{

	public Lattee(Coffee coffee) {
		super(coffee);
	}

	public void brewing() {
		super.brewing();
		System.out.print(" adding milk");
	}
	
}
