class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(b-a));

        for(int stone:stones){
            pq.offer(stone);
        }
        while(!pq.isEmpty()){
            if(pq.size()==1)
                return pq.poll();
            int x = pq.poll();
            int y = pq.poll();
            if(x==y)
                continue;
            if(x<y)
                pq.offer(y-x);
            if(x>y)
                pq.offer(x-y);
        }
        return 0;
    }
}
