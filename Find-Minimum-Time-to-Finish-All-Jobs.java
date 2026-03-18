1import java.util.*;
2
3class Solution {
4    int ans = Integer.MAX_VALUE;
5
6    public void backtrack(int[] jobs, int[] workers, int i) {
7        if (i == jobs.length) {
8            int max = 0;
9            for (int w : workers) max = Math.max(max, w);
10            ans = Math.min(ans, max);
11            return;
12        }
13
14        for (int j = 0; j < workers.length; j++) {
15            workers[j] += jobs[i];
16
17            // pruning
18            if (workers[j] < ans) {
19                backtrack(jobs, workers, i + 1);
20            }
21
22            // backtrack
23            workers[j] -= jobs[i];
24
25            // optimization: avoid duplicate states
26            if (workers[j] == 0) break;
27        }
28    }
29
30    public int minimumTimeRequired(int[] jobs, int k) {
31        int[] workers = new int[k];
32        backtrack(jobs, workers, 0);
33        return ans;
34    }
35}