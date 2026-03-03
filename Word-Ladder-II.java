1import java.util.*;
2
3class Solution {
4
5    private Set<String> visit = new HashSet<>();
6    private Map<String, List<String>> graph = new HashMap<>();
7    private List<List<String>> ans = new ArrayList<>();
8
9    // Add vertex
10    public void addVertex(String node) {
11        graph.putIfAbsent(node, new ArrayList<>());
12    }
13
14    // Add edge (reverse edge for DFS from endWord → beginWord)
15    public void addEdge(String src, String dest) {
16        graph.putIfAbsent(src, new ArrayList<>());
17        graph.putIfAbsent(dest, new ArrayList<>());
18
19        graph.get(dest).add(src);   // reverse direction
20    }
21
22    // DFS to build all shortest paths
23    public void dfs(String curr, List<String> list, String beginWord) {
24
25        list.add(curr);
26
27        if (curr.equals(beginWord)) {
28            List<String> temp = new ArrayList<>(list);
29            Collections.reverse(temp);
30            ans.add(temp);
31            list.remove(list.size() - 1);
32            return;
33        }
34
35        visit.add(curr);
36
37        for (String neighbor : graph.getOrDefault(curr, new ArrayList<>())) {
38            if (!visit.contains(neighbor)) {
39                dfs(neighbor, list, beginWord);
40            }
41        }
42
43        visit.remove(curr);
44        list.remove(list.size() - 1);
45    }
46
47    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
48
49        Set<String> wordSet = new HashSet<>(wordList);
50        if (!wordSet.contains(endWord)) return ans;
51
52        Queue<String> queue = new LinkedList<>();
53        Set<String> visited = new HashSet<>();
54
55        queue.add(beginWord);
56        visited.add(beginWord);
57
58        boolean found = false;
59
60        while (!queue.isEmpty() && !found) {
61
62            Set<String> visitedThisLevel = new HashSet<>();
63            int size = queue.size();
64
65            for (int i = 0; i < size; i++) {
66
67                String current = queue.poll();
68                addVertex(current);
69
70                char[] chars = current.toCharArray();
71
72                for (int j = 0; j < chars.length; j++) {
73
74                    char original = chars[j];
75
76                    for (char c = 'a'; c <= 'z'; c++) {
77
78                        if (c == original) continue;
79
80                        chars[j] = c;
81                        String transformed = new String(chars);
82
83                        if (transformed.equals(endWord) ||
84                                (wordSet.contains(transformed) && !visited.contains(transformed))) {
85
86                            if (!visitedThisLevel.contains(transformed)) {
87                                queue.add(transformed);
88                                visitedThisLevel.add(transformed);
89                            }
90
91                            addEdge(current, transformed);
92
93                            if (transformed.equals(endWord)) {
94                                found = true;
95                            }
96                        }
97                    }
98
99                    chars[j] = original;
100                }
101            }
102
103            visited.addAll(visitedThisLevel);
104        }
105
106        if (!found) return ans;
107
108        dfs(endWord, new ArrayList<>(), beginWord);
109        return ans;
110    }
111}