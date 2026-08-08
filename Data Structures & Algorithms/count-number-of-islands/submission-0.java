class Solution {
    private boolean isValid(int x, int y,int m, int n){
        return (x>=0 && y>=0 && x<m && y<n);
    }
    private void DFS(char[][] grid,int i,int j){
        int m = grid.length;
        int n = grid[0].length;
        int[][] direction = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};

        grid[i][j] = '0';
        for(int[] dir:direction){
            int x = i + dir[0];
            int y = j + dir[1];

            if(isValid(x,y,m,n) && grid[x][y]=='1'){
                DFS(grid,x,y);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int totalIslands = 0;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]=='1'){
                    totalIslands++;
                    DFS(grid,i,j);
                }
            }
        }
        return totalIslands;
    }
}
