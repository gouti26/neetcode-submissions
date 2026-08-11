class Solution {
    private void swap(int i,int j, int[] ar){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
    public void sortColors(int[] nums) {
        int n = nums.length;
        int zeroIndex = 0;
        int twoIndex = n-1;
        for(int i =0;i<=twoIndex;){
            if(nums[i]==1){
                i++;
                continue;
            }
            if(nums[i]==0){
                swap(zeroIndex,i,nums);
                zeroIndex++;
                i++;
            }else{
                swap(twoIndex,i,nums);
                twoIndex--;
            }
        }
    }
}