package week2;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //initialise variables
        int x, y, max, min, rem;

        // initialise new Scanner object that gets keyboard input
        Scanner scanner = new Scanner(System.in);

        // accept keyboard integer input
        System.out.println(
                "Euclid's Algorithm Calculator\n" +
                "_______________________________"
        );
        System.out.println("x = ");
        x = scanner.nextInt();
        System.out.println("y = ");
        y = scanner.nextInt();

        // find the greater integer of the two inputs
        max = Math.max(x, y);
        min = Math.min(x, y);

        // euclid algorithm
        do {
            rem = max % min;
            max = min;
            min = rem;
        }
        while (rem != 0);

        // print results to screen
        System.out.println("GCD = " + max);

    }
}
