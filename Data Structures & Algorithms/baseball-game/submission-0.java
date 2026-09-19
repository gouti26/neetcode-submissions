class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<operations.length;i++){
            if(operations[i].equals("+")){
                int first = st.pop();
                int second = st.pop();
                st.push(second);
                st.push(first);
                st.push(first+second);
            }else if(operations[i].equals("D")){
                st.push(st.peek()*2);
            }else if(operations[i].equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        int result = 0;
        while(!st.isEmpty()){
            result += st.pop();
        }
        return result;
    }
}