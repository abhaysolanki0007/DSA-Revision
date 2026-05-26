1class Solution {
2    public  ArrayList<List<Integer>>adj=new ArrayList<>();
3    public boolean ans=true;
4    public int vis[];
5    public void dfs(int node,int parent){
6        vis[node]=1;
7        for(int a:adj.get(node)){
8            // if(a!=parent){
9                if(vis[a]==1){
10                    if(a==parent){ans=false;return;}
11               continue;
12                }
13            // }
14            dfs(a,parent);
15        }
16    }
17    public boolean canFinish(int numCourses, int[][] prerequisites) {
18        for(int i=0;i<numCourses;i++){
19            adj.add(new ArrayList<>());
20        }
21       
22        for(int a[]:prerequisites){
23            adj.get(a[0]).add(a[1]);
24        }
25        // System.out.println(adj.get(0));
26        //  System.out.println(adj.get(1));
27        for(int i=0;i<numCourses;i++){
28             vis=new int[numCourses];
29            dfs(i,i);
30        }
31        return ans;
32    }
33}