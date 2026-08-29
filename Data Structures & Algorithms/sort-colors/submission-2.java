class Solution {
    private void swap(int[] nums, int i, int j){
        if(i==j)
            return;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void sortColors(int[] nums) {
        int left = 0;
        int n = nums.length;
        int right = n-1;
        int i = 0;
        while(i<=right){
            if(nums[i]==2){
                swap(nums,i,right--);
                continue;
            }
            if(nums[i]==0)
                swap(nums,i,left++);
            i++;
        }
    }
}