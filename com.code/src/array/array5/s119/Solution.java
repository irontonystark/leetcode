package array.array5.s119;

import java.util.ArrayList;
import java.util.List;

/*
119. 杨辉三角 II
给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:
输入: rowIndex = 3
输出: [1,3,3,1]
示例 2:
输入: rowIndex = 0
输出: [1]
示例 3:
输入: rowIndex = 1
输出: [1,1]
提示:
0 <= rowIndex <= 33
进阶：
你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
 */
//20后的阶乘就会超过long的范围
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        if (rowIndex == 0) {
            return res;
        }
        long cur = 1;
        for (int i = 1; i < rowIndex; i++) {
            cur=cur*(rowIndex-i+1)/i;
            res.add((int)cur);
        }
        res.add(1);
        return res;
    }
}