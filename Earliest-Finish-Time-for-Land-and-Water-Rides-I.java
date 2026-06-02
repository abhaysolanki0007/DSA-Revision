1class Solution {
2    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
3        int n=landStartTime.length;
4        int m=waterStartTime.length;
5        int ans=Integer.MAX_VALUE;
6        for(int i=0;i<n;i++){
7            int timeland= landStartTime[i];
8            int durationland=landDuration[i];
9            for(int j=0;j<m;j++){
10                 int timewater=waterStartTime[j];
11            int durationwater=waterDuration[j];
12                if(timewater<= timeland+durationland){
13                    ans=Math.min(ans, timeland+durationland+durationwater);
14                }
15                else{
16                    ans=Math.min(ans, timewater+durationwater);
17                }
18            }
19        }
20         for(int i=0;i<m;i++){
21            int timewater=waterStartTime[i];
22            int durationwater=waterDuration[i];
23            for(int j=0;j<n;j++){
24                  int timeland= landStartTime[j];
25            int durationland=landDuration[j];
26                if(timeland<= timewater+durationwater){
27                    ans=Math.min(ans, durationland+timewater+durationwater);
28                }
29                else{
30                    ans=Math.min(ans, timeland+durationland);
31                }
32            }
33        }
34        return ans;
35        
36    }
37}