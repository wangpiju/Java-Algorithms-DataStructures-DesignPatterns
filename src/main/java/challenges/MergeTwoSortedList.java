package challenges;

/**
 * Merge Two Sorted Lists (Easy)
 * Problem: Merge two sorted linked lists and return it as a new sorted list.
 * 
 * Example:
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 
 * @author jess
 */
public class MergeTwoSortedList {

  /**
   * Definition for singly-linked list node
   */
  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }

    @Override
    public String toString() {
      StringBuilder result = new StringBuilder();
      ListNode current = this;
      while (current != null) {
        result.append(current.val).append(" ");
        current = current.next;
      }
      return result.toString().trim();
    }
  }

  /**
   * Merges two sorted lists using recursion
   * Time Complexity: O(n + m) where n and m are lengths of input lists
   * Space Complexity: O(n + m) due to recursion stack
   */
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    // Base cases
    if (l1 == null)
      return l2;
    if (l2 == null)
      return l1;

    // Recursive case: choose smaller value and recurse
    if (l1.val < l2.val) {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    }
  }

  /**
   * Merges two sorted lists using iteration
   * Time Complexity: O(n + m) where n and m are lengths of input lists
   * Space Complexity: O(1) as only constant extra space is used
   */
  public static ListNode mergeTwoListsIterative(ListNode l1, ListNode l2) {
    // Create dummy head to simplify edge cases
    ListNode dummyHead = new ListNode(0);
    ListNode current = dummyHead;

    // Traverse both lists and add smaller value to result
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        current.next = l1;
        l1 = l1.next;
      } else {
        current.next = l2;
        l2 = l2.next;
      }
      current = current.next;
    }

    // Append remaining nodes from either list
    current.next = (l1 != null) ? l1 : l2;

    return dummyHead.next;
  }

  /**
   * Main method for testing the implementation
   */
  public static void main(String[] args) {
    // Create first sorted list: 1->2->4->6
    ListNode a = new ListNode(1);
    a.next = new ListNode(2);
    a.next.next = new ListNode(4);
    a.next.next.next = new ListNode(6);
    System.out.println("List 1: " + a);

    // Create second sorted list: 1->3->4->7
    ListNode b = new ListNode(1);
    b.next = new ListNode(3);
    b.next.next = new ListNode(4);
    b.next.next.next = new ListNode(7);
    System.out.println("List 2: " + b);

    // Test iterative merge
    ListNode result = mergeTwoListsIterative(b, a);
    System.out.println("Merged List: " + result);
  }
}
