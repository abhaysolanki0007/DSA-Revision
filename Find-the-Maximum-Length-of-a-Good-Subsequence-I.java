1import java.util.*;
2
3class Solution {
4    public int maximumLength(int[] nums, int K) {
5        int n = nums.length;
6
7        // dp[i][prev+1][k]
8        int[][][] dp = new int[n + 1][n + 1][K + 1];
9
10        // Base case already 0 (Java default)
11
12        // Fill from back
13        for (int i = n - 1; i >= 0; i--) {
14            for (int prev = i - 1; prev >= -1; prev--) {
15                for (int k = 0; k <= K; k++) {
16
17                    int take = 0;
18
19                    if (prev == -1 || nums[prev] == nums[i] || k > 0) {
20                        if (prev != -1 && nums[prev] != nums[i] && k > 0) {
21                            take = 1 + dp[i + 1][i + 1][k - 1];
22                        } else {
23                            take = 1 + dp[i + 1][i + 1][k];
24                        }
25                    }
26
27                    int nottake = dp[i + 1][prev + 1][k];
28
29                    dp[i][prev + 1][k] = Math.max(take, nottake);
30                }
31            }
32        }
33
34        return dp[0][0][K]; // prev = -1 → index 0
35    }
36}