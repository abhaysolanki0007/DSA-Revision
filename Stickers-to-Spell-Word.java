1class Solution {
2    public int maxi=(int)(1e9);
3    public int dp[];
4    public boolean canmake(String b,String a){
5        int freq1[]=new int[26];
6        int n=a.length(),m=b.length();
7        for(int i=0;i<n;i++){
8            char ch=a.charAt(i);
9            freq1[ch-'a']++;
10        }
11         for(int i=0;i<m;i++){
12            char ch=b.charAt(i);
13            freq1[ch-'a']--;
14        }
15         for(int i=0;i<26;i++){
16            if(freq1[i]>0) return false;
17         }
18         return true;
19    }
20    public Set<Integer>set=new HashSet<>();
21    public int sticker(String target,int xor){
22        if(xor==0) return 0;
23        if(dp[xor]!=-1) return dp[xor];
24        int ans=maxi;
25        for(int i=xor;i>0;i=((i-1)&(xor))){
26            if(set.contains(i)){
27                ans=Math.min(ans,1+sticker(target,i^xor));
28            }
29        }
30        return dp[xor]=ans;
31    }
32    public int minStickers(String[] stickers, String target) {
33       
34        int n=target.length(),m=stickers.length;
35         dp=new int[1<<n];
36         Arrays.fill(dp,-1);
37
38        for(int i=0;i<(int)(Math.pow(2,n));i++){
39            StringBuilder sb=new StringBuilder();
40              for(int j=0;j<31;j++){
41                if(((1<<j)&(i))!=0) sb.append(target.charAt(j));
42              }
43              for(int k=0;k<m;k++){
44                if(canmake(stickers[k],sb.toString())){
45                    set.add(i);break;
46                }
47              }
48        }
49        int ans=sticker(target,(1<<n)-1);
50        if(ans==maxi) return -1;
51        return ans;
52    }
53}