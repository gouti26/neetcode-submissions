class Solution {
    private void reverseRow(int[] row){
        int n = row.length-1;
        int i =0;
        while(i<n){
            int temp = row[i];
            row[i] = row[n];
            row[n] = temp;
            i++;
            n--;
        }
    }
    public void rotate(int[][] mat) {
        int n = mat.length;
        //transpose matrix
        for(int i = 0;i<n;i++){
            for(int j = i;j<n;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse row
        for(int[]row :mat){
            reverseRow(row);
        }
    }
}
