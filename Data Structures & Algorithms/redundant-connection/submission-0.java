class Solution {
    int[] parent;
    private int find(int node){
        while(parent[node]!=node){
            node = parent[node];
        }
        return node;
    }

    private void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);

        if(xRoot!=yRoot){
            parent[xRoot] = yRoot;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];

        for(int i =0;i<edges.length;i++){
            parent[i] = i;
        }

        for(int[] edge:edges){
            if(find(edge[0]) == find(edge[1])){
                return edge;
            }
            union(edge[0],edge[1]);
        }

        return new int[]{-1,-1};
    }
}
