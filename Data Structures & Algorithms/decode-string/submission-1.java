class Solution {
    private boolean isDigit(char ch){
        return ch>='0' && ch<='9';
    }
    public String decodeString(String s) {
        int n = s.length();
        Stack<String> st = new Stack<>();

        for(int i =0;i<n;i++){
            if(s.charAt(i)!=']'){
                st.push(String.valueOf(s.charAt(i)));
            }else{
                StringBuilder substring = new StringBuilder();
                while(!st.peek().equals("[")){
                    substring.insert(0,st.pop());
                }
                st.pop();
                StringBuilder num = new StringBuilder();
                while(!st.isEmpty() && isDigit(st.peek().charAt(0))){
                    num.insert(0,st.pop());
                }
                int count = Integer.parseInt(num.toString());
                String repeatedString = substring.toString().repeat(count);
                st.push(repeatedString);
            }
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}