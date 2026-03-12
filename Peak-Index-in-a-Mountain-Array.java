1class Solution {
2    public int peakIndexInMountainArray(int[] arr) {
3        int low=1,high=arr.length-2;
4        while(low<=high){
5            int mid=(low+high)/2;
6           
7            if(arr[mid-1]<arr[mid]&&arr[mid]>arr[mid+1]){
8                return mid;
9            }
10           else  if(arr[mid-1]<arr[mid]){
11                low=mid+1;
12            }
13            else{
14                high=mid-1;
15            }
16            
17        }
18        return 0;
19    }
20}