1class Solution {
2    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
3          int c=x+k-1;
4        for(int i=x;i<x+k/2;i++){
5            for(int j=y;j<y+k;j++){
6                // swap(grid,i,j,c,j);
7                int temp=grid[i][j];
8                grid[i][j]=grid[c][j];
9                grid[c][j]=temp;
10            }
11             c--;
12        }
13        return grid;
14    }
15}