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
        ListNode newHead = new ListNode(-1);
        ListNode temp = newHead;
        int carry = 0;
        int sum = 0;
        while(l1!=null && l2!=null){
            sum = l1.val + l2.val + carry;
            carry = sum/10;
            sum = sum%10;
            temp.next = new ListNode(sum);
            temp = temp.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l1!=null){
            while(l1!=null){
                sum = l1.val + carry;
                carry = sum/10;
                sum = sum%10;
                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 = l1.next;
            }
        }

        if(l2!=null){
            while(l2!=null){
                sum = l2.val + carry;
                carry = sum/10;
                sum = sum%10;
                temp.next = new ListNode(sum);
                temp = temp.next;
                l2 = l2.next;
            }
        }
        if(carry>0){
            temp.next = new ListNode(carry);
        }
        return newHead.next;
    }
}
