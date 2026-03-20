1
2
3public class Solution {
4    public int[][] minAbsDiff(int[][] grid, int k) {
5        int m = grid.length;
6        int n = grid[0].length;
7        int[][] ans = new int[m - k + 1][n - k + 1];
8        
9        for (int i = 0; i <= m - k; i++) {
10            for (int j = 0; j <= n - k; j++) {
11                List<Integer> element = new ArrayList<>();
12                 List<Integer> elements = new ArrayList<>();
13                for (int x = i; x < i + k; x++) {
14                    for (int y = j; y < j + k; y++) {
15                        element.add(grid[x][y]);
16                    }
17                }
18                for(int a:element){
19                    if(!elements.contains(a)) elements.add(a);
20                }
21                Collections.sort(elements);
22                int minDiff = Integer.MAX_VALUE;
23                for (int l = 1; l < elements.size(); l++) {
24                    int diff = Math.abs(elements.get(l) - elements.get(l - 1));
25                    if (diff < minDiff) {
26                        minDiff = diff;
27                    }
28                }
29                ans[i][j] = minDiff == Integer.MAX_VALUE ? 0 : minDiff;
30            }
31        }
32        return ans;
33    }
34}