1class Solution {
2    public int count(int id,int vis[],int n){
3        if(id==n+1) return 1;
4        int a=0;
5        for(int i=1;i<=n;i++){
6            if(vis[i]==-1){
7                if(id%i==0||i%id==0){
8                    vis[i]=1;
9                    a+=count(id+1,vis,n);
10                    vis[i]=-1;
11                }
12            }
13        }
14        return a;
15    }
16    public int countArrangement(int n) {
17        int vis[]=new int[n+1];
18        Arrays.fill(vis,-1);
19        return count(1,vis,n);
20    }
21}