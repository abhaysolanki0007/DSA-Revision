1class Solution {
2    public int findMin(int[] nums) {
3        int n=nums.length;
4        int p=n-1;
5        int min=5000;
6        while(p>=0){
7            if(nums[p]<min) min=nums[p];
8            p--;
9        }
10        return min;
11
12        
13    }
14}