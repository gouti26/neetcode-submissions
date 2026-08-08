class Solution {
    private boolean isPalindrome(String S, int start,int end){
        while(start<=end){
            if(S.charAt(start)!=S.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
    private void helper(String S, int index, List<String>temp, List<List<String>>result){
        int n = S.length();
        if(index==n){
            result.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<n;i++){
            if(isPalindrome(S,index,i)){
                temp.add(S.substring(index,i+1));
                helper(S,i+1,temp,result);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s,0,new ArrayList<String>(), result);
        return result;
    }
}
