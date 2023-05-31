import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author rceil
 */
public class L9Q2 {

    public static void main(String[] args) {
        Scanner rc = new Scanner(System.in);
        System.out.print("Input String : ");
        String input = rc.nextLine();

        System.out.println("Output Permutation : ");
        permuteString(input);
    }

    public static void permuteString(String word) {
        permuteStringHelper("", word);
    }

    private static void permuteStringHelper(String prefix, String remaining) {
        int length = remaining.length();

        // Base case: If there are no characters remaining, we have a permutation
        if (length == 0) {
            System.out.println(prefix);
            return;
        }

        // Recursive case: Iterate over each character in the remaining string
        for (int i = 0; i < length; i++) {
            // Take out the character at index i from the remaining string
            String newPrefix = prefix + remaining.charAt(i);
            String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);

            // Recursive call to find permutations of the remaining characters
            permuteStringHelper(newPrefix, newRemaining);
        }
    }
}
