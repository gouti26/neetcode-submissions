class Solution {
    private int helper(String s, int[]dp, int index){
        if(index == s.length()){
            return 1;
        }
        if(s.charAt(index)=='0')
            return 0;
        if(dp[index]!=-1)
            return dp[index];
        
        int count = helper(s,dp,index+1);
        if(index<s.length()-1 && (s.charAt(index)=='1' || (s.charAt(index)=='2'
        && s.charAt(index+1)<='6')))
            count += helper(s,dp,index+2);
        return dp[index] = count;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')
            return 0;
        
        int[] dp = new int[s.length()];
        Arrays.fill(dp,-1);
        return helper(s,dp,0);
    }
}
