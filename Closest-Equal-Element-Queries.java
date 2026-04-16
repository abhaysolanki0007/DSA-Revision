1class Solution {
2    public List<Integer> solveQueries(int[] nums, int[] queries) {
3        int n=nums.length;
4        HashMap<Integer,Integer>map=new HashMap<>();
5          HashMap<Integer,Integer>map2=new HashMap<>();
6        int arr[]=new int[n];
7        Arrays.fill(arr,n);
8        for(int i=0;i<n;i++){
9           if(map.containsKey(nums[i])){
10                arr[i]=Math.min(i-map.get(nums[i]),arr[i]);
11            }
12             map.put(nums[i],i);
13        }
14         for(int i=n-1;i>=0;i--){
15           if(map2.containsKey(nums[i])){
16                arr[i]=Math.min(map2.get(nums[i])-i,arr[i]);
17            }
18             map2.put(nums[i],i);
19        }
20        for(int i=0;i<n;i++){
21           if(map.containsKey(nums[i])){
22                arr[i]=Math.min(n+i-map.get(nums[i]),arr[i]);
23            }
24             
25        }
26        for(int i=n-1;i>=0;i--){
27           if(map2.containsKey(nums[i])){
28                arr[i]=Math.min(n+map2.get(nums[i])-i,arr[i]);
29            }
30            
31        }
32         List<Integer>list=new ArrayList<Integer>();
33        for(int i=0;i<queries.length;i++){
34            if(arr[queries[i]]==n) list.add(-1);
35            else list.add(arr[queries[i]]);
36        }
37        return list;
38        
39    }
40}