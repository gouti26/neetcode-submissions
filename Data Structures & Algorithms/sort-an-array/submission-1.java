class Solution {
    private void swap(int[]ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    private int partition(int[]nums, int left, int right){
        int index = left-1;
        int pivot = nums[right];
        for(int i =left;i<right;i++){
            if(nums[i]<=pivot){
                swap(nums,i,++index);
            }
        }
        swap(nums,right,index+1);
        return index+1;
    }
    private void quickSort(int[]nums, int left, int right){
        if(left<right){
            int index = partition(nums,left,right);
            quickSort(nums,left,index-1);
            quickSort(nums,index+1,right);
        }
    }
    public int[] sortArray(int[] nums) {
        int n = nums.length;
        quickSort(nums,0,n-1);
        return nums;
    }
}