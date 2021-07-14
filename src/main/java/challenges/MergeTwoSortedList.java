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

  //recursion
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

  //loop
  public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
    //fake head
    ListNode head = new ListNode(0);
    ListNode p = head;

    ListNode p1 = l1;
    ListNode p2 = l2;

    //The key to solve the problem is defining a fake head. Then compare the first elements from each list. Add the smaller one to the merged list.
    while (p1 != null && p2 != null) {
      if (p1.val < p2.val) {
        p.next = p1;
        p1 = p1.next;
      } else {
        p.next = p2;
        p2 = p2.next;
      }

      p = p.next;
    }

    //when one of them is empty, simply append it to the merged list
    if (p1 != null) {
      p.next = p1;
    }

    if (p2 != null) {
      p.next = p2;
    }

    return head.next;
  }

  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(4);
    a.next.next.next = new ListNode(6);
    System.out.println("list a: " + a);
    ListNode b = new ListNode(1);
    b.next = new ListNode(3);
    b.next.next = new ListNode(4);
    b.next.next.next = new ListNode(7);
    System.out.println("list b: " + b);

    ListNode result = mergeTwoLists2(b, a);

    System.out.println("result: " + result.toString());
  }
}
