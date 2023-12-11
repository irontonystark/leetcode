package everyday._2023_11.m907;

/*
907. 子数组的最小值之和
给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。
由于答案可能很大，因此 返回答案模 10^9 + 7 。

示例 1：
输入：arr = [3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。

示例 2：
输入：arr = [11,81,94,43,3]
输出：444

提示：
1 <= arr.length <= 3 * 104
1 <= arr[i] <= 3 * 104
 */
class Solution {
    long NUM = 1000000007;

    public int sumSubarrayMins(int[] arr) {
        long res = 0;
        for (int i = 0; i < arr.length; i++) {
            int left;
            int right;
            for (left = i; left >= 1; left--) {
                if (arr[left - 1] <= arr[i]) {
                    break;
                }
            }
            for (right = i; right <= arr.length - 2; right++) {
                if (arr[right + 1] < arr[i]) {
                    break;
                }
            }
            res = (res + ((long) arr[i] * (i - left + 1)) * (right - i + 1)) % NUM;
        }
        return (int) res;
    }
}
