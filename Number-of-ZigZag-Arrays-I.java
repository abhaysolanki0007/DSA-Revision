1import java.util.*;
2
3class Solution {
4    public int zigZagArrays(int n, int l, int r) {
5        int MOD = 1_000_000_007;
6        int m = r - l;
7
8        int[][][] dp = new int[n + 1][m + 1][2];
9
10        // base case
11        for (int prev = 0; prev <= m; prev++) {
12            dp[n][prev][0] = 1;
13            dp[n][prev][1] = 1;
14        }
15
16        // fill DP
17        for (int i = n - 1; i >= 1; i--) {
18
19            // build prefix sums for dp[i+1]
20            int[] prefix0 = new int[m + 1];
21            int[] prefix1 = new int[m + 1];
22
23            prefix0[0] = dp[i + 1][0][0];
24            prefix1[0] = dp[i + 1][0][1];
25
26            for (int v = 1; v <= m; v++) {
27                prefix0[v] = (prefix0[v - 1] + dp[i + 1][v][0]) % MOD;
28                prefix1[v] = (prefix1[v - 1] + dp[i + 1][v][1]) % MOD;
29            }
30
31            for (int prev = 0; prev <= m; prev++) {
32
33                // dir = 0 → need greater
34                int up = (prefix1[m] - prefix1[prev] + MOD) % MOD;
35
36                // dir = 1 → need smaller
37                int down = (prev > 0) ? prefix0[prev - 1] : 0;
38
39                dp[i][prev][0] = up;
40                dp[i][prev][1] = down;
41            }
42        }
43
44        // starting point
45        int res = 0;
46        for (int start = 0; start <= m; start++) {
47            res = (res + dp[1][start][0]) % MOD;
48            res = (res + dp[1][start][1]) % MOD;
49        }
50
51        return res;
52    }
53}