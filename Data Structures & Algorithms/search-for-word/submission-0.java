class Solution {
    public boolean isValid(int x,int y, int m,int n){
        if(x<0 || y<0 || x>=m || y>=n)
            return false;
        return true;
    }
    public boolean wordSearch(String word,boolean[][] vis, char[][] board,int x,int y,int index){
        if(index == word.length())
            return true;
        int row[]={0,0,-1,1};
        int col[]={-1,1,0,0};

        int m = board.length;
        int n = board[0].length;
        vis[x][y]= true;
        for(int i =0;i<4;i++){
            int newX = x+row[i];
            int newY = y+col[i];
            if(isValid(newX,newY,m,n) && !vis[newX][newY] && board[newX][newY]==word.charAt(index)){
                if(wordSearch(word,vis,board,newX,newY,index+1))
                    return true;
            }
        }
        vis[x][y]= false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] vis = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(board[i][j]==word.charAt(0) && !vis[i][j]){
                    if(wordSearch(word,vis,board,i,j,1))
                        return true;
                }
            }
        }
        return false;
    }
}