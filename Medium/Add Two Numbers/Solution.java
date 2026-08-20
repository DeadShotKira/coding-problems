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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addition = new ListNode(0);
        ListNode tail = addition;
        int carry=0;

        while(l1 != null || l2 != null || carry != 0){

            int a =(l1!=null)?l1.val:0;
            int b =(l2!=null)?l2.val:0;

            int sum = a+b+carry;
            int digit = sum % 10;
            carry = sum/10;
            ListNode newNode = new ListNode(digit);
            tail.next=newNode;
            tail = tail.next;
            l1=(l1!=null)?l1.next:null;
            l2=(l2!=null)?l2.next:null;

        }
        ListNode res = addition.next;
        addition.next = null;
        return res;

    }
}