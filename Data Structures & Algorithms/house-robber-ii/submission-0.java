class Solution {
    private int helper(int start,int end,int[]nums){
        int n = nums.length;
        int[] dp = new int[n];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for(int i = start+2;i<=end;i++){
            dp[i] = Math.max(dp[i-1],nums[i]+dp[i-2]);
        }
        return dp[end];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1)
            return nums[0];
        if(n==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(helper(0,n-2,nums),helper(1,n-1,nums));
    }
}
