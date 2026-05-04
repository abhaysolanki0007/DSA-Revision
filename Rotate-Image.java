1class Solution {
2    public void reverse(int matrix[][]){
3        int n=matrix.length;
4        for(int i=0;i<n;i++){
5            for(int a=0;a<n/2;a++){
6                int temp=matrix[i][a];
7                matrix[i][a]=matrix[i][n-1-a];
8                matrix[i][n-1-a]=temp;
9            }
10        }
11
12    }
13    public void rotate(int[][] matrix) {
14        int n=matrix.length;
15        for(int i=0;i<n;i++){
16            for(int j=i;j<n;j++){
17                if(i!=j){
18                    int temp=matrix[i][j];
19                    matrix[i][j]=matrix[j][i];
20                    matrix[j][i]=temp;
21                }
22            }
23        }
24        reverse(matrix);
25        
26    }
27}