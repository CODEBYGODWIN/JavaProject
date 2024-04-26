import java.util.Scanner;

public class GameManager {

    private int wordLength;
    private int maxAttempts;
    private int timeLimit;
    private String wordToGuess;
    private Scanner scanner;

    public GameManager(int wordLength, int maxAttempts, int timeLimit) {
        this.wordLength = wordLength;
        this.maxAttempts = maxAttempts;
        this.timeLimit = timeLimit;
        this.scanner = new Scanner(System.in);
        this.wordToGuess = new WordManager().generateRandomWord(wordLength);
    }

    public void startGame() {
        String attempt;
        int attempts = 0;
        long startTime = System.currentTimeMillis();

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

        // Calcul du temps écoulé
        long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
        System.out.println("Temps écoulé : " + elapsedTime + " secondes");

        // Vérification si le joueur a dépassé le temps limite
        if (elapsedTime >= timeLimit) {
            System.out.println("Vous avez dépassé le temps limite !");
        }
    }
}
