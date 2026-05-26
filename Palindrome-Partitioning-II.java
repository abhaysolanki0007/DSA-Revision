1class Solution {
2    public int max=(int)(1e9);
3    public int pali[][];
4    public Integer dp[][];
5    public int f(int i,int j,String s){
6        int n=s.length();
7        if(i==n) return 0;
8        if(j==n) return max;
9        if(dp[i][j]!=null) return dp[i][j];
10        int ans=f(i,j+1,s);
11        if(pali[i][j]==1){
12             ans=Math.min(ans,1+f(j+1,j+1,s));
13        }
14        return dp[i][j]=ans;
15    }
16    public int minCut(String s) {
17          int n=s.length();
18        pali=new int[n][n];
19        dp=new Integer[n][n];
20        for(int i=0;i<n;i++){
21            int j=i,k=i;
22            while(j>=0&&k<n){
23                if(s.charAt(j)!=s.charAt(k)){
24                    break;
25                }
26                pali[j][k]=1;
27                j--;k++;
28            }
29        }
30         for(int i=0;i<n;i++){
31            int j=i,k=i+1;
32            while(j>=0&&k<n){
33                if(s.charAt(j)!=s.charAt(k)){
34                    break;
35                }
36                pali[j][k]=1;
37                j--;k++;
38            }
39        }
40        return f(0,0,s)-1;
41    }
42}