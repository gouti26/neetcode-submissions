class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        long sum = 0;
        int n = nums.length;
        int minLength = n+1;

        for(int num:nums)
            sum+=num;
        if(sum<target)
            return 0;
        if(sum==target)
            return n;
        int left = 0;
        sum = 0;
        for(int i =0;i<n;i++){
            sum+=nums[i];
            while(sum>=target && left<=i){
                minLength = Math.min(minLength, i-left+1);
                sum = sum - nums[left];
                left++;
            }
        }
        return minLength;
    }
}