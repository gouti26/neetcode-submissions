class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(String str:strs){
            char [] tempAr = str.toCharArray();
            Arrays.sort(tempAr);
            String tempStr = String.valueOf(tempAr);
            if(mp.get(tempStr)==null){
                mp.put(tempStr,new ArrayList<>());
            }
            List<String> mapList = mp.get(tempStr);
            mapList.add(str);
            mp.put(tempStr,mapList);
        }
        List<List<String>> res = new ArrayList<>();

        for (String key : mp.keySet()) {
            List<String> value = mp.get(key);
            res.add(new ArrayList<>(value));
        }
        return res;

    }
}
