class Solution {
    private void swap(int[] nums, int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    private int partition(int []nums, int low,int high){
        int index = low-1;
        int pivot = nums[high];

        for(int i =low;i<high;i++){
            if(nums[i]<=pivot){
                index++;
                swap(nums,i,index);
            }
        }
        swap(nums,high,index+1);
        return index+1;
    }
    private void quick_sort(int[]nums, int low, int high){
        if(low<high){
            int partitionIndex = partition(nums,low,high);
            quick_sort(nums,low,partitionIndex-1);
            quick_sort(nums,partitionIndex+1,high);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quick_sort(nums,0,n-1);
        return nums;
    }
}