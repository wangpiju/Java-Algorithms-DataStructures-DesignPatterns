package algorithms;

import java.util.Arrays;

/**
 * 泡沫排序是一種簡單的排序算法，工作原理是重複地遍歷要排序的列表，比較每對相鄰的項目，
 * 若它們的順序錯誤就交換之。遍歷列表的工作重複進行直到沒有元素需要交換，也就是該列表已排序完成。
 * 這個算法的名字由來是因為越小的元素會逐漸“浮”到他們應在的位置。
 */
public class BubbleSort {
  public static int[] bubbleSort(int[] arr) {
    int n = arr.length;
    for (int i = 0; i < n-1; i++) {
      for (int j = 0; j < n-i-1; j++) {
        if (arr[j] > arr[j+1]) {
          // 交換 arr[j] 和 arr[j+1]
          int temp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = temp;
        }
      }
    }
    return arr;
  }

  public static void main(String[] args){
    int[] a = {3,5,1,2,7,3,2,8,9};
    System.out.println(Arrays.toString(bubbleSort(a)));
  }

  /**
   * 泡沫排序(Bubble Sort)
   *
   * 時間複雜度：
   * 最壞情況下（當輸入的數據是反排序的），泡沫排序的時間複雜度是 O(n^2)，其中 n 是輸入的數據量。
   * 最好情況下（當輸入的數據已經完全排序），泡沫排序的時間複雜度是 O(n)。
   * 平均情況下，泡沫排序的時間複雜度是 O(n^2)。
   * 空間複雜度：泡沫排序是在原數據上進行排序，不需要額外的儲存空間，所以其空間複雜度是 O(1)。
   */

}
