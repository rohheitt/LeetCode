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
    public ListNode removeElements(ListNode head, int val){
        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode remove = head;

        while(remove.next != null){
            if(remove.next.val == val){
                remove.next = remove.next.next;
            }else{
                remove = remove.next;
            }
        }

        return head;
    }
}