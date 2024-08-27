public class Register {
	public Purse makeChange(double amt) {
		Purse purse = new Purse();

		purse.add(amt);

		return purse;
	}
}