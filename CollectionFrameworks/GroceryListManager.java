package CollectionFrameworks;

import java.util.ArrayList;
import java.util.Scanner;

public class GroceryListManager {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scannner = new Scanner(System.in);
        String input;

        do{
            System.out.println("Enter an item to add it in your grocery list (or 'exit' to finish)");
            input = scannner.nextLine();
            if(!input.equalsIgnoreCase("exit")){
                groceryList.add(input);
                System.out.println(input + " has been added to your grocery List.");
            }
        }while(!input.equalsIgnoreCase("exit"));
        System.out.print("Your Grocery List\n" + groceryList+ "\n");
        scannner.close();
    }
}
