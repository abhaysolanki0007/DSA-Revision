1class Solution {
2    //  public List<String>ans=new ArrayList<>();
3    public Integer dp[];
4    Set<String>set=new HashSet<>();
5    public boolean dfs(int i,String s){
6        int n=s.length();
7        if(i>=n){
8            return true;
9        }
10        if(dp[i]!=null) return dp[i]==1?true:false;
11        boolean a=false;
12        for(int id=i;id<n;id++){
13            String sub=s.substring(i,id+1);
14            if(set.contains(sub)){
15                a|=dfs(id+1,s);
16            }
17        }
18        dp[i]=a==true?1:0;
19        return a;
20    }
21    public boolean k(String s, List<String> wordDict) {
22        dp=new Integer[s.length()];
23        for(String d:wordDict){
24            set.add(d);
25        }
26        return dfs(0,s);
27    }
28    public boolean wordBreak(String s, List<String> wordDict) {
29        return k(s,wordDict);
30    }
31}