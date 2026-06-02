1class Solution {
2    public boolean isvowel(char c){
3        return c=='a'||c=='e'||c=='i'||c=='o'||c=='u';
4    }
5    public int countOfSubstrings(String s, int k) {
6        HashMap<Character,Integer>map=new HashMap<>();
7        int n=s.length();
8        int i=0,l=0,cons=0;
9        int res=0;
10        while(i<n){
11            int ans=0;
12            char c=s.charAt(i);
13            if(isvowel(c)){
14                map.put(c,map.getOrDefault(c,0)+1);
15            }
16            else{
17                cons++;
18            }
19            while(l<=i&&cons>k){
20                char ch=s.charAt(l);
21               
22               if(isvowel(ch)){
23                map.put(ch,map.get(ch)-1);
24            }
25            else{
26                cons--;
27            }
28            l++;
29              if(isvowel(ch)){if(map.get(ch)==0) map.remove(ch);}
30            }
31             while(l<=i&&cons>=k&&map.size()==5){
32                 System.out.println(i);
33                  System.out.println("ans ++");
34                char ch=s.charAt(l);
35                ans++;
36               if(isvowel(ch)){
37                map.put(ch,map.get(ch)-1);
38            }
39            else{
40                cons--;
41            }
42            l++;
43              if(isvowel(ch)){if(map.get(ch)==0) map.remove(ch);}
44            }
45            int t=i+1;
46            res+=ans;
47            while(t<n&&isvowel(s.charAt(t))){
48                res+=ans;
49                t++;
50            }
51            i++;
52        }
53        return res;
54    }
55}