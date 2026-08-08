class Solution {
    public int[] productExceptSelf(int[] nums) {
        int zeroCount = 0;
        int product = 1;
        int n = nums.length;
        int[] res = new int[n];
        for(int num:nums){
            if(num==0)
                zeroCount++;
            else
                product *= num;
        }
        if(zeroCount > 1){
            return res;
        }else if(zeroCount == 1){
            for(int i =0;i<n;i++){
                if(nums[i]!=0)
                    res[i] = 0;
                else
                    res[i] = product;
            }
            return res;
        }
        for(int i =0;i<n;i++){
            res[i] = product/nums[i];
        }

        return res;
    }
}  
