import java.sql.SQLOutput;
import java.util.Scanner;

public class loanCalculator {

    static double[] totals = new double[10];
    static double[] monthly = new double[10];
    static int count = 0;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

int selector = 0;
        while (selector != 3) {

            System.out.println("1: Calculate new loan.");
            System.out.println("2: View loan history.");
            System.out.println("3:Exit");

            selector = input.nextInt();

            if (selector == 1) {
                loanInfo(input);
                }
            if (selector == 2) {
                showHistory();
            }

        }
            input.close();
    }


    //method to get all the information about the loan
    public static void loanInfo(Scanner input) {
// collect the amount which the user wants to borrow.
        System.out.println("Amount to borrow: ");
        int amountToBorrow = input.nextInt();
        // make sure the amount is not zero
        while (amountToBorrow <= 0) {
            System.out.println("Invalid amount. Please enter a valid amount: ");
            amountToBorrow = input.nextInt();
        }
// collect the interest rate
        System.out.println("Interest rate: ");
        double interestRate = input.nextDouble();
        // make sure the interest rate is larger than 0
        while( interestRate <0) {
            System.out.println("Invalid interest rate. Please enter a valid rate:");
            interestRate = input.nextDouble();
        }
//collect the term length of the loan
        System.out.println("Term length:");
        int termLength = input.nextInt();
        //make sure the term is larger than 0
        while  (termLength <= 0) {
            System.out.println("Invalid term. Please enter a valid:");
            termLength = input.nextInt();
        }
            double monthlyPayment = calculateLoan(amountToBorrow, termLength, interestRate);
            double total = amountToBorrow + (amountToBorrow * interestRate / 100);

            totals[count] = total;
            monthly[count] = monthlyPayment;
            count++;



            System.out.println("Total amount to pay back is: " + total);
            System.out.println("You would pay " + monthlyPayment+ " per month");
        }


    //method to work out the total amount to pay back + monthly instalments
    public static double calculateLoan(int amountToBorrow, int termLength, double interestRate) {
        double interest = amountToBorrow * (interestRate / 100);
        double total = amountToBorrow + interest;
        return total / termLength;
    }

    public static void showHistory() {

        if (count == 0) {
            System.out.println("There are no loans stored yet.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Loan " + (i + 1 ) +
                    ": Total = " + totals[i] +
                    ", monthly payment = " + monthly[i]);
        }
    }
}


