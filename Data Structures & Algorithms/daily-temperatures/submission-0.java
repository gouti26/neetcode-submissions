class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        result[n-1] = 0;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[st.peek()] < temperatures[i]){
                result[st.peek()] = i - st.peek();
                st.pop();
            }
            st.push(i);
        }

        while(!st.isEmpty()){
            int topIndex = st.pop();
            if(st.isEmpty()){
                result[topIndex] = 0;
                break;
            }
            if(temperatures[topIndex] > temperatures[st.peek()]){
                result[st.peek()] = topIndex - st.peek();
                st.pop();
                st.push(topIndex);
            }
        }

        return result;
    }
}
