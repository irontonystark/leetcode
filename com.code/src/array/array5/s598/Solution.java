package array.array5.s598;
/*
598. 范围求和 II
给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，
其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
示例 1:
输入: m = 3, n = 3，ops = [[2,2],[3,3]]
输出: 4
解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
示例 2:
输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
输出: 4
示例 3:
输入: m = 3, n = 3, ops = []
输出: 9
提示:
1 <= m, n <= 4 * 104
0 <= ops.length <= 104
ops[i].length == 2
1 <= ai <= m
1 <= bi <= n
 */
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0){
            return m*n;
        }
        int mina=ops[0][0];
        int minb=ops[0][1];
        for(int i=1;i<ops.length;i++){
            mina=Math.min(mina,ops[i][0]);
            minb=Math.min(minb,ops[i][1]);
        }
        return mina*minb;
    }
}
