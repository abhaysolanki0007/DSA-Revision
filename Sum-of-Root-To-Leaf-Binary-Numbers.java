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
17    int ans=0;
18    public void sum(TreeNode root,StringBuilder sb){
19        
20        if(root!=null&&root.left==null&&root.right==null){
21              sb.append(root.val);
22             ans+=Integer.parseInt(sb.toString(),2);
23              sb.deleteCharAt(sb.length()-1);
24             return;
25        }
26        if(root==null) return;
27        sb.append(root.val);
28        sum(root.left,sb);
29      
30        sum(root.right,sb);
31        sb.deleteCharAt(sb.length()-1);
32    }
33    public int sumRootToLeaf(TreeNode root) {
34        StringBuilder sb=new StringBuilder();
35        sum(root,sb);
36        return ans;
37    }
38}