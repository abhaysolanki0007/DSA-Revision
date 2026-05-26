1class Solution {
2    public void rev(int nums[]){
3        int i=0,j=nums.length-1;
4        while(i<j){
5            int t=nums[i];
6            nums[i]=nums[j];
7            nums[j]=t;
8            i++;j--;
9        }
10    }
11    public int maxProduct(int[] nums) {
12        int res=1;
13        int n=nums.length,ans=Integer.MIN_VALUE;
14        for(int i=0;i<n;i++){
15            res*=nums[i];
16            ans=Math.max(ans,res);
17            if(nums[i]==0) res=1;
18        }
19        rev(nums);
20        res=1;
21        for(int i=0;i<n;i++){
22            res*=nums[i];
23            ans=Math.max(ans,res);
24            if(nums[i]==0) res=1;
25        }
26        return ans;
27    }
28}