1import java.util.*;
2
3class Solution {
4    public int maxi = (int)1e9;
5
6    // solve for a given start index
7    public int solve(int[] nums, int start, int K) {
8        int n = nums.length;
9
10        int[][] dp = new int[n + 2][K + 1];
11
12        for (int i = 0; i <= n + 1; i++) {
13            Arrays.fill(dp[i], maxi);
14        }
15
16        // base: k = 0 → 0 cost
17        for (int i = 0; i <= n + 1; i++) {
18            dp[i][0] = 0;
19        }
20
21        for (int i = n - 1; i >= start; i--) {
22            for (int k = 1; k <= K; k++) {
23
24                // handle edge case (like zero==1 in your code)
25                if (i == n - 1 && start == 0) {
26                    dp[i][k] = maxi;
27                    continue;
28                }
29
30                int prev = (i > 0) ? nums[i - 1] : nums[n - 1];
31                int next = (i < n - 1) ? nums[i + 1] : nums[0];
32
33                int inc1 = -Math.min(0, nums[i] - prev - 1);
34                int inc2 = -Math.min(0, inc1 + nums[i] - next - 1);
35
36                int take = inc1 + inc2 + dp[i + 2][k - 1];
37                int nottake = dp[i + 1][k];
38
39                dp[i][k] = Math.min(take, nottake);
40            }
41        }
42
43        return dp[start][K];
44    }
45
46    public int minOperations(int[] nums, int k) {
47        int n = nums.length;
48
49        int ans = Math.min(
50            solve(nums, 0, k),  // corresponds to zero = 1
51            solve(nums, 1, k)   // corresponds to zero = 0
52        );
53
54        return ans >= maxi ? -1 : ans;
55    }
56}