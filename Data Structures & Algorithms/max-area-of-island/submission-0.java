class Solution {
    boolean isValid(int m,int n, int x,int y){
        return (x>=0 && x<m && y>=0 && y<n);
    }

    private int dfs(int[][] grid, int x,int y){
        int area = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[] row = new int[]{-1,1,0,0};
        int[] col = new int[]{0,0,1,-1};

        for(int i =0;i<4;i++){
            int newRow = row[i] + x;
            int newCol = col[i] + y;
            if(isValid(m,n,newRow,newCol) && grid[newRow][newCol]==1){
                area++;
                grid[newRow][newCol] = 2;
                area += dfs(grid,newRow,newCol);
            }
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(grid[i][j]==1){
                    grid[i][j] = 2; //mark visited
                    int area = dfs(grid,i,j)+1;
                    maxArea = Math.max(maxArea,area);
                }
            }
        }
        return maxArea;
    }
}
