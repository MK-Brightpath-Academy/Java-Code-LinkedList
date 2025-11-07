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
    public ListNode[] splitListToParts(ListNode head, int k) {
         ListNode[] result = new ListNode[k];
        int n = 0;
        ListNode curr = head;

        // Count total nodes
        while (curr != null) {
            n++;
            curr = curr.next;
        }

        int width = n / k;       // Minimum nodes per part
        int remainder = n % k;   // Extra nodes to distribute

        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode partHead = curr;
            ListNode prev = null;

            // Determine the size of this part
            int partSize = width + (i < remainder ? 1 : 0);

            for (int j = 0; j < partSize; j++) {
                prev = curr;
                if (curr != null) curr = curr.next;
            }

            // Disconnect current part
            if (prev != null) prev.next = null;

            result[i] = partHead;
        }

        return result;
    }
}