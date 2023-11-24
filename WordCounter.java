import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = "";

        System.out.println("Welcome");
        System.out.println("Do you want to enter a text or provide a file? (T/F)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("T")) {

            System.out.println("Please enter your text:");
            text = scanner.nextLine();
        } else if (choice.equalsIgnoreCase("F")) {

            System.out.println("Please enter the file name:");
            String fileName = scanner.nextLine();

            try {
                File file = new File(fileName);
                Scanner fileScanner = new Scanner(file);
                while (fileScanner.hasNextLine()) {
                    text += fileScanner.nextLine() + "\n";
                }
                fileScanner.close();
            } catch (FileNotFoundException e) {

                System.out.println("File not found: " + fileName);
                System.exit(1);
            }
        } else {

            System.out.println("Invalid choice: " + choice);
            System.exit(1);
        }

        String[] words = text.split("[\\s\\p{Punct}]+");

        int count = 0;

        for (String word : words) {
            count++;
        }

        System.out.println("The total number of words in your text is: " + count);
    }
}
