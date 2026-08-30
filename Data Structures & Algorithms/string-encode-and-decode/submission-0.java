class Solution {

    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for(int i = 0;i<strs.size();i++){
            String currentString = strs.get(i);
            int length = currentString.length();
            StringBuilder temp = new StringBuilder();
            temp.append(length);
            temp.append('#');
            encodedString.append(temp.toString());
            encodedString.append(currentString);
        }
        return encodedString.toString();
    }

    public List<String> decode(String str) {
        List<String> decodedList = new ArrayList<>();
        for(int i = 0;i<str.length();){
            int length = 0;
            int j = i;
            while(j<str.length() && str.charAt(j)!='#'){
                length = length*10 + str.charAt(j)-'0';
                j++;
            }
            i = j+1;
           // System.out.println("Length "+length);
            StringBuilder currentString = new StringBuilder();
            while(i<str.length() && length>0){
                currentString.append(str.charAt(i));
                i++;
                length--;
            }
            decodedList.add(currentString.toString());
        }
        return decodedList;
    }
}
