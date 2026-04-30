1class Solution {
2    public int longestSubarray(int[] nums) {
3        int n=nums.length,ans=0;
4        if(n==1) return 1;
5        int inc[]=new int[n];
6        Arrays.fill(inc,1);
7         int dec[]=new int[n];
8            Arrays.fill(dec,1);
9         for(int i=1;i<n;i++){
10            if(nums[i-1]<=nums[i]){
11                inc[i]+=inc[i-1];
12            }
13         }
14         for(int i=n-2;i>=0;i--){
15             if(nums[i+1]>=nums[i]){
16                dec[i]+=dec[i+1];
17            }
18         }
19          for(int i=1;i<n;i++){
20            ans=Math.max(ans,1+inc[i]);
21            ans=Math.max(ans,1+dec[i]);
22            if(i<n-1){
23                if(nums[i-1]<=nums[i+1]){
24                     ans=Math.max(ans,1+inc[i-1]+dec[i+1]);
25                }
26            }
27          }
28          return Math.min(ans,n);
29    }
30}