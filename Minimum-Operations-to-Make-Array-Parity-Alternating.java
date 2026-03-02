1import java.util.*;
2
3class Solution {
4
5    public int[] solve(int[] nums, boolean even) {
6         List<Integer> list=new ArrayList<>();
7        int op = 0;
8        int max= Integer.MIN_VALUE;
9        int min = Integer.MAX_VALUE;
10        for (int num : nums) {
11            if ((num % 2 != 0 && even) || (num % 2 == 0 && !even)) {
12                op++;
13               list.add(num);
14            }
15            else{
16            max=Math.max(max,num);
17            min=Math.min(min,num);
18            }
19            even = !even;
20        }
21        
22        Collections.sort(list);
23        int size=list.size();
24        if(size==0){
25              if(max-min==0)  return new int[]{op,1};
26             return new int[]{op,max-min};
27        }
28         max= Math.max(max,list.get(size-1)-1);
29          min=Math.min(min,list.get(0)+1);
30          if(max-min==0)  return new int[]{op,1};
31        return new int[]{op,max-min};
32        
33    }
34
35    public int[] makeParityAlternating(int[] nums) {
36        int n = nums.length;
37
38        // Case when n == 1
39        if (n == 1) return new int[]{0, 0};
40
41        // Case when all elements are same
42        Set<Integer> set = new HashSet<>();
43        for (int x : nums) set.add(x);
44
45        if (set.size() == 1) {
46            return new int[]{n / 2, 1};
47        }
48
49      int res1[]= solve(nums, false); // start with odd index even = false
50        int res2[] = solve(nums, true);  // start with even index even = true
51
52        if (res1[0] == res2[0]) {
53            return res1[1] < res2[1] ? res1 : res2;
54        }
55
56        return res1[0] < res2[0] ? res1 : res2;
57    }
58}