package everyday._2023_12.m2661;

import java.util.HashMap;
import java.util.Map;

/*
2661. 找出叠涂元素

给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。
arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。

示例 1：
image explanation for example 1
输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
输出：2
解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。

示例 2：
image explanation for example 2
输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
输出：3
解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。

提示：

m == mat.length
n = mat[i].length
arr.length == m * n
1 <= m, n <= 105
1 <= m * n <= 105
1 <= arr[i], mat[r][c] <= m * n
arr 中的所有整数 互不相同
mat 中的所有整数 互不相同
 */
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //行的总和
        int[] countx = new int[mat.length];
        //列的总和
        int[] county = new int[mat[0].length];
        int x = 0;
        int y = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int q = 0; q < mat.length; q++) {
            for (int k = 0; k < mat[0].length; k++) {
                map.put(mat[q][k], new int[]{q, k});
            }
        }
        for (int i = 0; i < arr.length; i++) {
            x = map.get(arr[i])[0];
            y = map.get(arr[i])[1];
            countx[x]++;
            if (countx[x] == mat[0].length) {
                return i;
            }
            county[y]++;
            if (county[y] == mat.length) {
                return i;
            }
        }
        return 0;
    }
}
