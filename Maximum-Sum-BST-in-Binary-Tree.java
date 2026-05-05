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
17    public int ans=0;
18    public int[] maxsum(TreeNode root){
19        if(root==null) return new int[]{0,0,0};
20        if(root.left==null&&root.right==null){
21             ans=Math.max(ans,root.val);
22            return new int[]{root.val,root.val,root.val};
23        }
24        int left[]=maxsum(root.left);
25          int right[]=maxsum(root.right);
26          int min=(int)(1e9);
27           int max=-(int)(1e9);
28           if(root.right!=null){min=Math.min(right[0],min);
29           }
30            if(root.left!=null){
31                // min=Math.min(min,root.left.val);
32                max=Math.max(max,left[1]);
33            }
34            int sum= left[2]+right[2]+root.val;
35            if(root.val<min&&root.val>max){ans=Math.max(ans,sum); 
36             if(root.right!=null){
37            max=Math.max(max,right[1]);
38           }
39            if(root.left!=null){
40                min=Math.min(min,left[0]);
41                max=Math.max(max,left[1]);
42            }return new int[]{
43              Math.min(min,root.val),Math.max(root.val,max),sum};
44                }
45          return new int[]{-(int)(1e9),(int)(1e9),sum};
46    }
47    public int maxSumBST(TreeNode root) {
48        maxsum(root);
49        return ans;
50    }
51}