class Solution {
    private int helper(int x, int y,int[] nums,int[][] dp){
        if(x>y)
            return 0;
        if(dp[x][y]!=-1)
            return dp[x][y];
        int cost = Integer.MIN_VALUE;
        for(int index = x;index<=y;index++){
            int val = nums[x-1]*nums[index]*nums[y+1] + 
                helper(x,index-1,nums,dp) + helper(index+1,y,nums,dp);
            cost = Math.max(cost,val);
        }
        return dp[x][y] = cost;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNum = new int[n+2];
        newNum[0] = newNum[n+1] = 1;
        for(int i=0;i<n;i++)
            newNum[i+1] = nums[i];
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i <= n; i++)
            Arrays.fill(dp[i], -1);
        return helper(1,n,newNum,dp);
        
    }
}
