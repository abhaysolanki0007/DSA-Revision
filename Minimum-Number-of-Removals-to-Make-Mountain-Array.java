1class Solution {
2    public int minimumMountainRemovals(int[] nums) {
3        int n = nums.length;
4        int[] lis = new int[n];
5        int[] lds = new int[n];
6        
7        // Calculate LIS ending at each index
8        Arrays.fill(lis, 1);
9        for (int i = 0; i < n; i++) {
10            for (int j = 0; j < i; j++) {
11                if (nums[j] < nums[i]) {
12                    lis[i] = Math.max(lis[i], lis[j] + 1);
13                }
14            }
15        }
16        
17        // Calculate LDS starting at each index (decreasing from right)
18        Arrays.fill(lds, 1);
19        for (int i = n - 1; i >= 0; i--) {
20            for (int j = n - 1; j > i; j--) {
21                if (nums[j] < nums[i]) {
22                    lds[i] = Math.max(lds[i], lds[j] + 1);
23                }
24            }
25        }
26        
27        // Find the longest mountain
28        int maxMountain = 0;
29        for (int i = 1; i < n - 1; i++) {
30            if (lis[i] > 1 && lds[i] > 1) { // Valid peak
31                maxMountain = Math.max(maxMountain, lis[i] + lds[i] - 1);
32            }
33        }
34        
35        // Minimum removals = total length - longest mountain length
36        return n - maxMountain;
37    }
38}