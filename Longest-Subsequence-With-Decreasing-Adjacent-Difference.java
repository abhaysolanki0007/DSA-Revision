1class Solution {
2    public int longestSubsequence(int[] nums) {
3        int n=nums.length;
4        int dp[][]=new int[301][301];
5        for(int row[]:dp){
6            Arrays.fill(row,1);
7        }
8        int ans=0;
9        for(int i=0;i<n;i++){
10            int diff=0;
11              int dp2[]=new int[301];
12              Arrays.fill(dp2,1);
13            for(int j=0;j<i;j++){
14                diff=Math.abs(nums[i]-nums[j]);
15                dp2[diff]=Math.max(dp2[diff],1+dp[nums[j]][diff]);
16            }
17            // System.out.println(dp2[1]);
18            // System.out.println(dp[nums[i]][diff])
19            for(int j=299;j>=0;j--){
20                dp[nums[i]][j]=Math.max(dp[nums[i]][j],dp2[j]);
21            }
22               for(int j=299;j>=0;j--){
23                dp[nums[i]][j]=Math.max(dp[nums[i]][j+1],dp[nums[i]][j]);
24            }
25            ans=Math.max(ans,dp[nums[i]][0]);
26            // System.out.println(dp[nums[i]][0]);
27        }
28        return ans;
29    }
30}