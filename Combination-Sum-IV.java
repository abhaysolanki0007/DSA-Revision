1class Solution {
2    public Integer dp[];
3    public int f(int nums[],int target){
4        if(target==0) return 1;
5        int n=nums.length;
6        int a=0;
7        if(dp[target]!=null) return dp[target];
8        for(int i=0;i<n;i++){
9           if(target>=nums[i]){
10            a+=f(nums,target-nums[i]);
11           }
12        }
13        return dp[target]=a;
14    }
15    public int combinationSum4(int[] nums, int target) {
16        int n=nums.length;
17        dp=new Integer[target+1];
18        return f(nums,target);
19    }
20}