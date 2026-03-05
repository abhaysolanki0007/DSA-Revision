1import java.util.*;
2
3class Solution {
4
5    HashMap<String, Integer> dp;
6
7    public int count(int i, int[] nums, long k, long num, long den) {
8
9        // prune overflow / useless states
10        if (num > Long.MAX_VALUE / 2 || den > Long.MAX_VALUE / 2) return 0;
11
12        // optional pruning: if ratio already too big
13        if (num > k * den * 1000000L) return 0;
14
15        String key = i + "#" + num + "#" + den;
16        if (dp.containsKey(key)) return dp.get(key);
17
18        // base case
19        if (i == nums.length) {
20            if (num == k * den) return 1;
21            return 0;
22        }
23
24        int multiply = count(i + 1, nums, k, num * nums[i], den);
25        int divide   = count(i + 1, nums, k, num, den * nums[i]);
26        int skip     = count(i + 1, nums, k, num, den);
27
28        int ans = multiply + divide + skip;
29        dp.put(key, ans);
30        return ans;
31    }
32
33    public int countSequences(int[] nums, long k) {
34        dp = new HashMap<>();
35        return count(0, nums, k, 1L, 1L);
36    }
37}