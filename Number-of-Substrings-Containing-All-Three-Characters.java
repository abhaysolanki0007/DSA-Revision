1class Solution {
2    public int numberOfSubstrings(String s) {
3        int n=s.length();
4        int r=0,l=0;
5        int ans=0;
6        HashMap<Character,Integer>map=new HashMap<>();
7        while(r<n){
8            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
9            while(l<r&&map.size()==3){
10                ans+=n-r;
11                char c=s.charAt(l);
12                map.put(c,map.get(c)-1);
13                if(map.get(c)==0) map.remove(c);
14                l++;
15            }
16            r++;
17        }
18        return ans;
19    }
20}