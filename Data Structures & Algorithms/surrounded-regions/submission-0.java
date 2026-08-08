class Solution {
    private boolean isValid(int x, int y, int m, int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }
    private void markRegion(char[][] board){
        int m = board.length;
        int n = board[0].length;
        int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};

        Queue<int[]> Q = new LinkedList<>();
        for(int i =0;i<m;i++){
            for(int j = 0;j<n;j++){
                if((i==0 || i== m-1 || j ==0 || j == n-1) && board[i][j] =='O'){
                    Q.offer(new int[]{i,j});
                }
            }
        }

        while(!Q.isEmpty()){
            int[] cell = Q.poll();
            if(board[cell[0]][cell[1]] == 'O'){
                board[cell[0]][cell[1]] = 'T';
                for(int[] dir:direction){
                    int newX = dir[0] + cell[0];
                    int newY = dir[1] + cell[1];
                    if(isValid(newX,newY,m,n) && board[newX][newY]=='O'){
                        Q.offer(new int[]{newX,newY});
                    }
                }
            }
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        markRegion(board);

        for(int i =0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]=='O')
                    board[i][j] = 'X';
                else if(board[i][j]=='T')
                    board[i][j] = 'O';
            }
        }
    }
}
