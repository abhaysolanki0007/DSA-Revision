1import java.util.*;
2
3class FenwickTree {
4    int tree[];
5    int n;
6
7    FenwickTree(int n) {
8        this.n = n;
9        tree = new int[n + 1];
10    }
11
12    void update(int i) {
13        while (i <= n) {
14            tree[i] += 1;
15            i += (i & -i);
16        }
17    }
18
19    int sum(int i) {
20        int res = 0;
21        while (i > 0) {
22            res += tree[i];
23            i -= (i & -i);
24        }
25        return res;
26    }
27
28    int rangeSum(int l, int r) {
29        return sum(r) - sum(l - 1);
30    }
31}
32
33class Solution {
34    public List<Integer> countSmaller(int[] nums) {
35
36        int OFFSET = 10000;  // handle negatives
37        int SIZE = 20001;    // range [-10000,10000]
38
39        FenwickTree fenwick = new FenwickTree(SIZE);
40
41        List<Integer> list = new ArrayList<>();
42        int n = nums.length;
43
44        for (int i = n - 1; i >= 0; i--) {
45
46            int idx = nums[i] + OFFSET + 1;  // shift to 1-based
47
48            // count smaller elements
49            list.add(fenwick.sum(idx - 1));
50
51            // insert current element
52            fenwick.update(idx);
53        }
54
55        Collections.reverse(list);
56        return list;
57    }
58}