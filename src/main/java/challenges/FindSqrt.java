package challenges;

public class FindSqrt {
  public static void main(String[] args) {
    int num = 17;
    int sqrt = sqrt(num);
    System.out.println("The square root of " + num + " is " + sqrt);
  }

  static int sqrt(int num) {
    //如果num小於2，那麼平方根就是數字本身，所以直接返回num。
    if (num < 2) {
      return num;
    }
    //定義兩個變數left和right，它們代表我們要在其中進行搜索的範圍。
    long left = 2;
    long right = num / 2;

    while (left <= right) {
      //找出left和right的中間值mid。
      long mid = left + (right - left) / 2;
      //計算mid的平方並將其賦值給squared。
      long squared = mid * mid;
      //如果squared等於num，則返回mid，因為我們已經找到了平方根。
      // 如果squared小於num，則將left設為mid + 1。
      // 如果squared大於num，則將right設為mid - 1。這就是二分搜尋法的核心。
      if (squared == num) {
        return (int) mid;
      } else if (squared < num) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    return (int) right;
  }

}
