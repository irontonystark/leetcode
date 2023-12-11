package array.array4.s414;
/*
414. 第三大的数
给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
示例 1：
输入：[3, 2, 1]
输出：1
解释：第三大的数是 1 。
示例 2：
输入：[1, 2]
输出：2
解释：第三大的数不存在, 所以返回最大的数 2 。
示例 3：
输入：[2, 2, 3, 1]
输出：1
解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
提示：
1 <= nums.length <= 104
-231 <= nums[i] <= 231 - 1
 */
class Solution {
    public int thirdMax(int[] nums) {
        int max1=nums[0];
        //有可能出现很小的负数，用负无穷来确保最小
        double max2=Double.NEGATIVE_INFINITY,max3=Double.NEGATIVE_INFINITY;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>max1){
                max3=max2;
                max2=max1;
                max1=nums[i];
            }else if(nums[i]<max1 && nums[i]>max2){
                max3=max2;
                max2=nums[i];
            }else if(nums[i]<max2 && nums[i]>max3){
                max3=nums[i];
            }
        }
        if(max3==Double.NEGATIVE_INFINITY){
            return max1;
        }else{
            return (int)max3;
        }
    }
}
