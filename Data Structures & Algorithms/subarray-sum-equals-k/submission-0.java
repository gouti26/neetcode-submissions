class Solution {
    public int subarraySum(int[] nums, int k) {
        int prefixSum = 0;
        int count = 0;
        Map<Integer,Integer> prefixSumFrequency = new HashMap<>();
        prefixSumFrequency.put(0,1);

        for(int i =0;i<nums.length;i++){
            prefixSum += nums[i];
            if(prefixSumFrequency.containsKey(prefixSum-k)){
                count += prefixSumFrequency.get(prefixSum-k);
            }
            prefixSumFrequency.put(prefixSum,
                    prefixSumFrequency.getOrDefault(prefixSum,0)+1);
        }

        return count;
    }
}