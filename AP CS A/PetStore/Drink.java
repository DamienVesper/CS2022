public class Drink {
    public String name;
    public String size;

    public double price;

    public Drink (int type, int size) {
        this.setName(type);
        this.setSize(size);

        this.price = 0.00;
    }

    public String getName () {
        return this.name;
    }

    public String getSize () {
        return this.size;
    }

    public double getPrice () {
        return this.price;
    }

    public void setName (int name) {
        switch (name) {
            case 1:
                this.name = "water";
                break;
            case 2:
                this.name = "coke";
                break;
        }
    }

    public void setSize (int size) {
        switch (size) {
            case 1:
                this.size = "Small";
                break;
            case 2:
                this.size = "Medium";
                break;
            case 3:
                this.size = "Large";
                break;
        }
    }

    public void setPrice (double price) {
        this.price = price;
    }

    public String toString () {
        String res = String.format("---\nTYPE: %s\nSIZE: %s\n---\nPRICE: %f\n---\n---\n", this.name, this.size, this.price);
        return res;
    }
}
