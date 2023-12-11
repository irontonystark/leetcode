package array.array6.m54;

import java.util.ArrayList;
import java.util.List;

/*
54. 螺旋矩阵
给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]
提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;//m行
        int n = matrix[0].length;//n列
        List<Integer>res= new ArrayList<>();
        int indexX=0,indexY=0;
        while(res.size()<m*n-1){
            while(indexY+1<n && matrix[indexX][indexY+1]>=-100){
                res.add(matrix[indexX][indexY]);
                matrix[indexX][indexY++]=-200;
            }
            while(indexX+1<m && matrix[indexX+1][indexY]>=-100){
                res.add(matrix[indexX][indexY]);
                matrix[indexX++][indexY]=-200;
            }
            while(indexY-1>-1 && matrix[indexX][indexY-1]>=-100){
                res.add(matrix[indexX][indexY]);
                matrix[indexX][indexY--]=-200;
            }
            while(indexX-1>-1 && matrix[indexX-1][indexY]>=-100){
                res.add(matrix[indexX][indexY]);
                matrix[indexX--][indexY]=-200;
            }
        }
        res.add(matrix[indexX][indexY]);
        return res;
    }
}
