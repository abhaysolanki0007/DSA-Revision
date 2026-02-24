1class Solution {
2    public long M=0;
3    public int len(long a){
4        int c=0;
5        while(a>0){a/=10;
6        c++;}
7        return c;
8    }
9    public long count(int k,long a,long b,int carry,long n,boolean zeroa,boolean zerob,long dp[][][][]){
10         
11        if(k==-1){
12            if(carry==0){return 1;}
13            return 0;
14        }
15        int limita=9,limitb=9;
16        if(zeroa==true) limita=0;
17          if(zerob==true) limitb=0;
18          int zeroaa=0,zerobb=0;
19          if(zeroa==true) zeroaa=1;
20           if(zerob==true) zerobb=1;
21            if(dp[k][carry][zeroaa][zerobb]!=-1) return dp[k][carry][zeroaa][zerobb];
22        long sum=0;
23        long digit=n%10;
24        long powa=(long)Math.pow(10,len(a));
25        if(a==0) powa=1;
26        long powb=(long)Math.pow(10,len(b));
27           if(b==0) powb=1;
28           int sta=0,stb=0;
29           if(k==len(M)-1){sta=1;stb=1;}
30        for(int i=sta;i<=limita;i++){
31            for(int j=stb;j<=limitb;j++){
32                if((i+j+carry)%10==digit){
33                    sum+=(long)count(k-1,a+i*powa,b+j*powb,(i+j+carry)/10,n/10,((i==0)||zeroa),((j==0)||zerob),dp);
34                }
35            }
36        }
37        return dp[k][carry][zeroaa][zerobb]=(long)(sum);
38    }
39    public long countNoZeroPairs(long n) {
40        long dp[][][][]=new long[20][10][2][2];
41       for (int i = 0; i < 20; i++) {
42    for (int j = 0; j < 10; j++) {
43        for (int k = 0; k < 2; k++) {
44            for (int l = 0; l < 2; l++) {
45                dp[i][j][k][l] = -1;
46            }
47        }
48    }
49}
50M=n;
51        return count(len(n)-1,0L,0L,0,n,false,false,dp);
52    }
53}