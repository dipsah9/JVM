package CollectionFrameworks;

import java.util.HashMap;

public class CharacterCounter {
    public static void main(String[] args) {
        String input = "hello world";
        HashMap<Character, Integer> charCount = new HashMap<>();

        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        System.out.println("Character Count:");
        for (char c : charCount.keySet()) {
            System.out.println(c + ": " + charCount.get(c));
        }
    }
}

