class Solution {
    public boolean valid(int i,int j,int grid[][]){
        int n=grid.length,m=grid[0].length;
        if(i>=n||j>=m||i<0||j<0) return false;
        return true;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        int n=grid.size(),m=grid.get(0).size();
        int mat[][]=new int[n][m];
        int dist[][]=new int[n][m];
        for(int row[]:dist){Arrays.fill(row,(int)(1e9));}
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                mat[i][j]=grid.get(i).get(j);
            }
        }
        dist[0][0]=mat[0][0];
        int dirxn[][]={{0,1},{0,-1},{1,0},{-1,0}};
        pq.offer(new int[]{mat[0][0],0,0});
        while(pq.size()>0){
            int arr[]=pq.poll();
            int cost=arr[0];
            int a=arr[1];
            int b=arr[2];
            if(a==n-1&&b==m-1){
                return cost<health;
            }
            for(int dir[]:dirxn){
                int x=dir[0];
                int y=dir[1];
                if(valid(a+x,b+y,mat)){
                    if(dist[a+x][b+y]>dist[a][b]+mat[a+x][b+y]){
                        dist[a+x][b+y]=dist[a][b]+mat[a+x][b+y];
                        pq.offer(new int[]{dist[a+x][b+y],a+x,b+y});
                    }
                }
            }
        }
        return false;
    }
}