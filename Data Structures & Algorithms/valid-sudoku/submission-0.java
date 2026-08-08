class Solution {
    public boolean isValidSudoku(char[][] board) { 
        // check in rows 
        for(int row = 0;row<9;row++){
            Set<Character> st = new HashSet<>();
            for(int i =0;i<9;i++){
                if(board[row][i]=='.')
                    continue;
                if(st.contains(board[row][i]))
                    return false;
                st.add(board[row][i]);
            }
        }

        // check in columns
        for(int col = 0;col<9;col++){
            Set<Character> st = new HashSet<>();
            for(int i =0;i<9;i++){
                if(board[i][col]=='.')
                    continue;
                if(st.contains(board[i][col]))
                    return false;
                st.add(board[i][col]);
            }
        }

        //check in box
        for(int box =0;box<9;box++){
            Set<Character> st = new HashSet<>();
            for(int i =0;i<3;i++){
                for(int j =0;j<3;j++){
                    int row = (box/3)*3 + i;
                    int col = (box%3)*3 + j;

                    if(board[row][col]=='.')
                        continue;
                    if(st.contains(board[row][col]))
                        return false;
                    st.add(board[row][col]);
                }
            }
        }
        return true;
    }
}
