class Solution {
    private boolean isValid(int x,int y, int m,int n){
        return (x>=0 && y>=0 && x<m && y<n);
    }

    private void BFS(Queue<int[]>Q,boolean[][] vis,int[][] heights){
        int m = heights.length;
        int n = heights[0].length;
        int[][] direction = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        while(!Q.isEmpty()){
            int[] curr = Q.poll();
            int row = curr[0];
            int col = curr[1];
            vis[row][col] = true;
            for(int[] dir:direction){
                int x = row + dir[0];
                int y = col + dir[1];
                if(isValid(x,y,m,n) && !vis[x][y] && heights[x][y]>=heights[row][col]){
                    Q.offer(new int[]{x,y});
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacificVis = new boolean[m][n];
        boolean[][] atlanticVis = new boolean[m][n];
        Queue<int[]> pacificQueue = new LinkedList<int[]>();
        Queue<int[]> atlanticQueue = new LinkedList<int[]>();

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(i==0 || j==0){
                    pacificQueue.offer(new int[]{i,j});
                }
                if(i==m-1 || j==n-1){
                    atlanticQueue.offer(new int[]{i,j});
                }
            }
        }

        BFS(pacificQueue,pacificVis,heights);
        BFS(atlanticQueue,atlanticVis,heights);
        List<List<Integer>> result = new ArrayList<>();
        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(pacificVis[i][j] && atlanticVis[i][j]){
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(i);
                    tempList.add(j);
                    result.add(tempList);
                }
            }
        }

        return result;
    }
}
