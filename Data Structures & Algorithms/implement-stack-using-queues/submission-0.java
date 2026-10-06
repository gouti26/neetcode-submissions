class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        return reverse();
    }
    
    public int top() {
        int val = reverse();
        q1.add(val);
        return val;
    }

    private int reverse(){
        while(!q1.isEmpty()){
            q2.add(q1.poll());
        }
        while(q2.size()>1){
            q1.add(q2.poll());
        }
        return q2.poll();
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */