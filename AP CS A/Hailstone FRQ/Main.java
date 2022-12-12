import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a positive integer greater than 0.");

        int n = input.nextInt();
        while (n <= 0) {
            System.out.println("Please enter a positive integer greater than 0.");
            n = input.nextInt();
        }

        input.close();

        int steps = hailstoneLength(n);
        boolean isLong = isLongSeq(n);
        double proportionCount = propLong(n);

        System.out.println("---");
        System.out.println(String.format("INPUT: %s", n));
        System.out.println("---");
        System.out.println(String.format("STEPS: %s", steps));
        System.out.println(String.format("TYPE: %s", isLong ? "LONG" : "SHORT"));
        System.out.println("---");
        System.out.println(String.format("PROPORTION OF LONG SEQUENCES: %s", proportionCount));
    }

    public static int hailstoneLength (int n) {
        int i = 1;

        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = (n * 3) + 1;
            }

            i++;
        }

        return i;
    }

    public static boolean isLongSeq (int n) {
        return hailstoneLength(n) > n;
    }

    public static double propLong (int n) {
        double i = 1;
        double longCount = 0;

        while (i < (n + 1)) {
            i++;

            if (isLongSeq(n)) {
                longCount++;
            }
        }

        return longCount / i;
    }
}
