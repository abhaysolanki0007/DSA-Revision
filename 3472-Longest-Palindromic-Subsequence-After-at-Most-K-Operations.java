class Solution {
    public int dp[][][];
    public int diff(int i,int j,String s){
        int a=s.charAt(i)-'a';
        int b=s.charAt(j)-'a';
        int d=Math.abs(a-b);
        return Math.min(d,26-d);
    }
    public int longest(int i,int j,String s,int k){
        if(i==j) return 1;
        if(i>j) return 0;
        if(dp[i][j][k]!=-1) return dp[i][j][k];
       int take=0;
       if(diff(i,j,s)<=k){
            take=2+longest(i+1,j-1,s,k-diff(i,j,s));
        }
       int nottake1=longest(i+1,j,s,k);
         int nottake2=longest(i,j-1,s,k);
         return dp[i][j][k]=Math.max(take,Math.max(nottake1,nottake2));
    }
    public int longestPalindromicSubsequence(String s, int k) {
        int n=s.length();
        dp=new int[n][n][k+1];
        for(int row[][]:dp){
            for(int col[]:row){
                Arrays.fill(col,-1);
            }
        }
        
        return longest(0,n-1,s,k);
    }
}