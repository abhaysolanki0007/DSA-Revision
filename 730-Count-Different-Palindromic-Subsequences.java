class Solution {
    public int MOD=(int)(1e9+7);
    public Long dp[][];
    public long f(int i,int j,String s){
        if(i==j) return 1;
        if(i>j) return 0;
            long ans=0;
        if(dp[i][j]!=null) return dp[i][j];
        if(s.charAt(j)==s.charAt(i)){
           
            ans+=2*f(i+1,j-1,s);
            int l=i+1,r=j-1;
            while(l<=r&&s.charAt(l)!=s.charAt(i)) l++;
            while(r>l&&s.charAt(r)!=s.charAt(j)) r--;
            if(l==r) ans++;
            else if(l>r) ans+=2;
            ans-=f(l+1,r-1,s)%MOD;
           
        }
        else{
            ans=(f(i+1,j,s)+f(i,j-1,s)-f(i+1,j-1,s))%MOD;
        }
         ans = (ans % MOD + MOD) % MOD;

        return dp[i][j] = ans;
    }
    public int countPalindromicSubsequences(String s) {
        int n=s.length();
        dp=new Long[n][n];
      return (int)(f(0,s.length()-1,s)%MOD);
    }
}