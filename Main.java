import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dict dict = new Dict();
        Scanner scan = new Scanner(System.in);
        String sentence = scan.nextLine();
        dict.listWrongWords(sentence);
    }
}
