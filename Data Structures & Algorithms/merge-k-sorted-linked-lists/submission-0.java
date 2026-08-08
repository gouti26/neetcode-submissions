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
    private ListNode mergeTwoList(ListNode l1, ListNode l2){
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            }else{
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }

        if(l1!=null)
            temp.next = l1;
        if(l2!=null)
            temp.next = l2;
        return head.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null ||lists.length == 0)
            return null;
        ListNode head = null;
        for(int i =0;i<lists.length;i++){
            head = mergeTwoList(head,lists[i]);
        }
        return head;
       
    }
}
