1import java.util.*;
2
3class Solution {
4
5    Set<Integer> goodSums = new HashSet<>();
6    Set<Long> goods = new HashSet<>();
7
8    Long[][][] dp;
9
10    boolean isGoodDigits(int x) {
11
12        String s = String.valueOf(x);
13
14        boolean inc = true, dec = true;
15
16        for (int i = 1; i < s.length(); i++) {
17
18            if (s.charAt(i) <= s.charAt(i - 1)) inc = false;
19            if (s.charAt(i) >= s.charAt(i - 1)) dec = false;
20        }
21
22        return inc || dec;
23    }
24
25    void generateGoodSums() {
26
27        for (int i = 1; i <= 135; i++)
28            if (isGoodDigits(i))
29                goodSums.add(i);
30    }
31
32    void generateGoods() {
33
34        genInc(0, -1, 0);
35        genDec(0, 10, 0);
36    }
37
38    void genInc(long num, int prev, int sum) {
39
40        if (num > 0) {
41
42            if (!goodSums.contains(sum))
43                goods.add(num);
44        }
45
46        for (int d = prev + 1; d <= 9; d++) {
47
48            long next = num * 10 + d;
49
50            if (next > 1e15) return;
51
52            genInc(next, d, sum + d);
53        }
54    }
55
56    void genDec(long num, int prev, int sum) {
57
58        if (num > 0) {
59
60            if (!goodSums.contains(sum))
61                goods.add(num);
62        }
63
64        for (int d = prev - 1; d >= 0; d--) {
65
66            long next = num * 10 + d;
67
68            if (next > 1e15) return;
69
70            genDec(next, d, sum + d);
71        }
72    }
73
74    long solve(String s, int pos, int sum, int tight) {
75
76        if (pos == s.length())
77            return goodSums.contains(sum) ? 1 : 0;
78
79        if (dp[pos][sum][tight] != null)
80            return dp[pos][sum][tight];
81
82        int limit = tight == 1 ? s.charAt(pos) - '0' : 9;
83
84        long ans = 0;
85
86        for (int d = 0; d <= limit; d++) {
87
88            int nt = (tight == 1 && d == limit) ? 1 : 0;
89
90            ans += solve(s, pos + 1, sum + d, nt);
91        }
92
93        return dp[pos][sum][tight] = ans;
94    }
95
96    long count(long x) {
97
98        if (x < 0) return 0;
99
100        String s = String.valueOf(x);
101
102        dp = new Long[20][140][2];
103
104        return solve(s, 0, 0, 1);
105    }
106
107    public long countFancy(long l, long r) {
108
109        generateGoodSums();
110        generateGoods();
111
112        long ans = count(r) - count(l - 1);
113
114        int goodCnt = 0;
115
116        for (long g : goods) {
117
118            if (g >= l && g <= r)
119                goodCnt++;
120        }
121
122        return ans + goodCnt;
123    }
124}