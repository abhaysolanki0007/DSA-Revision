1class Solution {
2    int[] dp;
3
4    public int solve(int[] nums1, int[] nums2, int mask) {
5        int n = nums1.length;
6
7        if (mask == (1 << n) - 1) return 0;
8
9        if (dp[mask] != -1) return dp[mask];
10
11        int i = Integer.bitCount(mask); // current index in nums1
12        int ans = Integer.MAX_VALUE;
13
14        for (int j = 0; j < n; j++) {
15            if ((mask & (1 << j)) == 0) {
16                int cost = (nums1[i] ^ nums2[j]) 
17                         + solve(nums1, nums2, mask | (1 << j));
18                ans = Math.min(ans, cost);
19            }
20        }
21
22        return dp[mask] = ans;
23    }
24
25    public int minimumXORSum(int[] nums1, int[] nums2) {
26        int n = nums1.length;
27        dp = new int[1 << n];
28        Arrays.fill(dp, -1);
29        return solve(nums1, nums2, 0);
30    }
31}