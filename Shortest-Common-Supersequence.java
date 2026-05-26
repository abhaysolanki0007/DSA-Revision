1class Solution {
2    public int maxi=(int)(1e9);
3    public String shortestCommonSupersequence(String str1, String str2) {
4         int n=str1.length(),m=str2.length();
5        int [][]dp=new int[n+1][m+1];
6         for(int row[]:dp){
7            Arrays.fill(row,maxi);
8         }
9        dp[n][m]=0;
10         for(int i=n;i>=0;i--){
11            dp[i][m]=n-i;
12            }
13            for(int i=m;i>=0;i--){
14            dp[n][i]=m-i;
15            }
16        for(int i=n-1;i>=0;i--){
17             for(int j=m-1;j>=0;j--){
18               if(str1.charAt(i)==str2.charAt(j)){  dp[i][j]=Math.min(dp[i][j],1+dp[i+1][j+1]);}
19                 dp[i][j]=Math.min(dp[i][j],1+dp[i][j+1]);
20                   dp[i][j]=Math.min(dp[i][j],1+dp[i+1][j]);
21             }
22        }
23        int i=0,j=0;
24        StringBuilder ans=new StringBuilder();
25        while(i<n&&j<m){
26            if(str1.charAt(i)==str2.charAt(j)){
27                ans.append(str1.charAt(i));
28                 i++;j++;
29            }
30               else if(dp[i+1][j]<dp[i][j]){
31                    ans.append(str1.charAt(i));i++;
32                }
33                else  if(dp[i][j+1]<dp[i][j]){
34                    ans.append(str2.charAt(j));j++;
35                }
36             }
37               if(i<n){
38                ans.append(str1.substring(i,n));
39               }
40               if(j<m){
41               ans.append(str2.substring(j,m));
42               }
43               return ans.toString();
44         }
45    }