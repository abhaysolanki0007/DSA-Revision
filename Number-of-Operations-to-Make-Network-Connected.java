1class Solution{
2    ArrayList<ArrayList<Integer>> buildGraph(int[][] edges, int n) {
3        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
4        for (int i = 0; i < n; i++) {
5            graph.add(new ArrayList<>());
6        }
7        for (int[] edge : edges) {
8            int u = edge[0];
9            int v = edge[1];
10
11            graph.get(u).add(v);
12            graph.get(v).add(u); // undirected
13        }
14
15        return graph;
16    }
17    void dfs(int node, boolean[] visited, ArrayList<ArrayList<Integer>> graph) {
18        visited[node] = true;
19
20        for (int neighbor : graph.get(node)) {
21            if (!visited[neighbor]) {
22                dfs(neighbor, visited, graph);
23            }
24        }
25    }
26    int countComponents(int[][] edges, int n) {
27        ArrayList<ArrayList<Integer>> graph = buildGraph(edges, n);
28        boolean[] visited = new boolean[n];
29
30        int count = 0;
31
32        for (int i = 0; i < n; i++) {
33            if (!visited[i]) {
34                dfs(i, visited, graph);
35                count++; 
36            }
37        }
38        return count;
39    }
40    public int parent[];
41   public int rank[];
42     public void DisjointSet(int n) {
43        rank = new int[n + 1];
44        parent = new int[n + 1];
45        for (int i = 0; i <= n; i++) {
46            parent[i] = i;
47        }
48    }
49      public boolean find(int u, int v) {
50        return (finduparent(u) == finduparent(v));
51    }
52    public int finduparent(int u){
53        if(parent[u]==u) return u;
54        return parent[u]=finduparent(parent[u]);
55    }
56    public void add(int a,int b){
57        int u=finduparent(a);
58        int v=finduparent(b);
59        if(rank[u]<rank[v]){
60            parent[u]=parent[v];
61        }
62        else if(rank[v]<rank[u]){
63             parent[v]=parent[u];
64        }
65        else{
66             parent[u]=parent[v];
67             rank[u]++;
68        }
69    }
70    public int makeConnected(int n, int[][] connections) {
71      Solution s=new Solution();
72      s.DisjointSet(n);
73        int extra=0;
74        for(int a[]:connections){
75            int u=a[0];
76            int v=a[1];
77            if(s.find(u,v)){
78               extra++;
79            }
80            else{
81                s.add(u,v);
82            }
83        }
84        int comp=s.countComponents(connections, n)-1;
85        if(comp<=extra){
86            return comp;
87        }
88        return -1;
89    }
90}