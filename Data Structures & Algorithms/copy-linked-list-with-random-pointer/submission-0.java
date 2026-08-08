/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null)
            return null;
        Node temp = head;
        while(temp!=null){
            Node tempNode = new Node(temp.val);
            tempNode.next = temp.next;
            temp.next = tempNode;
            temp = tempNode.next;
        }

        temp = head;
        while(temp!=null){
            Node temp1 = temp.next;
            if(temp.random!=null)
                temp1.random = temp.random.next;
            else
                temp1.random = null;
            temp = temp1.next;
        }

        Node newHead = head.next;
        Node newTemp = newHead;
        temp = head;

        while(newTemp!=null){
            temp.next = newTemp.next; 
            temp = temp.next;
            if(temp!=null)
                newTemp.next = temp.next;
            else{
                newTemp.next=null;
                break;
            }
            newTemp = newTemp.next;
        }
        return newHead;

    }
}
