1class Solution {
2    public String mergeCharacters(String s, int k) {
3        HashMap<Character,Integer>map=new HashMap<>();
4        StringBuilder sb=new StringBuilder();
5        int n=s.length(),c=0;
6        for(int i=0;i<n;i++){
7            char ch=s.charAt(i);
8            if(map.containsKey(ch)){
9                if(c-map.get(ch)<=k){
10                    continue;
11                }
12                else{
13                    sb.append(ch);
14                    map.put(ch,c);
15                    c++;
16                }
17            }
18             else{
19                 sb.append(ch);
20                 map.put(ch,c);
21                 c++;
22             }
23        }
24        return sb.toString();
25    }
26}