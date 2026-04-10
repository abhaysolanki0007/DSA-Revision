1class Solution {
2    public int minimumDistance(int[] nums) {
3        int ans=100000;
4        int n=nums.length;
5        for(int i=1;i<=n;i++){
6            List<Integer>list=new ArrayList<>();
7            for(int j=0;j<n;j++){
8                if(nums[j]==i){
9                list.add(j);
10                    }
11            }
12             for(int j=2;j<list.size();j++){
13                 ans=Math.min(ans,2*(list.get(j)-list.get(j-2)));
14             }
15        }
16        if(ans==100000) return -1;
17        return ans;
18    }
19}