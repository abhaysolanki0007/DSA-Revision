1import java.util.*;
2
3class Solution {
4
5    long encCost, flatCost;
6    int[] prefix;
7
8    // HashMap<Long, Long> dp = new HashMap<>();
9
10    long solve(int l, int len) {
11
12        // long key = (((long) l) << 32) | len;
13        // if (dp.containsKey(key)) return dp.get(key);
14
15        int r = l + len - 1;
16        int ones = prefix[r + 1] - prefix[l];
17
18        long costWhole;
19        if (ones == 0) costWhole = flatCost;
20        else costWhole = 1L * len * ones * encCost;
21
22        long ans = costWhole;
23
24        if (len % 2 == 0) {
25            int half = len / 2;
26            long split = solve(l, half) + solve(l + half, half);
27            ans = Math.min(ans, split);
28        }
29
30        // dp.put(key, ans);
31        return ans;
32    }
33
34    public long minCost(String s, int encCost, int flatCost) {
35
36        int n = s.length();
37
38        this.encCost = encCost;
39        this.flatCost = flatCost;
40
41        prefix = new int[n + 1];
42
43        for (int i = 0; i < n; i++)
44            prefix[i + 1] = prefix[i] + (s.charAt(i) == '1' ? 1 : 0);
45
46        return solve(0, n);
47    }
48}