class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int startIndex = 0;
        int maxLen = 0;

        for(int i =0;i<n;i++){
            int j = i;
            int k = i;
            //odd length string
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                j--;k++;
            }
            j++;k--;
            if(maxLen<k-j+1){
                maxLen = k-j+1;
                startIndex = j;
            }
            //Even length string
            j = i;
            k = i+1;
            while(j>=0 && k<n && s.charAt(j)==s.charAt(k)){
                j--;k++;
            }
            j++;k--;
            if(maxLen<k-j+1){
                maxLen = k-j+1;
                startIndex = j;
            }
        }
        return s.substring(startIndex,startIndex+maxLen);
    }
}
