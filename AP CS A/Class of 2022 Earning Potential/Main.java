import java.util.Scanner;

class Main {
    public static void main (String[] args) {
        Scanner inputDevice = new Scanner(System.in);

        // Tax rates.
        double StateTax = 0.045;
        double TakeHomePayRate = 0.55;

        // Arbitrary constants.
        final double Percentile20 = 0.2;
        final double Percentile80 = 0.8;

        // Inputs.
        double ClassSize;
        double CareerLength;
    
        double Top20Salary;
        double AverageSalary;

        System.out.println("What is the state tax rate?");
        StateTax = inputDevice.nextDouble();
        while (StateTax < 0.01 || StateTax > 0.99) {
            System.out.println("State tax rate must contain a value between 0.01 and 0.99.");
            System.out.println("What is the state tax rate?");
            TakeHomePayRate = inputDevice.nextDouble();
        }
        
        System.out.println("What is the take home pay rate?");
        TakeHomePayRate = inputDevice.nextDouble();
        while (TakeHomePayRate < 0.01 || TakeHomePayRate > 0.99) {
            System.out.println("Take-home pay rate must contain a value between 0.01 and 0.99.");
            System.out.println("What is the take home pay rate?");
            TakeHomePayRate = inputDevice.nextDouble();
        }

        System.out.println("How many members are in the class?");
        ClassSize = inputDevice.nextDouble();
        while (ClassSize < 1) {
            System.out.println("There must be at least one member in the class.");
            System.out.println("How many members are in the class?");
            ClassSize = inputDevice.nextDouble();
        }

        System.out.println("What is your career length (in years)?");
        CareerLength = inputDevice.nextDouble();
        while (CareerLength < 1) {
            System.out.println("Career length must be at least one year.");
            System.out.println("What is your career length (in years)?");
            CareerLength = inputDevice.nextDouble();
        }

        System.out.println("What is the 20th percentile salary of the class?");
        Top20Salary = inputDevice.nextDouble();
        while (Top20Salary < 1) {
            System.out.println("Top 20% salary must be at least $1.00.");
            System.out.println("What is the 20th percentile salary of the class?");
            Top20Salary = inputDevice.nextDouble();
        }

        System.out.println("What is the average salary of the class?");
        AverageSalary = inputDevice.nextDouble();
        if (AverageSalary < 1) {
            System.out.println("The average class salary must be at least $1.00.");
            System.out.println("What is the average salary of the class?");
            AverageSalary = inputDevice.nextDouble();
        }

        inputDevice.close();

        // 20th percentile salary.
        double T20IndividualAnnualPay = Top20Salary * TakeHomePayRate;
        double T20IndividualCareerPay = T20IndividualAnnualPay * CareerLength;

        double T20IndividualStateTax = Top20Salary * StateTax;
        double T20IndividualCareerTax = T20IndividualStateTax * CareerLength;

        double T20ClassAnnualPay = T20IndividualAnnualPay * (ClassSize * Percentile20);
        double T20ClassCareerPay = T20ClassAnnualPay * CareerLength;

        double T20ClassStateTax = T20IndividualStateTax * (ClassSize * Percentile20);
        double T20ClassCareerTax = T20ClassStateTax * CareerLength;

        // Average percentile salary.
        double IndividualAnnualPay = AverageSalary * TakeHomePayRate;
        double IndividualCareerPay = IndividualAnnualPay * CareerLength;

        double IndividualStateTax = AverageSalary * StateTax;
        double IndividualCareerTax = IndividualStateTax * CareerLength;

        double ClassAnnualPay = IndividualAnnualPay * (ClassSize * Percentile80);
        double ClassCareerPay = ClassAnnualPay * CareerLength;

        double ClassStateTax = IndividualStateTax * (ClassSize * Percentile80);
        double ClassCareerTax = ClassStateTax * CareerLength;

        System.out.println("------ TOP 20 PERCENT ------");
        System.out.println("[INDIVIDUAL] Annual Take Home Pay: $" + (double)Math.round(T20IndividualAnnualPay));
        System.out.println("[INDIVIDUAL] Career Take Home Pay: $" + (double)Math.round(T20IndividualCareerPay));
        System.out.println("");
        System.out.println("[INDIVIDUAL] Annual State Tax Paid: $" + (double)Math.round(T20IndividualStateTax));
        System.out.println("[INDIVIDUAL] Annual Career Tax Paid: $" + (double)Math.round(T20IndividualCareerTax));
        System.out.println("");
        System.out.println("[CLASS] Annual Take Home Pay: $" + (double)Math.round(T20ClassAnnualPay));
        System.out.println("[CLASS] Career Take Home Pay: $" + (double)Math.round(T20ClassCareerPay));
        System.out.println("");
        System.out.println("[CLASS] Annual State Tax Paid: $" + (double)Math.round(T20ClassStateTax));
        System.out.println("[CLASS] Annual Career Tax Paid: $" + (double)Math.round(T20ClassCareerTax));
        System.out.println("");

        System.out.println("------ LOWER 80 PERCENT ------");
        System.out.println("[INDIVIDUAL] Annual Take Home Pay: $" + (double)Math.round(IndividualAnnualPay));
        System.out.println("[INDIVIDUAL] Career Take Home Pay: $" + (double)Math.round(IndividualCareerPay));
        System.out.println("");
        System.out.println("[INDIVIDUAL] Annual State Tax Paid: $" + (double)Math.round(IndividualStateTax));
        System.out.println("[INDIVIDUAL] Annual Career Tax Paid: $" + (double)Math.round(IndividualCareerTax));
        System.out.println("");
        System.out.println("[CLASS] Annual Take Home Pay: $" + (double)Math.round(ClassAnnualPay));
        System.out.println("[CLASS] Career Take Home Pay: $" + (double)Math.round(ClassCareerPay));
        System.out.println("");
        System.out.println("[CLASS] Annual State Tax Paid: $" + (double)Math.round(ClassStateTax));
        System.out.println("[CLASS] Annual Career Tax Paid: $" + (double)Math.round(ClassCareerTax));
        System.out.println("");
    }
}
