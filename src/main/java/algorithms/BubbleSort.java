package algorithms;

import java.util.Arrays;

/**
 * Bubble Sort is a simple sorting algorithm that repeatedly steps through the
 * list,
 * compares adjacent elements and swaps them if they are in the wrong order.
 * The pass through the list is repeated until no more swaps are needed, which
 * means
 * the list is sorted. The algorithm gets its name because smaller elements
 * "bubble up"
 * to their correct positions.
 */
public class BubbleSort {
  public static int[] bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n - 1; i++) {
      for (int j = 0; j < n - i - 1; j++) {
        if (arr[j] > arr[j + 1]) {
          // Swap arr[j] and arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args) {
    int[] a = { 3, 5, 1, 2, 7, 3, 2, 8, 9 };
    System.out.println(Arrays.toString(bubbleSort(a)));
  }

  /**
   * Bubble Sort Analysis
   *
   * Time Complexity:
   * Worst Case: O(n^2) - when the input array is reverse sorted
   * Best Case: O(n) - when the input array is already sorted
   * Average Case: O(n^2)
   * 
   * Space Complexity: O(1) - sorting is done in-place, no extra storage is needed
   */
}
