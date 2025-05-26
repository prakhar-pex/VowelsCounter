import java.io.*;
import java.util.*;

public class VowelWordCounter {
    public static void main(String[] args) {
        Map<Character, Integer> vowelCount = new HashMap<>();
        Set<Character> vowels = new HashSet<>(Arrays.asList('A', 'E', 'I', 'O', 'U'));

        try (BufferedReader reader = new BufferedReader(new FileReader("InputFile.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > 0) {
                        char firstChar = Character.toUpperCase(word.charAt(0));
                        if (vowels.contains(firstChar)) {
                            vowelCount.put(firstChar, vowelCount.getOrDefault(firstChar, 0) + 1);
                        }
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Write output to file
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (char vowel : vowelCount.keySet()) {
                writer.println(vowel + ": " + vowelCount.get(vowel));
            }
            System.out.println("Output written to output.txt");
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
