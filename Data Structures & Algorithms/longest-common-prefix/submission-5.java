class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if(n==1)
            return strs[0];
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[n-1];
        int i = 0;
        for(;i<first.length();i++){
            if(first.charAt(i)!=last.charAt(i))
                break;
        }

        return first.substring(0,i);
    }
}