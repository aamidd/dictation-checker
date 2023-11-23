import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Dict {
    private final ArrayList<String> dict;

    public Dict() {
        dict = setDict();
    }

    public void printDict() {
        for (String s : dict)
            System.out.println(s);
    }

    public void listWrongWords(String sentence) {
        String[] array = sentence.split(" ");
        for (String s : array) {
            if (!isCorrect(s)) 
                System.out.printf("\u001B[31m%s\u001B[m ", s);
            else
                System.out.printf("%s ", s);
        }
        System.out.println();
    }

    public boolean isCorrect(String word) {
        return Collections.binarySearch(dict, word) >= 0;
    }

    private ArrayList<String> setDict() {
        ArrayList<String> words = new ArrayList<>();
        try {
            Scanner scan = new Scanner(Paths.get("words.txt"));
            while (scan.hasNext())
                words.add(scan.next());
        } catch (IOException e) {
            System.out.println("Error reading dictionary. Terminating.");
            System.exit(1);
        }
        return words;
    }
}
