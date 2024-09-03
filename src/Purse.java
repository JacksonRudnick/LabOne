import java.util.HashMap;
import java.util.Map;

import static java.lang.System.exit;

public class Purse {
	//Key is type of denomination, int is number of those denominations
	private final Map<Denomination, Integer> cash;
	//Array of all denomination types
	public final Denomination[] denominations = new Denomination[10];

	public Purse() {
		//initialize the Hashmap
		cash = new HashMap<Denomination, Integer>();

		denominations[0] = new Denomination("Penny", 0.01, "coin", "penny.png");
		denominations[1] = new Denomination("Nickel", 0.05, "coin", "nickel.png");
		denominations[2] = new Denomination("Dime", 0.1, "coin", "dime.png");
		denominations[3] = new Denomination("Quarter", 0.25, "coin", "quarter.png");
		denominations[4] = new Denomination("One-Dollar Note", 1, "bill", "one_note.png");
		denominations[5] = new Denomination("Five-Dollar Note", 5, "bill", "five_note.png");
		denominations[6] = new Denomination("Ten-Dollar Note", 10, "bill", "ten_note.png");
		denominations[7] = new Denomination("Twenty-Dollar Note", 20, "bill", "twenty_note.png");
		denominations[8] = new Denomination("Fifty-Dollar Note", 50, "bill", "fifty_note.png");
		denominations[9] = new Denomination("Hundred-Dollar Note", 100, "bill", "hundred_note.png");

		//initialize purse
		for (Denomination d : denominations) {
			this.add(d, 0);
		}
	}

	//add amount of money to hashmap
	public void add(Denomination d, int amt) {
		int oldAmt = 0;
		if (cash.get(d) != null) {
			oldAmt = cash.remove(d);
		}

		cash.put(d, oldAmt+amt);
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

	//return a copy of our cash map
	public Map<Denomination, Integer> getCash() {
		return cash;
	}
}
