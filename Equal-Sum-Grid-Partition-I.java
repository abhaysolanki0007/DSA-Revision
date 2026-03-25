1class Solution {
2    public boolean canPartitionGrid(int[][] grid) {
3        int n=grid.length,m=grid[0].length;
4        long sum=0;
5        for(int i=0;i<n;i++){
6            for(int j=0;j<m;j++){
7                sum+=grid[i][j];
8        }
9    }
10        long sum2=0;
11        for(int i=0;i<n;i++){
12             for(int j=0;j<m;j++){
13                sum2+=grid[i][j];
14                
15             }
16             if(2*sum2==sum) return true;
17        }
18        sum2=0;
19         for(int j=0;j<m;j++){
20             for(int i=0;i<n;i++){
21                  sum2+=grid[i][j];
22                
23             }
24              if(2*sum2==sum) return true;
25         }
26        return false;
27}
28}