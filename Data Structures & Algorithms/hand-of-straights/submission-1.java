class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if(n%groupSize != 0)
            return false;
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:hand){
            mp.put(num,mp.getOrDefault(num,0)+1);
        }
        Arrays.sort(hand);

        for(int i =0;i<n;i++){
            if(mp.get(hand[i])==0)
                continue;
            
            for(int j =0;j<groupSize;j++){
                int val = hand[i]+j;
                if(mp.getOrDefault(val,0)==0)
                    return false;
                mp.put(val,mp.get(val)-1);
            }
        }
        return true;
    }
}
