1
2
3class Solution {
4    
5    // Function to check if a single digit or a two-digit number is a valid decoding
6    private boolean isvalid(String s, int i) {
7       // No valid decoding starts with '0'
8        if (i + 1 < s.length()) {
9            int num = Integer.parseInt(s.substring(i, i + 2));
10            return num >= 1 && num <= 26;
11        }
12        return true; // Single digit is valid
13    }
14    
15    // Helper function to calculate the number of ways to decode the string
16    private int f(int i, String s, int[] dp) {
17        if (i >= s.length()) return 1; // Reached the end, return 1 way to decode
18        if (dp[i] != -1) return dp[i]; // Return memoized result if exists
19        
20        int take = 0, not = 0;
21          if (s.charAt(i) == '0') return 0;
22        
23        // Option 1: Skip the current digit
24        not = f(i + 1, s, dp);
25        
26        // Option 2: Take the current digit and the next one (if valid)
27        if (i + 1 < s.length() && isvalid(s, i)) {
28            take = f(i + 2, s, dp);
29        }
30        
31        return dp[i] = take + not; // Store and return the result
32    }
33
34    public int numDecodings(String s) {
35        int n = s.length();
36        int[] dp = new int[n + 1]; // dp array to store the results
37        Arrays.fill(dp, -1); // Initialize dp array with -1 for memoization
38        return f(0, s, dp); // Start the recursion from index 0
39    }
40}