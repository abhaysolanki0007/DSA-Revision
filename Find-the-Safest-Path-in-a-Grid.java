1class Solution {
2    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
3
4    public int maximumSafenessFactor(List<List<Integer>> grid) {
5        int n = grid.size();
6
7        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
8            return 0;
9
10        int[][] A = new int[n][n];
11
12        for (int i = 0; i < n; i++)
13            for (int j = 0; j < n; j++)
14                A[i][j] = grid.get(i).get(j);
15
16        Queue<int[]> q = new LinkedList<>();
17
18        for (int i = 0; i < n; i++)
19            for (int j = 0; j < n; j++)
20                if (A[i][j] == 1)
21                    q.add(new int[]{i, j});
22
23        while (q.size() > 0) {
24            int[] head = q.poll();
25            int i = head[0];
26            int j = head[1];
27            int v = A[i][j];
28
29            for (int[] d : dirs) {
30                int x = i + d[0];
31                int y = j + d[1];
32
33                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && A[x][y] == 0) {
34                    A[x][y] = v + 1;
35                    q.add(new int[]{x, y});
36                }
37            }
38        }
39
40        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
41        pq.add(new int[]{A[0][0], 0, 0});
42
43        while (pq.size() > 0) {
44            int[] head = pq.poll();
45            int sf = head[0];
46            int i = head[1];
47            int j = head[2];
48
49            if (i == n - 1 && j == n - 1)
50                return sf - 1;
51
52            for (int[] d : dirs) {
53                int x = i + d[0];
54                int y = j + d[1];
55
56                if (Math.min(x, y) >= 0 && Math.max(x, y) < n && A[x][y] > 0) {
57                    pq.add(new int[]{Math.min(sf, A[x][y]), x, y});
58                    A[x][y] *= -1;
59                }
60            }
61        }
62
63        return A[n - 1][n - 1] - 1;
64    }
65}