class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int num:nums){
            st.add(num);
        }

        int maxLen = 0;
        for(int num:nums){
            if(!st.contains(num-1)){
                int count = 0;
                int val = num;
                while(st.contains(val)){
                    count++;
                    val++;
                }
                maxLen = Math.max(count,maxLen);
            }
        }
        return maxLen;
    }
}
