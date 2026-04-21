1class Solution {
2    public int maximalSquare(char[][] matrix) {
3        int n=matrix.length,m=matrix[0].length;
4        int dp[][]=new int[n][m];
5          int ans=0;
6        for(int i=0;i<n;i++){
7            if(matrix[i][0]=='1'){dp[i][0]=1;ans=1;}
8            
9        }
10         for(int i=0;i<m;i++){
11            if(matrix[0][i]=='1'){dp[0][i]=1; ans=1;}
12        }
13      
14        for(int i=1;i<n;i++){
15            for(int j=1;j<m;j++){
16                if(matrix[i][j]=='1') dp[i][j]=1+Math.min(dp[i][j-1],Math.min(dp[i-1][j],dp[i-1][j-1]));
17                ans=Math.max(ans,dp[i][j]*dp[i][j]);
18            }
19        }
20        return ans;
21    }
22}