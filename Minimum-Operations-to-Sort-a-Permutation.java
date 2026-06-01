1class Solution {
2    public void rev(int nums[]){
3        int n=nums.length;
4        int i=0,j=n-1;
5        while(i<j){
6            int t=nums[i];
7            nums[i]=nums[j];
8            nums[j]=t;
9            i++;j--;
10        }
11    }
12     public int minOp(int[] nums,boolean flag) {
13        int n=nums.length,ans=(int)(1e9),c=0;
14         if(n==1&&nums[0]==0) return 0;
15        for(int i=1;i<n;i++){
16            if(nums[i-1]>nums[i]) c++;
17        }
18        if(nums[n-1]>nums[0]) c++;
19        if(c==1){
20             if(nums[n-1]>nums[0]) return 0;
21            for(int i=1;i<n;i++){
22            if(nums[i-1]>nums[i]){
23                ans=Math.min(ans,i);
24                 // if(flag==false) ans=Math.min(ans,1+n-i);
25                 ans=Math.min(ans,2+n-i);
26               if(flag==true) ans=Math.min(ans,n-i);
27                break;
28            }
29        }
30        }
31       return ans==(int)(1e9)?-1:ans; 
32    }
33    public int minOperations(int[] nums) {
34        int res=(int)(1e9);
35        if(minOp(nums,false)!=-1) res=minOp(nums,false);
36        rev(nums);
37        if(minOp(nums,true)!=-1) res=Math.min(res,1+minOp(nums,true));
38        return res==(int)(1e9)?-1:res;
39    }
40}