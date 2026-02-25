1import java.util.*;
2
3class Solution {
4    static class BIT {
5        int[] tree;
6        int n;
7        BIT(int n) {
8            this.n = n;
9            tree = new int[n + 1];
10        }
11        void update(int index, int val) {
12            while (index <= n) {
13                tree[index] += val;
14                index += index & -index;
15            }
16        }
17        int query(int index) {
18            int sum = 0;
19            while (index > 0) {
20                sum += tree[index];
21                index -= index & -index;
22            }
23            return sum;
24        }
25    }
26
27    public static long countSmall(int[] arr) {
28        int n = arr.length;
29        long result = 0;
30
31        // Coordinate compression
32        int[] sorted = arr.clone();
33        Arrays.sort(sorted);
34        Map<Integer, Integer> map = new HashMap<>();
35        int rank = 1;
36        for (int num : sorted) {
37            if (!map.containsKey(num)) map.put(num, rank++);
38        }
39
40        BIT bit = new BIT(rank);
41
42        for (int i = 0; i < n; i++) {
43            int r = map.get(arr[i]);
44            result += bit.query(r - 1); // count smaller on left
45            bit.update(r, 1);
46        }
47        return result;
48    }
49
50    public long countMajoritySubarrays(int[] nums, int target) {
51        int n = nums.length;
52        int[] pref = new int[n + 1]; // prefix sum array
53        pref[0] = 0;
54        for (int i = 0; i < n; i++) {
55            nums[i] = (nums[i] == target) ? 1 : -1;
56            pref[i + 1] = pref[i] + nums[i];
57        }
58        return countSmall(pref);
59    }
60
61   
62}