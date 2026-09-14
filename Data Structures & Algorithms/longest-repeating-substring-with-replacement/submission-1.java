class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int n = s.length();
        int maxLength = 0, maxFreq = 0;
        int[] hash = new int[26];
        for(int right = 0;right<n;right++){
            int index = s.charAt(right)-'A';
            hash[index]++;
            maxFreq = Math.max(maxFreq,hash[index]);

            if((right-left+1)-maxFreq >k){
                hash[s.charAt(left)-'A']--;
                left++;
            }

            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
