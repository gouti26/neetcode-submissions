class Solution {
    private boolean isOpenBracket(char ch){
        return ch =='[' || ch =='{' || ch == '(';
    }
    private boolean isMatch(char a, char b){
        if(a=='[' && b == ']')
            return true;
        if(a=='{' && b == '}')
            return true;
        if(a=='(' && b == ')')
            return true;
        return false;   
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(st.isEmpty() && !isOpenBracket(ch))
                return false;
            if(isOpenBracket(ch)){
                st.push(ch);
            }else{
                if(isMatch(st.peek(),ch)){
                    st.pop();
                }else
                    return false;
            }
        }
        return st.isEmpty();
    }
}
