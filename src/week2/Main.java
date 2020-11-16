package week2;
import java.util.Scanner;

public class Main {
	// initialise global variables
	static Scanner scanner;

	static void euclidCalculator() {
        //initialise variables
		int x;
		int y;
		int max;
		int min;
		int rem;

		// print task header info to screen
        System.out.println(
				"\nEuclid's Algorithm Calculator\n" + "_______________________________\n"
        );

		// accept keyboard integer input
		System.out.print("x = ");
        x = scanner.nextInt();
		System.out.print("y = ");
        y = scanner.nextInt();

        // find the greater integer of the two inputs
        max = Math.max(x, y);
        min = Math.min(x, y);

        // euclid algorithm
        do {
            rem = max % min;
            max = min;
            min = rem;
		} while (rem != 0);

        // print results to screen
        System.out.println("GCD = " + max);

	}

	static void randomDice() {
		// print task header info to screen
		System.out.println("\n20 Sided Dice\n" + "_______________________________\n");
		System.out.println("Enter a number to run its task: ");
		System.out.println("1. Roll the dice X times\n" + "2. Roll the dice until X\n");
		System.out.print("> ");

		int choice = scanner.nextInt();
		int num;

		switch (choice) {
			case 1 -> {
				System.out.print("\nNumber of dice rolls required: ");
				num = scanner.nextInt();
				for (int i = 0; i < num; i++) {
					int randomNumber = (int) (20 * Math.random() + 1);
					if (i == num - 1) {
						System.out.println(randomNumber);
					} else {
						System.out.print(randomNumber + ", ");
					}
				}
			}
			case 2 -> {
				System.out.print("\nNumber at which to stop: ");
				num = scanner.nextInt();
				int randomNumber;
				int count = 0;
				do {
					randomNumber = (int) (20 * Math.random() + 1);
					if (count < 100) {
						count += 1;
					} else {
						break;
					}

				} while (randomNumber != num);
				if (count == 100) {
					System.out.println("\033[0;30;41m 100 \033[0m rolls exceeded without a match");
				} else {
					System.out.printf("Dice was rolled \033[0;30;42m %1s \033[0m times before %2s showed up", count,
							num);
				}
			}
		}

	}

	static int instructions() {
		// variable to accept user selection on what task to run
		int choice;

		System.out.println("\nEnter a number to run its task: ");
		System.out.println("0. Exit the application\n" + "1. Euclid's Algorithm Calculator\n" + "2. 20 Sided Dice\n");
		System.out.print("> ");

		choice = scanner.nextInt();

		return choice;
	}

	public static void main(String[] args) {
		// create new instance of scanner in constructor
		scanner = new Scanner(System.in);

		// stores user task selection input
		int choice = instructions();

		do {
			switch (choice) {
				case 0 :
					continue;
				case 1 :
					euclidCalculator();
					break;
				case 2 :
					randomDice();
					break;
				default :
					break;
			}
			System.out.println("\nTASK COMPLETE\n");
			choice = instructions();
		} while (choice != 0);
		System.out.println("\nGOOD BYE\n");
    }
}
