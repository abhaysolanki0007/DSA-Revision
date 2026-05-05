1class Solution {
2    public int maxSubarraySumCircular(int[] nums) {
3        int n=nums.length,res=-(int)(1e9),ans=-(int)(1e9),total=0,cur=0,maxcur=-(int)(1e9);
4        for(int i=0;i<n;i++){
5            total+=nums[i];
6        }
7        int sum=0;
8       for(int i=0;i<n;i++){
9        if(sum<0){
10            sum=nums[i];
11        }
12        else sum+=nums[i];
13        ans=Math.max(ans,sum);
14        cur+=nums[i];
15         total-=nums[i];
16         maxcur=Math.max(maxcur,cur);
17        //  System.out.println(maxcur);
18          res=Math.max(res,total+maxcur); 
19       }      
20    
21    return Math.max(res,ans);
22    }
23}