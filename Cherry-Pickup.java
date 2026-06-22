1class Solution {
2    public int mini=-(int)(1e9);
3    public Integer dp[][][][];
4    public int dfs(int i,int j,int a,int b,int grid[][]){
5        int n=grid.length,m=grid[0].length;
6        if(i>=n||a>=n||j>=m||b>=m) return mini;
7        if(grid[i][j]==-1||grid[a][b]==-1)  return mini;
8        if(i==n-1&&j==m-1&&a==i&&b==j){
9            return grid[i][j];
10        }
11        if(dp[i][j][a][b]!=null) return dp[i][j][a][b];
12        int  sum=grid[i][j];
13        if(a!=i||b!=j) sum+=grid[a][b];
14        int op1=dfs(i+1,j,a+1,b,grid);
15         int op2=dfs(i+1,j,a,b+1,grid);
16          int op3=dfs(i,j+1,a+1,b,grid);
17           int op4=dfs(i,j+1,a,b+1,grid);
18           return dp[i][j][a][b]=sum+Math.max(Math.max(op1,op2),Math.max(op3,op4));
19    }
20    public int cherryPickup(int[][] grid) {
21         int n=grid.length,m=grid[0].length;
22        dp=new Integer[n][m][n][m];
23        int ans=dfs(0,0,0,0,grid);
24        return ans<0?0:ans;
25    }
26}