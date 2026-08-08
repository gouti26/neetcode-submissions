class Solution {
    public int jump(int[] nums) {
        //int stepCount = 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i =0;i<n;i++){
            int val = nums[i];
            for(int j = 1;j<=val;j++){
                if(i+j<n){
                    dp[i+j] = Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        return dp[n-1];
    }
}
