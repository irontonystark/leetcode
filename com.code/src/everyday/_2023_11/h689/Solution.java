package everyday._2023_11.h689;
/*
给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
示例 1：
输入：nums = [1,2,1,2,6,7,5,1], k = 2
输出：[0,3,5]
解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
示例 2：
输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
输出：[0,2,4]
 */
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int len=nums.length;
        int sum1=0,maxSum1=0,maxSum1id1=0;
        int sum2=0,maxSum2=0,maxSum2id1=0,maxSum2id2=k;
        int sum3=0,maxSum3=0,maxSum3id1=0,maxSum3id2=k,maxSum3id3=2*k;
        for(int i=0;i+2*k<len;i++){
            sum1+=nums[i];
            sum2+=nums[i+k];
            sum3+=nums[i+2*k];
            if(i==k-1){
                maxSum1=sum1;
                maxSum2=sum1+sum2;
                maxSum3=maxSum2+sum3;
            }
            if(i>k-1){
                sum1-=nums[i-k];
                sum2-=nums[i];
                sum3-=nums[i+k];
                //当前滑动窗口一的总和比之前的要大
                if(sum1>maxSum1){
                    maxSum1=sum1;
                    maxSum1id1=i-k+1;
                }
                if(sum2+maxSum1>maxSum2){
                    maxSum2=sum2+maxSum1;
                    maxSum2id1=maxSum1id1;
                    maxSum2id2=i+1;
                }
                if(sum3+maxSum2>maxSum3){
                    maxSum3=sum3+maxSum2;
                    maxSum3id1=maxSum2id1;
                    maxSum3id2=maxSum2id2;
                    maxSum3id3=i+k+1;
                }
            }
        }
        return new int[]{maxSum3id1,maxSum3id2,maxSum3id3};
    }
}
