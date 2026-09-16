class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length())
            return "";
        
        int[] tMap = new int[256];
        for(int i =0;i<t.length();i++)
            tMap[t.charAt(i)]++;
        
        int length = Integer.MAX_VALUE;
        int startIndex = 0, endIndex = 0;
        int currentWindowSize = 0;
        int head = 0;
        while(endIndex<s.length()){
            if(tMap[s.charAt(endIndex)]>0)
                currentWindowSize++;
            tMap[s.charAt(endIndex)]--;
            endIndex++;

            while(currentWindowSize == t.length()){
                if(length>endIndex-startIndex){
                    length = endIndex-startIndex;
                    head = startIndex;
                }
                tMap[s.charAt(startIndex)]++;
                if(tMap[s.charAt(startIndex)]>0)
                    currentWindowSize--;
                startIndex++;
            }
        }

        if(length == Integer.MAX_VALUE)
            return "";
        return s.substring(head,head+length);
    }
}
