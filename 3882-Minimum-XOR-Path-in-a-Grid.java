class Solution {
    public int ans=(int)(1e9);
    public Integer dp[][][];
    public int dfs(int i,int j,int sum,int[][] grid){
        int n=grid.length,m=grid[0].length;
        if(i==n-1&&j==m-1){
           ans=Math.min(ans,sum^grid[i][j]);
           return sum;
        }

        if(i>=n||j>=m) return (int)(1e9);
        if(dp[i][j][sum]!=null) return dp[i][j][sum];
        int a=dfs(i+1,j,sum^grid[i][j],grid);
         int b=dfs(i,j+1,sum^grid[i][j],grid);
         return dp[i][j][sum]=sum;
    }
    public int minCost(int[][] grid) {
        int n=grid.length,m=grid[0].length;
        dp=new Integer[n][m][1025];
        dfs(0,0,0,grid);
        return ans;
    }
}