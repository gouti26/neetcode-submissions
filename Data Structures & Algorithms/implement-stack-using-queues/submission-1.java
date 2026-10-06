class MyStack {
    Queue<Integer> q1;
    public MyStack() {
        q1 = new LinkedList<>();
    }
    
    public void push(int x) {
        q1.add(x);
    }
    
    public int pop() {
        return helper();
    }
    
    public int top() {
        int val = helper();
        q1.add(val);
        return val;
    }

    private int helper(){
        int size = q1.size();
        int k = 1;
        int val = 0;
        while(k<size){
            val = q1.poll();
            q1.add(val);
            k++;
        }
        return q1.poll();
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