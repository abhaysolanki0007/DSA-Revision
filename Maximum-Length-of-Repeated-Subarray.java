1class Solution {
2    public int findLength(int[] nums1, int[] nums2) {
3        int n=nums1.length,m=nums2.length,ans=0;
4        for(int i=0;i<n;i++){
5          int temp=i,j=0,c=0;
6           while(temp<n&&j<m){
7            if(nums1[temp]==nums2[j]){
8                temp++;j++;c++;
9            }
10            else{
11                  if(c==0) j++;
12                temp=i;c=0;
13                
14            }
15            ans=Math.max(ans,c);
16           }
17        }
18         for(int i=0;i<m;i++){
19          int temp=i,j=0,c=0;
20           while(temp<m&&j<n){
21            if(nums2[temp]==nums1[j]){
22                temp++;j++;c++;
23            }
24            else{
25                if(c==0) j++;
26                temp=i;c=0;
27                
28            }
29            ans=Math.max(ans,c);
30           }
31        }
32        return ans;
33    }
34}