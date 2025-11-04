/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) { if (head == null || head.next == null) return head;

        ListNode dummy = new ListNode(0); // Dummy node for sorted list
        dummy.next = head;

        ListNode lastSorted = head; // Last node of sorted part
        ListNode curr = head.next;  // Node to be inserted

        while (curr != null) {
            if (curr.val >= lastSorted.val) {
                // Current node is already in correct position
                lastSorted = lastSorted.next;
            } else {
                // Need to insert curr into sorted portion
                ListNode prev = dummy;
                // Find the correct position to insert
                while (prev.next.val < curr.val) {
                    prev = prev.next;
                }

                // Insert curr between prev and prev.next
                lastSorted.next = curr.next;
                curr.next = prev.next;
                prev.next = curr;
            }
            curr = lastSorted.next;
        }

        return dummy.next;
        
    }
}