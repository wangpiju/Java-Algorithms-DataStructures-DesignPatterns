package challenges;

/**
 * Problem: Reverse Vowels of a String
 * Write a function that takes a string as input and reverses only the vowels of
 * a string.
 * Vowels include 'a', 'e', 'i', 'o', 'u' and their uppercase variants.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for creating the char array
 */
public class ReverseVowels {
    // Set of vowels for efficient lookup
    private static final String VOWELS = "aeiouAEIOU";

    /**
     * Reverses the vowels in the given string while keeping other characters in
     * place.
     * 
     * @param s input string
     * @return string with vowels reversed
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() <= 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            // Find leftmost vowel
            while (left < right && !isVowel(chars[left])) {
                left++;
            }

            // Find rightmost vowel
            while (left < right && !isVowel(chars[right])) {
                right--;
            }

            // Swap vowels if found
            if (left < right) {
                swap(chars, left, right);
                left++;
                right--;
            }
        }

        return new String(chars);
    }

    /**
     * Checks if a character is a vowel
     */
    private boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    /**
     * Swaps two characters in an array
     */
    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    /**
     * Test cases for the reverseVowels method
     */
    public static void main(String[] args) {
        ReverseVowels solution = new ReverseVowels();

        // Test cases with expected outputs
        testCase(solution, "hello", "holle");
        testCase(solution, "DesignGUrus", "DusUgnGires");
        testCase(solution, "AEIOU", "UOIEA");
        testCase(solution, "aA", "Aa");
        testCase(solution, "", "");
    }

    /**
     * Helper method to run and print test cases
     */
    private static void testCase(ReverseVowels solution, String input, String expected) {
        String actual = solution.reverseVowels(input);
        System.out.printf("Input: %-12s | Expected: %-12s | Actual: %-12s | Pass: %b%n",
                input, expected, actual, expected.equals(actual));
    }
}
