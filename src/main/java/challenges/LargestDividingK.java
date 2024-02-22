package challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * N: Represents the size of array nums
 * K: Represents the integer K
 * nums: Represents the elements of array nums
 *
 * 問題敘述：
 * Given an integer array nums of size N and an Integer K. Find the largest positive number such that at least
 * K numbers from the array nums are divisible by it.
 *
 * 解題思路：
 * 要用Java有效率地實作"Largest Dividing K"演算法，首先需要理解演算法的目的：在給定的整數陣列nums中找到最大的正數，使得至少有K個數字能被它整除。
 *
 * 這個問題的關鍵在於找到一種方法，快速判斷某個數字是否為K個或更多陣列元素的公因數。一個直觀的方法是從1遍歷到陣列中的最大值，檢查每一個數字。但這種方法效率低下，
 * 尤其是當數字範圍很大時。
 *
 * 一個更有效的方法是反向思考：從nums陣列的元素出發，找出所有可能的公因數，然後判斷哪些公因數能被至少K個元素整除。
 *
 * 以下是實作步驟：
 *
 * 找出陣列中所有數字的公因數：首先，我們需要一個函數來找出一個數字的所有因數。然後，對nums陣列中的每個數字使用這個函數，收集所有可能的公因數。
 *
 * 計數每個因數：使用一個Map來記錄每個因數出現的次數。
 *
 * 找到最大的符合條件的因數：最後，遍歷Map中的每個因數，找到能被至少K個數字整除的最大因數。
 */
public class LargestDividingK {
    // 找出一個數字的所有因數
    private static Set<Integer> findAllFactors(int number) {
        Set<Integer> factors = new HashSet<>();
        for (int i = 1; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                factors.add(i);
                if (i != number / i) {
                    factors.add(number / i);
                }
            }
        }
        return factors;
    }

    public static int solve(int N, int K, int[] nums) {
        Map<Integer, Integer> factorCount = new HashMap<>();

        // 對每個數字找出所有因數並計數
        for (int num : nums) {
            for (int factor : findAllFactors(num)) {
                factorCount.put(factor, factorCount.getOrDefault(factor, 0) + 1);
            }
        }

        // 從大到小檢查每個因數
        int result = 0;
        for (int factor : factorCount.keySet()) {
            if (factorCount.get(factor) >= K) {
                result = Math.max(result, factor);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, -1, -3, 16, 32, 64, -5};
        int N = nums.length;
        int K = 3;

        System.out.println(solve(N, K, nums));
    }



}
