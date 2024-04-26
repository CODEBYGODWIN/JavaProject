import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenue dans le jeu du Pendu !");
        System.out.print("Entrez la longueur du mot à deviner : ");
        int wordLength = scanner.nextInt();
        System.out.print("Entrez le nombre d'essais maximum : ");
        int maxAttempts = scanner.nextInt();

        GameManager gameManager = new GameManager(wordLength, maxAttempts);
        gameManager.startGame();

        scanner.close();
    }
}
