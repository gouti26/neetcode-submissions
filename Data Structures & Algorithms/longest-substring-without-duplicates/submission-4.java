class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        int currentStart = 0;
        int maxLength = 0;

        for(int i =0;i<s.length();i++){
            if(mp.containsKey(s.charAt(i))){
                currentStart = Math.max(currentStart, mp.get(s.charAt(i))+1);
            }
            mp.put(s.charAt(i),i);
            maxLength = Math.max(maxLength,i-currentStart+1);
        }
        return maxLength;
    }
}
