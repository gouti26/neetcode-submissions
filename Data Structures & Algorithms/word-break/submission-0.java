class Solution {
    private boolean helper(String s, Set<String> st,Map<String,Boolean> memory){
        if(s.length()==0)
            return true;
        if(memory.containsKey(s))
            return memory.get(s);
        
        for(int i =1;i<=s.length();i++){
            String subStr = s.substring(0,i);
            if(st.contains(subStr)){
                memory.put(subStr,true);
                String remainingString = s.substring(i);
                if(helper(remainingString,st,memory))
                    return true;
            }
        }
        memory.put(s,false);
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictionary = new HashSet<>();
        for(String word:wordDict)
            dictionary.add(word);
        Map<String,Boolean> memory = new HashMap<>();
        return helper(s,dictionary,memory);
    }
}
