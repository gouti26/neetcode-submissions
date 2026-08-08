class Solution {
    public int maxProduct(int[] nums) {
        int left = 1;
        int right = 1;
        int ans = nums[0];
        int n = nums.length;
        for(int i =0;i<n;i++){
            if(left==0)
                left = 1;
            if(right == 0)
                right = 1;
            left = left*nums[i];
            right = right*nums[n-i-1];

            ans = Math.max(ans,Math.max(left,right));
        }
        return ans;
    }
}
