import java.util.Scanner;

/**
 * Entry location for the program.
 */
public class MyConsole {
    public static void main (String[] args) {
        Scanner inputDevice = new Scanner(System.in);

        int drinkType;
        int drinkSize;

        System.out.println("Welcome to your average generic vending machine. Please select a drink:");
        System.out.println("[1] Water [2] Coke");

        drinkType = inputDevice.nextInt();
        while (drinkType < 1 || drinkType > 2) {
            System.out.println("Drink type must contain a value between 1 and 2.");

            System.out.println("Please select a drink:");
            System.out.println("[1] Water [2] Coke");

            drinkType = inputDevice.nextInt();
        }

        System.out.println("What size drink would you like?");
        System.out.println("[1] Small (250mL) [2] Medium (400mL) [3] Large (550mL)");

        drinkSize = inputDevice.nextInt();
        while (drinkSize < 1 || drinkSize > 3) {
            System.out.println("Drink size must contain a value between 1 and 3.");

            System.out.println("What size drink would you like?");
            System.out.println("[1] Small (250mL) [2] Medium (400mL) [3] Large (550mL)");

            drinkType = inputDevice.nextInt();
        }

        // rate for water: 0.001692
        switch (drinkType) {
            case 1: {
                int drinkBrand;

                System.out.println("What brand water would you like?");
                System.out.println("[1] Nestle [2] DASANI [3] Ozarka [4] Aquafina");

                drinkBrand = inputDevice.nextInt();
                while (drinkBrand < 1 || drinkBrand > 4) {
                    System.out.println("Drink brand must contain a value between 1 and 4.");

                    System.out.println("What drink would you like of the Coca-Cola family?");
                    System.out.println("[1] Coca-Cola Classic [2] Diet Coca-Cola [3] Coca-Cola Zero [4] Cherry Coca-Cola");

                    drinkType = inputDevice.nextInt();
                }

                Water myDrink = new Water(drinkType, drinkSize, drinkBrand);
                System.out.println("Your order: \n" + myDrink);
            }
            case 2: {
                int drinkFlavor;

                System.out.println("What drink would you like of the Coca-Cola family?");
                System.out.println("[1] Coca-Cola Classic [2] Diet Coca-Cola [3] Coca-Cola Zero [4] Cherry Coca-Cola");

                drinkFlavor = inputDevice.nextInt();
                while (drinkFlavor < 1 || drinkFlavor > 4) {
                    System.out.println("Drink flavor must contain a value between 1 and 4.");

                    System.out.println("What drink would you like of the Coca-Cola family?");
                    System.out.println("[1] Coca-Cola Classic [2] Diet Coca-Cola [3] Coca-Cola Zero [4] Cherry Coca-Cola");

                    drinkType = inputDevice.nextInt();
                }

                Coke myDrink = new Coke(drinkType, drinkSize, drinkFlavor);
                System.out.println("Your order: \n" + myDrink);
            }
        }
;
    }
}
