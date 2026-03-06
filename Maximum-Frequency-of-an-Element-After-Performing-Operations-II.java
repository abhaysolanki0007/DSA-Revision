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
41        // int freq[] = new int[100001];
42        HashMap<Integer,Integer>map=new HashMap<>();
43        for (int x : nums) map.put(x,map.getOrDefault(x,0)+1);
44
45        int res = 0;
46        if(k==0||numOperations==0) return Collections.max(map.values());
47        // if() return Collections.max(map.values());
48        for (int i = 0; i < n; i++) {
49            for(int j=-k;j<=k;j+=k){
50
51            int ind = find(nums, nums[i]+j, k);      // last <= i+k
52            int ind2 = find2(nums, nums[i]+j, -k);   // first >= i-k
53
54            if (ind == -1 || ind2 == n || ind < ind2) continue;
55
56            int diff = ind - ind2 + 1;
57
58            if (!map.containsKey(nums[i]+j)) {
59                int ans = Math.min(diff, numOperations);
60                res = Math.max(res, ans);
61            } else {
62                int ans = Math.min(diff - map.get(nums[i]+j), numOperations);
63                res = Math.max(res, map.get(nums[i]+j) + ans);
64            }
65            }
66        }
67
68        return res;
69    }
70}