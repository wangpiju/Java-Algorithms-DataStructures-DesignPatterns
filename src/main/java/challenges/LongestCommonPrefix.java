package challenges;

public class LongestCommonPrefix {

  /**
   * @author jess 從字串陣列中找出最長前綴
   *     input: ["args", "arts", "arfsfsdfsdfsd", "ar43gfgfg", "ar5656ytytyt"]
   *     output: "ar"
   */
  public static String longestCommonPrefix(String[] strs) {
    if (strs == null || strs.length == 0) {
      return "";
    }

    String pre = strs[0];
    int i = 1;
    while (i < strs.length) {
      while (strs[i].indexOf(pre) != 0) {
        pre = pre.substring(0, pre.length() - 1);
      }
      i++;
    }
    return pre;
  }

  public static void main(String[] args) {
    System.out.println(longestCommonPrefix(new String[]{"args", "arts", "arfsfsdfsdfsd", "ar43gfgfg", "ar5656ytytyt"}));
  }
}
