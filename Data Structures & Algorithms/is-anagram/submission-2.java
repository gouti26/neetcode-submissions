class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        if(t.length()!=s.length())
            return false;
        for(int i =0;i<s.length();i++){
            int index = s.charAt(i)-'a';
            freq[index]++;
        }
        for(int i =0;i<t.length();i++){
            int index = t.charAt(i)-'a';
            if(freq[index]==0)
                return false;
            freq[index]--;
        }
        return true;
    }
}
