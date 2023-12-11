package string.string3.s14;

/*
14. 最长公共前缀
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串 ""。

示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

提示：
1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        int index = 0;
        while (index < strs[0].length()) {
            char temp = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (index >= strs[i].length() || strs[i].charAt(index) != temp) {
                    return res.toString();
                }
            }
            res.append(temp);
            index++;
        }
        return res.toString();
    }
}
