import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Enter the number of tries: ");
            int maxAttempts = scanner.nextInt();
            System.out.print("Enter the length of word: ");
            int wordLength = scanner.nextInt();
            System.out.print("Enter the time limit (in seconds): ");
            int timeLimit = scanner.nextInt();
            System.out.println("Welcome to Motus");

            GameManager gameManager = new GameManager(wordLength, maxAttempts, timeLimit);
            gameManager.startGame();
        } catch (ProjectException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
