1class Solution {
2    public int f(long a){
3        return (int)((Math.sqrt(1+8*a)-1)/2);
4    }
5    public long possible(long mid,int[]nums){
6        long sum=0;
7        for(int i=0;i<nums.length;i++){
8            long a=mid/nums[i];
9            sum+=f(a);
10        }
11        return sum;
12    }
13    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
14        long low=1,high=100000000000000000L;
15        long ans=0;
16        while(low<=high){
17            long mid=low+(high-low)/2;
18            if(possible(mid,workerTimes)>=(long)mountainHeight){
19                ans=mid;
20                high=mid-1;
21            }
22            else low=mid+1;
23        }
24        return ans;
25    }
26}