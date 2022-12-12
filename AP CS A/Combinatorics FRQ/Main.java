class Main {
    public static void main (String[] args) {
        tests();
    }

    /**
     * Run tests.
     */
    public static void tests () {
        // Prequisites: domain of n is [1, 12].
        numCombinations(0, 0); // Expected value: 0
        numCombinations(0, 1); // Expected value: 0
        numCombinations(1, 3); // Expected value: 0
        numCombinations(3, 1); // Expected value: 3
        numCombinations(11, 7); // Expected value: 330
        numCombinations(12, 3); // Expected value: 220
    }

    /**
     * Find the factorial of a number.
     * @param n The given number.
     * @return The factorial of the given number.
     */
    public static int factorial (int n) {
        int currentFactorial = 1;

        for (int i = 1; i <= n; i++) currentFactorial *= i;
        return currentFactorial;
    }

    /**
     * Display the total number of options in choosing a certain number of items in a given set quantity.
     * @param n The total number of items.
     * @param r The number of items to select.
     */
    public static void numCombinations (int n, int r) {
        if (r > n) {
            System.out.println(String.format("There are 0 way(s) of choosing %s items from %s choices.", r, n));
            return;
        }

        int options = factorial(n) / (factorial(r) * factorial(n - r));
        System.out.println(String.format("There are %s way(s) of choosing %s items from %s choices.", options, r, n));
    }
}
