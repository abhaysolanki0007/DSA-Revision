1class Solution {
2    public int[] twoSum(int[] nums, int target) {
3       for(int i=0;i<nums.length;i++){
4        for(int j=i+1;j<nums.length;j++){
5            if(nums[i]+nums[j]==target){
6                int a[]={i,j};
7                return a;
8            }
9
10        }
11
12       }
13       return null;
14    }
15}