class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        
        for(String str:strs){
            char [] currentArray = str.toCharArray();
            Arrays.sort(currentArray);
            String currentString = String.valueOf(currentArray);
            if(mp.get(currentString)==null){
                mp.put(currentString,new ArrayList<>());
            }
            List<String> mapList = mp.get(currentString);
            mapList.add(str);
            mp.put(currentString,mapList);
        }

        List<List<String>> res = new ArrayList<>();
        for(String key:mp.keySet()){
            List<String> value = mp.get(key);
            res.add(new ArrayList<>(value));
        }
        return res;

    }
}
