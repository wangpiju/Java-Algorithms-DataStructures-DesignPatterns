package challenges;

/**
 * String to Integer (atoi) Implementation
 * Converts a string to a 32-bit signed integer following these rules:
 * 1. Ignore leading whitespace
 * 2. Check for optional sign (+ or -)
 * 3. Read digits until non-digit character or end of string
 * 4. Handle overflow/underflow cases
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(1) as we only use constant extra space
 */
public class StringToInteger {

    /**
     * Converts string to integer (atoi implementation)
     * 
     * @param s input string to convert
     * @return converted integer value
     */
    public static int myAtoi(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int index = 0;
        int result = 0;
        int sign = 1;
        int len = s.length();

        // Skip leading whitespace
        while (index < len && s.charAt(index) == ' ') {
            index++;
        }

        // Check if we've reached the end after removing whitespace
        if (index == len) {
            return 0;
        }

        // Handle sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = (s.charAt(index) == '+') ? 1 : -1;
            index++;
        }

        // Process digits
        while (index < len) {
            char currentChar = s.charAt(index);

            // Break if non-digit character is found
            if (!Character.isDigit(currentChar)) {
                break;
            }

            // Convert character to digit
            int digit = currentChar - '0';

            // Check for overflow
            if (result > Integer.MAX_VALUE / 10 ||
                    (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update result
            result = result * 10 + digit;
            index++;
        }

        return sign * result;
    }

    /**
     * Test cases for the myAtoi implementation
     */
    public static void main(String[] args) {
        String[] testCases = {
                "42", // Basic positive number
                "   -42", // Number with whitespace and negative sign
                "4193 with words", // Number with trailing words
                "words and 987", // Words before number
                "-91283472332", // Overflow case
                "91283472332", // Overflow case
                "  ", // Only whitespace
                "+1", // Explicit positive sign
                "+-12", // Invalid sign sequence
                "" // Empty string
        };

        for (String test : testCases) {
            System.out.printf("Input: \"%-20s\" | Output: %d%n",
                    test, myAtoi(test));
        }
    }
}
