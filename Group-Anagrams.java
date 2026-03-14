1class Solution {
2    public String sort(String s){
3        String ans="";
4         char[] chars = s.toCharArray();
5         Arrays.sort(chars);
6         for(char a:chars){
7            String s2 = String.valueOf(a);
8            ans+=s2;
9         }
10         return ans;
11    }
12    public List<List<String>> groupAnagrams(String[] strs) {
13        String str[]=new String[strs.length];
14        int n=strs.length;
15        for(int i=0;i<str.length;i++){
16            str[i]=sort(strs[i]);
17        }
18        Map<String,List<String>>map=new HashMap<>();
19
20     for(int i=0;i<n;i++){
21        if(map.containsKey(str[i])){
22            map.get(str[i]).add(strs[i]);
23        }
24        else{
25            List<String >l=new ArrayList<String>();
26            l.add(strs[i]);
27            map.put(str[i],l);
28        }
29     }
30     List<List<String>>list=new ArrayList<List<String>>();
31       Iterator<Map.Entry<String, List<String>>> iterator = map.entrySet().iterator();
32        while (iterator.hasNext()) {
33            Map.Entry<String, List<String>> entry = iterator.next();
34          list.add(entry.getValue());
35        }
36        return list;
37    }
38}
39