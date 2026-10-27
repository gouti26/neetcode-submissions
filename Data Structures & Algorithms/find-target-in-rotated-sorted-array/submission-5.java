class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if(nums[low]<=nums[mid]){ // rotation in right part
                if(target>nums[mid] || target <nums[low]){
                    low = mid + 1;
                }else{
                    high = mid-1;
                }
            }else{ //rotation in left part
                if(target<nums[mid] || target>nums[high]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}
