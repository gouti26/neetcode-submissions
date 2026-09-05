class Solution {
    private boolean isValid(char ch){
        return((ch>='A' && ch<='Z') || ((ch>='a' && ch<='z')) || (ch>='0' && ch<='9'));
    }
    public boolean isPalindrome(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        while (left <= right) {
            while(left<right && !isValid(s.charAt(left)))
                left++;
            while(left<right && !isValid(s.charAt(right)))
                right--;
            if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
                return false;
            left++;
            right--;
        }
        return true;
    }
}