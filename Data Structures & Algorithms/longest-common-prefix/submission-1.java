class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        //Arrays.sort(strs, Comparator.comparingInt(String::length));
        Arrays.sort(strs);
        String word =strs[0];
        for(int i =1;i<n;i++){
            if(word.length()>strs[i].length()){
                word = strs[i];
            }
        }
        System.out.println("Word is " + word);
        for(int i =0;i<n;i++){
            if(strs[i].contains(word))
                continue;
            word = word.substring(0,word.length()-1);
            i--;
            System.out.println("New word "+word);
        }
        return word;
    }
}