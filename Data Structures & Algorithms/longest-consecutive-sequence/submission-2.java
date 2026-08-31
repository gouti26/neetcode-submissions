class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length<=1)
            return nums.length;
        Set<Integer> st = new HashSet<>();
        for(int num:nums){
            st.add(num);
        }
        int maxLength = 0;
        for(int num:nums){
            int length = 0;
            if(!st.contains(num-1)){
                int start = num;
                while(st.contains(start)){
                    length++;
                    start++;
                }
                maxLength = Math.max(maxLength,length);
            }
        }
        return maxLength;
    }
}
