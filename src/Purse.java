import java.util.HashMap;
import java.util.Map;

public class Purse {
	//Key is type of denomination, int is number of those denominations
	private final Map<Denomination, Integer> cash;
	//Array of all denomination types
	private final Denomination[] denominations = new Denomination[9];

	//initialize the Hashmap
	public Purse() {
		cash = new HashMap<Denomination, Integer>();

		denominations[0] = new Denomination("Penny", 0.01, "coin", "");
		denominations[1] = new Denomination("Nickel", 0.05, "coin", "");
		denominations[2] = new Denomination("Dime", 0.1, "coin", "");
		denominations[3] = new Denomination("Quarter", 0.25, "coin", "");
		denominations[4] = new Denomination("One-Dollar Note", 1, "bill", "");
		denominations[5] = new Denomination("Five-Dollar Note", 5, "bill", "");
		denominations[6] = new Denomination("Ten-Dollar Note", 10, "bill", "");
		denominations[7] = new Denomination("Twenty-Dollar Note", 20, "bill", "");
		denominations[8] = new Denomination("Fifty-Dollar Note", 50, "bill", "");

		for (Denomination d : denominations) {
			this.create(d, 0);
		}
	}

	//create an entry
	public void create(Denomination d, int amt) {
		//add an @amt of a @d to @cash
		cash.put(d, amt);
	}

	//section out money into appropriate categories
	public void add(double amt) {
		while (amt > 0.01) {
			if (amt >= 50) {
				cash.put(denominations[8], cash.remove(denominations[8]) + 1);
				amt -= 50;
			} else if (amt >= 20) {
				cash.put(denominations[7], cash.remove(denominations[7]) + 1);
				amt -= 20;
			} else if (amt >= 10) {
				cash.put(denominations[6], cash.remove(denominations[6]) + 1);
				amt -= 10;
			} else if (amt >= 5) {
				cash.put(denominations[5], cash.remove(denominations[5]) + 1);
				amt -= 5;
			} else if (amt >= 1) {
				cash.put(denominations[4], cash.remove(denominations[4]) + 1);
				amt -= 1;
			} else if (amt >= 0.25) {
				cash.put(denominations[3], cash.remove(denominations[3]) + 1);
				amt -= 0.25;
			} else if (amt >= 0.10) {
				cash.put(denominations[2], cash.remove(denominations[2]) + 1);
				amt -= 0.10;
			} else if (amt >= 0.05) {
				cash.put(denominations[1], cash.remove(denominations[1]) + 1);
				amt -= 0.05;
			} else {
				cash.put(denominations[0], cash.remove(denominations[0]) + 1);
				amt -= 0.01;
			}
		}

	}

	//return the amount of money removed from purse
	public double remove(Denomination d) {
		return d.amt() * cash.remove(d);
	}

	public double getValue() {
		double sum = 0;

		//iterate through map to total sum of denominations in purse
		for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
			sum += entry.getKey().amt() * entry.getValue();
		}

		return sum;
	}

	//return a string listing all type of denominations and the amount they are used
	public String toString() {
		String ret = "";

		for (Map.Entry<Denomination, Integer> entry : cash.entrySet()) {
			ret += entry.getKey().name() + ": " + entry.getValue() + "\n";
		}

		return ret.substring(0, ret.length() - 1);
	}
}
