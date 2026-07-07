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
    public ListNode reverseList(ListNode head) {
        ListNode temp = null;
        ListNode left = null;
        ListNode right = head;

        while(right != null){
            left = right;
            right = right.next;
            left.next = temp;
            temp = left;
        }
        head = temp;
        return head;
    }
}