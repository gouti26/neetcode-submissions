class Solution {
    public int maxArea(int[] heights) {
        int maxWater = 0;
        int n = heights.length;
        int left = 0, right = n-1;
        while(left<right){
            int water = Math.min(heights[left],heights[right])*(right-left);
            maxWater = Math.max(water,maxWater);

            if(heights[left]<=heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return maxWater;
    }
}
