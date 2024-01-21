import java.util.Arrays;
import java.util.Scanner;

public class PaymentSolution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of currency denominations:");
        int size = scanner.nextInt();

        System.out.println("Enter the currency denominations value:");
        int[] denominations = new int[size];
        for (int i = 0; i < size; i++) {
            denominations[i] = scanner.nextInt();
        }

        System.out.println("Enter the amount you want to pay:");
        int amount = scanner.nextInt();

        paymentApproach(denominations, amount);
    }

    private static void paymentApproach(int[] denominations, int amount) {
        Arrays.sort(denominations);
        int[] count = new int[denominations.length];

        System.out.println("Your payment approach in order to give the minimum number of notes will be:");

        for (int i = denominations.length - 1; i >= 0; i--) {
            count[i] = amount / denominations[i];
            if (count[i] > 0) {
                System.out.println(denominations[i] + ":" + count[i]);
                amount %= denominations[i];
            }
        }
    }
}
