class Solution {
    public boolean isAnagram(String s, String t) {
        int[] mp = new int[26];
        for(char ch:s.toCharArray()){
            mp[ch-'a']++;
        }

        for(char ch:t.toCharArray()){
            if(mp[ch-'a']==0)
                return false;
            mp[ch-'a']--;
        }
        for(int i =0;i<26;i++){
            if(mp[i]!=0)
                return false;
        }
        return true;
    }
}
