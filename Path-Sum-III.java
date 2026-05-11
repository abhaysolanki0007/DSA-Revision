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
17    public HashMap<Long,Integer>map=new HashMap<>();
18    public  int ans=0;
19    public void dfs(TreeNode root,long sum, long targetSum){
20        if(root==null) return;
21        long sum2=root.val+sum;
22        if(sum2==targetSum) ans++;
23        if(map.containsKey(sum2-targetSum)) ans+=map.get(sum2-targetSum);
24        map.put(sum2,map.getOrDefault(sum2,0)+1);
25        dfs(root.left,sum2,targetSum);
26        dfs(root.right,sum2,targetSum);
27        map.put(sum2,map.get(sum2)-1);
28    }
29    public int pathSum(TreeNode root, int targetSum) {
30        // if(targetSum!=0) map.put(0,1);
31        dfs(root,(long)0,(long)targetSum);
32        return ans;
33    }
34}