class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> lastIndexMap = new HashMap<>();
        for(int i =0;i<s.length();i++){
            lastIndexMap.put(s.charAt(i),i);
        }

        int size = 0;
        int lastIndex = 0;
        List<Integer> res = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            size++;
            lastIndex = Math.max(lastIndex,lastIndexMap.get(s.charAt(i)));

            if(i==lastIndex){
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
