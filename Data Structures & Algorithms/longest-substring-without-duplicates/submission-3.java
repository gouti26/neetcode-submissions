class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] indexHash = new int[256];
        int maxLength = 0;
        Arrays.fill(indexHash,-1);
        int startIndex = -1;
        for(int i =0;i<s.length();i++){
            startIndex = Math.max(indexHash[s.charAt(i)],startIndex);
            maxLength = Math.max(maxLength, i-startIndex);
            indexHash[s.charAt(i)] = i;
        }
        return maxLength;
    }
}
