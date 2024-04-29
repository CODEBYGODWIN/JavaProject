import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordManager {

    public String generateRandomWord(int length) {
        String[] wordsLength = filterWordsByLength(length);
        if (wordsLength.length == 0) {
            throw new ProjectException("No word find with that length.");
        }
        int randomIndex = (int) (Math.random() * wordsLength.length);
        return wordsLength[randomIndex];
    }

    private String[] filterWordsByLength(int length) {
        String filePath = "C:\\Users\\33772\\Documents\\JavaProject\\words.txt";
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
            throw new ProjectException("Error when reading the file.");
        }

        assert wordsArray != null;
        return java.util.Arrays.stream(wordsArray)
                .filter(word -> word.length() == length)
                .toArray(String[]::new);
    }
}
