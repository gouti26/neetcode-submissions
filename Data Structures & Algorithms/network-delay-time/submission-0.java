class Solution {
    class iPair{
        int node;
        int weight;
        public iPair(int node,int weight){
            this.node = node;
            this.weight = weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<iPair>> graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        int[] distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        for(int []time:times){
            graph.get(time[0]).add(new iPair(time[1],time[2]));
        }
        PriorityQueue<iPair> pq = new PriorityQueue<>((a,b)->(b.weight-a.weight));
        pq.offer(new iPair(k,0));
        distance[k] = 0;

        while(!pq.isEmpty()){
            int currentNode = pq.poll().node;

            for(iPair neighbor:graph.get(currentNode)){
                if(distance[neighbor.node]>distance[currentNode]+neighbor.weight){
                    distance[neighbor.node] = distance[currentNode] + neighbor.weight;
                    pq.offer(new iPair(neighbor.node,distance[neighbor.node]));
                }
            }
        }
        int minTime = Integer.MIN_VALUE;
        for(int i =1;i<=n;i++){
            if(distance[i]==Integer.MAX_VALUE)
                return -1;
            minTime = Math.max(minTime,distance[i]);
        }
        return minTime;
    }
}
