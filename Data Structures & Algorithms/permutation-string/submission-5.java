class Solution {
    private boolean isMatch(int[] hash1,int[] hash2){
        for(int i =0;i<26;i++){
            if(hash1[i]!=hash2[i])
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
        
        int[] hash1 = new int[26];
        int[] hash2 = new int[26];
        for(int i = 0;i<s1.length();i++)
            hash1[s1.charAt(i)-'a']++;
        
        for(int i = 0;i<s2.length();i++){
            hash2[s2.charAt(i)-'a']++;

            if(i>s1.length()-1){
                hash2[s2.charAt(i-s1.length())-'a']--;
            }
            if(isMatch(hash1,hash2)){
                return true;
            }
        }
        return false;
    }
}
