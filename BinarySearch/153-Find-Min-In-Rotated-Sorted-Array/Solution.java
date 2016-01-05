public class Solution {
	public int findMin(int[] nums) {
		// 3:54 - 4:04
		// consider normal case (array is not rotated)
		int start, end, mid;
		start = 0;
		end = nums.length - 1;

		// check if array is rotated
		if (nums[start] <= nums[end]) {
			return nums[start];
		}

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (mid > 0) {
				if (nums[mid] < nums[mid - 1]) {
					return nums[mid];
				} else if (nums[mid] > nums[start]) {
					start = mid;
				} else if (nums[mid] < nums[start]) {
					end = mid;
				}
			}
		}

		if (nums[end] < nums[start]) {
			return nums[end];
		} else {
			return nums[start];
		}
	}
}
