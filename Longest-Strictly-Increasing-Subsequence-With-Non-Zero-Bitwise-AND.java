1class Solution {
2    public int ans=0;
3    public static int lis(List<Integer> nums) {
4        ArrayList<Integer> sub = new ArrayList<>();
5
6        for (int num : nums) {
7            // Binary search for the first element >= num
8            int i = Collections.binarySearch(sub, num);
9
10            if (i < 0) {
11                i = -(i + 1); // Convert to insertion index
12            }
13
14            if (i < sub.size()) {
15                sub.set(i, num); // Replace element at index i
16            } else {
17                sub.add(num);    // Append if num is greater than all
18            }
19        }
20
21        return sub.size();
22    }
23    public void setbit(int nums[],int pow){
24        List<Integer>list=new ArrayList<>();
25        for(int a:nums){
26            if((a&pow)==(pow)) list.add(a);
27        }
28        ans=Math.max(ans,lis(list));
29    }
30    public int longestSubsequence(int[] nums) {
31        int i=0;
32        while(i<31){
33            int pow=(int)(Math.pow(2,i));
34            setbit(nums,pow);
35            i++;
36        }
37        return ans;
38    }
39}