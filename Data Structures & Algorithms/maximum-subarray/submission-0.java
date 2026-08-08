class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int tempSum = 0;

        for(int num:nums){
            tempSum += num;
            maxSum = Math.max(maxSum,tempSum);
            if(tempSum<0)
                tempSum = 0;
        }
        return maxSum;
    }
}
