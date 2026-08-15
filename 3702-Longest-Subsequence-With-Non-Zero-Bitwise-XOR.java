class Solution {
    public int longestSubsequence(int[] nums) {
        int cnt=0,n=nums.length,xor=0;
        for(int a:nums){
            if(a!=0) cnt=1;
            xor^=a;
        }
        if(cnt==0) return 0;
        if(xor!=0) return n; 
        return n-1;
    }
}