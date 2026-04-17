1class Solution {
2    public int dp[][];
3    public int f(int i,int j,int nums[]){
4        if(i>j) return 0;
5        int sum=0;
6        if(dp[i][j]!=-1) return dp[i][j];
7        for(int ind=i;ind<=j;ind++){
8            sum=Math.max(sum,nums[ind]*nums[i-1]*nums[j+1]+f(i,ind-1,nums)+f(ind+1,j,nums));
9        }
10        return dp[i][j]=sum;
11    }
12    public int maxCoins(int[] nums) {
13        int n=nums.length;
14        int arr[]=new int[n+2];
15        dp=new int[n+2][n+2];
16        for(int row[]:dp){
17            Arrays.fill(row,-1);
18        }
19        arr[0]=1;
20        arr[n+1]=1;
21        for(int i=1;i<=n;i++){
22            arr[i]=nums[i-1];
23        }
24        return f(1,n,arr);
25    }
26}