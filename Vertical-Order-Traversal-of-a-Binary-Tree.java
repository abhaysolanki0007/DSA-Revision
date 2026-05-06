1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public void dfs(TreeNode root,int pos,int level,  PriorityQueue<int[]>pq){
18        if(root==null) return;
19        pq.offer(new int[]{pos,level,root.val});
20        dfs(root.left,pos-1,level+1,pq);
21        dfs(root.right,pos+1,level+1,pq);
22    }
23    public List<List<Integer>> verticalTraversal(TreeNode root) {
24        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
25    if (a[0] == b[0] && a[1] == b[1]) 
26        return Integer.compare(a[2], b[2]);
27    if (a[0] == b[0]) 
28        return Integer.compare(a[1], b[1]);
29    return Integer.compare(a[0], b[0]);
30});
31        dfs(root,0,0,pq);
32        List<List<Integer>>ans=new ArrayList<>();
33        int prev=10000;
34        List<Integer>list=new ArrayList<>();
35        while(pq.size()>0){
36            int a[]=pq.poll();
37            int pos=a[0];
38            int level=a[1];
39            int value=a[2];
40            if(pos!=prev){
41                ans.add(new ArrayList<>(list));
42                list.clear();
43            }
44            list.add(value);
45            prev=pos;
46        }
47        ans.remove(0);
48          ans.add(new ArrayList<>(list));
49        return ans;
50
51    }
52}