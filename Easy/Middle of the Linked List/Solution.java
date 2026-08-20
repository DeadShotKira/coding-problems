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
    public ListNode middleNode(ListNode head) {
        ListNode temp = head;
        double count = 0.0;

        while(temp.next!=null){
            temp = temp.next;
            count ++;
        }

        count = Math.ceil((count/2));

        for(int i = 0; i<count; i++)
        {
            head = head.next;
        }
        return head;

    }
}