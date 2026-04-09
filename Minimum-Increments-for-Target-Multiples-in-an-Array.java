1import java.util.*;
2
3class Solution {
4    long[][] dp;
5    long[] lcmArr;
6    int n, m;
7    long INF = Long.MAX_VALUE / 2;
8
9    public int minimumIncrements(int[] nums, int[] target) {
10        n = nums.length;
11        m = target.length;
12
13        int fullMask = (1 << m) - 1;
14
15        // 🔹 Precompute LCM for all subsets
16        lcmArr = new long[1 << m];
17        for (int mask = 1; mask < (1 << m); mask++) {
18            long L = 1;
19            for (int j = 0; j < m; j++) {
20                if ((mask & (1 << j)) != 0) {
21                    L = lcm(L, target[j]);
22                }
23            }
24            lcmArr[mask] = L;
25        }
26
27        // 🔹 DP init
28        dp = new long[n][1 << m];
29        for (int i = 0; i < n; i++) {
30            Arrays.fill(dp[i], -1);
31        }
32
33        long ans = solve(0, 0, nums, fullMask);
34        return (int) ans;
35    }
36
37    private long solve(int i, int mask, int[] nums, int fullMask) {
38        // ✅ all targets covered
39        if (mask == fullMask) return 0;
40
41        // ❌ no numbers left
42        if (i == n) return INF;
43
44        if (dp[i][mask] != -1) return dp[i][mask];
45
46        long ans = INF;
47
48        // 🔴 NOT TAKE
49        ans = solve(i + 1, mask, nums, fullMask);
50
51        // 🟢 TAKE (only remaining subsets)
52        int rem = fullMask ^ mask;
53
54        for (int sub = rem; sub > 0; sub = (sub - 1) & rem) {
55            long L = lcmArr[sub];
56
57            // avoid overflow issues
58            if (L == 0) continue;
59
60            long r = nums[i] % L;
61            long cost = (r == 0 ? 0 : L - r);
62
63            ans = Math.min(ans,
64                    cost + solve(i + 1, mask | sub, nums, fullMask));
65        }
66
67        return dp[i][mask] = ans;
68    }
69
70    private long gcd(long a, long b) {
71        return b == 0 ? a : gcd(b, a % b);
72    }
73
74    private long lcm(long a, long b) {
75        return a / gcd(a, b) * b;
76    }
77}