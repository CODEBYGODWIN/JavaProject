public class WordManager {

    private String[] words = {"apple", "banana", "orange", "grape", "kiwi", "peach", "lemon"};

    public String generateRandomWord(int length) {
        String[] wordsLength = filterWordsByLength(length);
        int randomIndex = (int) (Math.random() * wordsLength.length);
        return wordsLength[randomIndex];
    }

    private String[] filterWordsByLength(int length) {
        return java.util.Arrays.stream(words)
                .filter(word -> word.length() == length)
                .toArray(String[]::new);
    }
}
