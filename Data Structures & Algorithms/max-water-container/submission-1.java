class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int maxWater = 0;
        while(left<right){
            int minVal = Math.min(heights[left],heights[right]);
            maxWater = Math.max(maxWater,(right-left)*minVal);
            if(heights[left]<heights[right])
                left++;
            else
                right--;
        }
        return maxWater;
    }
}
