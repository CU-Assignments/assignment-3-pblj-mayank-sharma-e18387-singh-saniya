import java.util.Scanner;

class InvalidPinException extends Exception {
    public InvalidPinException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final String CORRECT_PIN = "1234";
    private static double balance = 5000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter PIN: ");
        String enteredPin = scanner.nextLine();

        try {
            if (!enteredPin.equals(CORRECT_PIN)) {
                throw new InvalidPinException("Error: Invalid PIN.");
            }

            System.out.print("Withdraw Amount: ");
            double withdrawAmount = Double.parseDouble(scanner.nextLine
