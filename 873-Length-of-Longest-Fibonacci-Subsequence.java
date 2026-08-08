class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n=arr.length,ans=0;
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(arr[i],i);
        }
         int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,2);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                int diff=arr[i]-arr[j];
                if(map.containsKey(diff)){
                int ind=map.get(diff);
                if(ind<j){
                dp[j][i]=Math.max(dp[j][i],1+dp[ind][j]);
                ans=Math.max(dp[j][i],ans);
                }
                }
            }
        }
        return ans;
    }
}