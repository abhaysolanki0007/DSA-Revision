class Solution {
    public int maximalSquare(char[][] matrix) {
        int n=matrix.length,m=matrix[0].length,ans=0;
        int arr[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1') arr[i][j]++;
            }
        }
          for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i>0&&j>0&&arr[i][j]==1){
                arr[i][j]+=Math.min(arr[i-1][j-1],Math.min(arr[i][j-1],arr[i-1][j]));
                }
                ans=Math.max(ans, arr[i][j]*arr[i][j]);
            }
          }
          return ans;
    }
}