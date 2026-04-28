1class Solution {
2    public long maxAlternatingSum(int[] nums) {
3        int n=nums.length;
4        long dp[][]=new long[n][2];
5        dp[0][0]=nums[0];
6        for(int i=1;i<n;i++){
7            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+nums[i]);
8             dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-nums[i]);
9        }
10        return Math.max(dp[n-1][1],dp[n-1][0]);
11    }
12}