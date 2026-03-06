1class Solution {
2    public int minArrivalsToDiscard(int[] nums, int w, int m) {
3        int n=nums.length,l=0,discard=0;
4        HashMap<Integer,Integer>map=new HashMap<>();
5        Set<Integer>set=new HashSet<>();
6
7        for(int i=0;i<w;i++){
8            if(map.containsKey(nums[i])){
9                if(map.get(nums[i])==m){
10                    discard++;set.add(i);
11                    continue;
12                }
13            }
14               
15                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
16                
17            
18        }
19        for(int i=w;i<n;i++){
20            if(set.contains(l)){
21                set.remove(l);
22            }
23            else{
24                 map.put(nums[l],map.get(nums[l])-1);
25                 if(map.get(nums[l])==0) map.remove(nums[l]);
26            }
27             if(map.containsKey(nums[i])&&map.get(nums[i])==m){
28                    discard++;set.add(i);
29                }
30                else{
31                    map.put(nums[i],map.getOrDefault(nums[i],0)+1);
32                }
33                l++;
34        }
35        return discard;
36
37
38    }
39}