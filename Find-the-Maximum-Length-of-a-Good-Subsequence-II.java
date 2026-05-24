1class Solution {
2    public int maximumLength(int[] nums, int K) {
3        Map<Integer,Integer>map=new HashMap<>();
4        int n=nums.length;
5        int res[]=new int[n];
6        for(int i=0;i<n;i++){
7            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
8            res[i]=map.get(nums[i]);
9            // System.out.print(res[i]+" ");
10        }
11        //  System.out.println();
12        for(int k=1;k<=K;k++){
13            Map<Integer,Integer>map2=new HashMap<>();
14             int cur[]=res.clone();
15             int best=0;
16             for(int i=0;i<n;i++){
17                if(i>0){
18                    res[i]=Math.max(res[i],1+best);
19                   if(map2.containsKey(nums[i])) res[i]=Math.max(res[i],map2.get(nums[i])+1);
20                }
21                map2.put(nums[i],res[i]);
22                best=Math.max(best,cur[i]);
23                // System.out.print(cur[i]+" ");
24             }
25            //   for(int i=0;i<n;i++){
26            //         System.out.print(res[i]+" ");
27            //   }
28            //  System.out.println();
29        }
30        int ans=0;
31        for(int a:res){
32            ans=Math.max(ans,a);
33        }
34        return ans;
35    }
36}