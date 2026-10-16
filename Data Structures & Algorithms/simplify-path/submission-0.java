class Solution {
    public String simplifyPath(String path) {
        String[] ar = path.split("/");
        int n = ar.length;
        Stack<String> st = new Stack<>();
        for(int i =0;i<n;i++){
            if(ar[i]==""){
                while(i<n-1 && ar[i+1]==""){
                    i++;
                }
                continue;
            }
            if(ar[i].startsWith(".")){
                int len = ar[i].length();
                if(len==1)
                    continue;
                if(len==2){
                    if(!st.isEmpty())
                        st.pop();
                    if(!st.isEmpty())
                        st.pop();
                    continue;
                }
            }
            st.push("/");
            st.push(ar[i]);
        }

        StringBuilder result = new StringBuilder();
        if(st.isEmpty()){
            st.push("/");
        }
        while(!st.isEmpty()){
            //System.out.println(" => "+st.peek());
            result.insert(0,st.pop());
        }
        return result.toString();
    }
}