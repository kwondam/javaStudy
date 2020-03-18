package decorator;

public class CoffeeTest {

	public static void main(String[] args) {
		
		Coffee americano = new KenyaAmericano();
		americano.brewing();
		System.out.println();
		
		
		Coffee kenyaLatte = new Lattee(new KenyaAmericano());
		kenyaLatte.brewing();
	}

}
