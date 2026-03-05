1// import java.util.*;
2
3// class Solution {
4
5//     HashMap<String, Integer> dp;
6
7//     public int count(int i, int[] nums, long k, long num, long den) {
8
9//         // prune overflow / useless states
10//         if (num > Long.MAX_VALUE / 2 || den > Long.MAX_VALUE / 2) return 0;
11
12//         // optional pruning: if ratio already too big
13//         if (num > k * den * 1000000L) return 0;
14
15//         String key = i + "#" + num + "#" + den;
16//         if (dp.containsKey(key)) return dp.get(key);
17
18//         // base case
19//         if (i == nums.length) {
20//             if (num == k * den) return 1;
21//             return 0;
22//         }
23
24//         int multiply = count(i + 1, nums, k, num * nums[i], den);
25//         int divide   = count(i + 1, nums, k, num, den * nums[i]);
26//         int skip     = count(i + 1, nums, k, num, den);
27
28//         int ans = multiply + divide + skip;
29//         dp.put(key, ans);
30//         return ans;
31//     }
32
33//     public int countSequences(int[] nums, long k) {
34//         dp = new HashMap<>();
35//         return count(0, nums, k, 1L, 1L);
36//     }
37// }
38import java.util.*;
39
40class Solution {
41
42    HashMap<String, Integer> dp;
43
44    long gcd(long a, long b) {
45        while (b != 0) {
46            long t = a % b;
47            a = b;
48            b = t;
49        }
50        return a;
51    }
52
53    int dfs(int i, int[] nums, long num, long den, long k) {
54
55        long g = gcd(num, den);
56        num /= g;
57        den /= g;
58
59        String key = i + "#" + num + "#" + den;
60        if (dp.containsKey(key)) return dp.get(key);
61
62        if (i == nums.length) {
63            return (num == k * den) ? 1 : 0;
64        }
65
66        int ans = 0;
67
68        // multiply
69        ans += dfs(i + 1, nums, num * nums[i], den, k);
70
71        // divide
72        ans += dfs(i + 1, nums, num, den * nums[i], k);
73
74        // skip
75        ans += dfs(i + 1, nums, num, den, k);
76
77        dp.put(key, ans);
78        return ans;
79    }
80
81    public int countSequences(int[] nums, long k) {
82        dp = new HashMap<>();
83        return dfs(0, nums, 1, 1, k);
84    }
85}