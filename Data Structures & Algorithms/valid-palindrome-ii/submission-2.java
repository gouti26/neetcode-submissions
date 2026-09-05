class Solution {
    private boolean isPalindrome(String s,int index, int left, int right){
        while(left<=right){
            if(left==index){
                index = -1;
                left++;
                continue;
            }
            if(right == index){
                index = -1;
                right--;
                continue;
            }
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;right--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        for(int i =0;i<s.length();i++){
            if(isPalindrome(s,i,0,s.length()-1))
                return true;
        }
        return false;
    }
}