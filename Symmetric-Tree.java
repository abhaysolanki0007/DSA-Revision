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
17    public boolean dfs(TreeNode root,TreeNode root2){
18        if(root==null&&root2==null) return true;
19        if(root==null||root2==null) return false;
20        //  if(root.right==null&&root.left==null&&root2.right==null&&root2.left==null) return true;
21        // if(root2.right!=null&&root.left!=null&&root.left.val!=root2.right.val){
22        //     return false;
23        // }
24        //  if(root2.left!=null&&root.right!=null&&root.right.val!=root2.left.val){
25        //     return false;
26        // }
27        // if(root2.right==null) return false;
28        // if(root.left==null) return false;
29         
30        //     if(root.right==null) return false;
31        // if(root2.left==null) return false;
32        if(root.val!=root2.val) return false;
33        boolean a=dfs(root.left,root2.right);
34        boolean b=dfs(root.right,root2.left);
35        return a&b;
36    }
37    public boolean isSymmetric(TreeNode root) {
38        if(root.left==null&&root.right==null) return true;
39        if(root.left!=null&&root.right!=null){
40            if(root.left.val!=root.right.val) return false;
41        }
42         if(root.left==null||root.right==null){return false;}
43        return dfs(root.left,root.right);
44
45
46    }
47}