1class Solution {
2    int mod=1000000007;
3    public int xorAfterQueries(int[] nums, int[][] queries) {
4        int q=queries.length;
5        int n=nums.length;
6        for(int i=0;i<q;i++){
7            int l=queries[i][0];
8            int r=queries[i][1];
9            int k=queries[i][2];
10            int v=queries[i][3];
11            for(int j=l;j<=r;j+=k){
12                nums[j]=(int)((nums[j]*(long)v)%mod);
13            }
14        }
15        int ans=0;
16        for(int j=0;j<=n-1;j++){
17            ans=ans^nums[j];
18        }
19        return ans;
20    }
21}