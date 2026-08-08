class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i =0;i<n;i++)
            graph.add(new ArrayList<>());
        for(int [] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<int[]> Q = new LinkedList<>();
        Set<Integer> visit = new HashSet<>();
        Q.offer(new int[]{0,-1});
        visit.add(0);
        while(!Q.isEmpty()){
            int[] currPair = Q.poll();
            int node = currPair[0];
            int parent = currPair[1];
            for(int neighbor:graph.get(node)){
                if(neighbor == parent)
                    continue;
                if(visit.contains(neighbor))
                    return false;
                visit.add(neighbor);
                Q.offer(new int[]{neighbor,node});
            }
        }
        return visit.size() == n;
    }
}
