package array.array3.s697;


import java.util.Arrays;

/*
给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
示例 1：
输入：nums = [1,2,2,3,1]
输出：2
解释：
输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
连续子数组里面拥有相同度的有如下所示：
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
示例 2：
输入：nums = [1,2,2,3,1,4,2]
输出：6
解释：
数组的度是 3 ，因为元素 2 重复出现 3 次。
所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
提示：
nums.length 在 1 到 50,000 范围内。
nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
class Solution {

    public int findShortestSubArray(int[] nums) {
        int len=nums.length;
        int[] count=new int[50000];
        int[] index=new int[50000];
        int res=1;
        int maxcount=1;
        Arrays.fill(count,0);
        Arrays.fill(index,-1);
        for(int i=0;i<len;i++){
            count[nums[i]]++;
            if(index[nums[i]]!=-1){
                if(count[nums[i]]>maxcount){
                    res=i-index[nums[i]]+1;
                    maxcount=count[nums[i]];
                }else if(count[nums[i]]==maxcount) {
                    res=Math.min(res,i-index[nums[i]]+1);
                }
            }else{
                index[nums[i]]=i;
            }
        }
        return res;
    }
}
