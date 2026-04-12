1class Solution {
2    public int d(String s) {
3        HashMap<Integer,Integer>map=new HashMap<>();
4        int one=0,zero=0,freqone=0,freqzero=0,ans=0;
5        int n=s.length();
6        map.put(0,-1);
7        for(int i=0;i<n;i++){
8            char ch=s.charAt(i);
9            if(ch=='1') freqone++;
10            else freqzero++;
11        }
12        for(int i=0;i<n;i++){ 
13            char ch=s.charAt(i);
14            if(ch=='1') one++;
15            else zero++;
16            if(map.containsKey(one-zero+2)){
17                int len=i-map.get(one-zero+2);
18                if(freqone>=len/2&&freqzero>=len/2) ans=Math.max(ans,len);
19            }
20            if(map.containsKey(one-zero-2)){
21                 int len=i-map.get(one-zero-2);
22                if(freqone>=len/2&&freqzero>=len/2) ans=Math.max(ans,len);
23            }
24             if(map.containsKey(one-zero)){
25                int len=i-map.get(one-zero);
26               ans=Math.max(ans,len);
27            }
28              if(!map.containsKey(one-zero)) map.put(one-zero,i);
29        }
30        return ans;
31    }
32     public int longestBalanced(String s) {
33         int ans=0;
34         ans=Math.max(ans,d(s));
35         StringBuilder sb=new StringBuilder();
36         sb.append(s);
37         ans=Math.max(ans,d(sb.reverse().toString()));
38         return ans;
39     }
40}