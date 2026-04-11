1class Solution {
2    public int minimumDistance(int[] nums) {
3        int l=0,r=0;
4        int n=nums.length;
5        int ans=1000000000;
6        HashMap<Integer,Integer>map=new HashMap<>();
7        while(r<n){
8             map.put(nums[r],map.getOrDefault(nums[r],0)+1);
9            while(l<r&&map.get(nums[r])==3){
10                map.put(nums[l],map.get(nums[l])-1);
11                    l++;
12                   ans=Math.min(ans,2*(r-l+1));
13            }
14           
15            r++;
16        }
17        if(ans==1000000000) return -1;
18        return ans;
19    }
20}