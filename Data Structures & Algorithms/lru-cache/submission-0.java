class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key;
        int val;
        Node(int key,int val){
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
    int size;
    Map<Integer,Node> mp;
    Node head,tail;
    public LRUCache(int capacity) {
        size = capacity;
        mp = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void insert(Node nd){ //add key in the start of the list
        Node headNext = head.next;
        head.next = nd;
        nd.next = headNext;
        headNext.prev = nd;
        nd.prev = head;
        mp.put(nd.key,nd);
    }

    private void remove(Node nd){
        mp.remove(nd.key);
        Node prevNode = nd.prev;
        Node nextNode = nd.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    
    public int get(int key) {
        if(!mp.containsKey(key))
            return -1;
        Node nd = mp.get(key);
        int val = nd.val;
        remove(nd);
        insert(nd);
        return val;
    }
    
    public void put(int key, int value) {
        if(mp.containsKey(key)){
            remove(mp.get(key));
        }
        if(mp.size()==size){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }
}
