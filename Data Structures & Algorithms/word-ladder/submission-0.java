class Solution {
    class word{
        String word;
        int level;
        public word(String word,int level){
            this.word = word;
            this.level = level;
        }
    }
    private List<String> getAllNeighbors(String word){
        char[] tempAr = word.toCharArray();
        List<String> res = new ArrayList<>();
        for(int i=0;i<tempAr.length;i++){
            for(char ch='a';ch<='z';ch++){
                char oldChar = tempAr[i];
                tempAr[i] = ch;
                res.add(String.valueOf(tempAr));
                tempAr[i] = oldChar;
            }
        }
        return res;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<word> Q = new LinkedList<>();
        Q.add(new word(beginWord,1));

        Set<String> dict = new HashSet<>();
        for(String word:wordList)
            dict.add(word);
        dict.remove(beginWord);
        while(!Q.isEmpty()){
            word curr = Q.poll();
            if(curr.word.equals(endWord))
                return curr.level;
            
            for(String neighbor:getAllNeighbors(curr.word)){
                if(dict.contains(neighbor)){
                    int newLevel = curr.level + 1;
                   // System.out.println("New word "+neighbor+" With level "+newLevel);
                    Q.offer(new word(neighbor,newLevel));
                    dict.remove(neighbor);
                }
            }
        }
        return 0;
    }
}
