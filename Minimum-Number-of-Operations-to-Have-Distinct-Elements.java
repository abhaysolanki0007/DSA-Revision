1class Solution {
2    public int minOperations(int[] nums) {
3        Set<Integer>set=new HashSet<>();
4        int n=nums.length;
5        int i=n-1;
6        while(i>=0){
7             if(set.contains(nums[i])) break;
8            set.add(nums[i]);
9            i--;
10        }
11        return (int)(Math.ceil((float)(i+1)/3));
12    }
13}