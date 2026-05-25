1class Solution {
2    public int wiggleMaxLength(int[] nums) {
3        int n=nums.length;
4        int dp[][]=new int[n][2];
5        for(int row[]:dp){
6            Arrays.fill(row,1);
7        }
8        for(int i=1;i<n;i++){
9            if(nums[i]<nums[i-1]){
10                dp[i][0]=Math.max(dp[i-1][0],1+dp[i-1][1]);
11                
12            }
13            else if (nums[i]>nums[i-1]){
14                dp[i][1]=Math.max(dp[i-1][1],1+dp[i-1][0]);
15                
16            }
17            dp[i][1]=Math.max(dp[i-1][1],dp[i][1]);
18             dp[i][0]=Math.max(dp[i-1][0],dp[i][0]);
19
20        }
21        return Math.max(dp[n-1][1],dp[n-1][0]);
22    }
23}