package genericTest;

public class Powder extends Meterial{
	public String toString() {
		return "재료는 파우더 입니다";
	}

	@Override
	public void doPrinting() {
		System.out.println("파우더로 프린팅 합니다");
	}
}
