1class Solution {
2    public String smallestNumber(String s) {
3        int i=0,n=s.length(),c=1;
4        boolean flag=true;
5        StringBuilder sb=new StringBuilder();
6
7        while(i<n){
8              if(flag==false ) c++;
9            int c1=0,c2=0;
10            while(i<n&&s.charAt(i)=='I'){
11                c1++;
12                if(c1>1){
13                sb.append(c);
14                  c++;
15            }
16                i++;
17            }
18          
19            if(c1>0&&flag==true){flag=false;sb.append(c++);}
20            while(i<n&&s.charAt(i)=='D'){
21                 c2++;i++;
22            }
23            int temp=c+c2;
24            if(c1==0) flag=false;
25            while(temp>=c){
26                 sb.append(temp);
27                 temp--;
28            }
29            // System.out.println(temp);
30            if(c2==0&&flag==true){
31                sb.append(c);
32            }
33            c+=c2;
34              System.out.println(c);
35
36        }
37        return sb.toString();
38    }
39}