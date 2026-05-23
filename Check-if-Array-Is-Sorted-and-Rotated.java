1class Solution {
2    public boolean check(int[] nums) {
3        int c=0;
4        int n=nums.length;
5        for(int i=1;i<nums.length;i++){
6            if(nums[i-1]>nums[i]){
7                c++;
8            }
9        }
10        if(nums[n-1]>nums[0]) c++;
11        if(c<=1) return true;
12        else return false;
13    }
14}