import java.util.Scanner;

// Loan class encapsulates the loan details and calculations
class Loan {
    private double loanAmount;
    private double annualInterestRate;
    private int loanTermYears;

    // Constructor
    public Loan(double loanAmount, double annualInterestRate, int loanTermYears) {
        this.loanAmount = loanAmount;
        this.annualInterestRate = annualInterestRate;
        this.loanTermYears = loanTermYears;
    }

    // Method to calculate monthly payment
    public double calculateMonthlyPayment() {
        double monthlyInterestRate = annualInterestRate / 12 / 100;
        int totalMonths = loanTermYears * 12;
        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -totalMonths));
    }

    // Getters
    public double getLoanAmount() {
        return loanAmount;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getLoanTermYears() {
        return loanTermYears;
    }
}

// Main class to interact with the user
public class LoanCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Loan Calculator!");

        // Input from the user
        System.out.print("Enter Loan Amount: ");
        double loanAmount = scanner.nextDouble();

        System.out.print("Enter Annual Interest Rate (in %): ");
        double annualInterestRate = scanner.nextDouble();

        System.out.print("Enter Loan Term (in years): ");
        int loanTermYears = scanner.nextInt();

        // Creating Loan object
        Loan loan = new Loan(loanAmount, annualInterestRate, loanTermYears);

        // Calculating and displaying monthly payment
        double monthlyPayment = loan.calculateMonthlyPayment();
        System.out.printf("Your Monthly Payment: %.2f%n", monthlyPayment);

        scanner.close();
    }
}