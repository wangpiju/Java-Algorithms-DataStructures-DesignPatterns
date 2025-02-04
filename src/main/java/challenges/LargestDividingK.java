package challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem Description:
 * Given an integer array nums of size N and an Integer K, find the largest
 * positive number
 * such that at least K numbers from the array nums are divisible by it.
 *
 * Algorithm Approach:
 * 1. For each number in the array, find all its factors
 * 2. Keep track of how many numbers each factor can divide using a HashMap
 * 3. Find the largest factor that divides at least K numbers
 *
 * Time Complexity: O(N * sqrt(M)) where:
 * - N is the length of the input array
 * - M is the maximum number in the array
 * 
 * Space Complexity: O(M) where M is the maximum number in the array
 */
public class LargestDividingK {

    /**
     * Finds all factors of a given number using optimized trial division
     * 
     * @param number The number to find factors for
     * @return Set of all factors
     */
    private static Set<Integer> findFactors(int number) {
        Set<Integer> factors = new HashSet<>();
        number = Math.abs(number); // Handle negative numbers

        if (number == 0) {
            return factors;
        }

        // Only need to check up to square root
        int sqrt = (int) Math.sqrt(number);
        for (int i = 1; i <= sqrt; i++) {
            if (number % i == 0) {
                factors.add(i);
                if (i != number / i) { // Avoid adding the same factor twice for perfect squares
                    factors.add(number / i);
                }
            }
        }
        return factors;
    }

    /**
     * Solves the largest dividing K problem
     * 
     * @param N    Length of the array
     * @param K    Minimum count of numbers that must be divisible
     * @param nums Input array
     * @return Largest number that divides at least K numbers in the array
     */
    public static int solve(int N, int K, int[] nums) {
        if (N == 0 || K <= 0 || K > N) {
            return 0;
        }

        Map<Integer, Integer> factorCount = new HashMap<>();

        // Count how many numbers each factor can divide
        for (int num : nums) {
            if (num == 0)
                continue; // Skip zero as it has infinite factors
            Set<Integer> factors = findFactors(num);
            for (int factor : factors) {
                factorCount.merge(factor, 1, Integer::sum);
            }
        }

        // Find the largest factor that divides at least K numbers
        return factorCount.entrySet().stream()
                .filter(entry -> entry.getValue() >= K)
                .map(Map.Entry::getKey)
                .max(Integer::compareTo)
                .orElse(0);
    }

    /**
     * Example usage
     */
    public static void main(String[] args) {
        int[] nums = { 1, -1, -3, 16, 32, 64, -5 };
        int N = nums.length;
        int K = 3;

        System.out.println("Result: " + solve(N, K, nums));
    }
}
