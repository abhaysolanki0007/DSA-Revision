class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n=grid.length,ans=(int)(1e9);
      for(int i=0;i<n-1;i++){
        PriorityQueue<int[]>heap=new PriorityQueue<>((a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        for(int j=0;j<n;j++){
            heap.add(new int[]{grid[i][j],j});
        }
        int a[]=heap.poll();
        int val= a[0];
        int ind=a[1];
         for(int j=0;j<n;j++){
            if(j==ind) continue;
           grid[i+1][j]+=val;
        }
         int a1[]=heap.poll();
         grid[i+1][ind]+=a1[0];
      }
         for(int j=0;j<n;j++){
            ans=Math.min(ans,grid[n-1][j]);
         }
         return ans;
    }
}