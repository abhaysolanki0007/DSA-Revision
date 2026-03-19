1class Solution {
2
3    int[] cost;
4
5    public void givecost(int jobs[]) {
6        int n = jobs.length;
7        int size = 1 << n;
8        cost = new int[size];
9
10        for (int mask = 0; mask < size; mask++) {
11            int sum = 0;
12            for (int j = 0; j < n; j++) {
13                if (((mask >> j) & 1) == 1) {
14                    sum += jobs[j];
15                }
16            }
17            cost[mask] = sum;
18        }
19    }
20
21    public int time(int jobs[], int k, int mask,int dp[][]) {
22
23        if (mask == 0) return 0;
24        if (k == 0) return Integer.MAX_VALUE;
25        if(dp[k][mask]!=-1) return dp[k][mask];
26
27        int ans = Integer.MAX_VALUE;
28
29        for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
30            int curr = cost[sub];
31            int next = time(jobs, k - 1, mask ^ sub,dp);
32
33            if (next != Integer.MAX_VALUE) {
34                ans = Math.min(ans, Math.max(curr, next));
35            }
36        }
37
38        return dp[k][mask]=ans;
39    }
40
41    public int minimumTimeRequired(int[] jobs, int k) {
42        int n=jobs.length;
43        int dp[][]=new  int[k+1][1<<n];
44        for(int row[]:dp){
45            Arrays.fill(row,-1);
46        }
47        givecost(jobs);
48
49        return time(jobs, k, (1 << jobs.length) - 1,dp);
50    }
51}