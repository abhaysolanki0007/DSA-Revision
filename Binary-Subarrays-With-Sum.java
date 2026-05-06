1class Solution {
2    public int numSubarraysWithSum(int[] nums, int goal) {
3        int n=nums.length;
4        int l=0,r=0;
5        int ans=0,sum=0;
6        while(r<n){
7            sum+=nums[r];
8            int c=0;
9            boolean flag=false;
10            if(goal>0){
11            while(sum==goal&&l<=r){
12                c++;
13                if(nums[l]==1) sum--;
14                l++;
15            }
16            }
17            else{
18                while(r<n&&nums[r]==0){
19                    c++;
20                ans+=c;
21                r++;
22                flag=true;
23                }
24            }
25           
26             while(l<=r&&sum>goal){
27                 if(nums[l]==1) sum--;
28                l++;
29             }
30              if(r<n&&flag==false){
31            ans+=c;
32            r++;
33           if(goal>0) while(r<n&&nums[r]==0){ans+=c;r++;}
34            }
35        }
36        return ans;
37
38    }
39}