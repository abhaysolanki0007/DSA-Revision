1class Solution {
2    public int maxi=(int)(1e9);
3    public String s;
4    public int t=1;
5    public int flips(int i,int parity,int jump,int dp[][][]){
6      if(i==s.length()){
7           if(parity!=t) return maxi;
8           return 0;
9        }
10        if(i>s.length()){
11            return 0;
12        }
13        if (dp[i][parity][jump]!=-1) return dp[i][parity][jump];
14        int a=maxi,b=maxi,c=maxi;
15        if(s.charAt(i)=='1'){
16            if(parity==0){
17                a=1+flips(i+1,1,jump,dp);
18            }
19            else a=flips(i+1,0,jump,dp);
20        }
21        else{
22            if(parity==1){
23                b=1+flips(i+1,0,jump,dp);
24            }
25             else b=flips(i+1,1,jump,dp);
26        }
27        if(jump<1){
28            c=flips(i+1,parity,jump+1,dp);
29        }
30        return dp[i][parity][jump]=Math.min(c,Math.min(a,b));
31
32    }
33    public int minFlips(String S) {
34        s=S;
35        
36        int n=s.length(),ans=n,c=0;
37        int dp[][][]=new int[n][2][2];
38         for (int i = 0; i < n; i++) {
39            for (int j = 0; j < 2; j++) {
40                Arrays.fill(dp[i][j], -1);
41            }
42        }
43        
44        ans=Math.min(ans,flips(0,1,0,dp));
45         for (int i = 0; i < n; i++) {
46            for (int j = 0; j < 2; j++) {
47                Arrays.fill(dp[i][j], -1);
48            }
49        }
50        t=0;
51         ans=Math.min(ans,flips(0,0,0,dp));
52        return ans;
53    }
54}