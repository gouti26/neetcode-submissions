class Solution {
    private boolean isMatch(int[] num1, int[] num2){
        for(int i =0;i<26;i++){
            if(num1[i]!=num2[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m)
            return false;
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];

        for(int i =0;i<n;i++){
            hash1[s1.charAt(i)-'a']++;
        }

        for(int i =0;i<m;i++){
            hash2[s2.charAt(i)-'a']++;
            if(i>=n){
                hash2[s2.charAt(i-n)-'a']--;
            }
            if(isMatch(hash1,hash2))
                return true;
        }
        return false;
    }
}
