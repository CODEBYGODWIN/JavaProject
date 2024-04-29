import java.util.Scanner;

public class GameManager {

    private int wordLength;
    private int maxAttempts;
    private int timeLimit;
    private String wordToGuess;
    private Scanner scanner;
    private boolean isTimeUp;

    public GameManager(int wordLength, int maxAttempts, int timeLimit) {
        this.wordLength = wordLength;
        this.maxAttempts = maxAttempts;
        this.timeLimit = timeLimit;
        this.scanner = new Scanner(System.in);
        this.wordToGuess = new WordManager().generateRandomWord(wordLength);
        this.isTimeUp = false;
    }

    public void startGame() {
        String attempt;
        int attempts = 0;

        Thread timerThread = new Thread(new TimerRunnable());
        timerThread.start();

        while (true) {
            if (isTimeUp) {
                System.out.println("Temps écoulé !");
                break;
            }

            System.out.println("Essai " + (attempts + 1) + "/" + maxAttempts);
            System.out.print("Entrez votre tentative de " + wordLength + " lettres : ");
            attempt = scanner.next().toLowerCase();

            if (attempt.length() != wordLength) {
                System.out.println("La longueur du mot doit être de " + wordLength + " lettres. Réessayez !");
                continue;
            }

            VisualManager.displayAttempt(attempt, wordToGuess);

            if (attempt.equals(wordToGuess)) {
                System.out.println("Félicitations ! Vous avez trouvé le mot !");
                System.exit(0);
            }

            if (++attempts == maxAttempts) {
                System.out.println("Vous avez dépassé le nombre maximum d'essais. Le mot était : " + wordToGuess);
                System.exit(0);
            }
        }
    }

    private class TimerRunnable implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(timeLimit * 1000);
                isTimeUp = true;
            } catch (InterruptedException e) {
                throw new RuntimeException("what is the time");
            }
        }
    }
}
