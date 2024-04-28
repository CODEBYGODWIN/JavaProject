import java.util.Scanner;

public class GameManager {

    private int wordLength;
    private int maxAttempts;
    private int timeLimit;
    private String wordToGuess;
    private Scanner scanner;
    private boolean isTimeUp;

    public GameManager(int wordLength, int maxAttempts, int timeLimit) {
        if (timeLimit > 7200) {
            throw new ProjectException("Le temps maximum autorisé est de 7200 secondes.");
        }
        if (maxAttempts < 0) {
            throw new ProjectException("Le nombre d'essais ne peut pas être négatif.");
        }
        this.wordLength = wordLength;
        this.maxAttempts = maxAttempts;
        this.timeLimit = timeLimit;
        this.scanner = new Scanner(System.in);
        this.wordToGuess = new WordManager().generateRandomWord(wordLength);
        this.isTimeUp = false;
    }

    public void startGame() {
        System.out.println("You have "+ this.maxAttempts+" tries to guess the word and it starts with a "+this.wordToGuess.charAt(0));
        String attempt;
        int attempts = 0;

        Thread timerThread = new Thread(new TimerRunnable());
        timerThread.start();

        while (true) {
            if (isTimeUp) {
                System.out.println("\nTime is up");
                break;
            }

            if (attempts == maxAttempts) {
                System.out.println("\nYou have no more tries left. The word was : " + wordToGuess);
                System.exit(0);
            }

            System.out.print("Attempt " + (attempts + 1)+": ");
            attempt = scanner.next().toLowerCase();
            System.out.println();

            if (attempt.length() != wordLength) {
                System.out.println("Votre tentative doit contenir des lettres différentes et de longueur " + wordLength + ". Réessayez !");
                continue;
            }

            VisualManager.displayAttempt(attempt, wordToGuess);

            if (attempt.equals(wordToGuess)) {
                System.out.println("\nYou have won");
                System.exit(0);
            }
            attempts++;
        }
    }

    private class TimerRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(timeLimit * 1000);
                isTimeUp = true;
            } catch (InterruptedException e) {
                throw new ProjectException("Erreur lors de la gestion du temps.");
            }
        }
    }
}
