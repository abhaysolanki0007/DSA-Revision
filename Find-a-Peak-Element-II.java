1class Solution {
2    public int[] findPeakGrid(int[][] mat) {
3        int n=mat.length,m=mat[0].length;
4        int i=0,j=m-1;
5        int arr[]=new int[2];
6        while(i<n&&j>0){
7            if(mat[i][j]<mat[i][j-1]) j--; 
8            else if(i<n-1&&mat[i][j]<mat[i+1][j]) i++;
9            else {arr[0]=i;arr[1]=j;break;}
10        }
11        if(j<m-1&&mat[i][j+1]>mat[i][j]) arr[1]+=1;
12         if(i<n-1&&mat[i+1][j]>mat[i][j]) arr[0]+=1;
13        return arr;
14    }
15}