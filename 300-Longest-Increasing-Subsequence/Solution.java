public class Solution {
	public int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		
		int len = nums.length;
		int[] result = new int[len];

		for (int i = 0; i < len; i++) {
			result[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					result[i] = Math.max(result[j] + 1, result[i]);
				}
			}
		}

		int max = 0;
		for (int i = 0; i < len; i++) {
			max = Math.max(max, result[i]);
		}
        	return max;
	}
}
