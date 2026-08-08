class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int n = s.length();

        for(int i =0;i<n;i++){
            char ch = s.charAt(i);
            if(st.isEmpty()){
                if(ch=='}' || ch == ']' || ch==')')
                    return false;
                st.push(ch);
            }else{
                if(st.peek() == '[' && ch==']')
                    st.pop();
                else if(st.peek() == '(' && ch==')')
                    st.pop();
                else if(st.peek() == '{' && ch=='}')
                    st.pop();
                else
                    st.push(ch);
            }
        }
        return st.isEmpty();
    }
}
