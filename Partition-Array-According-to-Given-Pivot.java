1class Solution {
2    public int[] pivotArray(int[] nums, int pivot) {
3        int n=nums.length;
4        int arr[]=new int [n];
5        int c=0,cless=0;
6        for(int i=0;i<n;i++){
7            if(nums[i]==pivot) c++;
8           
9            else if(nums[i]<pivot) cless++;
10        }
11        int p1=0,p2=cless,p3=c+cless;
12        for(int i=0;i<n;i++){
13           if(nums[i]==pivot){
14            arr[p2]=pivot;
15            p2++;
16           }
17           else if(nums[i]<pivot){
18            arr[p1]=nums[i];
19            p1++;
20           }
21           else{
22            arr[p3]=nums[i];
23            p3++;
24           }
25          
26        }
27         return arr;
28        
29    }
30}