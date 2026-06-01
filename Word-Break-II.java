1class Solution {
2    public List<String>ans=new ArrayList<>();
3    Set<String>set=new HashSet<>();
4    public void dfs(int i,String s,StringBuilder sb){
5        int n=s.length();
6        if(i>=n){
7            ans.add(sb.substring(0,sb.length()-1).toString());
8            return;
9        }
10        for(int id=i;id<n;id++){
11            String sub=s.substring(i,id+1);
12            if(set.contains(sub)){
13                int len=sub.length();
14                sb.append(sub+" ");
15                dfs(id+1,s,sb);
16                while(len>=0){
17                    sb.deleteCharAt(sb.length()-1);
18                    len--;
19                }
20            }
21        }
22    }
23    public List<String> wordBreak(String s, List<String> wordDict) {
24        for(String d:wordDict){
25            set.add(d);
26        }
27        StringBuilder sb=new StringBuilder();
28        dfs(0,s,sb);
29        return ans;
30    }
31}