public class Solution {
	public int findDuplicate(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int len = nums.length;
		int start = 0, end = len - 1;
		int mid = 0, count = 0;

		while (start <= end) {
			mid = start + (end - start) / 2;
			count = 0;
			for (int i = 0; i < len; i++) {
				if (nums[i] <= mid) {
					count++;
				}
			}
			if (count > mid) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return (start == end ? nums[start] : nums[end]);
	}
}
