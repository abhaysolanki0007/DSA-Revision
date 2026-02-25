1class Solution {
2    public int[] sortByBits(int[] arr) {
3        int n=arr.length;
4        int nums[][]=new int[n][2];
5        for(int i=0;i<n;i++){
6            nums[i][0]=arr[i];
7            nums[i][1]=Integer.bitCount(arr[i]);
8        }
9        Arrays.sort(nums,(a,b)->{
10            if(a[1]==b[1]) return  Integer.compare(a[0],b[0]);
11           return Integer.compare(a[1],b[1]);
12        });
13         for(int i=0;i<n;i++){
14            arr[i]=nums[i][0];
15         }
16         return arr;
17    }
18}