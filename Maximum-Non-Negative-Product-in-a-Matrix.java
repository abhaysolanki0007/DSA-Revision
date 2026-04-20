1class Solution {
2    int mod = (int)(1e9 + 7);
3    public Map<String, long[]> map = new HashMap<>();
4    public long[] dfs(int i, int j, int grid[][]) {
5        int n = grid.length, m = grid[0].length;
6        String key=i+" "+j;
7        if(map.containsKey(key)) return map.get(key);
8        if (i == n - 1 && j == m - 1) {
9            return new long[]{grid[i][j], grid[i][j]};
10        }
11        if (i + 1 < n && j + 1 < m) {
12            long right[] = dfs(i, j + 1, grid);
13            long down[] = dfs(i + 1, j, grid);
14
15            long maxi = Math.max(right[0], down[0]);
16            long mini = Math.min(right[1], down[1]);
17
18            if (grid[i][j] < 0) {
19                return new long[]{mini * grid[i][j], maxi * grid[i][j]};
20            }
21            map.put(key, new long[]{maxi * grid[i][j], mini * grid[i][j]});
22            return map.get(key);
23        }
24
25        if (i + 1 < n) {
26            long arr[] = dfs(i + 1, j, grid);
27            if (grid[i][j] < 0) {
28                return new long[]{arr[1] * grid[i][j], arr[0] * grid[i][j]};
29            }
30            return new long[]{arr[0] * grid[i][j], arr[1] * grid[i][j]};
31        }
32
33        if (j + 1 < m) {
34            long arr[] = dfs(i, j + 1, grid);
35            if (grid[i][j] < 0) {
36                return new long[]{arr[1] * grid[i][j], arr[0] * grid[i][j]};
37            }
38            return new long[]{arr[0] * grid[i][j], arr[1] * grid[i][j]};
39        }
40
41        return new long[0];
42    }
43
44    public int maxProductPath(int[][] grid) {
45        long ans[] = dfs(0, 0, grid);
46        long res = Math.max(ans[0], ans[1]);
47
48        if (res < 0) return -1;
49
50        return (int)(res % mod);
51    }
52}