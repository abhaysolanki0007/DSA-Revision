class Solution {
    public int longestSubsequence(int[] arr, int diff) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int m=arr.length,ans=1;
        for(int i=0;i<m;i++){
            if(map.containsKey(arr[i])){
                ans=Math.max(ans,map.get(arr[i]));
            }
           else map.put(arr[i],1);
             map.put(arr[i]+diff,1+map.get(arr[i]));
        }
        return ans;
    }
}