import java.util.HashMap;
import java.util.Map;

public class VisualManager {

    public static void displayAttempt(String attempt, String wordToGuess) {
        Map<Character, Integer> letterCounts = new HashMap<>();
        for (char c : wordToGuess.toCharArray()) {
            letterCounts.put(c, letterCounts.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < attempt.length(); i++) {
            char letter = attempt.charAt(i);
            if (wordToGuess.charAt(i) == letter) {
                printColoredSquare(letter, "vert");
                letterCounts.put(letter, letterCounts.get(letter) - 1);
            } else if (letterCounts.containsKey(letter) && letterCounts.get(letter) > 0) {
                printColoredSquare(letter, "orange");
                letterCounts.put(letter, letterCounts.get(letter) - 1);
            } else {
                printColoredSquare(letter, "rouge");
            }
        }
        System.out.println("|");
    }

    private static void printColoredSquare(char letter, String color) {
        String colorCode;
        switch (color) {
            case "rouge":
                colorCode = "\033[41m"; // Rouge
                break;
            case "vert":
                colorCode = "\033[42m"; // Vert
                break;
            case "orange":
                colorCode = "\033[43m"; // Orange
                break;
            default:
                colorCode = "\033[0m"; // Couleur par défaut
        }
        System.out.print("|" + colorCode + " " + letter + " \033[0m");
    }
}
