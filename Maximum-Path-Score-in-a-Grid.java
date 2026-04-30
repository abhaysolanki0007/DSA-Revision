1class Solution {
2    public int mini=-(int)(1e9);
3    public int dp[][][];
4    public int score(int i,int j,int grid[][],int k){
5        int n=grid.length,m=grid[0].length;
6        if(k<0) return mini;
7        if(i==n-1&&j==m-1){
8            if(grid[i][j]==0) return 0;
9            if(k>0) return grid[i][j];
10            return mini;
11        }
12
13        if(i>=n||j>=m) return mini;
14        if( dp[i][j][k]!=-1) return  dp[i][j][k];
15        int temp=0;
16        if(grid[i][j]>=1) temp=1;
17        int right=score(i+1,j,grid,k-temp);
18         int down=score(i,j+1,grid,k-temp);
19         return dp[i][j][k]=Math.max(right,down)+grid[i][j];
20    }
21    public int maxPathScore(int[][] grid, int k) {
22        int n=grid.length,m=grid[0].length;
23        k=Math.min(k,150);
24        dp=new int[n][m][k+1];
25        for (int[][] mat : dp) {
26    for (int[] row : mat) {
27        Arrays.fill(row, -1);
28    }
29}
30        return score(0,0,grid,k)<0?-1:score(0,0,grid,k);
31    }
32}