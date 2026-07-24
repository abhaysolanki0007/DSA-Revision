class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length,ans=0;
        int dp[][]=new int[301][301];
      for(int i=0;i<n;i++){
         int cur=nums[i];
        for(int j=0;j<=300;j++){
            int prev=cur-j;
            if(prev>=0){
                dp[cur][j]=Math.max(dp[cur][j],1+dp[prev][j]);
            }
            if(j!=0){
            int next=cur+j;
            if(next<=300){
                dp[cur][j]=Math.max(dp[cur][j],1+dp[next][j]);
            }
            }
        }
        int max=dp[cur][300];
        for(int j=300;j>=0;j--){
            max=Math.max(max,dp[cur][j]);
             dp[cur][j]=max;
        }
        // System.out.println(max);
        ans=Math.max(ans,max);
      }
      return ans;
    }
}