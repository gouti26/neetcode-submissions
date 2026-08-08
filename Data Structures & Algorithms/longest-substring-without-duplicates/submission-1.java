class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash,-1);
        int index = 0;
        int maxLen = 0;

        for(int i =0;i<n;i++){
            index = Math.max(index,hash[s.charAt(i)]+1);
            maxLen = Math.max(maxLen,i-index+1);
            hash[s.charAt(i)] = i;
        }
        return maxLen;
    }
}
