1class Solution {
2    public long maxTotal(int[] value, int[] limit) {
3        int n=value.length;
4        int arr[][]=new int[n][2];
5        for(int i=0;i<n;i++){
6            arr[i][0]=value[i];
7            arr[i][1]=limit[i];
8        }
9        Arrays.sort(arr,(a,b)->{
10            if(a[1]==b[1]) return Integer.compare(b[0],a[0]);
11            return Integer.compare(a[1],b[1]);
12        });
13        HashMap<Integer,Integer>map=new HashMap<>();
14        Set<Integer>set=new HashSet<>();
15        for(int i=0;i<n;i++){
16            map.put(limit[i],map.getOrDefault(limit[i],0)+1);
17            set.add(limit[i]);
18        }
19        int active=0;
20        long ans=0;
21        for(int i=0;i<n;i++){
22          
23            int val=arr[i][0];
24            int lim=arr[i][1];
25              if(!set.contains(lim)) continue;
26            if(active<lim){
27                ans+=val;
28                active++;
29            }
30            if(set.contains(active)){
31                set.remove(active);
32                active-=map.get(active);
33                active=Math.max(active,0);
34            }
35        }
36        return ans;
37    
38
39
40
41
42    }
43}