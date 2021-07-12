package challenges;

/**
 * @author jess
 *     Merge Two Sorted Lists (Easy)
 *     Input: 1->2->4, 1->3->4
 *     Output: 1->1->2->3->4->4
 */
public class MergeTwoSortedList {

  public static class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      String result = val + " ";
      if (next != null) {
        result += next.toString();
      }
      return result;
    }
  }

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }

    if (l2 == null) {
      return l1;
    }

    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(4);
    ListNode b = new ListNode(1);
    b.next = new ListNode(3);
    b.next.next = new ListNode(4);

    ListNode result = mergeTwoLists(a, b);

    System.out.println(result.toString());
  }
}
