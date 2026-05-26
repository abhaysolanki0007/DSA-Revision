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
17    public int res=Integer.MIN_VALUE;
18    public int maxPath(TreeNode root) {
19        if(root==null) return 0;
20        int a=maxPath(root.left);
21        int b=maxPath(root.right);
22        int ans=root.val;
23        ans=Math.max(ans,root.val+a);
24         ans=Math.max(ans,root.val+b);
25         res=Math.max(res,ans);
26           res=Math.max(res,root.val+a+b);
27           return ans;
28    }
29
30    public int maxPathSum(TreeNode root) {
31        maxPath(root);
32        return res;
33    }
34}