class Solution {
    private void helper(int n,int open,int close,StringBuilder sb,List<String>res){
        if(open>n || close>n || open<close)
            return;
        if(open==close && open+close == n*2){
            res.add(sb.toString());
            return;
        }
        
        sb.append("(");
        helper(n,open+1,close,sb,res);
        sb.deleteCharAt(sb.length()-1);

        sb.append(")");
        helper(n,open,1+close,sb,res);
        sb.deleteCharAt(sb.length()-1);
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(n,0,0,new StringBuilder(),res);
        return res;
    }
}
