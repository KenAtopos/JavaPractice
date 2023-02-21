import java.util.Scanner;

public class JavaRolls {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // See Learn the Part for detailed instructions.
        System.out.println("Let's play Rolling Java. Type anything to start.");
        scan.nextLine();

        System.out.println("Great, here are the rules:\n");
        System.out.println("- If you roll a 6, the game stops.");
        System.out.println("- If you roll a 4, nothing happens.");
        System.out.println("- Otherwise, you get 1 point.\n");
        System.out.println("You must collect at least 3 points to win. Enter anything to roll:");

        scan.nextLine();

        int score = 0;
        while (true) {

            int diceRoll = rollDice();

            if (diceRoll == 4) {
                System.out.println("\nYou rolled a " + diceRoll + ". Zero point, keep rolling.");
                continue;
            } else {
                if (diceRoll != 6) {
                    rollDice();
                    System.out.println("\nYou rolled a " + diceRoll + ". One piont, keep rolling");
                    score++;
                } else {
                    System.out.println("\nYou rolled a 6. Game end.");
                    if (score >= 3) {
                        System.out.println("Your final score is " + score + "\nYou are lucky.");
                    } else {
                        System.out.println("Your final score is " + score + "\nGood luck next time.");
                    }
                    break;
                }
            }

        }

        scan.close();

    }

    /**
     * Function name: rollDice
     * 
     * @return randomNumber (int)
     *
     *         Inside the function:
     *         - return a random number between one and six.
     */
    public static int rollDice() {
        int randomNumber = (int) (Math.random() * 6 + 1);
        return randomNumber;
    }

}
