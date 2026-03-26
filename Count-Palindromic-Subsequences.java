1import java.util.*;
2
3class Solution {
4    int MOD = 1000000007;
5
6    public int countPalindromes(String s) {
7        int n = s.length();
8
9        // dp[i][len][first][second]
10        int[][][][] dp = new int[n + 1][6][11][11];
11
12        // Base case
13        for (int first = 0; first <= 10; first++) {
14            for (int second = 0; second <= 10; second++) {
15                dp[n][5][first][second] = 1;
16            }
17        }
18
19        // Fill table from back
20        for (int i = n - 1; i >= 0; i--) {
21            int digit = s.charAt(i) - '0';
22
23            for (int len = 0; len <= 5; len++) {
24                for (int first = 0; first <= 10; first++) {
25                    for (int second = 0; second <= 10; second++) {
26
27                        int ans = dp[i + 1][len][first][second]; // skip
28
29                        // take
30                        if (len == 0) {
31                            ans = (ans + dp[i + 1][1][digit][second]) % MOD;
32                        } 
33                        else if (len == 1) {
34                            ans = (ans + dp[i + 1][2][first][digit]) % MOD;
35                        } 
36                        else if (len == 2) {
37                            ans = (ans + dp[i + 1][3][first][second]) % MOD;
38                        } 
39                        else if (len == 3) {
40                            if (digit == second) {
41                                ans = (ans + dp[i + 1][4][first][second]) % MOD;
42                            }
43                        } 
44                        else if (len == 4) {
45                            if (digit == first) {
46                                ans = (ans + dp[i + 1][5][first][second]) % MOD;
47                            }
48                        }
49
50                        dp[i][len][first][second] = ans;
51                    }
52                }
53            }
54        }
55
56        return dp[0][0][10][10];
57    }
58}