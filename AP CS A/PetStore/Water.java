public class Water extends Drink {
    private String brand;

    public Water (int type, int size, int brand) {
        super(type, size);
        this.setBrand(brand);

        this.price = this.getPrice();
    }

    public String getBrand () {
        return this.brand;
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

        return (double)actualSize * 0.001692;
    }

    public void setBrand (int brand) {
        switch (brand) {
            case 1:
                this.brand = "Nestle";
                break;
            case 2:
                this.brand = "DASANI";
                break;
            case 3:
                this.brand = "Ozarka";
                break;
            case 4:
                this.brand = "Aquafina";
                break;
        }
    }

    public String toString () {
        String res = super.toString() + String.format("BRAND: %s\n---\n", this.brand);
        return res;
    }
}
