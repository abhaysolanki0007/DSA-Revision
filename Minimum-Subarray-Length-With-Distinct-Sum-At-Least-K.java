1class Solution {
2    public int minLength(int[] nums, int k) {
3        int l=0,r=0;
4        int  n=nums.length;
5        int ans=1000000000,sum=0;
6        HashMap<Integer,Integer>map=new HashMap<>();
7        while(r<n){
8            if(!map.containsKey(nums[r])){
9                sum+=nums[r];
10            }
11            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
12            while(sum>=k){
13                   ans=Math.min(ans,r-l+1);
14                if(map.containsKey(nums[l])){
15                    map.put(nums[l],map.get(nums[l])-1);
16                }
17                if(map.get(nums[l])==0){
18                    //remove from sum
19                    sum-=nums[l];
20                    map.remove(nums[l]);
21                }
22                l++;
23            }
24            r++;
25        }
26        return ans==1000000000?-1:ans;
27    }
28}