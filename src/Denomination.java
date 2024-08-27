//Record to represent individual money
public record Denomination(String name, double amt, String form, String img) {
}

/*
public class Denomination {
    //name of denomination
    private final String name;
    //amount the denomination represents
    private final double amt;
    //bill or coin
    private final String form;
    //string containing image name for an image of the type of money
    private final String img;

    //pass double of the amount of the denomination
    public Denomination(double amt) {
        this.amt = amt;

        //multiply by 100 to use int for switch
        this.name = switch((int) (amt*100)) {
            case 1 :
                this.form = "coin";
                yield "Penny";
            case 5 :
                this.form = "coin";
                yield "Nickel";
            case 10 :
                this.form = "coin";
                yield "Dime";
            case 25 :
                this.form = "coin";
                yield "Quarter";
            case 100 :
                this.form = "bill";
                yield "One-Dollar Note";
            case 500 :
                this.form = "bill";
                yield "Five-Dollar Note";
            case 1000 :
                this.form = "bill";
                yield "Ten-Dollar Note";
            case 5000 :
                this.form = "bill";
                yield "Fifty-Dollar Note";
            case 10000 :
                this.form = "bill";
                yield "One-Hundred Dollar Note";
            default : throw new RuntimeException("Denomination does not exist");
        };

        //replace with image of denomination
        img = null;
    }

    //Accessor Methods
    public String getName() {
        return name;
    }

    public double getAmt() {
        return amt;
    }

    public String getForm() {
        return form;
    }

    public String getImg() {
        return img;
    }
}
*/