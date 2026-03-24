1class Solution {
2    public int maxFrequency(int[] nums, int k, int numOperations) {
3        Arrays.sort(nums);
4        int freq[]=new int[1000000];
5        for(int a:nums){
6            freq[a]++;
7        }
8        // prefix sum freq arr
9        for(int i=1;i<500000;i++){
10            freq[i]=freq[i]+freq[i-1];
11        }
12        int ans=0;
13        for(int i=1;i<100001;i++){
14          int canchange=freq[i+k]-freq[Math.max(0,i-k-1)];
15        //   System.out.println(canchange);
16          int count =freq[i]-freq[i-1];
17          ans=Math.max(ans,count+Math.min(canchange-count,numOperations));
18        }
19        return ans;
20    }
21}