1class Solution {
2    public int dp[][];
3    public int f(int nums[],int i,int j){
4        int n=nums.length;
5        int sum=0;
6       
7        if(i>j){
8            return 0;
9        }
10         if(dp[i][j]!=-1) return dp[i][j];
11        for(int k=i;k<=j;k++){
12             int left=1;
13            if(i-1>=0){
14                left=nums[i-1];
15            }
16             int right=1;
17            if(j+1<n){
18                right=nums[j+1];
19            }
20            sum=Math.max(sum,nums[k]*left*right+f(nums,i,k-1)+f(nums,k+1,j));
21        }
22        return dp[i][j]=sum;
23    }
24    public int maxCoins(int[] nums) {
25        int n=nums.length;
26        dp=new int[n][n];
27        for(int row[]:dp){
28            Arrays.fill(row,-1);
29        }
30        return f(nums,0,nums.length-1);
31    }
32}