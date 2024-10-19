package CollectionFrameworks;

import java.util.HashSet;
import java.util.Scanner;

public class UniqueFruitsBasket {
    public static void main(String[] args) {
        HashSet<String> fruitBasket = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        do{
            System.out.println("Enter the fruits you want to add in the basket (or 'exit' to finish)");
            input = scanner.nextLine();

            if(input.equalsIgnoreCase("exit")){
                break;
            }

            if(fruitBasket.add(input)){
                System.out.println(input + " is added in the Basket.");
            }else{
                System.out.println(input + " is already in the basket.");
            }
        }while(!input.equalsIgnoreCase("exit"));
        System.out.println("Our unique Fruit basket is: \n" + fruitBasket);
        scanner.close();
    }
}
