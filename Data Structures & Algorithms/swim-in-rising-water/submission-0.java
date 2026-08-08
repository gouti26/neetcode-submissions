class Solution {
    private boolean isValid(int newX,int newY,int n){
        return (newX>=0 && newX<n && newY>=0 && newY<n);
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        minHeap.offer(new int[]{grid[0][0],0,0});
        vis[0][0] = true;

        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll();
            int x = curr[1];
            int y = curr[2];
            int elevation = curr[0];

            if(x==n-1 && y==n-1)
                return elevation;
            for(int[] dir:direction){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(isValid(newX,newY,n) && !vis[newX][newY]){
                    vis[newX][newY] = true;
                    int newElevation = Math.max(elevation,grid[newX][newY]);
                    minHeap.offer(new int[]{newElevation,newX,newY});
                }
            }
        }

        return n*n;
    }
}
