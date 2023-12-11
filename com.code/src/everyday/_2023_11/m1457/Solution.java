package everyday._2023_11.m1457;
/*
1457. 二叉树中的伪回文路径

给你一棵二叉树，每个节点的值为 1 到 9 。我们称二叉树中的一条路径是 「伪回文」的，当它满足：路径经过的所有节点值的排列中，存在一个回文序列。
请你返回从根到叶子节点的所有路径中 伪回文 路径的数目。

示例 1：
输入：root = [2,3,1,3,1,null,1]
输出：2
解释：上图为给定的二叉树。总共有 3 条从根到叶子的路径：红色路径 [2,3,3] ，绿色路径 [2,1,1] 和路径 [2,3,1] 。
     在这些路径中，只有红色和绿色的路径是伪回文路径，因为红色路径 [2,3,3] 存在回文排列 [3,2,3] ，绿色路径 [2,1,1] 存在回文排列 [1,2,1] 。
示例 2：
输入：root = [2,1,1,1,3,null,null,null,null,null,1]
输出：1
解释：上图为给定二叉树。总共有 3 条从根到叶子的路径：绿色路径 [2,1,1] ，路径 [2,1,3,1] 和路径 [2,1] 。
     这些路径中只有绿色路径是伪回文路径，因为 [2,1,1] 存在回文排列 [1,2,1] 。
示例 3：
输入：root = [9]
输出：1
提示：
给定二叉树的节点数目在范围 [1, 105] 内
1 <= Node.val <= 9
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        int[] count = new int[10];
        return dfs(root, count);
    }

    public int dfs(TreeNode root, int[] count) {
        if (root == null) {
            return 0;
        }
        count[root.val]++;
        int res = 0;
        if (root.left == null && root.right == null) {  //说明是叶子节点
            res = isHuiWen(count);
        } else {
            res = dfs(root.left, count) + dfs(root.right, count);
        }
        //当前为叶子节点时递归终止，这时候需要回溯到上一个节点
        count[root.val]--;
        return res;
    }

    public int isHuiWen(int[] count) {
        //奇数计数小于等于1才可以构成回文，范围从1到9
        int flag = 0;
        for (int i = 1; i <= 9; i++) {
            if (count[i] % 2 == 1) {
                flag++;
                if (flag >= 2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}