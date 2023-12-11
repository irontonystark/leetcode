package randomOne.s415;
/*
给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
示例 1：
输入：num1 = "11", num2 = "123"
输出："134"
示例 2：
输入：num1 = "456", num2 = "77"
输出："533"
示例 3：
输入：num1 = "0", num2 = "0"
输出："0"
提示：
1 <= num1.length, num2.length <= 104
num1 和num2 都只包含数字 0-9
num1 和num2 都不包含任何前导零
 */
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res= new StringBuilder("");
        int len1=num1.length()-1,len2=num2.length()-1;
        //判断是否进位
        int up=0;
        int temp=0;
        while(len1>=0||len2>=0||up!=0){
            if(len1>=0&&len2>=0){
                temp=num1.charAt(len1)-'0'+num2.charAt(len2)-'0'+up;
                len1--;
                len2--;
            } else if (len1>=0) {
                temp=num1.charAt(len1)-'0'+up;
                len1--;
            } else if (len2>=0) {
                temp=num2.charAt(len2)-'0'+up;
                len2--;
            }else{
                temp=up;
            }
            if(temp>=10){
                res.insert(0,(char)(temp-10+'0'));
                up=1;
            }else{
                res.insert(0,(char)(temp+'0'));
                up=0;
            }
        }
        return res.toString();
    }
}
