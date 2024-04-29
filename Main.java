import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu du Pendu !");

        int wordLength;
        do {
            System.out.print("Entrez la longueur du mot à deviner (plus de 0) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un entier valide.");
                scanner.next();
            }
            wordLength = scanner.nextInt();
        } while (wordLength <= 0);

        int maxAttempts;
        do {
            System.out.print("Entrez le nombre d'essais maximum (plus de 0) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un entier valide.");
                scanner.next();
            }
            maxAttempts = scanner.nextInt();
        } while (maxAttempts <= 0);

        int timeLimit;
        do {
            System.out.print("Entrez la durée limite (en secondes, plus de 0) : ");
            while (!scanner.hasNextInt()) {
                System.out.println("Veuillez entrer un entier valide.");
                scanner.next();
            }
            timeLimit = scanner.nextInt();
        } while (timeLimit <= 0);

        GameManager gameManager = new GameManager(wordLength, maxAttempts, timeLimit);
        gameManager.startGame();

        scanner.close();
    }
}
