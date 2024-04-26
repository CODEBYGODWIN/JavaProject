import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List
public class Main {
    public static void main(String[] args){
        // Chemin vers le fichier texte à lire
        String FilePath = "C:\\Users\\chris\\Downloads\\Projet1_JAVA\\JavaProject\\Mots.txt";
        try {
            // Lecture du fichier texte
            BufferedReader reader = new BufferedRead(new FileReader(filePath));
            String line;
            ArrayList<String> words = new ArrayList<>();

            // Lecture ligne par ligne
            while ((line = reader.readerLine()) != null) {
                // Séparer les mots par les espaces
                String[] lineWords = line.split("\\s+");

                // Ajout des mots à la liste
                words.addAll(Arrays.asList(lineWords));
            }
            // Fermer du lecteur
            reader.close();
        }

        // Transformer la liste de mots en tableau
        String[] wordsArray = words.toArray(new String[0]);

        // Affichage du tableau de mots
        System.out.println("les mots du fichier texte:");
        for (String word : wordsArray) {
            System.out.println(word);
        }
    } catch (IOException) {
        System.out.println("Error lors de la lecture du fichier:" + e.getMessage());
    }
}
