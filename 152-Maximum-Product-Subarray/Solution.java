public class Solution {
	public int maxProduct(int[] nums) {
		// 10:39 - 11:02
		int flag = 0; // 1 - even negative number; -1 - odd negative elements
		int p1 = -1, p2 = -1; // first and last negative index;
		int max = 1;
		int divisor1 = 1, divisor2 = 1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				if (flag == 0) { // first meet negative
					flag = -1;
					p1 = i;
					p2 = i;
					divisor1 = max * nums[i];
				}
				flag *= -1;
				p2 = i;
			}
			max *= nums[i];
		}

		if (flag >= 0) {
			return max;
		}

		for (int i = nums.length - 1; i >= p2; i--) {
			divisor2 *= nums[i];
		}

		return Math.max(max / divisor1, max / divisor2);
	}
}
