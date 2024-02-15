package challenges;

public class StringToInteger {
    public static int myAtoi(String s) {

        // To store the final integer result
        int result = 0;

        // To store the sign which would determine whether the result should be positive (1) or negative (-1)
        int sign = 1;

        // Index for iterating through the string
        int i = 0;

        // Ignore any leading whitespaces
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        // Check for sign
        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {

            // Set sign to negative if a minus sign is found
            if (s.charAt(i) == '-') {
                sign = -1;
            }

            // Then, move to the next character
            i++;
        }

        // Read the digits
        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {

            // Convert the current character to an integer
            int digit = s.charAt(i) - '0';

            // Check for overflow
            if (result > (Integer.MAX_VALUE - digit) / 10) {

                // If there's an overflow, return the maximum or minimum 32-bit integer value
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            // Update the result by multiplying it by 10 and adding the current digit
            result = result * 10 + digit;

            // Move to the next character
            i++;
        }

        // Return the final result, adjusted for the sign
        return sign * result;
    }

    //Driver code
    public static void main(String[] args) {
        String[] inputStrings = {"25", "   -25", "999 with words", "words and 567", "-91283472332", "91283472332"};

        for (int i = 0; i < inputStrings.length; i++) {
            System.out.println((i + 1) + ".\tInput string     : \"" + inputStrings[i] + "\"");
            int stoi = myAtoi(inputStrings[i]);
            System.out.println("\tConverted integer: " + stoi);
        }
    }
}
