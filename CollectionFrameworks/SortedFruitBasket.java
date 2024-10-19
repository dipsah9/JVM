package CollectionFrameworks;

import java.util.Scanner;
import java.util.TreeSet;

public class SortedFruitBasket {
    public static void main(String[] args) {
        TreeSet<String> sortedFruits = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        String fruit;

        while (true) {
            System.out.println("Enter a fruit (or 'done' to finish): ");
            fruit = scanner.nextLine();
            if (fruit.equalsIgnoreCase("done")) {
                break;
            }
            sortedFruits.add(fruit);
        }

        System.out.println("\nYour Sorted Fruit Basket: " + sortedFruits);
        scanner.close();
    }
}
