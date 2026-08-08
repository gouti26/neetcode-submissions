class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i =1;i<nums.length;i++){
            mp.put(nums[i-1],i-1);
            if(!mp.containsKey(target-nums[i]))
                continue;
            res[0]= mp.get(target-nums[i]);
            res[1]= i;
            break;
        }
        return res;
    }
}
