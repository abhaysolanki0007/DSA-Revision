1class Solution {
2    public int maxChunksToSorted(int[] arr) {
3        int n=arr.length;
4        int max=0,ans=0;
5        int i=0;
6        while(i<n){
7            
8            max=Math.max(arr[i],max);
9            if(max==i) ans++;
10            i++;
11        }
12        return ans;
13        
14    }
15}