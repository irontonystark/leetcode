package array.array6.m54;


import java.util.List;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        //int[][] matrix=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> nums = s.spiralOrder(matrix);
        for (int i = 0; i < nums.size(); i++) {
            System.out.println(nums.get(i));
        }
    }
}
