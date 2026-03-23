1class Solution {
2    public int cost[];
3    public int dp[];
4    public boolean canmake(int mask,int c,int side){
5        if(mask==0){
6            if(c==4) return true;
7            return false;
8        }
9       if(dp[mask]!=-1) return dp[mask]==1?true:false;
10        boolean flag=false;
11        for(int sub=mask;sub>0;sub=(sub-1)&mask){
12            if(cost[sub]==side){
13            flag=flag|canmake(mask^sub,c+1,side);
14            }
15        }
16        dp[mask]=flag==true?1:0;
17        return flag;
18    }
19    public boolean makesquare(int[] matchsticks) {
20        int n=matchsticks.length;
21        int mask=(1<<n);
22        cost=new int[mask];
23        int totalsum=0;
24        for(int a:matchsticks){
25            totalsum+=a;
26        }
27        dp=new int[mask];
28        // for(int row[]:dp){
29            Arrays.fill(dp,-1);
30        // }
31        if(totalsum%4!=0) return false;
32        
33        for(int sub=mask-1;sub>0;sub=(sub-1)){
34         
35            int sum=0;
36            for(int i=0;i<n;i++){
37                if(((sub)&(1<<i))!=0){
38                    sum+=matchsticks[n-1-i];
39                }
40            }
41            cost[sub]=sum;
42        }
43        return canmake(mask-1,0,totalsum/4);
44    }
45}