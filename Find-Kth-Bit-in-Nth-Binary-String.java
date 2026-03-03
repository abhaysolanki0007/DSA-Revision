1class Solution {
2    public int get(int n){
3        int t=1;
4        while(n>1){
5            t=2*t+1;
6            n--;
7        }
8        return t;
9    }
10    public char findKthBit(int n, int k) {
11    int N=get(n);
12    System.out.println(N);
13    int temp=N/2,c=0;
14    while(temp>0){
15        if(k==temp+1){c++;break;}
16        if(k>temp){
17            k=1+Math.abs(k-N);
18            c++;
19        }
20        N=N/2;
21         temp=N/2;
22
23    }
24    c=c%2;
25    return c==0?'0':'1';
26    }
27}