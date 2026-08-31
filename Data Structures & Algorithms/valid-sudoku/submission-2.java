class Solution {
    private boolean isRowValid(char[][]board, int row){
        int[] rowArray = new int[10];
        for(int i =0;i<9;i++){
            if(board[row][i]!='.'){
                if(rowArray[board[row][i]-'0']==1)
                    return false;
                rowArray[board[row][i]-'0']++;
            }
        }
        return true;
    }
    private boolean isColValid(char[][]board, int col){
        int[] colArray = new int[10];
        for(int i =0;i<9;i++){
            if(board[i][col]!='.'){
                if(colArray[board[i][col]-'0']==1)
                    return false;
                colArray[board[i][col]-'0']++;
            }
        }
        return true;
    }

    private boolean isBoxValid(char[][] board, int box){
        int[] boxArray = new int[10];
        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                int row = (box/3)*3 + i;
                int col = (box%3)*3 + j;
                if(board[row][col]=='.')
                    continue;
                if(boxArray[board[row][col]-'0']==1)
                    return false;
                boxArray[board[row][col]-'0']++;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for(int i =0;i<9;i++){
            if(!isRowValid(board,i))
                return false;
        }
        for(int i =0;i<9;i++){
            if(!isColValid(board,i))
                return false;
        }

        for(int i =0;i<9;i++){
            if(!isBoxValid(board,i))
                return false;
        }
        return true;
    }
}
