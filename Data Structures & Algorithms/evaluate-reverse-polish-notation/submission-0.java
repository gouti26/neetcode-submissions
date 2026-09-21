class Solution {
    private boolean isOperator(String str){
        return str.equals("+") || str.equals("-")|| str.equals("*") || str.equals("/");
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i =0;i<tokens.length;i++){
            if(isOperator(tokens[i])){
                int a = st.pop();
                int b = st.pop();
                if(tokens[i].equals("+")){
                    st.push(a+b);
                }
                if(tokens[i].equals("-")){
                    st.push(b-a);
                }
                if(tokens[i].equals("*")){
                    st.push(a*b);
                }
                if(tokens[i].equals("/")){
                    st.push(b/a);                    
                }
            }else{
                st.push(Integer.parseInt(tokens[i]));
            }
        }
        return st.peek();
    }
}
