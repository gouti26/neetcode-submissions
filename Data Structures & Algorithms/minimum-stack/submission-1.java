class MinStack {
    long min;
    Stack<Long> st;
    public MinStack() {
        st = new Stack<>();
        min = Integer.MAX_VALUE;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min = val;
            st.push(0L);
            return;
        }
        st.push(val-min);
        if(val<min)
            min = val;
    }
    
    public void pop() {
        long val = st.pop();
        if(val<0)
            min = min-val;
    }
    
    public int top() {
        if(st.peek()<=0)
            return (int)min;
        return (int)(min+st.peek());
    }
    
    public int getMin() {
        return (int)min;
    }
}
