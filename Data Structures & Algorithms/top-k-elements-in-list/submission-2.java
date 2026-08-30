class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num:nums)
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[1]-a[1]);
        for(Integer key:frequencyMap.keySet()){
            int val = frequencyMap.get(key);
            maxHeap.offer(new int[]{key,val});
        }

        int[] topKElements = new int[k];
        for(int i =0;i<k;i++){
            topKElements[i] = maxHeap.poll()[0];
        }

        return topKElements;
    }
}
