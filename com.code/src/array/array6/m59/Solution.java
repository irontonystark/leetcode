package array.array6.m59;

/*
59. 螺旋矩阵 II
给你一个正整数 n ，生成一个包含 1 到 n的平方 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：
输入：n = 1
输出：[[1]]
提示：
1 <= n <= 20
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int indexi = 0, indexj = 0;
        int num = 1;
        while (num < n * n) {
            while (indexj + 1 < n && res[indexi][indexj + 1] == 0) {
                res[indexi][indexj++] = num++;
            }
            while (indexi + 1 < n && res[indexi + 1][indexj] == 0) {
                res[indexi++][indexj] = num++;
            }
            while (indexj - 1 > -1 && res[indexi][indexj - 1] == 0) {
                res[indexi][indexj--] = num++;
            }
            while (indexi - 1 > -1 && res[indexi - 1][indexj] == 0) {
                res[indexi--][indexj] = num++;
            }
        }
        res[indexi][indexj] = num;
        return res;
    }
}
