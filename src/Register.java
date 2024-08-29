public class Register {
	public Purse makeChange(double amt) {
		Purse purse = new Purse();

		//cycle through possible denominations
		while (amt > 0.01) {
			if (amt >= 50) {
				purse.add(purse.denominations[8], 1);
				amt -= 50;
			} else if (amt >= 20) {
				purse.add(purse.denominations[7], 1);
				amt -= 20;
			} else if (amt >= 10) {
				purse.add(purse.denominations[6], 1);
				amt -= 10;
			} else if (amt >= 5) {
				purse.add(purse.denominations[5], 1);
				amt -= 5;
			} else if (amt >= 1) {
				purse.add(purse.denominations[4], 1);
				amt -= 1;
			} else if (amt >= 0.25) {
				purse.add(purse.denominations[3], 1);
				amt -= 0.25;
			} else if (amt >= 0.10) {
				purse.add(purse.denominations[2], 1);
				amt -= 0.10;
			} else if (amt >= 0.05) {
				purse.add(purse.denominations[1], 1);
				amt -= 0.05;
			} else {
				purse.add(purse.denominations[0], 1);
				amt -= 0.01;
			}
		}

		return purse;
	}
}