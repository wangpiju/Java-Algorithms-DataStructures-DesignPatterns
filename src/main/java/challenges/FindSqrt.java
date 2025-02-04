package challenges;

public class FindSqrt {
  public static void main(String[] args) {
    int num = 17;
    int sqrt = sqrt(num);
    System.out.println("The square root of " + num + " is " + sqrt);
  }

  /**
   * Calculates the integer square root of a number using binary search.
   * Returns the floor value of the square root.
   *
   * @param num the number to calculate square root for
   * @return the floor value of the square root
   * @throws IllegalArgumentException if num is negative
   */
  static int sqrt(int num) {
    // Handle negative input
    if (num < 0) {
      throw new IllegalArgumentException("Cannot calculate square root of negative number");
    }

    // If number is less than 2, return the number itself
    if (num < 2) {
      return num;
    }

    // Initialize binary search boundaries
    // Using long to prevent integer overflow during calculations
    long start = 1;
    long end = num / 2;

    // Perform binary search to find square root
    while (start <= end) {
      long mid = start + (end - start) / 2;
      long square = mid * mid;

      if (square == num) {
        return (int) mid; // Exact square root found
      } else if (square < num) {
        start = mid + 1; // Search in right half
      } else {
        end = mid - 1; // Search in left half
      }
    }

    // Return the floor value of the square root
    return (int) end;
  }
}
