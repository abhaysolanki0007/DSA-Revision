1class Solution {
2    public int findPeakElement(int[] nums) {
3         int n=nums.length;
4        int low=0,high=n-1;
5        int ans=-1;
6        if(n==1) return 0;
7        while(low<=high){
8            int mid=(low+high)/2; 
9           int left=Math.max(mid-1,0);
10           int right=Math.min(mid+1,n-1);
11            if(nums[mid]>=nums[left]&&nums[mid]>=nums[right]) return mid;
12            if(mid==0) low=mid+1;
13           else if(nums[mid-1]<nums[mid]){
14                low=mid+1;
15            }
16            else{
17                 high=mid-1;
18            }
19        }
20        return ans;
21    }
22}