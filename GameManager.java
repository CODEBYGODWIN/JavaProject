import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameManager {

    private int wordLength;
    private int maxAttempts;
    private String wordToGuess;
    private Scanner scanner;
    private Timer timer;

    public GameManager(int wordLength, int maxAttempts) {
        this.wordLength = wordLength;
        this.maxAttempts = maxAttempts;
        this.scanner = new Scanner(System.in);
        this.timer = new Timer(String.valueOf(System.in));
        this.wordToGuess = new WordManager().generateRandomWord(wordLength);
    }

    public void startGame() {
        String attempt;
        int attempts = 0;

        // Création du timer
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("\nTemps écoulé ! Le jeu est terminé.");
                scanner.close(); // Fermer le scanner
                timer.cancel(); // Arrêter le timer
            }
        }, 20000); // 2 minutes en millisecondes

        // Boucle principale du jeu
        while (true) {
            System.out.println("Essai " + (attempts + 1) + "/" + maxAttempts);
            System.out.print("Entrez votre tentative de " + wordLength + " lettres : ");
            attempt = scanner.next().toLowerCase();

            // Vérification si la lettre est déjà utilisée
            if (attempt.length() != wordLength) {
                System.out.println("Votre tentative doit contenir des lettres différentes et de longueur " + wordLength + ". Réessayez !");
                continue;
            }

            // Affichage de l'état des essais
            VisualManager.displayAttempt(attempt, wordToGuess);

            // Vérification si le mot est trouvé
            if (attempt.equals(wordToGuess)) {
                System.out.println("Félicitations ! Vous avez trouvé le mot !");
                break;
            }

            // Vérification si le joueur a dépassé le nombre maximum d'essais
            if (++attempts == maxAttempts) {
                System.out.println("Vous avez dépassé le nombre maximum d'essais. Le mot était : " + wordToGuess);
                break;
            }
        }

        // Arrêter le scanner et le timer
        scanner.close();
        timer.cancel();
    }
}
