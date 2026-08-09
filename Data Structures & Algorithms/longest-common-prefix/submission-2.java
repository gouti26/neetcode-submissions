class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        Arrays.sort(strs);
        String word =strs[0];
        for(int i =1;i<n;i++){
            if(word.length()>strs[i].length()){
                word = strs[i];
            }
        }
        for(int i =0;i<n;){
            if(!strs[i].contains(word)){
                word = word.substring(0,word.length()-1);
                continue;
            }
            i++;
        }
        return word;
    }
}