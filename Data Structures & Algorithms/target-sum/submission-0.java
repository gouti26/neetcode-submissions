class Solution {
    private int helper(int[] nums, int index,int target,int sum){
        if(index>=nums.length){
            if(sum==target)
                return 1;
            return 0;
        }
        return helper(nums,index+1,target,sum+nums[index]) + 
            helper(nums,index+1,target,sum-nums[index]);
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,0,target,0);
    }
}
