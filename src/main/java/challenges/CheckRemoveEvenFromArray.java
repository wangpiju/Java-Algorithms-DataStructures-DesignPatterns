package challenges;

/**
 * @author jess
 * Remove Even Integers from an Array
 */
public class CheckRemoveEvenFromArray{

  public static int[] removeEven(int[] arr) {
    int oddElements = 0;

    //Find number of odd elements in arr
    for (int j : arr) {
      if (j % 2 != 0) {
        oddElements++;
      }
    }

    //Create result array with the size equal to the number of odd elements in arr
    int[] result = new int[oddElements];
    int resultIndex = 0;

    //Put odd values from arr to the resulted array
    for (int j : arr) {
      if (j % 2 != 0) {
        result[resultIndex++] = j;
      }
    } //end of for loop

    return result;
  } //end of removeEven


  public static void main(String[] args) {

    int size = 10;
    //declaration and instantiation
    int[] arr = new int[size];

    System.out.print("Before removing Even Numbers: ");
    for (int i = 0; i < arr.length; i++) {
      // assigning values
      arr[i] = i;
      System.out.print(arr[i] +  " ");
    }
    System.out.println();
    // calling removeEven
    int[] newArr =  removeEven(arr);

    System.out.print("After removing Even Numbers: ");
    for (int j : newArr) {
      // printing array
      System.out.print(j + " ");
    }
  }
}
