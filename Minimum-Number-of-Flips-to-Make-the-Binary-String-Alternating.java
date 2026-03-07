1class Solution {
2    public int minFlips(String s) {
3        int n = s.length(), ans = n;
4        int arr1[][] = new int[n][2];
5        int cur = 0, flips = 0;
6        s=s+s;
7
8        // for (int i = n - 1; i >= 0; i--) {
9        //     int ch = s.charAt(i) - '0';
10        //     if (ch != cur) flips++;
11
12        //     if (cur == 0) arr1[i][0] = flips;
13        //     else arr1[i][1] = flips;
14
15        //     cur = (cur + 1) % 2;
16        // }
17
18        // cur = 1; flips = 0;
19        // for (int i = n - 1; i >= 0; i--) {
20        //     int ch = s.charAt(i) - '0';
21        //     if (ch != cur) flips++;
22
23        //     if (cur == 0) arr1[i][0] = flips;
24        //     else arr1[i][1] = flips;
25
26        //     cur = (cur + 1) % 2;
27        // }
28
29        // case when no rotation
30        // ans = Math.min(arr1[0][0], arr1[0][1]);
31
32        flips = 0;
33        cur = 0;
34        HashMap<Integer,Integer>map=new HashMap<>();
35        for (int i = 0; i < 2*n; i++) {
36            int ch = s.charAt(i) - '0';
37            if (ch != cur) flips++;
38           if(i>=n){
39            ans=Math.min(ans,flips-map.get(i-n));
40           }
41           map.put(i,flips);
42            cur = (cur + 1) % 2;
43        }
44        map.clear();
45        cur = 1; flips = 0;
46
47        for (int i = 0; i < 2*n; i++) {
48            int ch = s.charAt(i) - '0';
49            if (ch != cur) flips++;
50           if(i>=n){
51            ans=Math.min(ans,flips-map.get(i-n));
52           }
53            map.put(i,flips);
54            cur = (cur + 1) % 2;
55        }
56
57        return ans;
58    }
59}