public class Coke extends Drink {
    private String flavor;

    public Coke (int type, int size, int flavor) {
        super(type, size);
        this.setFlavor(flavor);

        this.price = this.getPrice();
    }

    public String getFlavor () {
        return this.flavor;
    };

    public double getPrice () {
        int actualSize;
        switch (this.size) {
            case "Large":
                actualSize = 550;
                break;
            case "Medium":
                actualSize = 400;
                break;
            default:
                actualSize = 250;
                break;
        }

        double costPerML;
        switch (this.flavor) {
            case "Diet Coca-Cola":
                costPerML = 0.00134;
                break;
            case "Coca-Cola Zero":
                costPerML = 0.00137;
                break;
            default:
                costPerML = 0.00141;
                break;
        }

        return (double)actualSize * costPerML;
    }

    public void setFlavor (int flavor) {
        switch (flavor) {
            case 1:
                this.flavor = "Coca-Cola Classic";
                break;
            case 2:
                this.flavor = "Diet Coca-Cola";
                break;
            case 3:
                this.flavor = "Coca-Cola Zero";
                break;
            case 4:
                this.flavor = "Cherry Coca-Cola";
                break;
        }
    }

    public String toString () {
        String res = super.toString() + String.format("FLAVOR: %s\n---\n", this.flavor);
        return res;
    }
}
