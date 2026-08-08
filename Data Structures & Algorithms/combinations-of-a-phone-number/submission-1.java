class Solution {
    private void DFS(String digits,Map<Character,String> keyboard, List<String> res,int index, StringBuilder sb){
        if(index==digits.length()){
            res.add(sb.toString());
            return;
        }
        String words = keyboard.get(digits.charAt(index));
        for(int j =0;j<words.length();j++){
            sb.append(words.charAt(j));
            DFS(digits,keyboard,res,index+1,sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if(digits.length()==0)
            return res;
        Map<Character,String> keyboard = new HashMap<>();
        keyboard.put('2',"abc");
        keyboard.put('3',"def");
        keyboard.put('4',"ghi");
        keyboard.put('5',"jkl");
        keyboard.put('6',"mno");
        keyboard.put('7',"pqrs");
        keyboard.put('8',"tuv");
        keyboard.put('9',"wxyz");

        DFS(digits,keyboard,res,0, new StringBuilder());
        return res;

    }
}
