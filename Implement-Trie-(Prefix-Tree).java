1
2class TrieNode {
3    TrieNode[] children;
4    boolean isEnd;
5    public TrieNode() {
6        children = new TrieNode[26]; // a-z
7        isEnd = false;
8    }
9}
10class Trie {
11private TrieNode root;
12
13    public Trie() {
14        root = new TrieNode();
15    }
16    
17    public void insert(String word) {
18           TrieNode node = root;
19        for(char ch:word.toCharArray()){
20            int index=ch-'a';
21            if(node.children[index]==null){
22                node.children[index]=new TrieNode();
23            }
24            node=node.children[index];
25        }
26        node.isEnd=true;
27        
28    }
29    
30    public boolean search(String word) {
31           TrieNode node = root;
32        for(char ch:word.toCharArray()){
33            int index=ch-'a';
34            if(node.children[index]==null){
35                return false;
36                // node.children[index]=new TrieNode();
37            }
38            node=node.children[index];
39        }
40        return node.isEnd;
41    }
42    
43    public boolean startsWith(String word) {
44           TrieNode node = root;
45         for(char ch:word.toCharArray()){
46            int index=ch-'a';
47            if(node.children[index]==null){
48                return false;
49                // node.children[index]=new TrieNode();
50            }
51            node=node.children[index];
52        }
53        return true;
54    }
55}
56
57/**
58 * Your Trie object will be instantiated and called as such:
59 * Trie obj = new Trie();
60 * obj.insert(word);
61 * boolean param_2 = obj.search(word);
62 * boolean param_3 = obj.startsWith(prefix);
63 */