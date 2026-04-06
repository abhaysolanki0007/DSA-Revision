1class SegmentTree {
2    int[] tree;
3    int n;
4
5    SegmentTree(int[] arr) {
6        n = arr.length;
7        tree = new int[4 * n];
8        build(arr, 0, 0, n - 1);
9    }
10
11    void build(int[] arr, int node, int start, int end) {
12        if (start == end) {
13            tree[node] = arr[start];
14            return;
15        }
16
17        int mid = (start + end) / 2;
18        build(arr, 2 * node + 1, start, mid);
19        build(arr, 2 * node + 2, mid + 1, end);
20
21        tree[node] = Math.max(tree[2 * node + 1],
22                              tree[2 * node + 2]);
23    }
24
25    int query(int l, int r) {
26        return query(0, 0, n - 1, l, r);
27    }
28
29    int query(int node, int start, int end, int l, int r) {
30        if (r < start || end < l) {
31            return Integer.MIN_VALUE;
32        }
33
34        if (l <= start && end <= r) {
35            return tree[node];
36        }
37
38        int mid = (start + end) / 2;
39        int left = query(2 * node + 1, start, mid, l, r);
40        int right = query(2 * node + 2, mid + 1, end, l, r);
41
42        return Math.max(left, right);
43    }
44
45    void update(int idx, int val) {
46        update(0, 0, n - 1, idx, val);
47    }
48
49    void update(int node, int start, int end, int idx, int val) {
50        if (start == end) {
51            tree[node] = val;
52            return;
53        }
54
55        int mid = (start + end) / 2;
56
57        if (idx <= mid) {
58            update(2 * node + 1, start, mid, idx, val);
59        } else {
60            update(2 * node + 2, mid + 1, end, idx, val);
61        }
62
63        tree[node] = Math.max(tree[2 * node + 1],
64                              tree[2 * node + 2]);
65    }
66}
67class Solution {
68    public int lengthOfLIS(int[] nums, int k) {
69        int n=nums.length,ans=0;
70        int arr[]=new int[100001];
71        SegmentTree seg=new SegmentTree(arr);
72        for(int i=0;i<n;i++){
73            int max=seg.query(nums[i]-k,nums[i]-1);
74            seg.update(nums[i],1+max);
75            ans=Math.max(1+max,ans);
76        }
77        return ans;
78    }
79}