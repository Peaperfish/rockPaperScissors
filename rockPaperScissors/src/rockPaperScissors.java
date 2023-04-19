import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    private int userScore;
    private int computerScore;

    private static String generateComputerChoice(Random random) {
        int choiceIndex = random.nextInt(3);
        if (choiceIndex == 0) {
            return ROCK;
        } else if (choiceIndex == 1) {
            return PAPER;
        } else {
            return SCISSORS;
        }
    }

    private static String getWinner(String user, String computer) {
        if (user.equals(computer)) {
            return "Tie \n";
        } else if ((user.equals(ROCK) && computer.equals(SCISSORS))
                || (user.equals(PAPER) && computer.equals(ROCK))
                || (user.equals(SCISSORS) && computer.equals(PAPER))) {
            return "User wins! \n";
        } else {
            return "Computer wins! \n";
        }
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine();

            if (userChoice.isEmpty()) {
                System.out.println("Thanks for playing!");
                System.out.printf("Final score: User %d - %d Computer%n", userScore, computerScore);
                break;
            }

            String computerChoice = generateComputerChoice(random);
            System.out.printf("User: %s%n", userChoice);
            System.out.printf("Computer: %s%n", computerChoice);

            String winner = getWinner(userChoice, computerChoice);
            System.out.println(winner);

            if (winner.equals("User wins!")) {
                userScore++;
            } else if (winner.equals("Computer wins!")) {
                computerScore++;
            }
            System.out.printf("Score: User %d - %d Computer%n", userScore, computerScore);
        }
    }
}
