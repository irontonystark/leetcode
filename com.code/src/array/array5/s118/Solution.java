package array.array5.s118;

import java.util.ArrayList;
import java.util.List;

/*
118. 杨辉三角
给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
在「杨辉三角」中，每个数是它左上方和右上方的数的和。
示例 1:
输入: numRows = 5
输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
示例 2:
输入: numRows = 1
输出: [[1]]
提示:
1 <= numRows <= 30
 */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        ArrayList<Integer> temp_old=new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> temp=new ArrayList<>();
            for(int j=1;j<=i;j++){
                if(j==1 || j==i){
                    temp.add(1);
                }else{
                    temp.add(temp_old.get(j-1)+temp_old.get(j));
                }
            }
            temp_old=temp;
            res.add(temp);
        }
        return res;
    }
}
