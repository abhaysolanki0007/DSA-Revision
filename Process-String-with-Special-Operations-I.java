1class Solution {
2    public String reverse(String s){
3        int i=0,n=s.length();
4        StringBuilder sb=new StringBuilder();
5        while(i<n){
6            sb.append(s.charAt(i));
7            i++;
8        }
9        return sb.reverse().toString();
10    }
11    public String processStr(String s) {
12      String ans="";
13      for(int i=0;i<s.length();i++){
14        char letter=s.charAt(i);
15        if(letter=='*'){
16            if(ans.length()>0) ans=ans.substring(0,ans.length()-1);
17        }
18       else if(letter=='#'){
19            ans+=ans;
20        }
21       else if(letter=='%'){
22            ans=reverse(ans);
23        }
24        else ans+=Character.toString(letter);
25        // System.out.println(ans);
26
27      }
28      return ans;
29    }
30}