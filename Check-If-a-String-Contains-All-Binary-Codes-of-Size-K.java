1class Solution {
2    public String binary(int i,int k){
3        String s=Integer.toBinaryString(i);
4        int diff=k-s.length();
5        String temp="";
6        for(int j=0;j<diff;j++){
7            temp+="0";
8        }
9        return temp+s;
10    }
11    public boolean hasAllCodes(String s, int k) {
12        // int a=(int)(Math.pow(2,k-1));
13         int b=(int)(Math.pow(2,k));
14         Set<Integer>set=new HashSet<>();
15       
16
17        int n=s.length();
18        for(int i=0;i<=n-k;i++){
19            String str=s.substring(i,i+k);
20         set.add(Integer.parseInt(str, 2));
21        }
22         for(int i=0;i<b;i++){
23            if(!set.contains(i)) return false;
24        }
25        return true;
26    }
27}