1class Solution {
2     public boolean is(String s1,int start,int end){
3       while (start <= end) {
4            if (s1.charAt(start++) != s1.charAt(end--))
5                return false;
6        }
7        return true;
8    }
9    public int f(int id,String s,int dp[]){
10        if(id==s.length()) return 0;
11        int a=Integer.MAX_VALUE;
12        if(dp[id]!=-1) return dp[id];
13        for(int i=id;i<s.length();i++){
14            if(is(s,id,i)){
15                a=Math.min(a,1+f(i+1,s,dp));
16            }
17        }
18        return dp[id]=a;
19    }
20    public int minCut(String s) {
21        int n= s.length();
22        int dp[]=new int [n];
23       
24        Arrays.fill(dp,-1);
25       return f(0,s,dp)-1;
26    }
27}