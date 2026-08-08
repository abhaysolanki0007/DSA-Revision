class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length,m=matrix[0].length,sum=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0&&j>0&&matrix[i][j]==1){
                   matrix[i][j]=Math.max(matrix[i][j],1+Math.min(matrix[i-1][j],Math.min(matrix[i-1][j-1],matrix[i][j-1])));
                }
                sum+=matrix[i][j];
            }
        }
        return sum;
    }
}