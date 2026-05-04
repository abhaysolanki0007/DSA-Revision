1class Solution {
2    public String minWindow(String s, String t) {
3        HashMap<Character,Integer>map=new HashMap<>();
4            HashMap<Character,Integer>map2=new HashMap<>();
5        Set<Character>set=new HashSet<>();
6        int i=0,n=t.length(),m=s.length();
7        for(i=0;i<n;i++){
8            char ch=t.charAt(i);
9            set.add(ch);
10            map.put(ch,map.getOrDefault(ch,0)+1);
11            // System.out.println(ch);
12        }
13        String res="";
14        i=0;int l=0,ans=m;
15        while(i<m){
16             char ch=s.charAt(i);
17            if(set.contains(ch)){
18                //  System.out.println(ch);
19                if(map.containsKey(ch)){
20                map.put(ch,map.get(ch)-1);
21                }
22                else{
23                     map2.put(ch,map2.getOrDefault(ch,0)+1);
24                }
25                if(map.containsKey(ch)&&map.get(ch)==0) map.remove(ch);
26             }
27            //  if(map.size()==0)   System.out.println(i);
28            while(l<=i&&map.size()==0){
29                char ch2=s.charAt(l);
30                if(i-l+1<=ans){
31                    ans=i-l+1;
32                    res=s.substring(l,i+1);
33                    // System.out.println(res);
34                }
35                if(set.contains(ch2)){
36                    //  System.out.println(l);
37                    if(map2.containsKey(ch2)){
38                       
39                        map2.put(ch2,map2.get(ch2)-1);
40                        if(map2.get(ch2)==0) map2.remove(ch2);
41                    }
42                   else map.put(ch2,1);
43                }
44                l++;
45            }
46            i++;
47        }
48        return res;
49    }
50}