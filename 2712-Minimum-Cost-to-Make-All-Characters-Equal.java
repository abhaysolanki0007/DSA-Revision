class Solution {
    public long minimumCost(String s) {
        int n=s.length();
        long ans=0;
        int i=1;
        char prev=s.charAt(0);
        while(i<n){
        while(i<n&&s.charAt(i)==prev){
            i++;
        }
        if(i>=n) break;
        // c++;
       if(i<=n/2) ans+=i;
       else ans+=n-i;
        prev=s.charAt(i);
       i++;
    }
    return ans;
    }
}