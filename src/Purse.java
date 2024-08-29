import java.util.HashMap;
import java.util.Map;

public class Purse {
	//Key is type of denomination, int is number of those denominations
	private final Map<Denomination, Integer> cash;
	//Array of all denomination types
	public final Denomination[] denominations = new Denomination[9];

	public Purse() {
		//initialize the Hashmap
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
}
