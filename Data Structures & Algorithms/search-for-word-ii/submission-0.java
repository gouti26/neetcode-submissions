class Solution {
    private boolean isValid(int x,int y, int m, int n){
        return (x>=0 && x<m && y>=0 && y<n);
    }
    private boolean DFS(char[][] board, String word, int index, int x, int y, boolean[][] vis){
        if(index==word.length())
            return true;
        int[][] direction = {{0,1},{0,-1},{1,0},{-1,0}};
        int m = board.length;
        int n = board[0].length;
        for(int[] dir:direction){
            int newX = x + dir[0];
            int newY = y + dir[1];

            if(isValid(newX,newY,m,n) && !vis[newX][newY] && board[newX][newY] == word.charAt(index)){
                vis[newX][newY] = true;
                if(DFS(board,word,index+1,newX,newY,vis))
                    return true;
                vis[newX][newY] = false;
            }
        }
        return false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int m = board.length;
        int n = board[0].length;
        List<String> res = new ArrayList<>();
        for(String word:words){
            boolean isFound = false;
            boolean[][] vis = new boolean[m][n];
            for(int i =0;i<m;i++){
                for(int j =0;j<n;j++){
                    if(board[i][j]==word.charAt(0)){
                        vis[i][j] = true;
                        if(DFS(board,word,1,i,j,vis)){
                            res.add(word);
                            isFound = true;
                            break;
                        }else
                            vis[i][j] = false;
                    }
                }
                if(isFound == true)
                    break;
            }
        }
        return res;
    }
}
