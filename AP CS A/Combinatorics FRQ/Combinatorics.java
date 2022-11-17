class Combinatorics {
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
            System.out.println(String.format("There are 0 ways of choosing %s items from %s choices", r, n));
            return;
        }

        int options = factorial(n) / (factorial(r) * factorial(n - r));
        System.out.println(String.format("There are %s ways of choosing %s items from %s choices", options, r, n));
    }
}
