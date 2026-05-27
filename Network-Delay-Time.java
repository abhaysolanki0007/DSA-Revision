1class Solution {
2    public int networkDelayTime(int[][] times, int n, int k) {
3        int dist[]=new int[n+1];
4        Arrays.fill(dist,(int)(1e9));
5         ArrayList<List<int[]>>adj=new ArrayList<>();
6        for(int i=0;i<=n;i++){
7            adj.add(new ArrayList<>());
8        }
9        for(int arr1[]:times){
10            adj.get(arr1[0]).add(new int[]{arr1[1],arr1[2]});
11        }
12        Queue<int[]>q=new LinkedList<>();
13        dist[k]=0;
14        q.offer(new int[]{k,0});
15        while(q.size()>0){
16            int arr[]=q.poll();
17            int node=arr[0];
18            int dis=arr[1];
19            for(int arr2[]:adj.get(node)){
20            int a=arr2[0];
21            int b=arr2[1];
22            if(dist[a]>dist[node]+b){
23                dist[a]=dist[node]+b;
24                q.offer(new int[]{a,dist[a]});
25            }
26            }
27        }
28        int ans=0;
29        for(int i=1;i<=n;i++){
30            int a=dist[i];
31            if(a==(int)(1e9)) return -1;
32            ans=Math.max(ans,a);
33        }
34        return ans;
35    }
36}