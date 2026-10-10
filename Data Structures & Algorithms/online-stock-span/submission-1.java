class StockSpanner {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public StockSpanner() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }
    
    public int next(int price) {
        if(st1.isEmpty()){
            st1.push(price);
            return 1;
        }
        st2.push(price);
        while(!st1.isEmpty() && price>=st1.peek()){
            st2.push(st1.pop());
        }
        int val = st2.size();
        while(!st2.isEmpty()){
            st1.push(st2.pop());
        }
        return val;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */