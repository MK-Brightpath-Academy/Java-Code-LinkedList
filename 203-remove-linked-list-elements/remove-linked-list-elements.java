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
    public ListNode removeElements(ListNode head, int val) {
          ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Current pointer starts at dummy
        ListNode current = dummy;

        // Traverse list
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node with target value
                current.next = current.next.next;
            } else {
                // Move ahead
                current = current.next;
            }
        }

        // Return new head (might have changed)
        return dummy.next;
    }
}