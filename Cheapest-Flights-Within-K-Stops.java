1class Pair{
2    int node,price;
3    Pair(int node,int price){
4        this.node=node;
5        this.price=price;
6    }
7}
8// class Pair2{
9//     int node,d;
10//     Pair(int node,int d){
11//         this.node=node;
12//         this.d=d;
13//     }
14// }
15class Solution {
16    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
17        ArrayList<List<int[]>>adj=new ArrayList<>();
18        for(int i=0;i<n;i++){
19            adj.add(new ArrayList<>());
20        }
21        for(int arr1[]:flights){
22            adj.get(arr1[0]).add(new int[]{arr1[1],arr1[2]});
23        }
24        int ans=(int)(1e9);
25        Queue<Pair>q=new LinkedList<>();
26        int c=0;
27        q.offer(new Pair(src,0));
28        int dist[]=new int[n];
29       
30        Arrays.fill(dist,(int)(1e9));
31         dist[src]=0;
32        while(q.size()>0){
33            int size=q.size();
34            int temp[]=dist.clone();
35            
36            for(int i=0;i<size;i++){
37            Pair p=q.poll();
38             
39            int x=p.node;
40            // System.out.println(x);
41            int y=p.price;
42            
43            for(int arr[]:adj.get(x)){
44               
45                int a=arr[0];
46                int b=arr[1];
47                // System.out.println(a+" "+dist[a]);
48
49                if(dist[a]>(b+dist[x])){
50        
51                   if(temp[a]>temp[x]+b) temp[a]=b+dist[x];
52                    q.offer(new Pair(a,temp[a]));
53                    // System.out.print(a+" ");
54                    //  System.out.print(temp[a]+" ");
55                }
56            }
57            }
58            dist=temp.clone();
59            
60            if(c>=k) break;
61            c++;
62            //  System.out.println();
63        }
64        return dist[dst]==(int)(1e9)?-1:dist[dst];
65        // return dist[dst];
66    }
67}