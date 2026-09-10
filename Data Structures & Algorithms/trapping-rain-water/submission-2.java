class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = height[0];
        int[] right = new int[n];
        right[n-1] = height[n-1];
        for(int i =n-2;i>=0;i--){
            right[i] = Math.max(height[i],right[i+1]);
        }
        int maxWater = 0;
        for(int i =1;i<n-1;i++){
            left = Math.max(left,height[i]);
            maxWater += Math.min(left,right[i])-height[i];
        }
        return maxWater;
    }
}
