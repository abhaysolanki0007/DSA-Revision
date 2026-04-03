1import java.util.*;
2
3class Node {
4    Node[] lists = new Node[26];
5    boolean flag = false;
6
7    Node() {
8        Arrays.fill(lists, null);
9    }
10}
11
12class Trie {
13    Node root;
14
15    Trie() {
16        root = new Node();
17    }
18
19    void insert(String word) {
20        Node node = root;
21        for (char c : word.toCharArray()) {
22            int ch = c - 'a';
23            if (node.lists[ch] == null) {
24                node.lists[ch] = new Node();
25            }
26            node = node.lists[ch];
27            node.flag = true;
28        }
29    }
30
31    List<Integer> search(String target, int start) {
32        List<Integer> validLengths = new ArrayList<>();
33        Node node = root;
34
35        for (int i = start; i < target.length(); i++) {
36            int idx = target.charAt(i) - 'a';
37            if (node.lists[idx] == null) break;
38
39            node = node.lists[idx];
40            if (node.flag) {
41                validLengths.add(i - start + 1);
42            }
43        }
44
45        return validLengths;
46    }
47}
48
49class Solution {
50    public int minValidStrings(String[] words, String target) {
51        Trie trie = new Trie();
52
53        for (String word : words) {
54            trie.insert(word);
55        }
56
57        int n = target.length();
58        int[] dp = new int[n + 1];
59        Arrays.fill(dp, Integer.MAX_VALUE);
60
61        dp[0] = 0;
62
63        for (int i = 0; i < n; i++) {
64            if (dp[i] == Integer.MAX_VALUE) continue;
65
66            List<Integer> lengths = trie.search(target, i);
67
68            for (int len : lengths) {
69                dp[i + len] = Math.min(dp[i + len], dp[i] + 1);
70            }
71        }
72
73        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
74    }
75}