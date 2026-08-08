class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int[] hash = new int[26];
        int res = 0;
        int maxFreq = 0;
        int left = 0;
        for(int right =0;right<n;right++){
            hash[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(right)-'A']);

            if(right-left+1-maxFreq > k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            res = Math.max(res,right-left+1);
        }
        return res;
    }
}
