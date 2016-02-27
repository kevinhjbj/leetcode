public class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum[i] == k) {
                result = Math.max(result, i + 1);
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (sum[i] - sum[j] == k) {
                    result = Math.max(i - j, result);
                }
            }
        }
        
        return result;
    }
}