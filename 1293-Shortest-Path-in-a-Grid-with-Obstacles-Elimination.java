class Solution {
    public int maxi=(int)(1e9);
    public boolean valid(int i,int j,int grid[][]){
          int n=grid.length,m=grid[0].length;
          if(i>=n||j>=m||i<0||j<0) return false;
          return true;
    }
    public int shortestPath(int[][] grid, int k) {
        int n=grid.length,m=grid[0].length;
        int dp[][][]=new int[n][m][k+1];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int dirxn[][]={{0,1},{1,0},{0,-1},{-1,0}};
        for(int row[][]:dp){
            for(int col[]:row){
                Arrays.fill(col,maxi);
            }
        }
        pq.offer(new int[]{grid[0][0],0,0});
        dp[0][0][grid[0][0]]=0;
        while(pq.size()>0){
            int arr[]=pq.poll();
            int a=arr[0];
            int b=arr[1];
            int c=arr[2];
            // int count=arr[3];
          
            for(int dir[]:dirxn){
                int x=b+dir[0];
                int y=c+dir[1];
               
                if(valid(x,y,grid)){
                     int newk=grid[x][y]+a;
                       if(newk>k) continue;
                    if(dp[x][y][newk]>dp[b][c][a]+1){
                    dp[x][y][newk]=dp[b][c][a]+1;
                    pq.offer(new int[]{newk,x,y});
                    }
                }
            }
        }

        int ans= maxi;
        for(int t=0;t<=k;t++){
            ans=Math.min(ans,dp[n-1][m-1][t]);
        }
        if(ans==maxi) return -1;
        return ans;

    }
}