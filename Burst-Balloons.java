1class Solution {
2    public Integer dp[][];
3    public int coins(int i,int j,int nums[]){
4          int n=nums.length;
5          if(i>j) return 0;
6          int ans=0;
7          if( dp[i][j]!=null) return  dp[i][j];
8          for(int id=i;id<=j;id++){
9            ans=Math.max(ans,nums[id]*nums[i-1]*nums[j+1]+coins(i,id-1,nums)+coins(id+1,j,nums));
10          }
11          return dp[i][j]=ans;
12    }
13    public int maxCoins(int[] nums1) {
14        int n=nums1.length;
15        dp=new Integer[n+2][n+2];
16        int nums[]=new int[n+2];
17        nums[0]=nums[n+1]=1;
18        for(int i=1;i<=n;i++){
19            nums[i]=nums1[i-1];
20        }
21        return coins(1,n,nums);
22    }
23}