1class Solution {
2    public int cost[];
3    public int target;
4    public Integer dp[][];
5    public boolean possible(int mask,int[] nums, int k){
6        if(mask==0&&k==0) return true;
7        if(k<=0) return false;
8        if(dp[mask][k]!=null) return dp[mask][k]==1?true:false;
9        boolean ans=false;
10        for(int id=mask;id>=0;id--){
11            id=(id&mask);
12            if(cost[id]==target){
13            ans|=possible(mask^id,nums,k-1);
14            }
15        }
16        dp[mask][k]=ans?1:0;
17        return ans;
18    }
19    public boolean canPartitionKSubsets(int[] nums, int k) {
20        int n=nums.length;
21        int mask=1<<n;
22        dp=new Integer[mask][k+1];
23        cost=new int[mask];
24        for(int i=0;i<n;i++){
25            target+=nums[i];
26        }
27        if(target%k!=0) return false;
28        target/=k;
29        for(int i=0;i<mask;i++){
30            int sum=0;
31            for(int j=0;j<n;j++){
32                if((i&(1<<j))!=0){
33                    sum+=nums[j];
34                }
35            }
36            cost[i]=sum;
37        }
38        return possible(mask-1,nums,k);
39    }
40}