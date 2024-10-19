package CollectionFrameworks;

import java.util.HashMap;
import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        HashMap<String, String> library = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String title, author;

        while (true) {
            System.out.println("Enter a book title (or 'exit' to finish): ");
            title = scanner.nextLine();
            if (title.equalsIgnoreCase("exit")) {
                break;
            }
            System.out.println("Enter the author of the book: ");
            author = scanner.nextLine();
            library.put(title, author);
            System.out.println(title + " by " + author + " has been added to your library.");
        }

        System.out.println("\nYour Library:");
        for (String bookTitle : library.keySet()) {
            System.out.println(bookTitle + " by " + library.get(bookTitle));
        }
        scanner.close();
    }
}
