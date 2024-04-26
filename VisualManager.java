public class VisualManager {

    public static void displayAttempt(String attempt, String wordToGuess) {
        for (int i = 0; i < attempt.length(); i++) {
            char letter = attempt.charAt(i);
            if (wordToGuess.charAt(i) == letter) {
                printColoredSquare(letter, "vert");
            } else if (wordToGuess.contains(Character.toString(letter))) {
                printColoredSquare(letter, "orange");
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
