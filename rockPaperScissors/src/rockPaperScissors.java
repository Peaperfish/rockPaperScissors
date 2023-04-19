import java.util.Random;
import java.util.Scanner;

public class rockPaperScissors {
    private static final String ROCK = "rock";
    private static final String PAPER = "paper";
    private static final String SCISSORS = "scissors";

    public void play() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int userScore = 0;
        int computerScore = 0;

        while (true) {
            System.out.print("Enter your choice (rock, paper, or scissors): ");
            String userChoice = scanner.nextLine();

            if (userChoice.isEmpty()) {
                System.out.printf("Your score: %d, Computer score: %d%n \n Thanks for playing! ", userScore, computerScore);
                break;
            }

            String computerChoice = generateComputerChoice(random);
            System.out.printf("User: %s%n", userChoice);
            System.out.printf("Computer: %s%n", computerChoice);

            String winner = getWinner(userChoice, computerChoice);
            System.out.println(winner);

            if (winner.equals("User wins! \n")) {
                userScore++;
            } else if (winner.equals("Computer wins! \n")) {
                computerScore++;
            }

            System.out.printf("Score: You %d, Computer %d%n%n", userScore, computerScore);
        }
    }


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
}
