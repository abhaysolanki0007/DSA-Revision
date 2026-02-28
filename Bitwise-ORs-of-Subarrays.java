1class Solution {
2    public int subarrayBitwiseORs(int[] arr) {
3        int n=arr.length;
4      Set<Integer> prev = new HashSet<>();
5        Set<Integer> ans = new HashSet<>();
6for (int i = 0; i < n; i++) {
7     Set<Integer> set = new HashSet<>();
8    for (int a : prev) {
9        set.add(arr[i] | a);
10    }
11    set.add(arr[i]);
12    ans.addAll(set);
13     prev=set;
14        }
15        return ans.size();
16    }
17}