class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();

        for(String str:strs){
            char[] charAr = str.toCharArray();
            Arrays.sort(charAr);
            String currString = String.valueOf(charAr);
            if(mp.get(currString)==null){
                mp.put(currString, new ArrayList<>());
            }
            List<String> currentList = mp.get(currString);
            currentList.add(str);
            mp.put(currString,currentList); 
        }

        List<List<String>> result = new ArrayList<>();
        for(String key:mp.keySet()){
            List<String> val = mp.get(key);
            result.add(new ArrayList<>(val));
        }
        return result;

    }
}
