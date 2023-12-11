package array.array6.m59;

public class Test {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 4;
        int[][] nums = s.generateMatrix(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(nums[i][j]);
            }
        }
    }
}
