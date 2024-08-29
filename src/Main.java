public class Main {
	public static void main(String[] args) {
		//Create register
		Register register = new Register();

		Purse p = register.makeChange(69.89);
		System.out.println(p.toString());
	}
}
