class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> mp = new HashMap<>();
        for(int num:nums){
            mp.put(num, mp.getOrDefault(num,0)+1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        for(Integer key:mp.keySet()){
            int val = mp.get(key);
            pq.offer(new int[]{key,val});
        }

        for(int i =0;i<k;i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }
}
