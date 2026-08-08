class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m>n)
            return "";
        int[] hash_t = new int[256];
        for(int i =0;i<m;i++){
            hash_t[t.charAt(i)]++;
        }

        int currentWindowSize = 0, head = 0;
        int start =0, end = 0;
        int len = Integer.MAX_VALUE;
        while(end<s.length()){
            if(hash_t[s.charAt(end)]>0)
                currentWindowSize++;
            hash_t[s.charAt(end)]--;
            end++;
            while(currentWindowSize==m){
                if(len>end-start){
                    len = end-start;
                    head = start;
                }
                hash_t[s.charAt(start)]++;
                if(hash_t[s.charAt(start)]>0){
                    currentWindowSize--;
                }
                start++;
            }
        }
        if(len==Integer.MAX_VALUE)
            return "";
        return s.substring(head,head+len);
    }
}
