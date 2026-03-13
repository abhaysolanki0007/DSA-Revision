1class Solution {
2    public int numSubmat(int[][] mat) {
3        int m = mat.length, n = mat[0].length;
4        int[] h = new int[n];
5        int cnt = 0;
6
7        for(int i=0; i<m; i++) {
8            for(int j=0; j<n; j++) {
9                h[j] = mat[i][j] == 1 ? h[j] + 1 : 0;
10            }
11
12            for(int j=0; j<n; j++) {
13                int mn = h[j];
14                for(int k=j; k>=0 && mn>0; k--) {
15                    mn = Math.min(mn, h[k]);
16                    cnt += mn;
17                }
18            }
19        }
20        return cnt;
21    }
22}