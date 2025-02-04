package challenges;

/**
 * Find the longest common prefix among an array of strings.
 * For example:
 * Input: ["args", "arts", "arfsfsdfsdfsd", "ar43gfgfg", "ar5656ytytyt"]
 * Output: "ar"
 * 
 * Time Complexity: O(S) where S is the sum of all characters in all strings
 * Space Complexity: O(1) as we only use constant extra space
 */
public class LongestCommonPrefix {

  /**
   * Finds the longest common prefix string amongst an array of strings.
   * 
   * @param strs array of strings to check
   * @return the longest common prefix, or empty string if no common prefix exists
   */
  public static String longestCommonPrefix(String[] strs) {
    // Handle edge cases
    if (strs == null || strs.length == 0) {
      return "";
    }
    if (strs.length == 1) {
      return strs[0];
    }

    // Take first string as initial prefix
    String prefix = strs[0];

    // Compare prefix with each string
    for (int i = 1; i < strs.length; i++) {
      // While current string doesn't start with the prefix,
      // keep shortening the prefix from the end
      while (!strs[i].startsWith(prefix)) {
        prefix = prefix.substring(0, prefix.length() - 1);
        if (prefix.isEmpty()) {
          return "";
        }
      }
    }

    return prefix;
  }

  /**
   * Main method for testing the implementation
   */
  public static void main(String[] args) {
    String[] testStrings = {
        "args",
        "arts",
        "arfsfsdfsdfsd",
        "ar43gfgfg",
        "ar5656ytytyt"
    };
    System.out.println("Longest common prefix: " +
        longestCommonPrefix(testStrings));
  }
}
