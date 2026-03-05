1import java.util.*;
2
3class Solution {
4
5    // last index <= i + k
6    public int find(int nums[], int i, int k) {
7        int val = i + k;
8        int n = nums.length;
9        int low = 0, high = n - 1, ans = -1;
10
11        while (low <= high) {
12            int mid = (low + high) / 2;
13            if (nums[mid] <= val) {
14                ans = mid;
15                low = mid + 1;
16            } else high = mid - 1;
17        }
18        return ans;
19    }
20
21    // first index >= i - k
22    public int find2(int nums[], int i, int k) {
23        int val = i + k;
24        int n = nums.length;
25        int low = 0, high = n - 1, ans = n;
26
27        while (low <= high) {
28            int mid = (low + high) / 2;
29            if (nums[mid] >= val) {
30                ans = mid;
31                high = mid - 1;
32            } else low = mid + 1;
33        }
34        return ans;
35    }
36
37    public int maxFrequency(int[] nums, int k, int numOperations) {
38        int n = nums.length;
39        Arrays.sort(nums);
40
41        int freq[] = new int[100001];
42        for (int x : nums) freq[x]++;
43
44        int res = 0;
45
46        for (int i = 1; i < 100001; i++) {
47
48            int ind = find(nums, i, k);      // last <= i+k
49            int ind2 = find2(nums, i, -k);   // first >= i-k
50
51            if (ind == -1 || ind2 == n || ind < ind2) continue;
52
53            int diff = ind - ind2 + 1;
54
55            if (freq[i] == 0) {
56                int ans = Math.min(diff, numOperations);
57                res = Math.max(res, ans);
58            } else {
59                int ans = Math.min(diff - freq[i], numOperations);
60                res = Math.max(res, freq[i] + ans);
61            }
62        }
63
64        return res;
65    }
66}