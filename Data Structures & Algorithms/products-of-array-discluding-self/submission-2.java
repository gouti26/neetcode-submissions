class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int arrayMultiply = 1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                zeroCount++;
            else
                arrayMultiply = arrayMultiply*nums[i];
        }
        int[] result = new int[n];
        if(zeroCount>1)
            return result;
        
        if(zeroCount == 1){
            for(int i =0;i<n;i++){
                if(nums[i]==0)
                    result[i] = arrayMultiply;
                else
                    result[i] = 0;
            }
            return result;
        }
        for(int i =0;i<n;i++){
            result[i] = arrayMultiply/nums[i];
        }
        return result;
    }
}  
