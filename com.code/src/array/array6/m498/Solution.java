package array.array6.m498;

/*
498. 对角线遍历

给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。

示例 1：
输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,4,7,5,3,6,8,9]
示例 2：
输入：mat = [[1,2],[3,4]]
输出：[1,2,3,4]

提示：
m == mat.length
n == mat[i].length
1 <= m, n <= 104
1 <= m * n <= 104
-105 <= mat[i][j] <= 105
 */
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int flag = 1;//+1表示从左下到右上，-1表示从右上到左下
        int count=0;
        int x = 0,y=0;//用来遍历的横坐标和纵坐标
        int[] res = new int[m * n];
        while (count<m*n) {
            res[count++]=mat[x][y];
            if(flag==1) {  //从左下到右上
                if (isLegal(x - 1, y + 1, m, n)) {
                    x = x - 1;
                    y = y + 1;
                } else if (isLegal(x, y + 1, m, n)) {
                    y = y + 1;
                    flag = -flag;
                } else if (isLegal(x + 1, y, m, n)) {
                    x = x + 1;
                    flag = -flag;
                }
            } else if (flag == -1) {  //从右上到左下
                if (isLegal(x + 1, y - 1, m, n)) {
                    x = x + 1;
                    y = y - 1;
                } else if (isLegal(x + 1, y, m, n)) {
                    x = x + 1;
                    flag = -flag;
                } else if (isLegal(x, y + 1, m, n)) {
                    y = y + 1;
                    flag = -flag;
                }
            }
        }
        return res;
    }

    public boolean isLegal(int x, int y, int m, int n) {
        if (0 <= x && x <= m - 1 && 0 <= y && y <= n - 1) {
            return true;
        } else {
            return false;
        }
    }
}

