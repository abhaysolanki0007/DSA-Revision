1class Solution {
2    public int mini=-(int)(1e9);
3    public int dp[][];
4    public int minhealth(int i,int j,int grid[][]){
5        int n=grid.length,m=grid[0].length;
6        if(i==n-1&&j==m-1) return grid[i][j];
7
8        if(i>=n||j>=m) return mini;
9        if(dp[i][j]!=-1) return  dp[i][j];
10        int down=minhealth(i+1,j,grid);
11         int right=minhealth(i,j+1,grid);
12         return dp[i][j]=Math.min(grid[i][j],grid[i][j]+Math.max(right,down));
13    }
14    public int calculateMinimumHP(int[][] dungeon) {
15          int n=dungeon.length,m=dungeon[0].length;
16       
17        dp=new int[n][m];
18        for(int row[]:dp){
19            Arrays.fill(row,-1);
20        }
21         int ans=minhealth(0,0,dungeon);
22        
23        if(ans>0) return 1;
24        return 1+Math.abs(ans);
25    }
26}