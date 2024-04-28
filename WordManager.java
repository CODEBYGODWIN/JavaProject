import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordManager {

    public String generateRandomWord(int length) {
        String[] wordsLength = filterWordsByLength(length);
        if (wordsLength.length == 0) {
            throw new ProjectException("Aucun mot trouvé avec la longueur spécifiée.");
        }
        int randomIndex = (int) (Math.random() * wordsLength.length);
        return wordsLength[randomIndex];
    }

    private String[] filterWordsByLength(int length) {
        String filePath = "C:\\Nouveau dossier\\words.txt";
        String[] wordsArray = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            ArrayList<String> words = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] lineWords = line.split("\\s+");
                words.addAll(Arrays.asList(lineWords));
            }

            reader.close();
            wordsArray = words.toArray(new String[0]);

        } catch (IOException e) {
            throw new ProjectException("Erreur lors de la lecture du fichier: " + e.getMessage());
        }

        assert wordsArray != null;
        return java.util.Arrays.stream(wordsArray)
                .filter(word -> word.length() == length)
                .toArray(String[]::new);
    }
}
